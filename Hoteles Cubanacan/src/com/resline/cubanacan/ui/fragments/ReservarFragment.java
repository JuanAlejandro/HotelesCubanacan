package com.resline.cubanacan.ui.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import com.resline.cubanacan.R;
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSetEntrada:
                showDatePicker();
                break;
            case R.id.btnSetSalida:
                // todo: when show date picker out set min date as the start date
                showDatePicker();
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
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
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
