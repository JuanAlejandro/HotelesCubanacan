package com.resline.cubanacan.ui.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.HotelesListActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * Created by Juan Alejandro on 11/04/2016.
 */
public class ReservarFragment extends BaseFragment implements View.OnClickListener {
    private View mViewInfoFragment;

    private Spinner spinnerDestino;

    private AutoCompleteTextView actvHoteles;

    private Button setEntrada;

    private Button setSalida;

    private DatePickerDialog dpd;

    // card views
    private CardView defaultRoom;
    private CardView secondRoom;
    private CardView thirdRoom;
    private CardView fourthRoom;
    private CardView fifthRoom;

    // todo: optimizar esto (hacerlo de forma dinámica)
    // default
    private Button btnLessHab, btnPlusHab;
    private Button btnLessAdults, btnPlusAdults;
    private Button btnLessChild, btnPlusChild;
    private TextView tvHabs, tvAdults, tvChild;

    // 2
    private Button btnLessHabTwo, btnPlusHabTwo;
    private Button btnLessAdultsTwo, btnPlusAdultsTwo;
    private Button btnLessChildTwo, btnPlusChildTwo;
    private TextView tvHabsTwo, tvAdultsTwo, tvChildTwo;

    // 3
    private Button btnLessHabThree, btnPlusHabThree;
    private Button btnLessAdultsThree, btnPlusAdultsThree;
    private Button btnLessChildThree, btnPlusChildThree;
    private TextView tvHabsThree, tvAdultsThree, tvChildThree;

    // 4
    private Button btnLessHabFour, btnPlusHabFour;
    private Button btnLessAdultsFour, btnPlusAdultsFour;
    private Button btnLessChildFour, btnPlusChildFour;
    private TextView tvHabsFour, tvAdultsFour, tvChildFour;

    // 5
    private Button btnLessHabFive, btnPlusHabFive;
    private Button btnLessAdultsFive, btnPlusAdultsFive;
    private Button btnLessChildFive, btnPlusChildFive;
    private TextView tvHabsFive, tvAdultsFive, tvChildFive;

    private Button btnMasOpciones;
    private Button btnBuscar;

    private int conteoHab = 1;

    public static ReservarFragment newInstance() {
        return new ReservarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_reservar, container, false);

        loadViews();

        initCalendarFilter();

        return mViewInfoFragment;
    }

    private void loadViews() {
        spinnerDestino = (Spinner) mViewInfoFragment.findViewById(R.id.actvDestino);

        actvHoteles = (AutoCompleteTextView) mViewInfoFragment.findViewById(R.id.actvHoteles);

        setEntrada = (Button) mViewInfoFragment.findViewById(R.id.btnSetEntrada);

        setSalida = (Button) mViewInfoFragment.findViewById(R.id.btnSetSalida);

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

        // final buttons
        btnBuscar = (Button) mViewInfoFragment.findViewById(R.id.btnBuscar);
        btnMasOpciones = (Button) mViewInfoFragment.findViewById(R.id.btnOtrasOpciones);

        btnBuscar.setOnClickListener(this);
        btnMasOpciones.setOnClickListener(this);
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
            case R.id.btnSetEntrada:
                showDatePicker();
                break;
            case R.id.btnSetSalida:
                // todo: when show date picker out set min date as the start date
                showDatePicker();
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
                break;
            case R.id.btnLessNin:
                break;
            case R.id.btnPlusAd:
                break;
            case R.id.btnPlusNin:
                break;
            // second room
            case R.id.btnLessAdTwo:
                break;
            case R.id.btnLessNinTwo:
                break;
            case R.id.btnPlusAdTwo:
                break;
            case R.id.btnPlusNinTwo:
                break;
            // third room
            case R.id.btnLessAdThree:
                break;
            case R.id.btnLessNinThree:
                break;
            case R.id.btnPlusAdThree:
                break;
            case R.id.btnPlusNinThree:
                break;
            // fourth room
            case R.id.btnLessAdFour:
                break;
            case R.id.btnLessNinFour:
                break;
            case R.id.btnPlusAdFour:
                break;
            case R.id.btnPlusNinFour:
                break;
            // fifth room
            case R.id.btnLessAdFive:
                break;
            case R.id.btnLessNinFive:
                break;
            case R.id.btnPlusAdFive:
                break;
            case R.id.btnPlusNinFive:
                break;
            case R.id.btnBuscar:
                startActivity(new Intent(mActivity, HotelesListActivity.class));
                break;
            case R.id.btnOtrasOpciones:
                break;
        }
    }

    private void showRoom(int conteoHab) {
        switch (conteoHab) {
            case 2:
                secondRoom.setVisibility(View.VISIBLE);
                break;
            case 3:
                thirdRoom.setVisibility(View.VISIBLE);
                break;
            case 4:
                fourthRoom.setVisibility(View.VISIBLE);
                break;
            case 5:
            default:
                fifthRoom.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void hideRooms(int conteoHab) {
        switch (conteoHab) {
            case 1:
                secondRoom.setVisibility(View.GONE);
                break;
            case 2:
                thirdRoom.setVisibility(View.GONE);
                break;
            case 3:
                fourthRoom.setVisibility(View.GONE);
                break;
            case 4:
            default:
                fifthRoom.setVisibility(View.GONE);
                break;
        }
    }

    private void initCalendarFilter() {
        // Get the date of tomorrow
        Calendar date = Calendar.getInstance();

        // By default the selected day is tomorrow
        dpd = DatePickerDialog.newInstance(
                new DatePickerListener(),
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH)
        );

        dpd.setMinDate(date);

        // Set maximun date as 30 days after today (a month)
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.DATE, 30);    // Add 30 days
        dpd.setMaxDate(lastDate);
    }

    private class DatePickerListener implements DatePickerDialog.OnDateSetListener {
        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link java.util.Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            // todo: set text button as the selected date
            // your code here
        }
    }

    private void showDatePicker() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show date picker dialog
            dpd.show(mActivity.getFragmentManager(), TAG);
        }
    }
}
