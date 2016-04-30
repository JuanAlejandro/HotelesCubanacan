package com.resline.cubanacan.ui.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.General.CountryResponse;
import com.resline.cubanacan.src.ws.WSClass.General.TitlesResponse;
import com.resline.cubanacan.src.ws.WSClass.Models.AvailableRoomTypeVO;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.src.ws.WSClass.Models.MealPlanDetailsVO;
import com.resline.cubanacan.src.ws.WebServicesClient;
import com.resline.cubanacan.ui.activities.api.BaseActivity;
import com.resline.cubanacan.ui.model.CheckBoxTag;
import com.resline.cubanacan.ui.model.MealPlanButtonTag;
import com.resline.cubanacan.ui.utils.MealPlanDialogFragment;
import com.squareup.picasso.Picasso;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by David on 23/04/2016.
 */
public class ElegirHabitacionActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private LinearLayout llRooms;
    private CardView[] listCard;
    private TextView[] textView;
    private LinearLayout[] linearLayouts, linearLayoutsRooms;

    private CardView[][] cardRoomTypeList;

    private HotelAvailabilitySearchResultVO hotelSelected = null;
    private Long hotelId = null;

    private TextView totalPrice;
    private double totalPriceValue = 0;

    private CheckBox[][] checkBox;
    private int countRooms;

    private Button[][] btnMealPlan;
    private Button btnElegirHab;

    boolean countriesReady, titlesReady;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolBar();
        loadViews();
    }

    private void loadViews() {

        Bundle bundle = getIntent().getExtras();

        //Creando las habitaciones
        llRooms = (LinearLayout) findViewById(R.id.llRooms);
        totalPrice = (TextView) findViewById(R.id.tvAPagar);
        btnElegirHab = (Button) findViewById(R.id.btnElegirHab);

        btnElegirHab.setOnClickListener(this);

        if (bundle != null)
            hotelId = bundle.getLong("idHotel");

        boolean hotelFind = false;
        if (hotelId != null) {
            for (HotelAvailabilitySearchResultVO hotel : AppController.getCurrentSearchResult().getHotelsAvaibility()) {
                if (hotel.getId().equals(hotelId)) {
                    hotelSelected = hotel;
                    hotelFind = true;
                    break;
                }
            }

            if (hotelFind) {
                this.countRooms = AppController.getRoomReservationRequest().getRooms().getBookedRoom().size();

                listCard = new CardView[countRooms];
                textView = new TextView[countRooms];
                linearLayouts = new LinearLayout[countRooms];
                linearLayoutsRooms = new LinearLayout[countRooms];
                cardRoomTypeList = new CardView[countRooms][];
                checkBox = new CheckBox[countRooms][];
                btnMealPlan = new Button[countRooms][];

                for (int i = 0; i < countRooms; i++) {
                    listCard[i] = new CardView(this);
                    listCard[i].setId(i);
                    CardView.LayoutParams layoutParams = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(10, 10, 10, 10);
                    listCard[i].setLayoutParams(layoutParams);

                    linearLayoutsRooms[i] = new LinearLayout(this);
                    linearLayoutsRooms[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                    linearLayoutsRooms[i].setOrientation(LinearLayout.VERTICAL);

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

                    linearLayoutsRooms[i].addView(textView[i]);

                    inflateRoomTypes(linearLayouts[i], i);

                    linearLayoutsRooms[i].addView(linearLayouts[i]);
                    listCard[i].addView(linearLayoutsRooms[i]);
                    llRooms.addView(listCard[i]);
                }
            }
        }

        setTotalPrice(AppController.getCurrentSearchResult().getCurrencyName());
    }

    private void inflateRoomTypes(LinearLayout content, int position) {
        List<AvailableRoomTypeVO> rooms = hotelSelected.getRoomAvailabilitySearchResults().get(position).getAvailableRoomTypes();

        int cont = 0;
        int countRoom = rooms.size();
        cardRoomTypeList[position] = new CardView[countRoom];
        checkBox[position] = new CheckBox[countRoom];
        btnMealPlan[position] = new Button[countRoom];
        for (AvailableRoomTypeVO room : rooms) {

            LayoutInflater inflater = LayoutInflater.from(this);
            int id = R.layout.card_room_type;
            CardView cardView = (CardView) inflater.inflate(id, null, false);

            TextView roomCode = (TextView) cardView.findViewById(R.id.tvTitleOne);
            roomCode.setText(room.getCode());

            TextView roomPrice = (TextView) cardView.findViewById(R.id.tvSubTitleOne);
            String price = String.format("%s %s", String.valueOf(room.getPrice()), room.getCurrencyName());
            roomPrice.setText(price);

            ImageView roomImage = (ImageView) cardView.findViewById(R.id.ivRoomImage);
            Picasso.with(this)
                    .load(AppController.getHotels().get(hotelId).getImages().getImage().get(0).getImageUrl())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.ic_launcher)
                    .into(roomImage);


            long idMealPlan = -1;
            double mealPlanPrice = 0;

            btnMealPlan[position][cont] = (Button) cardView.findViewById(R.id.btnMealPlan);
            if (hotelSelected.isAllInclusive()) {
                btnMealPlan[position][cont].setVisibility(View.INVISIBLE);
            } else {
                btnMealPlan[position][cont].setVisibility(View.VISIBLE);
                btnMealPlan[position][cont].setText(room.getMealPlans().get(0).getCode());
                btnMealPlan[position][cont].setTag(new MealPlanButtonTag(position, cont));
                btnMealPlan[position][cont].setOnClickListener(this);
                idMealPlan = room.getMealPlans().get(0).getId();
                mealPlanPrice = (double) room.getMealPlansPrices().get(String.valueOf(idMealPlan));
            }

            checkBox[position][cont] = (CheckBox) (cardView.findViewById(R.id.cbRoom));
            if (cont == 0) {
                totalPriceValue += room.getPrice();
                checkBox[position][cont].setChecked(true);
            }
            checkBox[position][cont].setTag(new CheckBoxTag(position, cont, room.getPrice(), idMealPlan, mealPlanPrice));
            checkBox[position][cont++].setOnCheckedChangeListener(this);

            content.addView(cardView);
        }
    }

    private void setTotalPrice(String currency) {

        double price = 0;
        for (int i = 0; i < this.countRooms; i++) {
            for (int j = 0; j < checkBox[i].length; j++) {
                if (checkBox[i][j].isChecked()) {
                    CheckBoxTag tag = (CheckBoxTag) checkBox[i][j].getTag();
                    price += tag.getPrice() + tag.getMealPlanPrice();
                }
            }
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        String priceStr = formatter.format(price);
        String priceFormat = String.format("%s %s", priceStr, currency);
        totalPrice.setText(priceFormat);
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

        Object tag = v.getTag();
        if (tag instanceof MealPlanButtonTag) {
            //lanzar el Alert para seleccionar los meal plan
            MealPlanButtonTag mealPlanButtonTag = (MealPlanButtonTag) tag;
            int positionRoom = mealPlanButtonTag.getPositionRoom();
            int positionRoomType = mealPlanButtonTag.getPositionRoomType();

            //Lista de opciones
            List<MealPlanDetailsVO> mealPlanDetailsVOList = hotelSelected.getRoomAvailabilitySearchResults().get(positionRoom).getAvailableRoomTypes().get(positionRoomType).getMealPlans();
            Map mealPlanPrices = hotelSelected.getRoomAvailabilitySearchResults().get(positionRoom).getAvailableRoomTypes().get(positionRoomType).getMealPlansPrices();

            long[] ids = new long[mealPlanDetailsVOList.size()];
            String[] options = new String[mealPlanDetailsVOList.size()];
            double[] prices = new double[mealPlanDetailsVOList.size()];
            int cont = 0;
            for (MealPlanDetailsVO mealPlanDetailsVO : mealPlanDetailsVOList) {

                ids[cont] = mealPlanDetailsVO.getId();
                options[cont] = mealPlanDetailsVO.getCode();
                prices[cont++] = (double) mealPlanPrices.get(String.valueOf(mealPlanDetailsVO.getId()));
            }

            FragmentManager fm = this.getFragmentManager();
            MealPlanDialogFragment mealPlanDialogFragment = MealPlanDialogFragment.newInstance(ids, options, prices, "Planes Alimenticios", positionRoom, positionRoomType);
            mealPlanDialogFragment.show(fm, "fragment_alert");
        } else {
            switch (v.getId()) {
                case R.id.btnElegirHab:
                    goToHoldersData();
                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        CheckBoxTag tag = (CheckBoxTag) buttonView.getTag();
        int roomPosition = tag.getRoomPosition();
        int roomTypePosition = tag.getRoomTypePosition();
        boolean isUnique = true;

        //Algoritmo para que solo este marcado un check dentro de cada habitacion solicitada
        //Si lo que voy a hacer es deseleccionar no lo dejo hacer
        if (!isChecked) {
            if (checkBox[roomPosition].length == 1)
                checkBox[roomPosition][roomTypePosition].setChecked(true);
            for (int i = 0; i < checkBox[roomPosition].length; i++)
                if (checkBox[roomPosition][i].isChecked() && roomTypePosition != i)
                    isUnique = false;
            if (isUnique)
                checkBox[roomPosition][roomTypePosition].setChecked(true);
        } else {
            //Si selecciono alguna otra opcion entonces deselecciono la que etsaba marcada
            for (int i = 0; i < checkBox[roomPosition].length; i++)
                if (checkBox[roomPosition][i].isChecked() && roomTypePosition != i)
                    checkBox[roomPosition][i].setChecked(false);


            //Mando a actualizar el letrero del precio
            setTotalPrice(AppController.getCurrentSearchResult().getCurrencyName());
        }
    }

    public void selectedMealPlan(int positionRoom, int positionRoomType, Long mealPriceId, String mealPlanCode, double mealPlanPrice) {
        btnMealPlan[positionRoom][positionRoomType].setText(mealPlanCode);
        ((CheckBoxTag) checkBox[positionRoom][positionRoomType].getTag()).setIdMealPlan(mealPriceId);
        ((CheckBoxTag) checkBox[positionRoom][positionRoomType].getTag()).setMealPlanPrice(mealPlanPrice);
        setTotalPrice(AppController.getCurrentSearchResult().getCurrencyName());
    }

    private void goToHoldersData() {
        //Llenando los datos del roomreservation
        for (int i = 0; i < this.countRooms; i++) {
            for (int j = 0; j < checkBox[i].length; j++) {

                if (checkBox[i][j].isChecked()) {
                    long idMealPlan = ((CheckBoxTag) checkBox[i][j].getTag()).getIdMealPlan();
                    long idRoomType = hotelSelected.getRoomAvailabilitySearchResults().get(i).getAvailableRoomTypes()
                            .get(j).getId();

                    AppController.getRoomReservationRequest().getRooms().getBookedRoom().get(i).setMealPlanId(idMealPlan);
                    AppController.getRoomReservationRequest().getRooms().getBookedRoom().get(i).setRoomTypeId(idRoomType);
                    //TODO Aqui faltaria entrar tambien los datos de los servicios opcionales
                }
            }
        }
        loadCountries();
    }

    private void loadCountries() {

        WebServicesClient.get().getCountries("getCountry", null, new Callback<CountryResponse>() {
            @Override
            public void success(CountryResponse countryResponse, Response response) {
                if (countryResponse == null) {
                    showErrorMessage();
                } else {
                    if (countryResponse.getOperationMessage().equals("OK")) {
                        AppController.setCountries(countryResponse);
                    }
                }
                countriesReady = true;
                isAllReady();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                showErrorMessage();
                countriesReady = true;
                isAllReady();
            }
        });

        WebServicesClient.get().getTitles("getTitles", null, new Callback<TitlesResponse>() {
            @Override
            public void success(TitlesResponse titlesResponse, Response response) {
                if (titlesResponse == null) {
                    showErrorMessage();
                } else {
                    if (titlesResponse.getOperationMessage().equals("OK")) {
                        AppController.setTitles(titlesResponse);
                    }
                }
                titlesReady = true;
                isAllReady();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                showErrorMessage();
                titlesReady = true;
                isAllReady();
            }
        });
    }

    private void isAllReady() {
        if (countriesReady && titlesReady) {
            startActivity(new Intent(ElegirHabitacionActivity.this, ConfirmarReservaActivity.class).putExtras(getBundle()));
        }
    }

    private void showErrorMessage() {

        Toast.makeText(ElegirHabitacionActivity.this, "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
    }

    private Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("idHotel", hotelId);
        bundle.putDouble("price", totalPriceValue);
        return bundle;
    }
}
