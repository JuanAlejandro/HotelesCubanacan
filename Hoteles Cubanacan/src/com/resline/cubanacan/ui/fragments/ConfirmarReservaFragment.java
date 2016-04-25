package com.resline.cubanacan.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.HotelFullDetails;
import com.resline.cubanacan.src.ws.WSClass.Image.Image;
import com.resline.cubanacan.ui.activities.TitularActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;

/**
 * Created by Juan Alejandro on 18/04/2016.
 */
public class ConfirmarReservaFragment extends BaseFragment implements View.OnClickListener {
    private View mViewInfoFragment;

    private ImageView[] ivStarts;

    private ImageView hotelImage;

    private TextView tvNombreHotel;

    private TextView tvSubtitulo;

    private TextView in, out;

    private TextView tvImporte;

    private Spinner spinANombreDe;

    private EditText etNombre, etApellidos;

    private Spinner spinPais;

    private CheckBox cbFumador;

    private Button btnSiguiente;

    private Long hotelId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_confirm_reserva, container, false);

        loadViewComponents();

        return mViewInfoFragment;
    }

    private void loadViewComponents() {

        //Categoria
        ivStarts = new ImageView[5];
        ivStarts[0] = (ImageView)mViewInfoFragment.findViewById(R.id.start1);
        ivStarts[1] = (ImageView)mViewInfoFragment.findViewById(R.id.start2);
        ivStarts[2] = (ImageView)mViewInfoFragment.findViewById(R.id.start3);
        ivStarts[3] = (ImageView)mViewInfoFragment.findViewById(R.id.start4);
        ivStarts[4] = (ImageView)mViewInfoFragment.findViewById(R.id.start5);

        hotelImage = (ImageView)mViewInfoFragment.findViewById(R.id.ivHotelImageRoomConfirm);

        // nombre del hotel
        tvNombreHotel = (TextView) mViewInfoFragment.findViewById(R.id.tvTitle);

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

        loadHotelInfo();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSiguiente:
                startActivity(new Intent(mActivity, TitularActivity.class));
                break;
        }
    }

    private void loadHotelInfo(){
        /*Bundle bundle = getActivity().getIntent().getExtras();
        hotelId = bundle.getLong("hotelId");*/
        hotelId = 5L;

        HotelFullDetails hotel = AppController.getHotels().get(hotelId);

        Image image = hotel.getImages().getImage().get(0);

        Picasso.with(mActivity)
                .load(image.getImageUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_launcher)
                .into(hotelImage);

        paintStars(hotel.getCategoryEnum().ordinal()+2);

        tvNombreHotel.setText(hotel.getName());
        tvSubtitulo.setText(String.format("Reservación para %d noche(s)", AppController.getSearchHotelCriteria().getNights()));

    }

    private void paintStars(int countStars){

        for(int i=0; i<countStars; i++){
            ivStarts[0].setVisibility(View.VISIBLE);
        }
    }
}
