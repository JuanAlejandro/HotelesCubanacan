package com.resline.cubanacan.ui.fragments;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.google.gson.Gson;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.*;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Models.HotelAvailabilitySearchResultVO;
import com.resline.cubanacan.src.ws.WSClass.Reservation.ArrayOfBookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.BookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.PaymentMethodEnum;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationRequest;
import com.resline.cubanacan.src.ws.WSClass.system.ArrayOfInt;
import com.resline.cubanacan.src.ws.WebServicesClient;
import com.resline.cubanacan.ui.activities.HotelesListActivity;
import com.resline.cubanacan.ui.activities.MainActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import com.resline.cubanacan.ui.utils.ErrorDialogFragment;
import com.resline.cubanacan.ui.view.GenericDialogs;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Juan Alejandro on 11/04/2016.
 */
public class ReservarFragment extends BaseFragment implements View.OnClickListener {
    private View mViewInfoFragment;

    private EditText etDestino;

    private AutoCompleteTextView actvHoteles;

    private CardView setEntrada;

    private CardView setSalida;

    private DatePickerDialog dpdCheckIn, dpdCheckOut;

    // Elementos visuales de la fecha a seleccionar
    private TextView tvInDia, tvInDiaMes, tvInMes, tvInAnno;
    private TextView tvOutDia, tvOutDiaMes, tvOutMes, tvOutAnno;

    // card views
    private CardView defaultRoom;
    private CardView secondRoom;
    private CardView thirdRoom;
    private CardView fourthRoom;
    private CardView fifthRoom;

    TextView tvCantAdOne;
    TextView tvCantAdTwo;
    TextView tvCantAdThree;
    TextView tvCantAdFour;
    TextView tvCantAdFive;

    TextView tvCantNinOne;
    TextView tvCantNinTwo;
    TextView tvCantNinThree;
    TextView tvCantNinFour;
    TextView tvCantNinFive;

    private Button btnLessHab, btnPlusHab;
    private Button btnLessAdults, btnPlusAdults;
    private Button btnLessChild, btnPlusChild;
    private Button btnLessNinAgeOne, btnLessNinAgeTwo, btnLessNinAgeThree;
    private Button btnPlusNinAgeOne, btnPlusNinAgeTwo, btnPlusNinAgeThree;
    private TextView tvHabs, tvAdults, tvChild;
    private TextView tvCantNinAgeOne, tvCantNinAgeTwo, tvCantNinAgeThree;

    // linear layouts with kids age
    // default
    private RelativeLayout llKidAgeFirstDefault;
    private RelativeLayout llKidAgeSecondDefault;
    private RelativeLayout llKidAgeThirdDefault;

    private Button btnMasOpciones;
    private Button btnBuscar;

    private int conteoHab = 1;

    private int maxRoomsCount = 5;
    private int maxChildrenCount = 3;

    //Arreglos de Contadores para que me sea mas comodo a la hora de leer sus valores
    int[] countAdults = new int[maxRoomsCount];
    int[] countChildren = new int[maxRoomsCount];
    int[][] childrenAges = new int[maxRoomsCount][maxChildrenCount];

    private String[] locationsList;
    private ArrayList<String> hotelsList;
    private ArrayList<Long> locationsIdList;

    MaterialDialog progressDialog;

    int countRooms = 1;
    Long idLocation = -1L;
    int posLocation = 0;
    int currentRoom = 1;

    public static ReservarFragment newInstance() {
        return new ReservarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_reservar, container, false);

        loadViews();

        initCalendarFilter();

        loadSpinners();

