package com.resline.cubanacan.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 14/04/2016.
 */
public class ElegirHabitacionActivity1 extends BaseActivity implements View.OnClickListener {

    Long hotelId;
    CardView cvRoom;
    LinearLayout llRooms;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbar();

        Bundle bundle = getIntent().getExtras();
        hotelId = bundle.getLong("idHotel");
        loadViewComponents();
    }

    private void loadViewComponents() {

        /*cvRoom = (CardView)findViewById(R.id.cvRoom);
        llRooms = (LinearLayout)findViewById(R.id.llRooms);
        Button btnReservar = (Button) findViewById(R.id.btnReservar);
        btnReservar.setOnClickListener(this);*/

        loadRoomsType();
    }

    private void setToolbar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_elegir_hab;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.pick_room_title);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }

    private void loadRoomsType(){
        //TODO Esto es para sacar la info del hotel seleccionado pero hay que mejorar la forma de acceso
        HotelAvailabilitySearchResultVO hotelSelected = null;
        for (HotelAvailabilitySearchResultVO hotel:AppController.getCurrentSearchResult().getHotelsAvaibility()) {
            if(hotel.getId() == hotelId){
                hotelSelected = hotel;
            }
        }

        int countRooms = AppController.getRoomReservationRequest().getRooms().getBookedRoom().size();

        CardView[] roomsCardView = new CardView[countRooms];
        LayoutInflater[] layoutInflater = new LayoutInflater[countRooms];

        LinearLayout[] llexample = new LinearLayout[countRooms];

        for(int i=0; i<countRooms; i++){
            layoutInflater[i] = LayoutInflater.from(this);
            llexample[i] = (LinearLayout) layoutInflater[i].inflate(R.layout.card_room_type, llRooms, true);

        }

        /*RelativeLayout[] rlCardView = new RelativeLayout[countRooms];
        TextView[] tvRoomNumber = new TextView[countRooms];
        @IdRes int roomNumberId = 0;
        @IdRes int roomNumberTypeId = 1 + countRooms;
        for(int i=0; i<countRooms; i++){
            rlCardView[i] = new RelativeLayout(this);
            rlCardView[i].setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            //Letrero de la habitacion
            tvRoomNumber[i] = new TextView(this);
            tvRoomNumber[i].setId(roomNumberId++);
            tvRoomNumber[i].setText("Habitación "+(i+1));
            tvRoomNumber[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tvRoomNumber[i].setTextSize(18);
            tvRoomNumber[i].setPadding(10, 10, 10, 10);
            tvRoomNumber[i].setGravity(Gravity.CENTER);
            tvRoomNumber[i].setTextColor(Color.BLACK);

            LinearLayout llRoomContent = new LinearLayout(this);
            llRoomContent.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            int countRoomTypes = hotelSelected.getRoomAvailabilitySearchResults().get(i).getAvailableRoomTypes().size();
            CardView[] cardViewRoomsType = new CardView[countRoomTypes];

            for(int j=0; j<countRoomTypes; j++){

                @IdRes int imenageId = 1 + countRooms + countRoomTypes;
                AvailableRoomTypeVO roomType = hotelSelected.getRoomAvailabilitySearchResults().get(i).getAvailableRoomTypes().get(j);

                cardViewRoomsType[j] = new CardView(this);
                cardViewRoomsType[j].setLayoutParams(new CardView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                cardViewRoomsType[j].setCardElevation(4);
                cardViewRoomsType[j].setPadding(10, 10, 10, 10);
                cardViewRoomsType[j].setClickable(true);
                //cardViewRoomsType[j].setCard(DraR.drawable.card_item_selector);

                RelativeLayout rlRoomType = new RelativeLayout(this);
                rlRoomType.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setId(imenageId++);
                imageView.setBackgroundColor(Color.WHITE);
                Image image = AppController.getHotels().get(hotelId).getImages().getImage().get(0);
                Picasso.with(mActivity)
                        .load(image.getImageUrl())
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.ic_launcher)
                        .into(imageView);

                @IdRes int checkBoxId = 1 + countRooms + 2 * countRoomTypes;
                CheckBox checkBox = new CheckBox(this);
                checkBox.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                RelativeLayout rlRoomTypedescription = new RelativeLayout(this);
                rlRoomTypedescription.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                //Letrero del tipo de habitacion
                TextView tvRoomType = new TextView(this);
                tvRoomType.setId(roomNumberTypeId++);
                tvRoomType.setText(roomType.getCode());
                tvRoomType.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tvRoomType.setTextSize(18);
                tvRoomType.setPadding(10, 10, 10, 10);
                tvRoomType.setGravity(Gravity.CENTER);
                tvRoomType.setTextColor(Color.BLACK);

                //Letrero del precio de la habitacion
                TextView tvRoomPrice = new TextView(this);
                tvRoomPrice.setId(roomNumberTypeId++);
                tvRoomPrice.setText(roomType.getPrice().toString() + AppController.getCurrentSearchResult().getCurrencyName());
                tvRoomPrice.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tvRoomPrice.setTextSize(14);
                tvRoomPrice.setPadding(10, 10, 16, 16);
                tvRoomPrice.setTextColor(Color.BLACK);

                rlRoomTypedescription.addView(checkBox);
                rlRoomTypedescription.addView(tvRoomType);
                rlRoomType.addView(rlRoomTypedescription);
                rlRoomType.addView(imageView);
                rlRoomType.addView(tvRoomPrice);
                cardViewRoomsType[j].addView(rlRoomType);
                llRoomContent.addView(cardViewRoomsType[j]);
            }
            rlCardView[i].addView(tvRoomNumber[i]);
            rlCardView[i].addView(llRoomContent);
            cvRoom.addView(rlCardView[i]);
        }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReservar:
                startActivity(new Intent(ElegirHabitacionActivity1.this, ConfirmarReservaActivity.class));
                break;
        }
    }
}
