package com.resline.cubanacan.src.ws;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import com.squareup.okhttp.OkHttpClient;

/**
 * @Author David
 * @Date 11/03/2016
 * @Description Clase para manejar el acceso a los ws
 */
public class WebServicesClient {
    private static WebServicesInterface wsInterface;
    //private static final String WS_ROOT = "http://192.168.180.1/pam/hotelescubanacan.com/web";
    private static final String WS_ROOT = "http://192.168.5.107/pam/hotelescubanacan.com/web";
    //private static final String WS_ROOT = "http://www.hotelescubanacan.com/web";

    private static void init() {
        if(wsInterface == null) {
            RestAdapter.Builder builder = new RestAdapter.Builder()
                    .setEndpoint(WS_ROOT)
                    .setClient(new OkClient(new OkHttpClient()));

            RestAdapter restAdapter = builder.build();
            wsInterface = restAdapter.create(WebServicesInterface.class);
        }
    }

    public static WebServicesInterface get() {
        init();
        return wsInterface;
    }
}
