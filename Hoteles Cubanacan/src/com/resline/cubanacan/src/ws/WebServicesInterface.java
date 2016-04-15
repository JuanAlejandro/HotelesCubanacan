package com.resline.cubanacan.src.ws;

import com.resline.cubanacan.src.ws.WSClass.General.CountryResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelAvaibilityResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelsFullDetailsResponse;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocationResponse;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationResponse;
import com.resline.cubanacan.src.ws.WSClass.Tpv.TPVResponse;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.Callback;

/**
 * @Author David
 * @Date 11/03/2016
 * @Description Clase que servira de interfaz para consumir los WS
 */
public interface WebServicesInterface {

    @FormUrlEncoded
    @POST("/webservice")
    void searchHotels(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<HotelAvaibilityResponse> callBack
    );

    @FormUrlEncoded
    @POST("/webservice")
    void getLocations(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<FullLocationResponse> callBack
    );

    @FormUrlEncoded
    @POST("/webservice")
    void getHotels(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<HotelsFullDetailsResponse> callBack
    );

    @FormUrlEncoded
    @POST("/webservice")
    void prepareTpvData(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<TPVResponse> callBack
    );

    @FormUrlEncoded
    @POST("/webservice")
    void saveRoomReservation(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<RoomReservationResponse> callBack
    );

    @FormUrlEncoded
    @POST("/webservice")
    void getCountries(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<CountryResponse> callBack
    );
}
