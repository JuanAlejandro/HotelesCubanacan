package com.resline.cubanacan.ui.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Toast;
import com.google.gson.Gson;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelFullDetails;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationCellRequest;
import com.resline.cubanacan.src.ws.WSClass.Tpv.TPVPostData;
import com.resline.cubanacan.src.ws.WSClass.Tpv.TPVResponse;
import com.resline.cubanacan.src.ws.WebServicesClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TPVActivity extends AppCompatActivity {
    WebView wvNavigator;
    long hotelId;
    double price;
    String urlOK, urlKo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadViews();
    }

    private void loadViews(){
        wvNavigator = (WebView)findViewById(R.id.wvNavigator);
        loadWebView();
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon)
        {
            //Aqui verificamos que si es URLOK vaya a una pantalla ok y si es URLKO que vaya a una pantalla ko
            //URLOK
            if(url.equals(urlOK)){
                //TODO ir a OK Activity

            }else if(url.equals(urlKo)){

                //TODO ir a KO Activity
            }
        }
    }

    private void loadWebView(){

        RoomReservationCellRequest roomReservationCellRequest = new RoomReservationCellRequest();
        roomReservationCellRequest.setRoomReservationRequest(AppController.getRoomReservationRequest());
        roomReservationCellRequest.setCurrencyId(1);  //TODO Esto no puede quedarse asi
        Bundle bundle = getIntent().getExtras();
        hotelId = bundle.getLong("idHotel");
        price = bundle.getDouble("price");
        HotelFullDetails hotel = AppController.getHotels().get(hotelId);
        roomReservationCellRequest.setHotelName(hotel.getName());
        roomReservationCellRequest.setLanguage("001");
        roomReservationCellRequest.setPrice(price);

        Gson gson = new Gson();
        String roomReservationCellRequestJson = gson.toJson(roomReservationCellRequest);

        WebServicesClient.get().prepareTpvData("prepareTPVData", roomReservationCellRequestJson,
                new Callback<TPVResponse>() {
                    @Override
                    public void success(TPVResponse tpvResponse, Response response) {
                        if (tpvResponse == null) {
                            showErrorMessage();
                        }

                        if (tpvResponse.isOk()) {

                            WebSettings webSettings = wvNavigator.getSettings();
                            webSettings.setJavaScriptEnabled(true);

                            TPVPostData tpvPostData = tpvResponse.getData().getTpvPostData();
                            String order = tpvPostData.getDs_Merchant_Order();

                            Map<String, String> mapParams = new HashMap<String, String>();
                            mapParams.put("operation[Ds_Merchant_Amount]", tpvPostData.getDs_Merchant_Amount());
                            mapParams.put("operation[Ds_Merchant_Order]", order);
                            mapParams.put("operation[Ds_Merchant_ProductDescription]", "Pago del Pedido "+order);
                            mapParams.put("operation[Ds_Merchant_Titular]", tpvPostData.getDs_Merchant_Titular());
                            mapParams.put("operation[Ds_Merchant_UrlConfirm]", tpvPostData.getDs_Merchant_UrlConfirm());
                            mapParams.put("operation[Ds_Merchant_UrlOK]", tpvPostData.getDs_Merchant_UrlOK());
                            urlOK = tpvPostData.getDs_Merchant_UrlOK();
                            mapParams.put("operation[Ds_Merchant_UrlKO]", tpvPostData.getDs_Merchant_UrlKO());
                            urlKo = tpvPostData.getDs_Merchant_UrlKO();
                            mapParams.put("operation[Ds_Merchant_MerchantName]", tpvPostData.getDs_Merchant_MerchantName());
                            //TODO Cambiar el idioma a partir de lo que haya seleccionado el usuario
                            mapParams.put("operation[Ds_Merchant_ConsumerLanguage]", "001");
                            mapParams.put("operation[Ds_Merchant_MerchantSignature]", tpvPostData.getDs_Merchant_MerchantSignature());
                            mapParams.put("operation[Ds_ClientSignature]", tpvPostData.getDs_ClientSignature());
                            mapParams.put("operation[Ds_Merchant_Currency]", "978");

                            Collection<Map.Entry<String, String>> postData = mapParams.entrySet();
                            String distpatchUrl = tpvResponse.getData().getDispatchUrl();

                            StringBuilder sb = new StringBuilder();
                            sb.append("<html><head></head>");
                            sb.append("<body onload='form1.submit()'>");
                            sb.append(String.format("<form id='form1' action='%s' method='%s'>", distpatchUrl, "post"));
                            for (Map.Entry<String, String> item : postData) {
                                sb.append(String.format("<input name='%s' type='hidden' value='%s' />", item.getKey(), item.getValue()));
                            }
                            sb.append("</form></body></html>");

                            wvNavigator.loadData(sb.toString(), "text/html", "UTF-8");
                        } else {

                        }

                    }
                    @Override
                    public void failure(RetrofitError retrofitError) {
                        showErrorMessage();
                    }
                });
    }

    private void showErrorMessage(){

        Toast.makeText(TPVActivity.this, "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
    }

}
