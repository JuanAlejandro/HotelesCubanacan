package com.resline.cubanacan.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.General.Country;
import com.resline.cubanacan.src.ws.WSClass.General.CountryResponse;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationCellRequest;
import com.resline.cubanacan.src.ws.WSClass.Tpv.TPVResponse;
import com.resline.cubanacan.src.ws.WebServicesClient;
import com.resline.cubanacan.ui.activities.ElegirHabitacionActivity;
import com.resline.cubanacan.ui.activities.TPVActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;

/**
 * Created by Juan Alejandro on 18/04/2016.
 */
public class TitularFragment extends BaseFragment implements View.OnClickListener {
    private View mViewFragment;

    private TextView tvNombreHotel;

    private RatingBar rbCategoria;

    private TextView tvSubtitulo;

    private TextView in, out;

    private TextView tvImporte;

    private Spinner spinANombreDe;

    private EditText etNombre, etApellidos, etCorreo;

    private Spinner spinPais;

    private CheckBox cbAcepto;

    private Button btnPagar;

    private ArrayList<String> countriesList, countriesCodeList;

    double price;
    long hotelId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewFragment = inflater.inflate(R.layout.fragment_titular, container, false);

        loadViewComponents();

        return mViewFragment;
    }

    private void loadViewComponents() {
        // nombre del hotel
        tvNombreHotel = (TextView) mViewFragment.findViewById(R.id.tvTitle);

        // rating bar de la categoria
        rbCategoria = (RatingBar) mViewFragment.findViewById(R.id.rbCategory);

        rbCategoria.setNumStars(5);

        rbCategoria.setRating(3);

        // subtitulo
        tvSubtitulo = (TextView) mViewFragment.findViewById(R.id.tvSubtitle);

        // in & out
        in = (TextView) mViewFragment.findViewById(R.id.tvIn);
        out = (TextView) mViewFragment.findViewById(R.id.tvOut);

        // importe
        tvImporte = (TextView) mViewFragment.findViewById(R.id.tvImporte);

        // spinner a nombre de...
        spinANombreDe = (Spinner) mViewFragment.findViewById(R.id.spinTitular);


        // nombre & apellidos
        etNombre = (EditText) mViewFragment.findViewById(R.id.etNombre);
        etApellidos = (EditText) mViewFragment.findViewById(R.id.etApellidos);
        etCorreo = (EditText) mViewFragment.findViewById(R.id.etCorreo);

        // spinner pais
        spinPais = (Spinner) mViewFragment.findViewById(R.id.spinPais);

        // fumador
        cbAcepto = (CheckBox) mViewFragment.findViewById(R.id.cbAcepto);

        // boton siguiente
        btnPagar = (Button) mViewFragment.findViewById(R.id.btnPagar);

        btnPagar.setOnClickListener(this);

        loadSpinners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPagar:
                pay();
                break;
        }
    }

    private void loadSpinners() {

        CountryResponse countries = AppController.getCountries();

        if (countries != null) {
            countriesList = new ArrayList<String>();
            countriesCodeList = new ArrayList<String>();
            for (Country country : countries.getCountryResult().getCountry()) {
                countriesList.add(country.getName());
                countriesCodeList.add(country.getCountryCode());
            }

            ArrayAdapter countriesAdapter = new ArrayAdapter<String>(this.getContext(),
                    android.R.layout.simple_spinner_dropdown_item, countriesList);
            countriesAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
            spinPais.setAdapter(countriesAdapter);
        } else {
            spinPais.setEnabled(false);
        }
    }

    private void pay(){
        RoomReservationCellRequest roomReservationCellRequest = new RoomReservationCellRequest();

        AppController.getRoomReservationRequest().setTitularEmail(etCorreo.toString());
        AppController.getRoomReservationRequest().setTitularName(etNombre.toString());
        AppController.getRoomReservationRequest().setTitularLastName(etApellidos.toString());

        roomReservationCellRequest.setRoomReservationRequest(AppController.getRoomReservationRequest());
        roomReservationCellRequest.setPrice(price * 0.10);
        roomReservationCellRequest.setLanguage("001");
        roomReservationCellRequest.setHotelName(AppController.getHotels().get(hotelId).getName());
        roomReservationCellRequest.setCurrencyId(1); //TODO Esto no puede quedarse asi

        WebServicesClient.get().payAndGoToTpv("payAndGoToTpv", null, new Callback<TPVResponse>() {
            @Override
            public void success(TPVResponse tpvResponse, Response response) {
                if (tpvResponse == null) {
                    showErrorMessage();
                }
                else{
                    if (tpvResponse.getOperationMessage().equals("OK")) {
                        startActivity(new Intent(getActivity(), TPVActivity.class));
                    }
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                showErrorMessage();
            }
        });
    }

    private void showErrorMessage(){

        Toast.makeText(getActivity(), "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadPreferencesAndBundle() {
        super.loadPreferencesAndBundle();

        hotelId = mBundle.getLong("idHotel");

        price = mBundle.getDouble("price");
    }
}
