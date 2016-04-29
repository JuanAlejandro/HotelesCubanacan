package com.resline.cubanacan.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.General.Country;
import com.resline.cubanacan.src.ws.WSClass.General.CountryResponse;
import com.resline.cubanacan.src.ws.WSClass.General.Title;
import com.resline.cubanacan.src.ws.WSClass.General.TitlesResponse;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelFullDetails;
import com.resline.cubanacan.src.ws.WSClass.Image.Image;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocationResponse;
import com.resline.cubanacan.src.ws.WSClass.Reservation.BookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.PersonalTitleEnum;
import com.resline.cubanacan.src.ws.WSClass.Reservation.Principal;
import com.resline.cubanacan.src.ws.WSClass.Reservation.Rooming;
import com.resline.cubanacan.src.ws.WebServicesClient;
import com.resline.cubanacan.ui.activities.ConfirmarReservaActivity;
import com.resline.cubanacan.ui.activities.ElegirHabitacionActivity;
import com.resline.cubanacan.ui.activities.SplashActivity;
import com.resline.cubanacan.ui.activities.TitularActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import com.resline.cubanacan.ui.fragments.api.RecyclerViewFragment;
import com.resline.cubanacan.ui.model.CardViewBean;
import com.resline.cubanacan.ui.model.CheckBoxTag;
import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan Alejandro on 18/04/2016.
 */
public class ConfirmarReservaFragment extends RecyclerViewFragment implements View.OnClickListener {
    private View mViewInfoFragment;

    private ImageView[] ivStarts;

    private ImageView hotelImage;

    private TextView tvNombreHotel;

    private TextView tvSubtitulo;

    private TextView in, out;

    private TextView tvImporte;

    private Spinner spinANombreDe;

    private EditText etNombre, etApellidos;

    private Spinner[] spCountry, spTitle;

    private CheckBox cbFumador;

    private Button btnSiguiente;

    private Long hotelId;
    private Double price;

    private int countRooms;

    private TextView[] roomNumber;
    private EditText[] titularName;
    private TextView[] titularLastName;
    private CheckBox[] isSmoker;

