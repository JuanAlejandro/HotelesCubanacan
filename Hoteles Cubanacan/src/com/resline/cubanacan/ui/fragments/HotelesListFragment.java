package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelesListFragment extends RecyclerViewFragment {
    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return new HotelesCardsAdapter(mActivity, mListCard);
    }

    @Override
    protected List<CardViewBean> getContentInCards() {
        List<CardViewBean> temp = new ArrayList<>();
        // todo: get the content
        temp = populateList();
        return temp;
    }

    private List<CardViewBean> populateList() {
        //TODO Buscar como ordenar listas en java
        List<HotelAvailabilitySearchResultVO> hotels = AppController.getCurrentSearchResult().getHotelsAvaibility();

        Map<Long, ArrayOfImage> hotelImages = AppController.getCurrentSearchResult().getHotelImage();
        Collection<Map.Entry<Long, ArrayOfImage>> hotelImagesData = hotelImages.entrySet();

        List<CardViewBean> listCard = new ArrayList<>();

        for (HotelAvailabilitySearchResultVO hotel : hotels) {
            Image image = hotelImages.get(hotel.getId()).getImage().get(0);
            Double minimumPrice = hotel.getMinimumPrice();
            String price = "";
            if(minimumPrice != null)
                price = minimumPrice.toString();
            //TODO como crear una uri para la imagen
            listCard.add(new CardViewBean(null, hotel.getName(), hotel.getLocationName(), price));
        }
        return listCard;
    }
}
