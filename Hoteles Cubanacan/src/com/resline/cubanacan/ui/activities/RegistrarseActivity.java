package com.resline.cubanacan.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 24/04/2016.
 */
public class RegistrarseActivity extends BaseActivity implements View.OnClickListener {
    private Button btnAceptar;

    // data vars
    private EditText etNombre;

    private EditText etApellido;

    private Spinner spinIdioma;

    private Spinner spinPais;

    private EditText etDireccion;

    private EditText etCorreo;

    private EditText etRepetirCorreo;

    private EditText etContrasenna;

    private EditText etRepetirContrasenna;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolBar();

        loadViewComponents();
    }

    private void loadViewComponents() {
        // accept button
        btnAceptar = (Button) findViewById(R.id.accept);
        btnAceptar.setOnClickListener(this);

        // nombre
        etNombre = (EditText) findViewById(R.id.etNombre);
        // apellido
        etApellido = (EditText) findViewById(R.id.etApellido);
        // direccion
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        // correo
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        // repetir correo
        etRepetirCorreo = (EditText) findViewById(R.id.etRepetirCorreo);
        // contrasenna
        etContrasenna = (EditText) findViewById(R.id.etContrasena);
        // repetir contrasenna
        etRepetirContrasenna = (EditText) findViewById(R.id.etRepetirContrasena);

        // spinners
        // idioma
        spinIdioma = (Spinner) findViewById(R.id.spinLanguage);
        // pais
        spinPais = (Spinner) findViewById(R.id.spinPais);
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.registrarse_title);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }

    private void setToolBar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.accept:
                // your code here to save data
                startActivity(new Intent(RegistrarseActivity.this, UserProfileActivity.class));
                break;
        }
    }
}
