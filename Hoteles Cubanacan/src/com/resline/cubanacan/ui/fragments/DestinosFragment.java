package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelDetails;
import com.resline.cubanacan.src.ws.WSClass.Image.ArrayOfImage;
import com.resline.cubanacan.src.ws.WSClass.Image.Image;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.ui.adapter.DestinosCardAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewWithFAB;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CardViewDestino;
import com.resline.cubanacan.ui.model.CardViewGeneral;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Juan Alejandro on 22/04/2016.
 */
public class DestinosFragment extends RecyclerViewWithFAB {
    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return new DestinosCardAdapter(mActivity, mListCard);
    }

    @Override
    protected List<CardViewBean> getContentInCards() {
        List<CardViewBean> temp = new ArrayList<>();
        // todo: get the content
        temp = populateList();
        return temp;
    }

    private List<CardViewBean> populateList() {
        List<CardViewBean> listCard = new ArrayList<>();
        Map<Long, FullLocation> locations = AppController.getLocations();
        List<FullLocation> locationList = new ArrayList<FullLocation>(locations.values());

        Collections.sort(locationList, new Comparator<FullLocation>() {
            @Override
            public int compare(FullLocation location1, FullLocation location2) {
                String locationName1 = location1.getName();
                String locationName2 = location2.getName();
                if(locationName1 == null)
                    return -1;
                if(locationName2 == null)
                    return 1;
                return locationName1.compareTo(locationName2);
            }
        });

        Iterator it = locations.keySet().iterator();
        while(it.hasNext()){
            Long id = (Long)it.next();
            Uri uri =  Uri.parse(locations.get(id).getImages().getImage().get(0).getImageUrl());
            String name =locations.get(id).getName();
            int countHoteles = locations.get(id).getHotels().getHotelsDetails().size();
            String countHotelesStr = "";
            if(countHoteles != 1)
                countHotelesStr = String.format("%d hoteles", countHoteles);
            else
                countHotelesStr = "1 hotel";
            String habitaciones = "habitaciones ";
            double minimunPrice = getMinimunPrice(locations.get(id).getHotels().getHotelsDetails());
            String minimunPriceStr = String.format("desde %.2f EUR", minimunPrice);
            listCard.add(new CardViewDestino(id, uri, name, countHotelesStr, minimunPriceStr, habitaciones));
        }

        return listCard;
    }

    private double getMinimunPrice(List<HotelDetails> hotels){

        double minimunPrice = 100000;

        for(HotelDetails hotel : hotels){
            if(hotel.getFromPrice() != null){
                if(hotel.getFromPrice() < minimunPrice && hotel.getFromPrice() > 0)
                    minimunPrice = hotel.getFromPrice();
            }
        }

        return minimunPrice;
    }
}
