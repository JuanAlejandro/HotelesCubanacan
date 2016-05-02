package com.resline.cubanacan.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelsFullDetailsResponse;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocationResponse;
import com.resline.cubanacan.src.ws.WebServicesClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Juan Alejandro on 04/04/2016.
 */
public class SplashActivity extends AppCompatActivity {
    private static long SPLASH_TIME = 2 * 1000;   // 2 segundos
    private boolean splashActiveFlag = true;
    private static String TAG = "SplashActivity";

    boolean locationsReady, hotelsReady, isShowedErrorMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //executeThread();
        getData();
    }

    private void executeThread() {
        Thread splashTimer = new Thread() {
            public void run() {
                try {
                    WebServicesClient.get().getLocations("getSupportedFullLocations", null, new Callback<FullLocationResponse>() {
                        @Override
                        public void success(FullLocationResponse fullLocationResponse, Response response) {
                            if (fullLocationResponse == null) {
                                showErrorMessage();
                            }
                            else{
                                if (fullLocationResponse.getOperationMessage().equals("OK")) {
                                    AppController.setLocations(fullLocationResponse);
                                }
                            }
                            locationsReady = true;
                            isAllReady();
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            locationsReady = true;
                            showErrorMessage();
                            isAllReady();
                        }
                    });

                    WebServicesClient.get().getHotels("getHotelsFullDetails", null, new Callback<HotelsFullDetailsResponse>() {
                        @Override
                        public void success(HotelsFullDetailsResponse hotelsFullDetailsResponse, Response response) {
                            if (hotelsFullDetailsResponse == null) {
                                showErrorMessage();
                            } else {
                                if (hotelsFullDetailsResponse.getOperationMessage().equals("OK")) {
                                    AppController.setHotels(hotelsFullDetailsResponse);
                                }
                            }
                            hotelsReady = true;
                            isAllReady();
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            hotelsReady = true;
                            isAllReady();
                        }
                    });

                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                } finally {
                    finish();
                }
            }
        };
        splashTimer.start();
    }

    private void getData(){
        WebServicesClient.get().getLocations("getSupportedFullLocations", null, new Callback<FullLocationResponse>() {
            @Override
            public void success(FullLocationResponse fullLocationResponse, Response response) {
                if (fullLocationResponse == null) {
                    showErrorMessage();
                }
                else{
                    if (fullLocationResponse.getOperationMessage().equals("OK")) {
                        AppController.setLocations(fullLocationResponse);
                    }
                }
                locationsReady = true;
                isAllReady();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                locationsReady = true;
                showErrorMessage();
                isAllReady();
            }
        });

        WebServicesClient.get().getHotels("getHotelsFullDetails", null, new Callback<HotelsFullDetailsResponse>() {
            @Override
            public void success(HotelsFullDetailsResponse hotelsFullDetailsResponse, Response response) {
                if (hotelsFullDetailsResponse == null) {
                    showErrorMessage();
                } else {
                    if (hotelsFullDetailsResponse.getOperationMessage().equals("OK")) {
                        AppController.setHotels(hotelsFullDetailsResponse);
                    }
                }
                hotelsReady = true;
                isAllReady();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                hotelsReady = true;
                isAllReady();
            }
        });
    }

    private void showErrorMessage(){
        if(!isShowedErrorMessage)
            Toast.makeText(SplashActivity.this, "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
    }

    private void isAllReady(){
        if(locationsReady && hotelsReady){
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    }
}
