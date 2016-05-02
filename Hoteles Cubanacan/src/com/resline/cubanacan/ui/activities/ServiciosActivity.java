package com.resline.cubanacan.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.ui.activities.api.BaseActivity;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class ServiciosActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "ServiciosActivity";
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to set back arrow in toolbar
        setToolbar();
        loadViewComponents();
    }

    private void loadViewComponents() {

        tvContent = (TextView)findViewById(R.id.tvContent);

        Bundle bundle = getIntent().getExtras();
        Long hotelId = bundle.getLong("hotelId");
        tvContent.setText(AppController.getHotels().get(hotelId).getServices());
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
        return R.layout.activity_servicios;
    }

    @Override
    protected String getTitleToolBar() {
        return getString(R.string.services_title);
    }

    @Override
    protected Toolbar getLayoutResourceToolBar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()){
            case R.id.ivGallery:
                break;
            case R.id.btnElegirHab:
                break;
        }*/
    }
}
