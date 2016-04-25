package com.resline.cubanacan.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 24/04/2016.
 */
public class RegistrarseActivity extends BaseActivity implements View.OnClickListener {
    private Button btnAceptar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolBar();

        loadViewComponents();
    }

    private void loadViewComponents() {
        btnAceptar = (Button) findViewById(R.id.accept);
        btnAceptar.setOnClickListener(this);
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
                startActivity(new Intent(RegistrarseActivity.this, UserProfileActivity.class));
                break;
        }
    }
}
