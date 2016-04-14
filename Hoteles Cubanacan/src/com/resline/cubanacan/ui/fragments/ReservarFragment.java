package com.resline.cubanacan.ui.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.HotelesListActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * Created by Juan Alejandro on 11/04/2016.
 */
public class ReservarFragment extends BaseFragment implements View.OnClickListener{
    private View mViewInfoFragment;

    private AutoCompleteTextView actvDestino;

    private AutoCompleteTextView actvHoteles;

    private Button setEntrada;

    private Button setSalida;

    private ImageView searchDestinos;

    private ImageView searchHoteles;

    private DatePickerDialog dpd;

    private Button btnLessHab, btnPlusHab;

    private Button btnLessAdults, btnPlusAdults;

    private Button btnLessChild, btnPlusChild;

    private TextView tvHabs, tvAdults, tvChild;

    private Button btnMasOpciones;

    private Button btnBuscar;

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
        actvDestino = (AutoCompleteTextView) mViewInfoFragment.findViewById(R.id.actvDestino);

        actvHoteles = (AutoCompleteTextView) mViewInfoFragment.findViewById(R.id.actvHoteles);

        setEntrada = (Button) mViewInfoFragment.findViewById(R.id.btnSetEntrada);

        setSalida = (Button) mViewInfoFragment.findViewById(R.id.btnSetSalida);

        searchDestinos = (ImageView) mViewInfoFragment.findViewById(R.id.ivSearch);

        searchHoteles = (ImageView) mViewInfoFragment.findViewById(R.id.ivSearchHoteles);

        setEntrada.setOnClickListener(this);

        setSalida.setOnClickListener(this);

        searchDestinos.setOnClickListener(this);

        searchHoteles.setOnClickListener(this);

        // buttons to select quantity

        btnLessAdults = (Button) mViewInfoFragment.findViewById(R.id.btnLessAd);

        btnLessChild = (Button) mViewInfoFragment.findViewById(R.id.btnLessNin);

        btnLessHab = (Button) mViewInfoFragment.findViewById(R.id.btnLessHab);

        btnPlusAdults = (Button) mViewInfoFragment.findViewById(R.id.btnPlusAd);

        btnPlusChild = (Button) mViewInfoFragment.findViewById(R.id.btnPlusNin);

        btnPlusHab = (Button) mViewInfoFragment.findViewById(R.id.btnPlusHab);

        btnLessAdults.setOnClickListener(this);

        btnLessHab.setOnClickListener(this);

        btnLessChild.setOnClickListener(this);

        btnPlusAdults.setOnClickListener(this);

        btnPlusHab.setOnClickListener(this);

        btnPlusChild.setOnClickListener(this);

        // text views of quantity of adults, rooms, and children

        tvAdults = (TextView) mViewInfoFragment.findViewById(R.id.tvAdultos);

        tvChild = (TextView) mViewInfoFragment.findViewById(R.id.tvCantNin);

        tvHabs = (TextView) mViewInfoFragment.findViewById(R.id.tvCantHab);

        // final buttons

        btnBuscar = (Button) mViewInfoFragment.findViewById(R.id.btnBuscar);

        btnMasOpciones = (Button) mViewInfoFragment.findViewById(R.id.btnOtrasOpciones);

        btnBuscar.setOnClickListener(this);

        btnMasOpciones.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivSearch:
                break;
            case R.id.ivSearchHoteles:
                break;
            case R.id.btnSetEntrada:
                showDatePicker();
                break;
            case R.id.btnSetSalida:
                // todo: when show date picker out set min date as the start date
                showDatePicker();
                break;
            case R.id.btnLessAd:
                break;
            case R.id.btnLessHab:
                break;
            case R.id.btnLessNin:
                break;
            case R.id.btnPlusAd:
                break;
            case R.id.btnPlusHab:
                break;
            case R.id.btnPlusNin:
                break;
            case R.id.btnBuscar:
                startActivity(new Intent(mActivity, HotelesListActivity.class));
                break;
            case R.id.btnOtrasOpciones:
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
