package com.resline.cubanacan.ui.fragments;

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

    public static ReservarFragment newInstance() {
        return new ReservarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_reservar, container, false);

        loadViews();

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

    }
}
