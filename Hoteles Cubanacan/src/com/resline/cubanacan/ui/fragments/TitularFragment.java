package com.resline.cubanacan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;

/**
 * Created by Juan Alejandro on 18/04/2016.
 */
public class TitularFragment extends BaseFragment implements View.OnClickListener {
    private View mViewFragment;

    private TextView tvNombreHotel;

    private RatingBar rbCategoria;

    private TextView tvSubtitulo;

    private TextView in, out;

    private TextView tvImporte;

    private Spinner spinANombreDe;

    private EditText etNombre, etApellidos, etCorreo;

    private Spinner spinPais;

    private CheckBox cbAcepto;

    private Button btnPagar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewFragment = inflater.inflate(R.layout.fragment_titular, container, false);

        loadViewComponents();

        return mViewFragment;
    }

    private void loadViewComponents() {
        // nombre del hotel
        tvNombreHotel = (TextView) mViewFragment.findViewById(R.id.tvTitle);

        // rating bar de la categoria
        rbCategoria = (RatingBar) mViewFragment.findViewById(R.id.rbCategory);

        rbCategoria.setNumStars(5);

        rbCategoria.setRating(3);

        // subtitulo
        tvSubtitulo = (TextView) mViewFragment.findViewById(R.id.tvSubtitle);

        // in & out
        in = (TextView) mViewFragment.findViewById(R.id.tvIn);
        out = (TextView) mViewFragment.findViewById(R.id.tvOut);

        // importe
        tvImporte = (TextView) mViewFragment.findViewById(R.id.tvImporte);

        // spinner a nombre de...
        spinANombreDe = (Spinner) mViewFragment.findViewById(R.id.spinTitular);


        // nombre & apellidos
        etNombre = (EditText) mViewFragment.findViewById(R.id.etNombre);
        etApellidos = (EditText) mViewFragment.findViewById(R.id.etApellidos);
        etCorreo = (EditText) mViewFragment.findViewById(R.id.etCorreo);

        // spinner pais
        spinPais = (Spinner) mViewFragment.findViewById(R.id.spinPais);

        // fumador
        cbAcepto = (CheckBox) mViewFragment.findViewById(R.id.cbAcepto);

        // boton siguiente
        btnPagar = (Button) mViewFragment.findViewById(R.id.btnPagar);

        btnPagar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPagar:
                break;
        }
    }
}
