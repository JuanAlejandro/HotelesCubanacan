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
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelDetailsActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to set back arrow in toolbar
        setToolbar();

        // set button pick room
        Button pickRoom = (Button) findViewById(R.id.btnElegirHab);
        pickRoom.setOnClickListener(this);
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
        return R.layout.activity_details;
    }

    @Override
    protected String getTitleToolBar() {
        return "";
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnElegirHab:
                Bundle bundle = getIntent().getExtras();
                if(bundle == null) {
                    String error = "Esto es un mensaje de error";
                }
                else{
                    Long hotelId = bundle.getLong("hotelId");
                    Intent intent = new Intent(HotelDetailsActivity.this, ElegirHabitacionActivity.class);
                    intent.putExtra("hotelId", hotelId);
                    startActivity(intent);
                }

                break;
        }
    }
}
