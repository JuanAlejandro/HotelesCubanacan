package com.resline.cubanacan.src.ws;

import com.resline.cubanacan.src.ws.WSClass.General.CountryResponse;
import com.resline.cubanacan.src.ws.WSClass.General.TitlesResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelAvaibilityResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelsFullDetailsResponse;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocationResponse;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationResponse;
import com.resline.cubanacan.src.ws.WSClass.Tpv.TPVResponse;
import retrofit.http.*;
import retrofit.Callback;

/**
 * @Author David
 * @Date 11/03/2016
 * @Description Clase que servira de interfaz para consumir los WS
 */
public interface WebServicesInterface {

    @FormUrlEncoded
    @Headers("Accept-Language: es-ES")
    @POST("/webservice")
    void searchHotels(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<HotelAvaibilityResponse> callBack
    );

    @Headers("Accept-Language: es-ES")
    @FormUrlEncoded
    @POST("/webservice")
    void getLocations(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<FullLocationResponse> callBack
    );

    @Headers("Accept-Language: es-ES")
    @FormUrlEncoded
    @POST("/webservice")
    void getHotels(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<HotelsFullDetailsResponse> callBack
    );

    @Headers("Accept-Language: es-ES")
    @FormUrlEncoded
    @POST("/webservice")
    void prepareTpvData(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<TPVResponse> callBack
    );

    @Headers("Accept-Language: es-ES")
    @FormUrlEncoded
    @POST("/webservice")
    void saveRoomReservation(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<RoomReservationResponse> callBack
    );

    @Headers("Accept-Language: es-ES")
    @FormUrlEncoded
    @POST("/webservice")
    void getCountries(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<CountryResponse> callBack
    );

    @Headers("Accept-Language: es-ES")
    @FormUrlEncoded
    @POST("/webservice")
    void getTitles(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<TitlesResponse> callBack
    );

    @Headers("Accept-Language: es-ES")
    @FormUrlEncoded
    @POST("/webservice")
    void payAndGoToTpv(
            @Field("functionName") String functionName,
            @Field("paramsJson") String params, Callback<TPVResponse> callBack
    );
}
