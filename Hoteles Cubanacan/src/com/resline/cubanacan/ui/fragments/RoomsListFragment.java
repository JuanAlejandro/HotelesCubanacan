package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelAvaibilityResponse;
import com.resline.cubanacan.src.ws.WSClass.Image.ArrayOfImage;
import com.resline.cubanacan.src.ws.WSClass.Image.Image;
import com.resline.cubanacan.src.ws.WSClass.Models.AvailableRoomTypeVO;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.src.ws.WSClass.Models.RoomAvailabilitySearchResultVO;
import com.resline.cubanacan.ui.adapter.HotelesCardsAdapter;
import com.resline.cubanacan.ui.adapter.RoomsCardsAdapter;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewFragment;
import com.resline.cubanacan.ui.fragments.api.RoomViewFragment;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.RoomTypeViewBean;
import com.resline.cubanacan.ui.model.RoomViewBean;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by David on 23/04/2016.
 */
public class RoomsListFragment extends RoomViewFragment {

    FrameLayout flRooms;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Long hotelId = null;

        //Creando las habitaciones
        //llRooms = (LinearLayout)getActivity().findViewById(R.id.llRooms);

        if(bundle != null)
            hotelId = bundle.getLong("idHotel");

        HotelAvailabilitySearchResultVO hotelSelected = null;
        boolean hotelFind = false;
        if(hotelId != null) {
            for (HotelAvailabilitySearchResultVO hotel : AppController.getCurrentSearchResult().getHotelsAvaibility()) {
                if (hotel.getId() == hotelId) {
                    hotelSelected = hotel;
                    hotelFind = true;
                    break;
                }
            }

            if (hotelFind) {
                int countRooms = AppController.getRoomReservationRequest().getRooms().getBookedRoom().size();
                CardView[] listCard = new CardView[countRooms];
                for (int i = 0; i < countRooms; i++) {
                    listCard[i] = new CardView(getContext());
                    listCard[i].setId(i);
                    CardView.LayoutParams layoutParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(10, 10, 10, 10);
                    listCard[i].setLayoutParams(layoutParams);

                    RelativeLayout relativeLayout = new RelativeLayout(getContext());
                    relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

                    TextView textView = new TextView(getActivity());
                    CardView.LayoutParams layoutParamsTextView = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
                    textView.setLayoutParams(layoutParamsTextView);
                    textView.setTextSize(18);
                    textView.setText("Habitación " + (i + 1));
                    textView.setPadding(10, 10, 10, 10);
                    textView.setGravity(Gravity.CENTER);
                    textView.setTextColor(Color.BLACK);

                    relativeLayout.addView(textView);
                    listCard[i].addView(relativeLayout);
                    flRooms.addView(listCard[i]);
                }
            }
        }

    }

    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<RoomViewBean> mListCard) {
        return new RoomsCardsAdapter(mActivity, mListCard);
    }

    @Override
    protected List<RoomViewBean> getContentInCards() {
        List<RoomViewBean> temp;
        Bundle bundle = getArguments();
        if(bundle != null)
            temp = populateList(bundle.getLong("idHotel"));
        else
            temp = populateList(null);

        return temp;
    }

    private List<RoomViewBean> populateList(Long hotelId) {

        HotelAvailabilitySearchResultVO hotelSelected = null;
        List<RoomViewBean> listCard = new ArrayList<>();
        /*boolean hotelFind = false;
        if(hotelId != null){
            for (HotelAvailabilitySearchResultVO hotel:AppController.getCurrentSearchResult().getHotelsAvaibility()) {
                if(hotel.getId() == hotelId){
                    hotelSelected = hotel;
                    hotelFind = true;
                    break;
                }
            }

            if(hotelFind){
                int countRooms = AppController.getRoomReservationRequest().getRooms().getBookedRoom().size();
                for(int i=0; i<countRooms; i++){
                    List<RoomTypeViewBean> listRoomType = new ArrayList<RoomTypeViewBean>();
                    for(AvailableRoomTypeVO room : hotelSelected.getRoomAvailabilitySearchResults().get(i).getAvailableRoomTypes()) {
                        listRoomType.add(new RoomTypeViewBean(room.getId(), room.getCode(), room.getPrice()));
                    }
                    listCard.add(new RoomViewBean((i+1), "Habitación "+(i+1), listRoomType));
                }
            }
        }*/

        return listCard;
    }
}
