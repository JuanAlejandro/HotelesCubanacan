package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 14/04/2016.
 */
public class ElegirHabitacionActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbar();

        loadViewComponents();
    }

    private void loadViewComponents() {
        // todo: associate visual elements with objects
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
        return R.layout.elegir_hab_activity;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.pick_room_title);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.screen_default_toolbar);
    }
}
