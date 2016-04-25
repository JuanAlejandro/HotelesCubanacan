package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Image.ArrayOfImage;
import com.resline.cubanacan.src.ws.WSClass.Image.Image;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.ui.adapter.HotelesCardsAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewFragment;
import com.resline.cubanacan.ui.model.CardViewBean;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelesListFragment extends RecyclerViewFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // aqui obtienes el bundle que pasaste en la activity
        Bundle bundle = getArguments();
    }

    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return new HotelesCardsAdapter(mActivity, mListCard);
    }

    @Override
    protected List<CardViewBean> getContentInCards() {
        List<CardViewBean> temp = new ArrayList<>();
        Bundle bundle = getArguments();
        if(bundle != null)
            temp = populateList(bundle.getInt("filter"));
        else
            temp = populateList(0);

        return temp;
    }

    private List<CardViewBean> populateList(int filter) {
        List<HotelAvailabilitySearchResultVO> hotels = AppController.getCurrentSearchResult().getHotelsAvaibility();

        switch (filter){
            case 0:      //Price Filter
                Collections.sort(hotels, new Comparator<HotelAvailabilitySearchResultVO>() {
                    @Override
                    public int compare(HotelAvailabilitySearchResultVO hotel1, HotelAvailabilitySearchResultVO hotel2) {
                        Double priceHotel1 = AppController.getHotels().get(hotel1.getId()).getFromPrice();
                        Double priceHotel2 = AppController.getHotels().get(hotel2.getId()).getFromPrice();
                        if(priceHotel1 == null)
                            return -1;
                        if(priceHotel2 == null)
                            return 1;
                        return priceHotel1.compareTo(priceHotel2);
                    }
                });
                break;
            case 1:
                Collections.sort(hotels, new Comparator<HotelAvailabilitySearchResultVO>() {
                    @Override
                    public int compare(HotelAvailabilitySearchResultVO hotel1, HotelAvailabilitySearchResultVO hotel2) {
                        return new String(hotel1.getName()).compareTo(new String(hotel2.getName()));
                    }
                });
                break;
            case 2:
                Collections.sort(hotels, new Comparator<HotelAvailabilitySearchResultVO>() {
                    @Override
                    public int compare(HotelAvailabilitySearchResultVO hotel1, HotelAvailabilitySearchResultVO hotel2) {
                        return new Integer(hotel1.getCategory().ordinal()).compareTo(new Integer(hotel2.getCategory().ordinal()));
                    }
                });
                break;
            default:
                Collections.sort(hotels, new Comparator<HotelAvailabilitySearchResultVO>() {
                    @Override
                    public int compare(HotelAvailabilitySearchResultVO hotel1, HotelAvailabilitySearchResultVO hotel2) {
                        Double priceHotel1 = AppController.getHotels().get(hotel1.getId()).getFromPrice();
                        Double priceHotel2 = AppController.getHotels().get(hotel2.getId()).getFromPrice();
                        if(priceHotel1 == null)
                            return -1;
                        if(priceHotel2 == null)
                            return 1;
                        return priceHotel1.compareTo(priceHotel2);
                    }
                });
        }

        Map<Long, ArrayOfImage> hotelImages = AppController.getCurrentSearchResult().getHotelImage();
        List<CardViewBean> listCard = new ArrayList<>();

        for (HotelAvailabilitySearchResultVO hotel : hotels) {
            Image image = hotelImages.get(hotel.getId()).getImage().get(0);
            Double minimumPrice = AppController.getHotels().get(hotel.getId()).getFromPrice();
            DecimalFormat formatter = new DecimalFormat("#.00");
            String minimumPriceStr = "0";
            if(minimumPrice != null)
                minimumPriceStr = formatter.format(minimumPrice).toString();
            int countNights = AppController.getSearchHotelCriteria().getNights();
            String nightsStr = "noche";
            if(countNights != 1)
                nightsStr = "noches";
            String currency = AppController.getCurrentSearchResult().getCurrencyName();
            String nightsStrComplete = String.format("%d %s desde ", countNights, nightsStr);
            String price = String.format("%s %s", minimumPriceStr, currency);
            Uri uri =  Uri.parse(image.getImageUrl());
            listCard.add(new CardViewBean(hotel.getId(), uri, hotel.getName(), nightsStrComplete, price, hotel.getLocationName(), hotel.getCategory().ordinal()));
        }
        return listCard;
    }
}
