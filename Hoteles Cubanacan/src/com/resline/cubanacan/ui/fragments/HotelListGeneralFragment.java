package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelFullDetails;
import com.resline.cubanacan.src.ws.WSClass.Image.ArrayOfImage;
import com.resline.cubanacan.src.ws.WSClass.Image.Image;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.ui.adapter.HotelesCardsAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewWithFAB;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CardViewHotel;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Juan Alejandro on 24/04/2016.
 */
public class HotelListGeneralFragment extends RecyclerViewWithFAB {
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
        Map<Long, HotelFullDetails> hotels = AppController.getHotels();
        List<HotelFullDetails> hotelList = new ArrayList<HotelFullDetails>(hotels.values());

        switch (filter){
            case 0:      //Price Filter
                Collections.sort(hotelList, new Comparator<HotelFullDetails>() {
                    @Override
                    public int compare(HotelFullDetails hotel1, HotelFullDetails hotel2) {
                        Double priceHotel1 = hotel1.getFromPrice();
                        Double priceHotel2 = hotel2.getFromPrice();
                        if(priceHotel1 == null)
                            return -1;
                        if(priceHotel2 == null)
                            return 1;
                        return priceHotel1.compareTo(priceHotel2);
                    }
                });
                break;
            case 1:
                Collections.sort(hotelList, new Comparator<HotelFullDetails>() {
                    @Override
                    public int compare(HotelFullDetails hotel1, HotelFullDetails hotel2) {
                        return new String(hotel1.getName()).compareTo(new String(hotel2.getName()));
                    }
                });
                break;
            case 2:
                Collections.sort(hotelList, new Comparator<HotelFullDetails>() {
                    @Override
                    public int compare(HotelFullDetails hotel1, HotelFullDetails hotel2) {
                        return new Integer(hotel1.getCategoryEnum().ordinal()).compareTo(new Integer(hotel2.getCategoryEnum().ordinal()));
                    }
                });
                break;
            default:
                Collections.sort(hotelList, new Comparator<HotelFullDetails>() {
                    @Override
                    public int compare(HotelFullDetails hotel1, HotelFullDetails hotel2) {
                        Double priceHotel1 = hotel1.getFromPrice();
                        Double priceHotel2 = hotel2.getFromPrice();
                        if(priceHotel1 == null)
                            return -1;
                        if(priceHotel2 == null)
                            return 1;
                        return priceHotel1.compareTo(priceHotel2);
                    }
                });
        }

        List<CardViewBean> listCard = new ArrayList<>();

        Iterator it = hotels.keySet().iterator();
        while(it.hasNext()) {
            Long id = (Long) it.next();

            Image image = hotels.get(id).getImages().getImage().get(0);
            Double minimumPrice = hotels.get(id).getFromPrice();
            String currency = AppController.getCurrentSearchResult().getCurrencyName();
            String minimumPriceStr = "desde 0.00 " +currency;
            if(minimumPrice != null)
                minimumPriceStr = String.format("desde %.2f %s", minimumPrice, currency);
            Uri uri =  Uri.parse(image.getImageUrl());
            listCard.add(new CardViewHotel(id, uri, hotels.get(id).getName(), "", minimumPriceStr, hotels.get(id).getLocation().toString(), hotels.get(id).getCategoryEnum().ordinal()));
        }

        return listCard;
    }
}
