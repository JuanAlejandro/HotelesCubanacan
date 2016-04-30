package com.resline.cubanacan.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelDetailsActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "HotelDetailsActivity";

    private ImageView panoramicImage;

    private TextView tvHotelName;

    private ImageView goToGallery;

    private TextView tvAddress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to set back arrow in toolbar
        setToolbar();

        loadViewComponents();

        // set button pick room
        Button pickRoom = (Button) findViewById(R.id.btnElegirHab);
        pickRoom.setOnClickListener(this);
        Log.d(TAG, String.valueOf(mBundle.getInt("my_int")));
    }

    private void loadViewComponents() {
        panoramicImage = (ImageView) findViewById(R.id.ivHotel);

        tvHotelName = (TextView) findViewById(R.id.tvNombreHotel);

//        goToGallery = (ImageView) findViewById(R.id.ivGallery);

        tvAddress = (TextView) findViewById(R.id.tvDireccion);

//        goToGallery.setOnClickListener(this);
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

    protected Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("idHotel", mBundle.getLong("idHotel"));
        return bundle;
    }

    @Override
    protected int getLayoutResourceIdentifier() {
        return R.layout.activity_details;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.detalles_title);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.ivGallery:
//                break;
            case R.id.btnElegirHab:
                startActivity(new Intent(HotelDetailsActivity.this, ElegirHabitacionActivity.class).putExtras(getBundle()));
                break;
        }
    }
}
