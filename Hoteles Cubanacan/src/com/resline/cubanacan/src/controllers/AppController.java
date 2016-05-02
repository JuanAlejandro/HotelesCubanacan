package com.resline.cubanacan.src.controllers;

import android.os.Environment;
import android.util.Base64;
import java.io.File;
import java.util.*;

import com.resline.cubanacan.src.models.User;
import com.resline.cubanacan.src.ws.WSClass.General.CountryResponse;
import com.resline.cubanacan.src.ws.WSClass.General.TitlesResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelAvaibilityResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelFullDetails;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelsFullDetailsResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.SearchHotelCriteria;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocationResponse;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationRequest;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * @Author David
 * @Date 11/03/2016
 * @Description Clase controladora de la app
 */
//TODO Hacer esta clase un singlenton
public class AppController {

    /*public static final String FILTER_PREFERENCE_FILENAME = "filterPreferences";
    public static final String FILTER_PREFERENCE_DISTANCE = "distance";
    public static final String FILTER_PREFERENCE_ORDERBY = "orderBy";*/

    private static RoomReservationRequest roomReservationRequest = null;
    private static SearchHotelCriteria searchHotelCriteria = null;
    private static HotelAvaibilityResponse currentSearchResult = null;
    private static Map<Long, FullLocation> currentLocations = null;
    private static Map<Long, HotelFullDetails> currentHotels = null;
    private static TitlesResponse titles = null;
    private static CountryResponse countries = null;
    private static String[] checkinStr = null;
    private static String[] checkoutStr = null;

    private static User currentUser;
    private static boolean loggedIn = false;
    private static String userAuth = "";
    private static String anounymousAuth = "";

    public static User getCurrentUser() {
        return currentUser;
    }

    public static RoomReservationRequest getRoomReservationRequest(){
        return roomReservationRequest;
    }

    public static void setRoomReservationRequest(RoomReservationRequest newRoomReservationRequest){
        roomReservationRequest = newRoomReservationRequest;
    }

    public static SearchHotelCriteria getSearchHotelCriteria(){
        return searchHotelCriteria;
    }

    public static void setSearchHotelCriteria(SearchHotelCriteria newSearchHotelCriteria){
        searchHotelCriteria = newSearchHotelCriteria;
    }

    public static HotelAvaibilityResponse getCurrentSearchResult(){
        return currentSearchResult;
    }

    public  static void setCurrentSearchResult(HotelAvaibilityResponse searcResult){
        currentSearchResult = searcResult;
    }

    public static Map<Long, FullLocation> getLocations(){
        return currentLocations;
    }

    public  static void setLocations(FullLocationResponse locations){
        currentLocations = new HashMap<Long, FullLocation>();
        List<FullLocation> fullLocations = locations.getFullLocations().getFullLocation();
        for (FullLocation location : fullLocations){

            currentLocations.put(location.getId(), location);
        }
    }

    public static Map<Long, HotelFullDetails> getHotels(){
        return currentHotels;
    }

    public  static void setHotels(HotelsFullDetailsResponse hotels){
        currentHotels = new HashMap<Long, HotelFullDetails>();
        List<HotelFullDetails> hotelsFullDetails = hotels.getHotelsFullDetailsResult().getHotelsDetails();
        for (HotelFullDetails hotel : hotelsFullDetails){

            currentHotels.put(hotel.getHotelId(), hotel);
        }
    }

    public static CountryResponse getCountries(){
        return countries;
    }

    public  static void setCountries(CountryResponse newCountries){
        countries = newCountries;
    }

    public static TitlesResponse getTitles() {
        return titles;
    }

    public static void setTitles(TitlesResponse titles) {
        AppController.titles = titles;
    }

    public static void setCurrentUser(User user) {
        if(user == null) {
            loggedIn = false;
            userAuth = "";
        } else {
            currentUser = user;
            loggedIn = true;
            String auth = String.format(Locale.ENGLISH, "%s:%s", user.getUsername(), user.getPassword());
            userAuth = String.format(Locale.ENGLISH, "Basic %s", Base64.encodeToString(auth.getBytes(), Base64.DEFAULT));
        }
    }

    public static boolean isLoggedIn() {
        return loggedIn;// || isFacebookLoggedIn();
    }

    /*public static void logout() {
        setCurrentUser(null);
        final AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken != null) {
            LoginManager.getInstance().logOut();
        }
    }*/

    public static String getUserAuth() {
        return userAuth;
    }

    public static String getAnonymousAuth() {
        String username = "anonymous";
        String password = "anonymous";

        String auth = String.format(Locale.ENGLISH, "%s:%s", username, password);
        final String headerAuth = String.format(Locale.ENGLISH, "Basic %s", Base64.encodeToString(auth.getBytes(), Base64.DEFAULT));

        return headerAuth;
    }

    public static File getStorageDirectory() {
        File dir = new File(Environment.getExternalStorageDirectory(), "MyFilin");
        dir.mkdirs();
        return dir;
    }

    public static String[] getCheckinStr() {
        if(checkinStr == null)
            checkinStr = new String[4];
        return checkinStr;
    }

    public static void setCheckinStr(String[] checkinStr) {
        AppController.checkinStr = checkinStr;
    }

    public static String[] getCheckoutStr() {
        if(checkoutStr == null)
            checkoutStr = new String[4];
        return checkoutStr;
    }

    public static void setCheckoutStr(String[] checkoutStr) {
        AppController.checkoutStr = checkoutStr;
    }
}
