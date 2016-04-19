package com.resline.cubanacan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import org.w3c.dom.Text;

/**
 * Created by Juan Alejandro on 18/04/2016.
 */
public class ConfirmarReservaFragment extends BaseFragment implements View.OnClickListener {
    private View mViewInfoFragment;

    private TextView tvNombreHotel;

    private RatingBar rbCategoria;

    private TextView tvSubtitulo;

    private TextView in, out;

    private TextView tvImporte;

    private Spinner spinANombreDe;

    private EditText etNombre, etApellidos;

    private Spinner spinPais;

    private CheckBox cbFumador;

    private Button btnSiguiente;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_confirm_reserva, container, false);

        loadViewComponents();

        return mViewInfoFragment;
    }

    private void loadViewComponents() {
        // nombre del hotel
        tvNombreHotel = (TextView) mViewInfoFragment.findViewById(R.id.tvTitle);

        // rating bar de la categoria
        rbCategoria = (RatingBar) mViewInfoFragment.findViewById(R.id.rbCategory);

        rbCategoria.setNumStars(5);

        rbCategoria.setRating(3);

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
        spinPais = (Spinner) mViewInfoFragment.findViewById(R.id.spinPais);

        // fumador
        cbFumador = (CheckBox) mViewInfoFragment.findViewById(R.id.cbFumador);

        // boton siguiente
        btnSiguiente = (Button) mViewInfoFragment.findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSiguiente:
                break;
        }
    }
}
