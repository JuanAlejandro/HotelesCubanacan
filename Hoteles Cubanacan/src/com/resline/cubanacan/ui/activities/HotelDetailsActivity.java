package com.resline.cubanacan.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelFullDetails;
import com.resline.cubanacan.ui.activities.api.BaseActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by Juan Alejandro on 13/04/2016.
 */
public class HotelDetailsActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "HotelDetailsActivity";

    private ImageView panoramicImage;
    private TextView tvHotelName;
    private TextView tvAddress;
    private TextView tvDescription;
    private TextView tvAirPortDistance;

    private TextView tvInDiaMes;
    private TextView tvInMes;
    private TextView tvInAnno;

    private TextView tvOutDiaMes;
    private TextView tvOutMes;
    private TextView tvOutAnno;

    private Button btnServices;
    private Button btnThemes;

    ImageView[] stars;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to set back arrow in toolbar
        setToolbar();

        loadViewComponents();

        loadData();
    }

    private void loadViewComponents() {
        panoramicImage = (ImageView) findViewById(R.id.ivHotel);
        tvHotelName = (TextView) findViewById(R.id.tvNombreHotel);
        tvAddress = (TextView) findViewById(R.id.tvDireccion);
        stars = new ImageView[5];
        stars[0] = (ImageView) findViewById(R.id.start1);
        stars[1] = (ImageView) findViewById(R.id.start2);
        stars[2] = (ImageView) findViewById(R.id.start3);
        stars[3] = (ImageView) findViewById(R.id.start4);
        stars[4] = (ImageView) findViewById(R.id.start5);
        tvAddress = (TextView) findViewById(R.id.tvDireccion);
        tvDescription = (TextView)findViewById(R.id.tvDesc);
        tvAirPortDistance = (TextView)findViewById(R.id.tvDistancia);

        tvInDiaMes = (TextView)findViewById(R.id.tvInDiaMes);
        tvInMes = (TextView)findViewById(R.id.tvInMes);
        tvInAnno = (TextView)findViewById(R.id.tvInAnno);

        tvOutDiaMes = (TextView)findViewById(R.id.tvOutDiaMes);
        tvOutMes = (TextView)findViewById(R.id.tvOutMes);
        tvOutAnno = (TextView)findViewById(R.id.tvOutAnno);

        btnServices = (Button)findViewById(R.id.btnServiciosActividades);
        btnThemes = (Button)findViewById(R.id.btnMotivos);
        Button pickRoom = (Button) findViewById(R.id.btnElegirHab);

        pickRoom.setOnClickListener(this);
        btnServices.setOnClickListener(this);
        btnThemes.setOnClickListener(this);
    }

    private void loadData(){
        Long hotelId = mBundle.getLong("idHotel");
        HotelFullDetails hotel = AppController.getHotels().get(hotelId);

        tvHotelName.setText(hotel.getName());
        showStars(hotel.getCategoryEnum().ordinal() + 2);
        Uri imgUri = Uri.parse(hotel.getImages().getImage().get(0).getImageUrl());
        if(imgUri != null){
            Picasso.with(this)
                    .load(imgUri.toString())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.ic_launcher)
                    .into(panoramicImage);
        }
        tvAddress.setText(hotel.getAdress().getAddress1());
        tvDescription.setText(Html.fromHtml(hotel.getDescription()).toString());
        //tvAirPortDistance.setText(Html.fromHtml(hotel.get).toString());

        String[] checkinStr = AppController.getCheckinStr();
        String[] checkoutStr = AppController.getCheckoutStr();

        tvInDiaMes.setText(checkinStr[0]);
        tvInMes.setText(checkinStr[1]);
        tvInAnno.setText(checkinStr[2]);

        tvOutDiaMes.setText(checkoutStr[0]);
        tvOutMes.setText(checkoutStr[1]);
        tvOutAnno.setText(checkoutStr[2]);
    }

    private void showStars(int countStars){

        for (int i=0; i<countStars; i++)
            stars[i].setVisibility(View.VISIBLE);
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
            case R.id.btnElegirHab:
                startActivity(new Intent(HotelDetailsActivity.this, ElegirHabitacionActivity.class).putExtras(getBundle()));
                break;
            case R.id.btnServiciosActividades:
                startActivity(new Intent(HotelDetailsActivity.this, ServiciosActivity.class).putExtras(getBundle()));
                break;
            /*case R.id.btnMotivos:
                startActivity(new Intent(HotelDetailsActivity.this, ElegirHabitacionActivity.class).putExtras(getBundle()));
                break;*/
        }
    }
}
