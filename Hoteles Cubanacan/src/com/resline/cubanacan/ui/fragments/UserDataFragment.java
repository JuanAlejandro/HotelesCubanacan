package com.resline.cubanacan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;

/**
 * Created by Juan Alejandro on 27/04/2016.
 * Fragmento para mostrar los datos del usuario en el perfil de usuario
 */
public class UserDataFragment extends BaseFragment implements View.OnClickListener {
    private Button edit;
    private TextView email;
    private TextView address;
    private Spinner spinIdioma;
    private Spinner spinPais;
    private View mViewFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewFragment = inflater.inflate(R.layout.fragment_user_data, container, false);

        loadViews();

        return mViewFragment;
    }

    private void loadViews() {
        edit = (Button) mViewFragment.findViewById(R.id.edit);
        email = (TextView) mViewFragment.findViewById(R.id.tvCorreo);
        address = (TextView) mViewFragment.findViewById(R.id.tvDireccion);
        // spinners
        // idioma
        spinIdioma = (Spinner) mViewFragment.findViewById(R.id.spinLanguage);
        // pais
        spinPais = (Spinner) mViewFragment.findViewById(R.id.spinPais);
        edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit:
                // tu codigo de editar aquí
                break;
        }
    }
}
