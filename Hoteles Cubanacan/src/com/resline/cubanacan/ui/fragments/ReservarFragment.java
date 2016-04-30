package com.resline.cubanacan.ui.fragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.*;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Reservation.ArrayOfBookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.BookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.PaymentMethodEnum;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationRequest;
import com.resline.cubanacan.src.ws.WSClass.system.ArrayOfInt;
import com.resline.cubanacan.src.ws.WebServicesClient;
import com.resline.cubanacan.ui.activities.HotelesListActivity;
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

    private Button btnLessHab, btnPlusHab;
    private Button btnLessAdults, btnPlusAdults;
    private Button btnLessChild, btnPlusChild;
    private Button btnLessNinAgeOne, btnLessNinAgeTwo, btnLessNinAgeThree;
    private Button btnPlusNinAgeOne, btnPlusNinAgeTwo, btnPlusNinAgeThree;
    private TextView tvHabs, tvAdults, tvChild;
    private TextView tvCantNinAgeOne, tvCantNinAgeTwo, tvCantNinAgeThree;

    // 2
    private Button btnLessHabTwo, btnPlusHabTwo;
    private Button btnLessAdultsTwo, btnPlusAdultsTwo;
    private Button btnLessChildTwo, btnPlusChildTwo;
    private Button btnLessNinAgeOneTwo, btnLessNinAgeTwoTwo, btnLessNinAgeThreeTwo;
    private Button btnPlusNinAgeOneTwo, btnPlusNinAgeTwoTwo, btnPlusNinAgeThreeTwo;
    private TextView tvHabsTwo, tvAdultsTwo, tvChildTwo, tvAgeChildTwo;
    private TextView tvCantNinAgeOneTwo, tvCantNinAgeTwoTwo, tvCantNinAgeThreeTwo;

    // 3
    private Button btnLessHabThree, btnPlusHabThree;
    private Button btnLessAdultsThree, btnPlusAdultsThree;
    private Button btnLessChildThree, btnPlusChildThree;
    private Button btnLessNinAgeOneThree, btnLessNinAgeTwoThree, btnLessNinAgeThreeThree;
    private Button btnPlusNinAgeOneThree, btnPlusNinAgeTwoThree, btnPlusNinAgeThreeThree;
    private TextView tvHabsThree, tvAdultsThree, tvChildThree, tvAgeChildThree;
    private TextView tvCantNinAgeOneThree, tvCantNinAgeTwoThree, tvCantNinAgeThreeThree;

    // 4
    private Button btnLessHabFour, btnPlusHabFour;
    private Button btnLessAdultsFour, btnPlusAdultsFour;
    private Button btnLessChildFour, btnPlusChildFour;
    private Button btnLessNinAgeOneFour, btnLessNinAgeTwoFour, btnLessNinAgeThreeFour;
    private Button btnPlusNinAgeOneFour, btnPlusNinAgeTwoFour, btnPlusNinAgeThreeFour;
    private TextView tvHabsFour, tvAdultsFour, tvChildFour, tvAgeChildFour;
    private TextView tvCantNinAgeOneFour, tvCantNinAgeTwoFour, tvCantNinAgeThreeFour;

    // 5
    private Button btnLessHabFive, btnPlusHabFive;
    private Button btnLessAdultsFive, btnPlusAdultsFive;
    private Button btnLessChildFive, btnPlusChildFive;
    private Button btnLessNinAgeOneFive, btnLessNinAgeTwoFive, btnLessNinAgeThreeFive;
    private Button btnPlusNinAgeOneFive, btnPlusNinAgeTwoFive, btnPlusNinAgeThreeFive;
    private TextView tvHabsFive, tvAdultsFive, tvChildFive, tvAgeChildFive;
    private TextView tvCantNinAgeOneFive, tvCantNinAgeTwoFive, tvCantNinAgeThreeFive;

    // linear layouts with kids age
    // default
    private RelativeLayout llKidAgeFirstDefault;
    private RelativeLayout llKidAgeSecondDefault;
    private RelativeLayout llKidAgeThirdDefault;
    // two
    private RelativeLayout llKidAgeFirstTwo;
    private RelativeLayout llKidAgeSecondTwo;
    private RelativeLayout llKidAgeThirdTwo;
    // three
    private RelativeLayout llKidAgeFirstThree;
    private RelativeLayout llKidAgeSecondThree;
    private RelativeLayout llKidAgeThirdThree;
    // four
    private RelativeLayout llKidAgeFirstFour;
    private RelativeLayout llKidAgeSecondFour;
    private RelativeLayout llKidAgeThirdFour;
    // five
    private RelativeLayout llKidAgeFirstFive;
    private RelativeLayout llKidAgeSecondFive;
    private RelativeLayout llKidAgeThirdFive;

    private Button btnMasOpciones;
    private Button btnBuscar;

    private int conteoHab = 1;

    private int maxRoomsCount = 5;
    private int maxChildrenCount = 3;

    private int conteoKidDefault = 0;
    private int conteoKidTwo = 0;
    private int conteoKidThree = 0;
    private int conteoKidFour = 0;
    private int conteoKidFive = 0;

    //Arreglos de Contadores para que me sea mas comodo a la hora de leer sus valores
    int[] countAdults = new int[maxRoomsCount];
    int[] countChildren = new int[maxRoomsCount];
    int[][] childrenAges = new int[maxRoomsCount][maxChildrenCount];

    private ArrayList<String> locationsList, hotelsList;
    private ArrayList<Long> locationsIdList;

    MaterialDialog progressDialog;

    int countRooms = 1;
    Long idLocation = null;

    public static ReservarFragment newInstance() {
        return new ReservarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_reservar, container, false);

        loadViews();

        initCalendarFilter();

        // todo: OJO con esto
        // loadSpinners();

        return mViewInfoFragment;
    }

    private void loadViews() {
        etDestino = (EditText) mViewInfoFragment.findViewById(R.id.etDestino);
        etDestino.setOnClickListener(new OnLocationsSelectedListener());

        actvHoteles = (AutoCompleteTextView) mViewInfoFragment.findViewById(R.id.actvHoteles);

        setEntrada = (CardView) mViewInfoFragment.findViewById(R.id.cvIn);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // todo: set text to every element
//        setEntrada.setText(dateFormat.format(calendar.getTime()));

        setSalida = (CardView) mViewInfoFragment.findViewById(R.id.cvOut);
        calendar.add(Calendar.DAY_OF_YEAR, 3);
//        setSalida.setText(dateFormat.format(calendar.getTime()));

        // Elementos visuales de las fechas
        // Entrada
        tvInDia = (TextView) mViewInfoFragment.findViewById(R.id.tvInDia);
        tvInDiaMes = (TextView) mViewInfoFragment.findViewById(R.id.tvInDiaMes);
        tvInMes = (TextView) mViewInfoFragment.findViewById(R.id.tvInMes);
        tvInAnno = (TextView) mViewInfoFragment.findViewById(R.id.tvInAnno);

        // Entrada
        tvOutDia = (TextView) mViewInfoFragment.findViewById(R.id.tvOutDia);
        tvOutDiaMes = (TextView) mViewInfoFragment.findViewById(R.id.tvOutDiaMes);
        tvOutMes = (TextView) mViewInfoFragment.findViewById(R.id.tvOutMes);
        tvOutAnno = (TextView) mViewInfoFragment.findViewById(R.id.tvOutAnno);


        setEntrada.setOnClickListener(this);

        setSalida.setOnClickListener(this);

        // card views
        initializeCardViews();

        // buttons to select quantity
        // default people card or form
        initializeDefaultPeopleForm();

        initializeSecondPeopleForm();

        initializeThirdPeopleForm();

        initializeFourthPeopleForm();

        initializeFifthPeopleForm();

        initializeLinearLayoutKidsAge();

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

    // todo: OJO con esto
    @Deprecated
    private void loadSpinners() {

        Map<Long, FullLocation> locations = AppController.getLocations();

        if (locations != null) {
            Collection<Map.Entry<Long, FullLocation>> locationsData = locations.entrySet();
            locationsList = new ArrayList<String>();
            locationsIdList = new ArrayList<Long>();
            for (Map.Entry<Long, FullLocation> item : locationsData) {
                locationsList.add(item.getValue().getName());
                locationsIdList.add(item.getValue().getId());
            }

            ArrayAdapter locationsAdapter = new ArrayAdapter<String>(this.getContext(),
                    android.R.layout.simple_spinner_dropdown_item, locationsList);
            locationsAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
//            etDestino.setAdapter(locationsAdapter);
        } else {
//            etDestino.setEnabled(false);
        }

        Map<Long, HotelFullDetails> hotels = AppController.getHotels();

        if (hotels != null) {
            Collection<Map.Entry<Long, HotelFullDetails>> hotelsData = hotels.entrySet();
            hotelsList = new ArrayList<String>();
            for (Map.Entry<Long, HotelFullDetails> item : hotelsData) {
                hotelsList.add(item.getValue().getName());
            }

            ArrayAdapter hotelsAdapter = new ArrayAdapter<String>(this.getContext(),
                    android.R.layout.simple_spinner_dropdown_item, hotelsList);
            hotelsAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
            actvHoteles.setAdapter(hotelsAdapter);
            actvHoteles.setThreshold(1);
        } else {
            etDestino.setEnabled(false);
        }
    }

    private void initializeLinearLayoutKidsAge() {
        // default
        llKidAgeFirstDefault = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeOne);
        llKidAgeSecondDefault = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeTwo);
        llKidAgeThirdDefault = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeThree);
        // two
        llKidAgeFirstTwo = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeOneTwo);
        llKidAgeSecondTwo = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeTwoTwo);
        llKidAgeThirdTwo = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeThreeTwo);
        // three
        llKidAgeFirstThree = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeOneThree);
        llKidAgeSecondThree = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeTwoThree);
        llKidAgeThirdThree = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeThreeThree);
        // four
        llKidAgeFirstFour = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeOneFour);
        llKidAgeSecondFour = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeTwoFour);
        llKidAgeThirdFour = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeThreeFour);
        // five
        llKidAgeFirstFive = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeOneFive);
        llKidAgeSecondFive = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeTwoFive);
        llKidAgeThirdFive = (RelativeLayout) mViewInfoFragment.findViewById(R.id.llNinnosAgeThreeFive);
    }

    private void initializeCardViews() {
        defaultRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeople);
        secondRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleTwo);
        thirdRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleThree);
        fourthRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleFour);
        fifthRoom = (CardView) mViewInfoFragment.findViewById(R.id.cvPeopleFive);
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
        // to select quantity for each person
        btnLessAdults = (Button) mViewInfoFragment.findViewById(R.id.btnLessAd);
        btnLessChild = (Button) mViewInfoFragment.findViewById(R.id.btnLessNin);
        btnPlusAdults = (Button) mViewInfoFragment.findViewById(R.id.btnPlusAd);
        btnPlusChild = (Button) mViewInfoFragment.findViewById(R.id.btnPlusNin);
        // onClickListener
        btnLessAdults.setOnClickListener(this);
        btnLessChild.setOnClickListener(this);
        btnPlusAdults.setOnClickListener(this);
        btnPlusChild.setOnClickListener(this);
        // text views of quantity of adults, rooms, and children
        tvAdults = (TextView) mViewInfoFragment.findViewById(R.id.tvAdultos);
        tvChild = (TextView) mViewInfoFragment.findViewById(R.id.tvCantNin);
    }

    private void initializeSecondPeopleForm() {
        btnLessAdultsTwo = (Button) mViewInfoFragment.findViewById(R.id.btnLessAdTwo);
        btnLessChildTwo = (Button) mViewInfoFragment.findViewById(R.id.btnLessNinTwo);
        btnPlusAdultsTwo = (Button) mViewInfoFragment.findViewById(R.id.btnPlusAdTwo);
        btnPlusChildTwo = (Button) mViewInfoFragment.findViewById(R.id.btnPlusNinTwo);
        // onClickListener
        btnLessAdultsTwo.setOnClickListener(this);
        btnLessChildTwo.setOnClickListener(this);
        btnPlusAdultsTwo.setOnClickListener(this);
        btnPlusChildTwo.setOnClickListener(this);
        // text views of quantity of adults, rooms, and children
        tvAdultsTwo = (TextView) mViewInfoFragment.findViewById(R.id.tvAdultos);
        tvChildTwo = (TextView) mViewInfoFragment.findViewById(R.id.tvCantNin);
    }

    private void initializeThirdPeopleForm() {
        // to select quantity for each person
        btnLessAdultsThree = (Button) mViewInfoFragment.findViewById(R.id.btnLessAdThree);
        btnLessChildThree = (Button) mViewInfoFragment.findViewById(R.id.btnLessNinThree);
        btnPlusAdultsThree = (Button) mViewInfoFragment.findViewById(R.id.btnPlusAdThree);
        btnPlusChildThree = (Button) mViewInfoFragment.findViewById(R.id.btnPlusNinThree);
        // onClickListener
        btnLessAdultsThree.setOnClickListener(this);
        btnLessChildThree.setOnClickListener(this);
        btnPlusAdultsThree.setOnClickListener(this);
        btnPlusChildThree.setOnClickListener(this);
        // text views of quantity of adults, rooms, and children
        tvAdultsThree = (TextView) mViewInfoFragment.findViewById(R.id.tvAdultosThree);
        tvChildThree = (TextView) mViewInfoFragment.findViewById(R.id.tvCantNinThree);
    }

    private void initializeFourthPeopleForm() {
        // to select quantity for each person
        btnLessAdultsFour = (Button) mViewInfoFragment.findViewById(R.id.btnLessAdFour);
        btnLessChildFour = (Button) mViewInfoFragment.findViewById(R.id.btnLessNinFour);
        btnPlusAdultsFour = (Button) mViewInfoFragment.findViewById(R.id.btnPlusAdFour);
        btnPlusChildFour = (Button) mViewInfoFragment.findViewById(R.id.btnPlusNinFour);
        // onClickListener
        btnLessAdultsFour.setOnClickListener(this);
        btnLessChildFour.setOnClickListener(this);
        btnPlusAdultsFour.setOnClickListener(this);
        btnPlusChildFour.setOnClickListener(this);
        // text views of quantity of adults, rooms, and children
        tvAdultsFour = (TextView) mViewInfoFragment.findViewById(R.id.tvAdultosFour);
        tvChildFour = (TextView) mViewInfoFragment.findViewById(R.id.tvCantNinFour);
    }

    private void initializeFifthPeopleForm() {
        // to select quantity for each person
        btnLessAdultsFive = (Button) mViewInfoFragment.findViewById(R.id.btnLessAdFive);
        btnLessChildFive = (Button) mViewInfoFragment.findViewById(R.id.btnLessNinFive);
        btnPlusAdultsFive = (Button) mViewInfoFragment.findViewById(R.id.btnPlusAdFive);
        btnPlusChildFive = (Button) mViewInfoFragment.findViewById(R.id.btnPlusNinFive);
        // onClickListener
        btnLessAdultsFive.setOnClickListener(this);
        btnLessChildFive.setOnClickListener(this);
        btnPlusAdultsFive.setOnClickListener(this);
        btnPlusChildFive.setOnClickListener(this);
        // text views of quantity of adults, rooms, and children
        tvAdultsFive = (TextView) mViewInfoFragment.findViewById(R.id.tvAdultos);
        tvChildFive = (TextView) mViewInfoFragment.findViewById(R.id.tvCantNin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvIn:
                showDatePicker(dpdCheckIn);
                break;
            case R.id.cvOut:
                // todo: when show date picker out set min date as the start date
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
            // default room
            case R.id.btnLessAd:
                if (countAdults[0] > 1) {
                    countAdults[0]--;
                    updateAdDefault();
                }
                break;
            case R.id.btnPlusAd:
                if (countAdults[0] < 3) {
                    countAdults[0]++;
                    updateAdDefault();
                }
                break;
            // kids
            case R.id.btnPlusNin:
                if (countChildren[0] < 3) {
                    countChildren[0]++;
                    showKidDefault(countChildren[0]);
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNin:
                if (countChildren[0] > 0) {
                    countChildren[0]--;
                    hideKidDefault(countChildren[0]);
                } else {
                    // do something
                }
                break;
            //kids age
            case R.id.btnLessNinAgeOne:
                if (childrenAges[0][0] > 0) {
                    childrenAges[0][0]--;
                    showChildAgeOne();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeOne:
                if (childrenAges[0][0] < 12) {
                    childrenAges[0][0]++;
                    showChildAgeOne();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeTwo:
                if (childrenAges[0][1] > 0) {
                    childrenAges[0][1]--;
                    showChildAgeTwo();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeTwo:
                if (childrenAges[0][1] < 12) {
                    childrenAges[0][1]++;
                    showChildAgeTwo();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeThree:
                if (childrenAges[0][2] > 0) {
                    childrenAges[0][2]--;
                    showChildAgeThree();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeThree:
                if (childrenAges[0][2] < 12) {
                    childrenAges[0][2]++;
                    showChildAgeThree();
                } else {
                    // do something
                }
                break;
            // second room
            case R.id.btnLessAdTwo:
                if (countAdults[1] > 1) {
                    countAdults[1]--;
                    updateAdTwo();
                }
                break;
            case R.id.btnPlusAdTwo:
                if (countAdults[1] < 3) {
                    countAdults[1]++;
                    updateAdTwo();
                }
                break;
            // kids
            case R.id.btnPlusNinTwo:
                if (countChildren[1] < 3) {
                    countChildren[1]++;
                    showKidTwo(countChildren[1]);
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinTwo:
                if (countChildren[1] > 0) {
                    countChildren[1]--;
                    hideKidTwo(countChildren[1]);
                } else {
                    // do something
                }
                break;
            //kids age
            case R.id.btnLessNinAgeOneTwo:
                if (childrenAges[1][0] > 0) {
                    childrenAges[1][0]--;
                    showChildAgeOneTwo();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeOneTwo:
                if (childrenAges[1][0] < 12) {
                    childrenAges[1][0]++;
                    showChildAgeOneTwo();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeTwoTwo:
                if (childrenAges[1][1] > 0) {
                    childrenAges[1][1]--;
                    showChildAgeTwoTwo();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeTwoTwo:
                if (childrenAges[1][1] < 12) {
                    childrenAges[1][1]++;
                    showChildAgeTwoTwo();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeThreeTwo:
                if (childrenAges[1][2] > 0) {
                    childrenAges[1][2]--;
                    showChildAgeThreeTwo();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeThreeTwo:
                if (childrenAges[1][2] < 12) {
                    childrenAges[1][2]++;
                    showChildAgeThreeTwo();
                } else {
                    // do something
                }
                break;
            // third room
            case R.id.btnLessAdThree:
                if (countAdults[2] > 1) {
                    countAdults[2]--;
                    updateAdThree();
                }
                break;
            case R.id.btnPlusAdThree:
                if (countAdults[2] < 3) {
                    countAdults[2]++;
                    updateAdThree();
                }
                break;
            // kids
            case R.id.btnPlusNinThree:
                if (countChildren[2] < 3) {
                    countChildren[2]++;
                    showKidThree(countChildren[2]);
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinThree:
                if (countChildren[2] > 0) {
                    countChildren[2]--;
                    hideKidThree(countChildren[2]);
                } else {
                    // do something
                }
                break;
            //kids age
            case R.id.btnLessNinAgeOneThree:
                if (childrenAges[2][0] > 0) {
                    childrenAges[2][0]--;
                    showChildAgeOneThree();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeOneThree:
                if (childrenAges[2][0] < 12) {
                    childrenAges[2][0]++;
                    showChildAgeOneThree();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeTwoThree:
                if (childrenAges[2][1] > 0) {
                    childrenAges[2][1]--;
                    showChildAgeTwoThree();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeTwoThree:
                if (childrenAges[2][1] < 3) {
                    childrenAges[2][1]++;
                    showChildAgeTwoThree();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeThreeThree:
                if (childrenAges[2][2] > 0) {
                    childrenAges[2][2]--;
                    showChildAgeThreeThree();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeThreeThree:
                if (childrenAges[2][2] < 12) {
                    childrenAges[2][2]++;
                    showChildAgeThreeThree();
                } else {
                    // do something
                }
                break;
            // fourth room
            case R.id.btnLessAdFour:
                if (countAdults[3] > 1) {
                    countAdults[3]--;
                    updateAdFour();
                }
                break;
            case R.id.btnPlusAdFour:
                if (countAdults[3] < 3) {
                    countAdults[3]++;
                    updateAdFour();
                }
                break;
            // kids
            case R.id.btnPlusNinFour:
                if (countChildren[3] < 3) {
                    countChildren[3]++;
                    showKidFour(countChildren[3]);
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinFour:
                if (countChildren[3] > 0) {
                    countChildren[3]--;
                    hideKidFour(countChildren[3]);
                } else {
                    // do something
                }
                break;
            //kids age
            case R.id.btnLessNinAgeOneFour:
                if (childrenAges[3][0] > 0) {
                    childrenAges[3][0]--;
                    showChildAgeOneFour();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeOneFour:
                if (childrenAges[3][0] < 12) {
                    childrenAges[3][0]++;
                    showChildAgeOneFour();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeTwoFour:
                if (childrenAges[3][1] > 0) {
                    childrenAges[3][1]--;
                    showChildAgeTwoFour();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeTwoFour:
                if (childrenAges[3][1] < 12) {
                    childrenAges[3][1]++;
                    showChildAgeTwoFour();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeThreeFour:
                if (childrenAges[3][2] > 0) {
                    childrenAges[3][2]--;
                    showChildAgeThreeFour();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeThreeFour:
                if (childrenAges[3][2] < 12) {
                    childrenAges[3][2]++;
                    showChildAgeThreeFour();
                } else {
                    // do something
                }
                break;
            // fifth room
            case R.id.btnLessAdFive:
                if (countAdults[4] > 1) {
                    countAdults[4]--;
                    updateAdFive();
                }
                break;
            case R.id.btnPlusAdFive:
                if (countAdults[4] < 3) {
                    countAdults[4]++;
                    updateAdFive();
                }
                break;
            case R.id.btnPlusNinFive:
                if (countChildren[4] < 3) {
                    countChildren[4]++;
                    showKidFive(countChildren[4]);
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinFive:
                if (countChildren[4] > 0) {
                    countChildren[4]--;
                    hideKidFive(countChildren[4]);
                } else {
                    // do something
                }
                break;
            //kids age
            case R.id.btnLessNinAgeOneFive:
                if (childrenAges[4][0] > 0) {
                    childrenAges[4][0]--;
                    showChildAgeOneFive();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeOneFive:
                if (childrenAges[4][0] < 12) {
                    childrenAges[4][0]++;
                    showChildAgeOneFive();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeTwoFive:
                if (childrenAges[4][1] > 0) {
                    childrenAges[4][1]--;
                    showChildAgeTwoFive();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeTwoFive:
                if (childrenAges[4][1] < 12) {
                    childrenAges[4][1]++;
                    showChildAgeTwoFive();
                } else {
                    // do something
                }
                break;
            case R.id.btnLessNinAgeThreeFive:
                if (childrenAges[4][2] > 0) {
                    childrenAges[4][2]--;
                    showChildAgeThreeFive();
                } else {
                    // do something
                }
                break;
            case R.id.btnPlusNinAgeThreeFive:
                if (childrenAges[4][2] < 12) {
                    childrenAges[4][2]++;
                    showChildAgeThreeFive();
                } else {
                    // do something
                }
                break;

            case R.id.btnBuscar:
                progressDialog = GenericDialogs.showProgressDialog(mActivity, R.string.wait_title, R.string.wait_content).build();
                progressDialog.show();
                search();
                break;
            case R.id.btnOtrasOpciones:
                break;
        }
    }

    private void hideKidDefault(int conteoKid) {
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
    }

    private void hideKidTwo(int conteoKid) {
        switch (conteoKid) {
            case 0:
                llKidAgeFirstTwo.setVisibility(View.GONE);
                tvChildTwo.setText("0");
                break;
            case 1:
                llKidAgeSecondTwo.setVisibility(View.GONE);
                tvChildTwo.setText("1");
                break;
            case 2:
                llKidAgeThirdTwo.setVisibility(View.GONE);
                tvChildTwo.setText("2");
                break;
        }
    }

    private void hideKidThree(int conteoKid) {
        switch (conteoKid) {
            case 0:
                llKidAgeFirstThree.setVisibility(View.GONE);
                tvChildThree.setText("0");
                break;
            case 1:
                llKidAgeSecondThree.setVisibility(View.GONE);
                tvChildThree.setText("1");
                break;
            case 2:
                llKidAgeThirdThree.setVisibility(View.GONE);
                tvChildThree.setText("2");
                break;
        }
    }

    private void hideKidFour(int conteoKid) {
        switch (conteoKid) {
            case 0:
                llKidAgeFirstFour.setVisibility(View.GONE);
                tvChildFour.setText("0");
                break;
            case 1:
                llKidAgeSecondFour.setVisibility(View.GONE);
                tvChildFour.setText("1");
                break;
            case 2:
                llKidAgeThirdFour.setVisibility(View.GONE);
                tvChildThree.setText("2");
                break;
        }
    }

    private void hideKidFive(int conteoKid) {
        switch (conteoKid) {
            case 0:
                llKidAgeFirstFive.setVisibility(View.GONE);
                tvChildFive.setText("0");
                break;
            case 1:
                llKidAgeSecondFive.setVisibility(View.GONE);
                tvChildFive.setText("1");
                break;
            case 2:
                llKidAgeThirdFive.setVisibility(View.GONE);
                tvChildFive.setText("2");
                break;
        }
    }

    private void showKidDefault(int conteoKid) {
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
    }

    private void showKidTwo(int conteoKid) {
        switch (conteoKid) {
            case 1:
                llKidAgeFirstTwo.setVisibility(View.VISIBLE);
                tvChildTwo.setText("1");
                break;
            case 2:
                llKidAgeSecondTwo.setVisibility(View.VISIBLE);
                tvChildTwo.setText("2");
                break;
            case 3:
                llKidAgeThirdTwo.setVisibility(View.VISIBLE);
                tvChildTwo.setText("3");
                break;
        }
    }

    private void showKidThree(int conteoKid) {
        switch (conteoKid) {
            case 1:
                llKidAgeFirstThree.setVisibility(View.VISIBLE);
                tvChildThree.setText("1");
                break;
            case 2:
                llKidAgeSecondThree.setVisibility(View.VISIBLE);
                tvChildThree.setText("2");
                break;
            case 3:
                llKidAgeThirdThree.setVisibility(View.VISIBLE);
                tvChildThree.setText("3");
                break;
        }
    }

    private void showKidFour(int conteoKid) {
        switch (conteoKid) {
            case 1:
                llKidAgeFirstFour.setVisibility(View.VISIBLE);
                tvChildFour.setText("1");
                break;
            case 2:
                llKidAgeSecondFour.setVisibility(View.VISIBLE);
                tvChildFour.setText("2");
                break;
            case 3:
                llKidAgeThirdFour.setVisibility(View.VISIBLE);
                tvChildFour.setText("3");
                break;
        }
    }

    private void showKidFive(int conteoKid) {
        switch (conteoKid) {
            case 1:
                llKidAgeFirstFive.setVisibility(View.VISIBLE);
                tvChildFive.setText("1");
                break;
            case 2:
                llKidAgeSecondFive.setVisibility(View.VISIBLE);
                tvChildFive.setText("2");
                break;
            case 3:
                llKidAgeThirdFive.setVisibility(View.VISIBLE);
                tvChildFive.setText("3");
                break;
        }
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

    private void updateAdDefault() {
        tvAdults.setText(countAdults[0] + "");
    }

    private void updateAdTwo() {
        tvAdultsTwo.setText(countAdults[1] + "");
    }

    private void updateAdThree() {
        tvAdultsThree.setText(countAdults[2] + "");
    }

    private void updateAdFour() {
        tvAdultsFour.setText(countAdults[3] + "");
    }

    private void updateAdFive() {
        tvAdultsFive.setText(countAdults[4] + "");
    }

    private void showChildAgeOne() {
        tvCantNinAgeOne.setText(childrenAges[0][0] + "");
    }

    private void showChildAgeTwo() {
        tvCantNinAgeTwo.setText(childrenAges[0][1] + "");
    }

    private void showChildAgeThree() {
        tvCantNinAgeThree.setText(childrenAges[0][2] + "");
    }

    private void showChildAgeOneTwo() {
        tvCantNinAgeOneTwo.setText(childrenAges[1][0] + "");
    }

    private void showChildAgeTwoTwo() {
        tvCantNinAgeTwoTwo.setText(childrenAges[1][1] + "");
    }

    private void showChildAgeThreeTwo() {
        tvCantNinAgeThreeTwo.setText(childrenAges[1][2] + "");
    }

    private void showChildAgeOneThree() {
        tvCantNinAgeOneThree.setText(childrenAges[2][0] + "");
    }

    private void showChildAgeTwoThree() {
        tvCantNinAgeTwoThree.setText(childrenAges[2][1] + "");
    }

    private void showChildAgeThreeThree() {
        tvCantNinAgeThreeThree.setText(childrenAges[2][2] + "");
    }

    private void showChildAgeOneFour() {
        tvCantNinAgeOneFour.setText(childrenAges[3][0] + "");
    }

    private void showChildAgeTwoFour() {
        tvCantNinAgeTwoFour.setText(childrenAges[3][1] + "");
    }

    private void showChildAgeThreeFour() {
        tvCantNinAgeThreeFour.setText(childrenAges[3][2] + "");
    }

    private void showChildAgeOneFive() {
        tvCantNinAgeOneFive.setText(childrenAges[4][0] + "");
    }

    private void showChildAgeTwoFive() {
        tvCantNinAgeTwoFive.setText(childrenAges[4][1] + "");
    }

    private void showChildAgeThreeFive() {
        tvCantNinAgeThreeFive.setText(childrenAges[4][2] + "");
    }

    private void initCalendarFilter() {
        // Get the date of tomorrow
        Calendar dateCheckIn = Calendar.getInstance();
        dateCheckIn.add(Calendar.DAY_OF_YEAR, 2);

        // By default the selected day is tomorrow
        dpdCheckIn = DatePickerDialog.newInstance(
                new CheckInDatePickerListener(),
                dateCheckIn.get(Calendar.YEAR),
                dateCheckIn.get(Calendar.MONTH),
                dateCheckIn.get(Calendar.DAY_OF_MONTH)
        );
        dpdCheckIn.setMinDate(dateCheckIn);

        Calendar dateCheckOut = Calendar.getInstance();
        dateCheckOut.add(Calendar.DAY_OF_YEAR, 3);
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
            // todo: Establecer fecha para cada elemento
//            setEntrada.setText(String.format("%d/%d/%d", dayOfMonth, (monthOfYear + 1), year));
            Calendar checkOutCalendar = Calendar.getInstance();
            checkOutCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            checkOutCalendar.set(Calendar.MONTH, monthOfYear);
            checkOutCalendar.set(Calendar.YEAR, year);
            checkOutCalendar.add(Calendar.DAY_OF_YEAR, 1);
//            setSalida.setText(String.format("%d/%d/%d", checkOutCalendar.get(Calendar.DAY_OF_MONTH),
//                    checkOutCalendar.get(Calendar.MONTH) + 1,
//                    checkOutCalendar.get(Calendar.YEAR)));
            dpdCheckOut.getSelectedDay().setDay(checkOutCalendar.get(Calendar.YEAR), checkOutCalendar.get(Calendar.MONTH),
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
//            setSalida.setText(String.format("%d/%d/%d", dayOfMonth, (monthOfYear + 1), year));
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
            // todo: Establecer fecha
//            Date checkIn = dateFormat.parse(setEntrada.getText().toString());
//            Date checkOut = dateFormat.parse(setSalida.getText().toString());

//            Long msCheckOut = checkOut.getTime();
//            Long msCheckIn = checkIn.getTime();
//            Long msDifference = msCheckOut - msCheckIn;
//            long nights = msDifference / (1000 * 60 * 60 * 24);
//            hotelCriteria.setNights((int) nights);
//            GregorianCalendar checkOutCalendar = new GregorianCalendar();
//            checkOutCalendar.setTime(checkOut);

            //2- Nombre del Hotel
            String hotelName = actvHoteles.getText().toString();
            if (hotelName.length() != 0)
                hotelCriteria.setResortName(actvHoteles.getText().toString());

            //3- Id del Destino
            if (idLocation != null)
                hotelCriteria.setLocationId(idLocation);

            //4- CheckIn
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            hotelCriteria.setCheckInDate(dateFormat.format(checkIn));

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
            // todo: Comentado
//            roomReservationRequest.setCheckIn(dateFormat.format(checkIn));
//            roomReservationRequest.setCheckOut(dateFormat.format(checkOut));
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
                            Toast.makeText(getContext(), "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
                        }
                    });
        } catch (Exception e) {
            String excep = e.getMessage();
        }
    }

    private class OnLocationsSelectedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // Mostrar listado de Destinos
            // todo: Hacer esto cuando se seleccione el destino
            int position = 0;
            idLocation = locationsIdList.get(position);
        }
    }
}
