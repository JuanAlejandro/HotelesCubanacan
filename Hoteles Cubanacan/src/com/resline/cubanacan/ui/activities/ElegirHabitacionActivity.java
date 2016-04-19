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
 * Created by Juan Alejandro on 14/04/2016.
 */
public class ElegirHabitacionActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbar();

        loadViewComponents();
    }

    private void loadViewComponents() {
        // todo: associate visual elements with objects
        Button btnReservar = (Button) findViewById(R.id.btnReservar);
        btnReservar.setOnClickListener(this);
    }

    private void setToolbar() {
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_elegir_hab;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.pick_room_title);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReservar:
                startActivity(new Intent(ElegirHabitacionActivity.this, ConfirmarReservaActivity.class));
                break;
        }
    }
}
