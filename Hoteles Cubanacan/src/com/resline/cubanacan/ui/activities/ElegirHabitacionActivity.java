package com.resline.cubanacan.ui.activities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Models.AvailableRoomTypeVO;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.src.ws.WSClass.Reservation.BookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.Rooming;
import com.resline.cubanacan.ui.activities.api.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by David on 23/04/2016.
 */
public class ElegirHabitacionActivity extends BaseActivity implements View.OnClickListener {

    LinearLayout llRooms;
    CardView[] listCard;
    RelativeLayout[] relativeLayout;
    TextView[] textView;
    LinearLayout[] linearLayouts;

    CardView[][] cardRoomTypeList;
    LinearLayout[][] rlRoomType;
    ImageView[][] imageViews;

    HotelAvailabilitySearchResultVO hotelSelected = null;
    Long hotelId = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolBar();
        loadViews();
    }

    private void loadViews(){

        Bundle bundle = getIntent().getExtras();


        //Creando las habitaciones
        llRooms = (LinearLayout)findViewById(R.id.llRooms);

        if(bundle != null)
            hotelId = bundle.getLong("idHotel");

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

                listCard = new CardView[countRooms];
                relativeLayout = new RelativeLayout[countRooms];
                textView = new TextView[countRooms];
                linearLayouts = new LinearLayout[countRooms];
                cardRoomTypeList = new CardView[countRooms][];
                //rlRoomType = new RelativeLayout[countRooms][];

                for (int i = 0; i < countRooms; i++) {
                    listCard[i] = new CardView(this);
                    listCard[i].setId(i);
                    CardView.LayoutParams layoutParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(10, 10, 10, 10);
                    listCard[i].setLayoutParams(layoutParams);

                    relativeLayout[i] = new RelativeLayout(this);
                    relativeLayout[i].setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

                    textView[i] = new TextView(this);
                    CardView.LayoutParams layoutParamsTextView = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
                    textView[i].setLayoutParams(layoutParamsTextView);
                    textView[i].setTextSize(18);
                    textView[i].setText("Habitación " + (i + 1));
                    textView[i].setPadding(10, 10, 10, 10);
                    textView[i].setGravity(Gravity.CENTER);
                    textView[i].setTextColor(Color.BLACK);

                    linearLayouts[i] = new LinearLayout(this);
                    linearLayouts[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    linearLayouts[i].setOrientation(LinearLayout.VERTICAL);

                    relativeLayout[i].addView(textView[i]);
                    relativeLayout[i].addView(linearLayouts[i]);
                    listCard[i].addView(relativeLayout[i]);

                    inflateRoomTypes(linearLayouts[i], i);

                    llRooms.addView(listCard[i]);
                }
            }
        }
    }

    private void inflateRoomTypes(LinearLayout content, int position){
        List<AvailableRoomTypeVO> rooms = hotelSelected.getRoomAvailabilitySearchResults().get(position).getAvailableRoomTypes();

        int cont = 0;
        int roomingCount = rooms.size();
        cardRoomTypeList[position] = new CardView[roomingCount];
        for(AvailableRoomTypeVO room : rooms) {

            //Agregando los elementos por cada tipo de habitacion para la habitacion position
            //1- Agregando el CardView que contendra todos los elementos del room type
            cardRoomTypeList[position][cont] = new CardView(this);
            cardRoomTypeList[position][cont].setId(cont);
            CardView.LayoutParams layoutParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4, 4, 4, 4);
            cardRoomTypeList[position][cont].setLayoutParams(layoutParams);
            cardRoomTypeList[position][cont].setElevation(4);
            cardRoomTypeList[position][cont].setPadding(10, 10, 10, 10);
            cardRoomTypeList[position][cont].setForeground(Drawable.createFromPath("@drawable/card_item_selector"));

            //2- Creando el linear layout horizontal que contendra la imagen, un layout central y el checkbox
            LinearLayout linearLayout = new LinearLayout(this);
            CardView.LayoutParams llLayoutParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            //2.1- Agregando la Imagen View
            ImageView imageView = new ImageView(this);
            ViewGroup.LayoutParams imageLayoutParams = new ViewGroup.LayoutParams(0, R.dimen.card_item_img_height);
            imageView.setLayoutParams(imageLayoutParams);
            //TODO como cambiar el weight de una imagen
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(mActivity)
                    .load(AppController.getHotels().get(hotelId).getImages().getImage().get(0).getImageUrl())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.ic_launcher)
                    .into(imageView);

            //2.2- Añadiendo contenido del centro
            //2.2.1- Añadiendo linear layout que contendra los elementos verticalmente
            LinearLayout linearLayoutCentralContent = new LinearLayout(this);
            CardView.LayoutParams llcentralLayoutParams = new CardView.LayoutParams(0, CardView.LayoutParams.WRAP_CONTENT);
            linearLayoutCentralContent.setOrientation(LinearLayout.VERTICAL);
            //TODO linearLayoutCentralContent.setWeightSum(5);

            //2.2.2- Añadiendo el Textview que mostrara el codigo del tipo de habitacion
            TextView tvRoomCode = new TextView(this);
            CardView.LayoutParams codeLayoutParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
            tvRoomCode.setLayoutParams(codeLayoutParams);
            tvRoomCode.setPadding(0, 10, 0, 10);
            tvRoomCode.setTextSize(R.dimen.title_size);
            tvRoomCode.setTextColor(getResources().getColor(R.color.black_button));
            tvRoomCode.setText(room.getCode());

            //2.3- Añadiendo el checkbox
            CheckBox checkBox = new CheckBox(this);

            //Insertando elementos

        }
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_elegir_hab;
    }

    @Override
    protected String getTitleToolBar() {
        return mResources.getString(R.string.pick_room);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }

    private void fragmentTransaction(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.llRooms, fragment)
                    .commit();
        }
    }

    private void setToolBar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.btnPrice:
                if (!btnPrice.isSelected())
                    btnPrice.setSelected(true);

                setFilterList(Filter.PRICE_FILTER);

                btnName.setSelected(false);
                btnCategory.setSelected(false);
                break;
            case R.id.btnName:
                if (!btnName.isSelected())
                    btnName.setSelected(true);

                setFilterList(Filter.NAME_FILTER);

                btnPrice.setSelected(false);
                btnCategory.setSelected(false);
                break;
            case R.id.btnCategory:
                // cambias el bundle aqui en dependencia del caso
                if (!btnCategory.isSelected())
                    btnCategory.setSelected(true);

                setFilterList(Filter.CATEGORY_FILTER);

                btnName.setSelected(false);
                btnPrice.setSelected(false);
                break;
        }
        Fragment fragment = new HotelesListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("filter", filter.ordinal());
        fragment.setArguments(bundle);
        fragmentTransaction(fragment);*/
    }
}