        return mViewInfoFragment;
    }

    private void loadViews() {
        etDestino = (EditText) mViewInfoFragment.findViewById(R.id.etDestino);
        etDestino.setOnClickListener(this);

        actvHoteles = (AutoCompleteTextView) mViewInfoFragment.findViewById(R.id.actvHoteles);

        //Ajustando calendario del checkin
        setEntrada = (CardView) mViewInfoFragment.findViewById(R.id.cvIn);

        tvInDia = (TextView) mViewInfoFragment.findViewById(R.id.tvInDia);
        tvInDiaMes = (TextView) mViewInfoFragment.findViewById(R.id.tvInDiaMes);
        tvInMes = (TextView) mViewInfoFragment.findViewById(R.id.tvInMes);
        tvInAnno = (TextView) mViewInfoFragment.findViewById(R.id.tvInAnno);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        //TODO Ver el format para lo que se necesita
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateStrIn = dateFormat.format(calendar.getTime());

        tvInDiaMes.setText(dateStrIn.substring(0,2));
        tvInMes.setText(dateStrIn.substring(3,5));
        tvInMes.setVisibility(View.VISIBLE);
        tvInAnno.setText(dateStrIn.substring(6,10));

        setEntrada.setOnClickListener(this);

        //Ajustando calendario del checkout
        setSalida = (CardView) mViewInfoFragment.findViewById(R.id.cvOut);

        tvOutDia = (TextView) mViewInfoFragment.findViewById(R.id.tvOutDia);
        tvOutDiaMes = (TextView) mViewInfoFragment.findViewById(R.id.tvOutDiaMes);
        tvOutMes = (TextView) mViewInfoFragment.findViewById(R.id.tvOutMes);
        tvOutAnno = (TextView) mViewInfoFragment.findViewById(R.id.tvOutAnno);

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        String dateStrOut = dateFormat.format(calendar.getTime());
        tvOutDiaMes.setText(dateStrOut.substring(0,2));
        tvOutMes.setText(dateStrOut.substring(3,5));
        tvOutAnno.setText(dateStrOut.substring(6,10));

        setSalida.setOnClickListener(this);

        // card views
        initializeCardViews();

        // buttons to select quantity
        // default people card or form
        initializeDefaultPeopleForm();

        // final buttons

        btnBuscar = (Button) mViewInfoFragment.findViewById(R.id.btnBuscar);

        btnMasOpciones = (Button) mViewInfoFragment.findViewById(R.id.btnOtrasOpciones);

        btnBuscar.setOnClickListener(this);

        btnMasOpciones.setOnClickListener(this);

        for (int i = 0; i < maxRoomsCount; i++) {
            countAdults[i] = 1;
            countChildren[i] = 0;
            for (int j = 0; j < maxChildrenCount; j++) {
                childrenAges[i][j] = 0;
            }
        }
    }

    private void loadSpinners() {

        Map<Long, FullLocation> locations = AppController.getLocations();
        List<FullLocation> locationList = new ArrayList<FullLocation>(locations.values());

        Collections.sort(locationList, new Comparator<FullLocation>() {
            @Override
            public int compare(FullLocation location1, FullLocation location2) {
                return new String(location1.getName()).compareTo(new String(location2.getName()));
            }
        });

        Collection<Map.Entry<Long, FullLocation>> locationsData = locations.entrySet();
        int pos = 1;
        locationsList = new String[locations.size() + 1];
        locationsList[0] = "Todos";
        locationsIdList = new ArrayList<Long>();
        locationsIdList.add(-1L);
        for (FullLocation item : locationList) {
            locationsList[pos++] = item.getName();
            locationsIdList.add(item.getId());
        }

        ArrayAdapter locationsAdapter = new ArrayAdapter<String>(this.getContext(),
                R.layout.autocomplete_list_item, locationsList);
        locationsAdapter.setDropDownViewResource(R.layout.autocomplete_list_item);

        Map<Long, HotelFullDetails> hotels = AppController.getHotels();

        if (hotels != null) {
            Collection<Map.Entry<Long, HotelFullDetails>> hotelsData = hotels.entrySet();
            hotelsList = new ArrayList<String>();
            for (Map.Entry<Long, HotelFullDetails> item : hotelsData) {
                hotelsList.add(item.getValue().getName());
            }

            ArrayAdapter hotelsAdapter = new ArrayAdapter<String>(this.getContext(),
                    R.layout.autocomplete_list_item, hotelsList);
            hotelsAdapter.setDropDownViewResource(R.layout.autocomplete_list_item);
            //actvHoteles.setDropDownBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.autocomplete_dropdown));
            actvHoteles.setAdapter(hotelsAdapter);
            actvHoteles.setThreshold(1);
        } /*else {
            actvHoteles.setEnabled(false);
        }*/
    }

    private void initializeCardViews() {
        defaultRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeople);
        secondRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleTwo);
        thirdRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleThree);
        fourthRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleFour);
        fifthRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleFive);

        // set onClickListener()
        defaultRoom.setOnClickListener(this);
        secondRoom.setOnClickListener(this);
        thirdRoom.setOnClickListener(this);
        fourthRoom.setOnClickListener(this);
        fifthRoom.setOnClickListener(this);

        tvCantAdOne = (TextView) mViewInfoFragment.findViewById(R.id.tvCantAd);
        tvCantAdTwo = (TextView) mViewInfoFragment.findViewById(R.id.tvCantAdTwo);
        tvCantAdThree = (TextView) mViewInfoFragment.findViewById(R.id.tvCantAdThree);
        tvCantAdFour = (TextView) mViewInfoFragment.findViewById(R.id.tvCantAdFour);
        tvCantAdFive = (TextView) mViewInfoFragment.findViewById(R.id.tvCantAdFive);

        tvCantNinOne = (TextView)mViewInfoFragment.findViewById(R.id.tvCantNin);
        tvCantNinTwo = (TextView)mViewInfoFragment.findViewById(R.id.tvCantNinTwo);
        tvCantNinThree = (TextView)mViewInfoFragment.findViewById(R.id.tvCantNinThree);
        tvCantNinFour = (TextView)mViewInfoFragment.findViewById(R.id.tvCantNinFour);
        tvCantNinFive = (TextView)mViewInfoFragment.findViewById(R.id.tvCantNinFive);
    }

    private void initializeDefaultPeopleForm() {
        // room
        btnLessHab = (Button) mViewInfoFragment.findViewById(R.id.btnLessHab);
        btnPlusHab = (Button) mViewInfoFragment.findViewById(R.id.btnPlusHab);
        // plus and less room
        btnLessHab.setOnClickListener(this);
        btnPlusHab.setOnClickListener(this);
        // to show how many habs are selected
        tvHabs = (TextView) mViewInfoFragment.findViewById(R.id.tvCantHab);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.etDestino:{
                showLocationsDialog();
                break;
            }
            case R.id.cvIn:
                showDatePicker(dpdCheckIn);
                break;
            case R.id.cvOut:
                showDatePicker(dpdCheckOut);
                break;
            // rooms
            case R.id.btnLessHab:
                if (conteoHab > 1) {
                    conteoHab--;
                    hideRooms(conteoHab);
                } else {
                    Toast.makeText(mActivity, R.string.must_reservar_msg, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnPlusHab:
                if (conteoHab < 5) {
                    conteoHab++;
                    showRoom(conteoHab);
                } else {
                    Toast.makeText(mActivity, R.string.only_reservar_msg, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cvPeople:
                currentRoom = 1;
                showHabitacionDatosDialog(1);
                break;
            case R.id.cvPeopleTwo:
                currentRoom = 2;
                showHabitacionDatosDialog(2);
                break;
            case R.id.cvPeopleThree:
                currentRoom = 3;
                showHabitacionDatosDialog(3);
                break;
            case R.id.cvPeopleFour:
                currentRoom = 4;
                showHabitacionDatosDialog(4);
                break;
            case R.id.cvPeopleFive:
                currentRoom = 5;
                showHabitacionDatosDialog(5);
                break;
            // default room
            case R.id.btnLessAd:
                if (countAdults[currentRoom - 1 ] > 1) {
                    countAdults[currentRoom - 1 ]--;
                    updateAdults(countAdults[currentRoom - 1 ]);
                }
                break;
            case R.id.btnPlusAd:
                if (countAdults[currentRoom - 1 ] < 3) {
                    countAdults[currentRoom - 1 ]++;
                    updateAdults(countAdults[currentRoom - 1 ]);
                }
                break;
            // kids
            case R.id.btnPlusNin:
                if (countChildren[currentRoom - 1 ] < 3) {
                    countChildren[currentRoom - 1 ]++;
                    showKidAge(countChildren[currentRoom - 1 ]);
                }
                break;
            case R.id.btnLessNin:
                if (countChildren[currentRoom - 1 ] > 0) {
                    countChildren[currentRoom - 1]--;
                    hideKidAge(countChildren[currentRoom - 1]);
                }
                break;
//            //kids age
            case R.id.btnLessNinAgeOne:
                if (childrenAges[currentRoom - 1][0] > 0) {
                    childrenAges[currentRoom - 1][0]--;
                    showChildAgeOne(childrenAges[currentRoom - 1][0]);
                }
                break;
            case R.id.btnPlusNinAgeOne:
                if (childrenAges[currentRoom - 1][0] < 12) {
                    childrenAges[currentRoom - 1][0]++;
                    showChildAgeOne(childrenAges[currentRoom - 1][0]);
                }
                break;
            case R.id.btnLessNinAgeTwo:
                if (childrenAges[0][1] > 0) {
                    childrenAges[0][1]--;
                    showChildAgeTwo(childrenAges[currentRoom - 1][0]);
                }
                break;
            case R.id.btnPlusNinAgeTwo:
                if (childrenAges[0][1] < 12) {
                    childrenAges[0][1]++;
                    showChildAgeTwo(childrenAges[currentRoom - 1][0]);
                }
                break;
            case R.id.btnLessNinAgeThree:
                if (childrenAges[0][2] > 0) {
                    childrenAges[0][2]--;
                    showChildAgeThree(childrenAges[currentRoom - 1][0]);
                }
                break;
            case R.id.btnPlusNinAgeThree:
                if (childrenAges[0][2] < 12) {
                    childrenAges[0][2]++;
                    showChildAgeThree(childrenAges[currentRoom - 1][0]);
                }
                break;
            case R.id.btnBuscar:
                progressDialog = GenericDialogs.showProgressDialog(mActivity, R.string.wait_title, R.string.wait_find_hotels).build();
                progressDialog.show();
                search();
                break;
            case R.id.btnOtrasOpciones:
                break;
        }
    }

    private void showHabitacionDatosDialog(int numHab) {
        final MaterialDialog dialogHabitacion = GenericDialogs.getMaterialDialogBuilder(mActivity)
                .title(R.string.mas_opciones)
                .positiveText(R.string.accept)
                /*.neutralText(R.string.cancelar)*/
                .buttonsGravity(GravityEnum.CENTER)
                .autoDismiss(false)
                .customView(R.layout.dialog_habitacion, true)
                .callback(new DialogCallback())
                .show();

        // To customize and initialize dialog's elements
        View dialogCustomView = dialogHabitacion.getCustomView();
        if (dialogCustomView != null) {
            btnLessAdults = (Button) dialogCustomView.findViewById(R.id.btnLessAd);
            btnPlusAdults = (Button) dialogCustomView.findViewById(R.id.btnPlusAd);
            btnLessChild = (Button) dialogCustomView.findViewById(R.id.btnLessNin);
            btnPlusChild = (Button) dialogCustomView.findViewById(R.id.btnPlusNin);

            btnLessAdults.setOnClickListener(this);
            btnPlusAdults.setOnClickListener(this);
            btnLessChild.setOnClickListener(this);
            btnPlusChild.setOnClickListener(this);

            // text views of quantity of adults, rooms, and children
            tvAdults = (TextView) dialogCustomView.findViewById(R.id.tvCantAd);
            tvChild = (TextView) dialogCustomView.findViewById(R.id.tvCantNin);

            btnLessNinAgeOne = (Button) dialogCustomView.findViewById(R.id.btnLessNinAgeOne);
            btnLessNinAgeTwo = (Button) dialogCustomView.findViewById(R.id.btnLessNinAgeTwo);
            btnLessNinAgeThree = (Button) dialogCustomView.findViewById(R.id.btnLessNinAgeThree);

            btnPlusNinAgeOne = (Button) dialogCustomView.findViewById(R.id.btnPlusNinAgeOne);
            btnPlusNinAgeTwo = (Button) dialogCustomView.findViewById(R.id.btnPlusNinAgeTwo);
            btnPlusNinAgeThree = (Button) dialogCustomView.findViewById(R.id.btnPlusNinAgeThree);

            btnLessNinAgeOne.setOnClickListener(this);
            btnLessNinAgeTwo.setOnClickListener(this);
            btnLessNinAgeThree.setOnClickListener(this);

            btnPlusNinAgeOne.setOnClickListener(this);
            btnPlusNinAgeTwo.setOnClickListener(this);
            btnPlusNinAgeThree.setOnClickListener(this);

            //        // default
            llKidAgeFirstDefault = (RelativeLayout) dialogCustomView.findViewById(R.id.llNinnosAgeOne);
            llKidAgeSecondDefault = (RelativeLayout) dialogCustomView.findViewById(R.id.llNinnosAgeTwo);
            llKidAgeThirdDefault = (RelativeLayout) dialogCustomView.findViewById(R.id.llNinnosAgeThree);

            tvCantNinAgeOne = (TextView) dialogCustomView.findViewById(R.id.tvCantNinAgeOne);
            tvCantNinAgeTwo = (TextView) dialogCustomView.findViewById(R.id.tvCantNinAgeTwo);
            tvCantNinAgeThree = (TextView) dialogCustomView.findViewById(R.id.tvCantNinAgeThree);

            updateControls(numHab);

        }
    }

    private void updateControls(int numHab){

        tvAdults.setText(String.valueOf(countAdults[currentRoom - 1]));
        tvChild.setText(String.valueOf(countChildren[currentRoom - 1]));
        for(int i=1; i<=countChildren[currentRoom-1]; i++){
            showKidAge(i);
            switch(i){
                case 1:
                    tvCantNinAgeOne.setText(String.valueOf(childrenAges[numHab-1][i-1]));
                    break;
                case 2:
                    tvCantNinAgeTwo.setText(String.valueOf(childrenAges[numHab-1][i-1]));
                    break;
                case 3:
                    tvCantNinAgeThree.setText(String.valueOf(childrenAges[numHab-1][i-1]));
                    break;
            }
        }
    }

    // Clase para atender las acciones de respuesta del dialogo
    private class DialogCallback extends MaterialDialog.ButtonCallback {

        public DialogCallback() {
        }

        @Override
        public void onPositive(MaterialDialog dialog) {

            View dialogCustomView = dialog.getCustomView();

            if (dialogCustomView != null) {
            }

            dialog.dismiss();
        }

        /*@Override
        public void onNeutral(MaterialDialog dialog) {
            View dialogCustomView = dialog.getCustomView();

            if (dialogCustomView != null) {
            }
            dialog.dismiss();
        }*/
    }

    private void updateKidAge(int conteoKid){
        switch (currentRoom){
            case 1:
                tvCantNinOne.setText(String.valueOf(conteoKid));
                break;
            case 2:
                tvCantNinTwo.setText(String.valueOf(conteoKid));
                break;
            case 3:
                tvCantNinThree.setText(String.valueOf(conteoKid));
                break;
            case 4:
                tvCantNinFour.setText(String.valueOf(conteoKid));
                break;
            case 5:
                tvCantNinFive.setText(String.valueOf(conteoKid));
                break;
        }
    }

    private void hideKidAge(int conteoKid) {
        switch (conteoKid) {
            case 0:
                llKidAgeFirstDefault.setVisibility(View.GONE);
                tvChild.setText("0");
                break;
            case 1:
                llKidAgeSecondDefault.setVisibility(View.GONE);
                tvChild.setText("1");
                break;
            case 2:
                llKidAgeThirdDefault.setVisibility(View.GONE);
                tvChild.setText("2");
                break;
        }
        updateKidAge(conteoKid);
    }

    private void showKidAge(int conteoKid) {
        switch (conteoKid) {
            case 1:
                llKidAgeFirstDefault.setVisibility(View.VISIBLE);
                tvChild.setText("1");
                break;
            case 2:
                llKidAgeSecondDefault.setVisibility(View.VISIBLE);
                tvChild.setText("2");
                break;
            case 3:
                llKidAgeThirdDefault.setVisibility(View.VISIBLE);
                tvChild.setText("3");
                break;
        }
        updateKidAge(conteoKid);
    }

    private void showRoom(int conteoHab) {
        switch (conteoHab) {
            case 2:
                secondRoom.setVisibility(View.VISIBLE);
                tvHabs.setText("2");
                break;
            case 3:
                thirdRoom.setVisibility(View.VISIBLE);
                tvHabs.setText("3");
                break;
            case 4:
                fourthRoom.setVisibility(View.VISIBLE);
                tvHabs.setText("4");
                break;
            case 5:
            default:
                fifthRoom.setVisibility(View.VISIBLE);
                tvHabs.setText("5");
                break;
        }
    }

    private void hideRooms(int conteoHab) {
        switch (conteoHab) {
            case 1:
                secondRoom.setVisibility(View.GONE);
                tvHabs.setText("1");
                break;
            case 2:
                thirdRoom.setVisibility(View.GONE);
                tvHabs.setText("2");
                break;
            case 3:
                fourthRoom.setVisibility(View.GONE);
                tvHabs.setText("3");
                break;
            case 4:
            default:
                fifthRoom.setVisibility(View.GONE);
                tvHabs.setText("4");
                break;
        }
    }

    private void updateAdults(int value){
        tvAdults.setText(String.valueOf(value));

        switch (currentRoom){
            case 1:
                tvCantAdOne.setText(String.valueOf(value));
                break;
            case 2:
                tvCantAdTwo.setText(String.valueOf(value));
                break;
            case 3:
                tvCantAdThree.setText(String.valueOf(value));
                break;
            case 4:
                tvCantAdFour.setText(String.valueOf(value));
                break;
            case 5:
                tvCantAdFive.setText(String.valueOf(value));
                break;
        }
    }

    private void showChildAgeOne(int value) {
        tvCantNinAgeOne.setText(String.valueOf(value));
    }

    private void showChildAgeTwo(int value) {
        tvCantNinAgeTwo.setText(String.valueOf(value));
    }

    private void showChildAgeThree(int value) {
        tvCantNinAgeThree.setText(String.valueOf(value));
    }

    private void initCalendarFilter() {
        // Get the date of tomorrow
        Calendar dateCheckIn = Calendar.getInstance();
        dateCheckIn.add(Calendar.DAY_OF_YEAR, 1);

        // By default the selected day is tomorrow
        dpdCheckIn = DatePickerDialog.newInstance(
                new CheckInDatePickerListener(),
                dateCheckIn.get(Calendar.YEAR),
                dateCheckIn.get(Calendar.MONTH),
                dateCheckIn.get(Calendar.DAY_OF_MONTH)
        );
        dpdCheckIn.setMinDate(dateCheckIn);

        Calendar dateCheckOut = Calendar.getInstance();
        dateCheckOut.add(Calendar.DAY_OF_YEAR, 2);
        dpdCheckOut = DatePickerDialog.newInstance(
                new CheckOutDatePickerListener(),
                dateCheckOut.get(Calendar.YEAR),
                dateCheckOut.get(Calendar.MONTH),
                dateCheckOut.get(Calendar.DAY_OF_MONTH)
        );
        dpdCheckOut.setMinDate(dateCheckOut);
    }

    private class CheckInDatePickerListener implements DatePickerDialog.OnDateSetListener {
        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link java.util.Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

            tvInDiaMes.setText(String.valueOf(dayOfMonth));
            tvInMes.setText(String.valueOf((monthOfYear + 1)));
            tvInAnno.setText(String.valueOf(year));

            Calendar checkOutCalendar = Calendar.getInstance();
            checkOutCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            checkOutCalendar.set(Calendar.MONTH, monthOfYear);
            checkOutCalendar.set(Calendar.YEAR, year);
            checkOutCalendar.add(Calendar.DAY_OF_YEAR, 1);

            tvOutDiaMes.setText(String.valueOf(checkOutCalendar.get(Calendar.DAY_OF_MONTH)));
            tvOutMes.setText(String.valueOf(checkOutCalendar.get(Calendar.MONTH) + 1));
            tvOutAnno.setText(String.valueOf(checkOutCalendar.get(Calendar.YEAR)));

            dpdCheckOut = DatePickerDialog.newInstance(
                    new CheckOutDatePickerListener(),
                    checkOutCalendar.get(Calendar.YEAR),
                    checkOutCalendar.get(Calendar.MONTH),
                    checkOutCalendar.get(Calendar.DAY_OF_MONTH));
            dpdCheckOut.setMinDate(checkOutCalendar);
        }
    }

    private class CheckOutDatePickerListener implements DatePickerDialog.OnDateSetListener {
        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link java.util.Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
//
            tvOutDiaMes.setText(String.valueOf(dayOfMonth));
            tvOutMes.setText(String.valueOf((monthOfYear + 1)));
            tvOutAnno.setText(String.valueOf(year));
        }
    }

    private void showDatePicker(DatePickerDialog datePickerDialog) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show date picker dialog
            datePickerDialog.show(mActivity.getFragmentManager(), TAG);
        }
    }

    private void search() {
        try {

            int maxResults = 100;
            SearchHotelCriteria hotelCriteria = new SearchHotelCriteria();

            //Llenando el SearchHotelCriteria
            //1- Cantidad de noches

            DateFormat dateFormat = DateFormat.getDateInstance();

            final String checkInStr = String.format("%s/%s/%s", tvInDiaMes.getText(), tvInMes.getText(), tvInAnno.getText());
            String checkOutStr = String.format("%s/%s/%s", tvOutDiaMes.getText(), tvOutMes.getText(), tvOutAnno.getText());

            final Date checkIn = dateFormat.parse(checkInStr);
            Date checkOut = dateFormat.parse(checkOutStr);

            Long msCheckOut = checkOut.getTime();
            Long msCheckIn = checkIn.getTime();
            Long msDifference = msCheckOut - msCheckIn;
            long nights = msDifference / (1000 * 60 * 60 * 24);
            hotelCriteria.setNights((int) nights);
            GregorianCalendar checkOutCalendar = new GregorianCalendar();
            checkOutCalendar.setTime(checkOut);

            //2- Nombre del Hotel
            String hotelName = actvHoteles.getText().toString();
            if (hotelName.length() != 0)
                hotelCriteria.setResortName(actvHoteles.getText().toString());

            //3- Id del Destino
            if (idLocation != -1)
                hotelCriteria.setLocationId(idLocation);

            //4- CheckIn
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            hotelCriteria.setCheckInDate(dateFormat.format(checkIn));

            //5- Habitaciones
            //Por cada habitacion se crea un RoomAllocation
            int countRooms = Integer.parseInt(tvHabs.getText().toString());
            RoomAllocation[] roomAllocation = new RoomAllocation[countRooms];
            BookedRoom[] bookedRoom = new BookedRoom[countRooms];
            ArrayOfInt[] childrenAgesArrayInt = new ArrayOfInt[countRooms];
            ArrayOfBookedRoom arrayBookedRoom = new ArrayOfBookedRoom();
            for (int i = 0; i < countRooms; i++) {
                roomAllocation[i] = new RoomAllocation();
                roomAllocation[i].setQuantity(1);
                roomAllocation[i].setAdults(countAdults[i]);
                int countOfChildren = countChildren[i];
                childrenAgesArrayInt[i] = new ArrayOfInt();
                for (int j = 0; j < countOfChildren; j++) {
                    childrenAgesArrayInt[i].getInt().add(childrenAges[i][j]);
                }
                roomAllocation[i].setChildrenAges(childrenAgesArrayInt[i]);

                hotelCriteria.getAllocation().getRoomAllocation().add(roomAllocation[i]);

                bookedRoom[i] = new BookedRoom();
                bookedRoom[i].setAdults(countAdults[i]);
                bookedRoom[i].setChildrenAges(childrenAgesArrayInt[i]);
                arrayBookedRoom.getBookedRoom().add(bookedRoom[i]);
            }

            SearchHotelRequest searchHotelRequest = new SearchHotelRequest();
            searchHotelRequest.setMaxResults(maxResults);
            searchHotelRequest.setCriteria(hotelCriteria);

            //Guardando los datos de la reservacion
            RoomReservationRequest roomReservationRequest = new RoomReservationRequest();
            roomReservationRequest.setCheckIn(dateFormat.format(checkIn));
            roomReservationRequest.setCheckOut(dateFormat.format(checkOut));
            roomReservationRequest.setPaymentMethod(PaymentMethodEnum.CREDIT_CAR);
            roomReservationRequest.setRooms(arrayBookedRoom);

            AppController.setRoomReservationRequest(roomReservationRequest);
            AppController.setSearchHotelCriteria(hotelCriteria);

            Gson gson = new Gson();
            String searchHotelRequestJson = gson.toJson(searchHotelRequest);
            //String searchHotelRequestJson = "{\"criteria\":{\"allocation\":{\"roomAllocation\":[{\"childrenAges\":{\"int\":[0]},\"adults\":2,\"quantity\":1}]},\"checkInDate\":\"2016-04-20\",\"locationId\":5,\"nights\":1},\"maxResults\":10}";
            //String searchHotelRequestJson = "{\"maxResults\":200,\"criteria\":{\"nights\":1,\"checkInDate\":\"2016-04-10\",\"allocation\":{\"roomAllocation\":[{\"childrenAges\":{\"int\":[]},\"quantity\":1,\"adults\":1},{\"childrenAges\":{\"int\":[]},\"quantity\":1,\"adults\":1}]}}}";

            WebServicesClient.get().searchHotels("SearchHotels", searchHotelRequestJson,
                    new Callback<HotelAvaibilityResponse>() {
                        @Override
                        public void success(HotelAvaibilityResponse hotelAvaibilityResponse, Response response) {
                            progressDialog.dismiss();
                            if (hotelAvaibilityResponse == null) {
                                Toast.makeText(getContext(), "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
                                return;
                            } else if (hotelAvaibilityResponse.getOperationMessage().equals("OK")) {
                                AppController.setCurrentSearchResult(hotelAvaibilityResponse);

                                String[] checkinStr = new String[4];
                                checkinStr[0] = tvInDiaMes.getText().toString();
                                checkinStr[1] = tvInMes.getText().toString();
                                checkinStr[2] = tvInAnno.getText().toString();
                                checkinStr[3] = tvInDia.getText().toString();

                                String[] checkoutStr = new String[4];
                                checkoutStr[0] = tvOutDiaMes.getText().toString();
                                checkoutStr[1] = tvOutMes.getText().toString();
                                checkoutStr[2] = tvOutAnno.getText().toString();
                                checkoutStr[3] = tvOutDia.getText().toString();

                                AppController.setCheckinStr(checkinStr);
                                AppController.setCheckoutStr(checkoutStr);

                                startActivity(new Intent(getContext(), HotelesListActivity.class));
                            } else {
                                FragmentManager fm = mActivity.getFragmentManager();
                                String errorMessage = hotelAvaibilityResponse.getError();
                                ErrorDialogFragment errorDialog = ErrorDialogFragment.newInstance(errorMessage);
                                errorDialog.show(fm, "fragment_alert");
                            }
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
                        }
                    });
        } catch (Exception e) {
            String excep = e.getMessage();
        }
    }

    /*private class OnLocationsSelectedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // Mostrar listado de Destinos
            // todo: Hacer esto cuando se seleccione el destino
            int position = 0;
            idLocation = locationsIdList.get(position);
        }
    }*/

    private void showLocationsDialog() {

        final MaterialDialog dialogLocations = new MaterialDialog.Builder(mActivity)
                .title(R.string.locations_title)
                .items(locationsList)
                .theme(Theme.LIGHT)
                .itemsCallbackSingleChoice(posLocation, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        posLocation = which;
                        idLocation = locationsIdList.get(which);
                        etDestino.setText(locationsList[which]);
                        return true;
                    }
                })
                .positiveText(R.string.ok)
                .show();
    }
}