    private ArrayList<String> countriesList, countriesCodeList;
    private ArrayList<String> titlesList, titlesCodeList;
    private String[] countryCode, titleCode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_confirm_reserva, container, false);

        loadViewComponents();

        return mViewInfoFragment;
    }

    @Override
    protected RecyclerView.Adapter getRecyclerViewCardAdapter(Activity mActivity, List<CardViewBean> mListCard) {
        return null;
    }

    @Override
    protected List<CardViewBean> getContentInCards() {
        return null;
    }

    @Override
    protected void loadViewComponents() {

        //Categoria
        ivStarts = new ImageView[5];
        ivStarts[0] = (ImageView)mViewInfoFragment.findViewById(R.id.start1);
        ivStarts[1] = (ImageView)mViewInfoFragment.findViewById(R.id.start2);
        ivStarts[2] = (ImageView)mViewInfoFragment.findViewById(R.id.start3);
        ivStarts[3] = (ImageView)mViewInfoFragment.findViewById(R.id.start4);
        ivStarts[4] = (ImageView)mViewInfoFragment.findViewById(R.id.start5);

        hotelImage = (ImageView)mViewInfoFragment.findViewById(R.id.ivHotelImageRoomConfirm);

        // nombre del hotel
        tvNombreHotel = (TextView) mViewInfoFragment.findViewById(R.id.tvTitle);

        // subtitulo
        tvSubtitulo = (TextView) mViewInfoFragment.findViewById(R.id.tvSubtitle);

        // in & out
        in = (TextView) mViewInfoFragment.findViewById(R.id.tvIn);
        out = (TextView) mViewInfoFragment.findViewById(R.id.tvOut);

        // importe
        tvImporte = (TextView) mViewInfoFragment.findViewById(R.id.tvImporte);

        // spinner a nombre de...
        spinANombreDe = (Spinner) mViewInfoFragment.findViewById(R.id.spinTitular);

        // nombre & apellidos
        etNombre = (EditText) mViewInfoFragment.findViewById(R.id.etNombre);
        etApellidos = (EditText) mViewInfoFragment.findViewById(R.id.etApellidos);

        // spinner pais
        //spinPais = (Spinner) mViewInfoFragment.findViewById(R.id.spinPais);

        // fumador
        cbFumador = (CheckBox) mViewInfoFragment.findViewById(R.id.cbFumador);

        // boton siguiente
        btnSiguiente = (Button) mViewInfoFragment.findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(this);

        this.countRooms = AppController.getRoomReservationRequest().getRooms().getBookedRoom().size();

        loadHotelInfo();

        loadSpinners();

        inflateHolderRoomForm();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSiguiente:
                goToRoomReservationHolderData();
                startActivity(new Intent(mActivity, TitularActivity.class));
                break;
        }
    }

    private void loadHotelInfo(){
        Bundle bundle = getActivity().getIntent().getExtras();
        hotelId = bundle.getLong("idHotel");
        price = bundle.getDouble("price");

        HotelFullDetails hotel = AppController.getHotels().get(hotelId);

        Image image = hotel.getImages().getImage().get(0);

        Picasso.with(mActivity)
                .load(image.getImageUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_launcher)
                .into(hotelImage);

        paintStars(hotel.getCategoryEnum().ordinal()+2);

        tvNombreHotel.setText(hotel.getName());
        tvSubtitulo.setText(String.format("Reservación para %d noche(s)", AppController.getSearchHotelCriteria().getNights()));
    }

    private void paintStars(int countStars){

        for(int i=0; i<countStars; i++){
            ivStarts[0].setVisibility(View.VISIBLE);
        }
    }

    private void inflateHolderRoomForm(){

        roomNumber = new TextView[this.countRooms];
        titularName = new EditText[this.countRooms];
        titularLastName = new EditText[this.countRooms];
        isSmoker = new CheckBox[this.countRooms];
        spCountry = new Spinner[this.countRooms];
        spTitle = new Spinner[this.countRooms];

        LinearLayout linearLayout = (LinearLayout)mViewInfoFragment.findViewById(R.id.llHabitaciones);

        for(int i=0; i<this.countRooms; i++) {

            LayoutInflater inflater = LayoutInflater.from(getActivity());
            int id = R.layout.card_room_titular;
            CardView cardView = (CardView) inflater.inflate(id, null, false);

            RelativeLayout relativeLayout = (RelativeLayout) cardView.findViewById(R.id.rlHabitaciones);

            roomNumber[i] = (TextView) cardView.findViewById(R.id.tvTitular);
            roomNumber[i].setText("Habitación " + (i + 1));

            TextView labelTitle = (TextView) cardView.findViewById(R.id.tvHabANombreTitle);

            spTitle[i] = (Spinner) cardView.findViewById(R.id.spinTitular);
            spTitle[i].setTag(i);
            if(titlesList != null){
                ArrayAdapter titlesAdapter = new ArrayAdapter<String>(this.getContext(),
                        android.R.layout.simple_spinner_dropdown_item, titlesList);
                titlesAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                spTitle[i].setAdapter(titlesAdapter);
                spTitle[i].setOnItemSelectedListener(new ConfirmarReservaFragment.OnTitlesSelectedListener());
            } else {
                spTitle[i].setEnabled(false);
            }


            titularName[i] = (EditText) cardView.findViewById(R.id.etNombre);

            titularLastName[i] = (EditText) cardView.findViewById(R.id.etApellidos);

            spCountry[i] = (Spinner) cardView.findViewById(R.id.spinPais);
            spCountry[i].setTag(i);
            if(countriesList != null){
                ArrayAdapter countriesAdapter = new ArrayAdapter<String>(this.getContext(),
                        android.R.layout.simple_spinner_dropdown_item, countriesList);
                countriesAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                spCountry[i].setAdapter(countriesAdapter);
                spCountry[i].setOnItemSelectedListener(new ConfirmarReservaFragment.OnCountriesSelectedListener());
            } else {
                spCountry[i].setEnabled(false);
            }

            isSmoker[i] = (CheckBox) cardView.findViewById(R.id.cbFumador);

            linearLayout.addView(cardView);
        }
    }

    private void loadSpinners() {

        CountryResponse countries = AppController.getCountries();

        if (countries != null) {
            countriesList = new ArrayList<String>();
            countriesCodeList = new ArrayList<String>();
            countryCode = new String[this.countRooms];
            for (Country country : countries.getCountryResult().getCountry()) {
                countriesList.add(country.getName());
                countriesCodeList.add(country.getCountryCode());
            }
        }

        TitlesResponse titles = AppController.getTitles();

        if (titles != null) {
            titlesList = new ArrayList<String>();
            titlesCodeList = new ArrayList<String>();
            titleCode = new String[this.countRooms];
            for (Title title : titles.getTitleResult()) {
                titlesList.add(title.getName());
                titlesCodeList.add(title.getCode());
            }
        }

    }

    private void goToRoomReservationHolderData(){

        for(int i=0; i<this.countRooms; i++){
            BookedRoom bookedRoom = new BookedRoom();
            Rooming rooming = new Rooming();
            Principal principal = new Principal();
            principal.setCountryCode(countryCode[i]);
            principal.setFirstName(titularName[i].toString());
            principal.setLastName(titularLastName[i].toString());
            principal.setPersonalTitle(PersonalTitleEnum.fromValue(titleCode[i]));
            rooming.setPrincipal(principal);
            //rooming.setRequirements();
            rooming.setSmoking(isSmoker[i].isChecked());
            rooming.setPrincipal(principal);

            AppController.getRoomReservationRequest().getRooms().getBookedRoom().get(i).getRoomings().getRooming().add(rooming);
        }
        startActivity(new Intent(mViewInfoFragment.getContext(), TitularActivity.class).putExtras(getBundle()));
    }

    private Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("idHotel", hotelId);
        bundle.putDouble("price", price);
        return bundle;
    }

    private class OnCountriesSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int pos = (int)parent.getTag();
            countryCode[pos] = countriesCodeList.get(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class OnTitlesSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int pos = (int)parent.getTag();
            titleCode[pos] = titlesCodeList.get(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
