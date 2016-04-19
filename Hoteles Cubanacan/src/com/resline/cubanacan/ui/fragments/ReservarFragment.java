package com.resline.cubanacan.ui.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.resline.cubanacan.R;
import com.resline.cubanacan.src.controllers.AppController;
import com.resline.cubanacan.src.ws.WSClass.Hotel.*;
import com.resline.cubanacan.src.ws.WSClass.Location.FullLocation;
import com.resline.cubanacan.src.ws.WSClass.Reservation.ArrayOfBookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.BookedRoom;
import com.resline.cubanacan.src.ws.WSClass.Reservation.PaymentMethodEnum;
import com.resline.cubanacan.src.ws.WSClass.Reservation.RoomReservationRequest;
import com.resline.cubanacan.src.ws.WSClass.system.ArrayOfInt;
import com.resline.cubanacan.src.ws.WebServicesClient;
import com.resline.cubanacan.ui.activities.HotelesListActivity;
import com.resline.cubanacan.ui.activities.MainActivity;
import com.resline.cubanacan.ui.fragments.api.BaseFragment;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.google.gson.Gson;

/**
 * Created by Juan Alejandro on 11/04/2016.
 */
public class ReservarFragment extends BaseFragment implements View.OnClickListener{
    private View mViewInfoFragment;

    private Spinner spDestinos;

    private AutoCompleteTextView actvHoteles;

    private Button setEntrada;

    private Button setSalida;

    private DatePickerDialog dpdCheckIn, dpdCheckOut;

    private Button btnLessHab, btnPlusHab;

    private Button btnLessAdults, btnPlusAdults;

    private Button btnLessChild, btnPlusChild;

    private TextView tvHabs, tvAdults, tvChild;

    private Button btnMasOpciones;

    private Button btnBuscar;

    private ArrayList<String> locationsList, hotelsList;
    private ArrayList<Long> locationsIdList;

    int countRooms = 1;
    Long idLocation = null;

    public static ReservarFragment newInstance() {
        return new ReservarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewInfoFragment = inflater.inflate(R.layout.fragment_reservar, container, false);

        loadViews();

        initCalendarFilter();

        loadSpinners();

        return mViewInfoFragment;
    }

    private void loadViews() {
        spDestinos = (Spinner) mViewInfoFragment.findViewById(R.id.spDestino);
        spDestinos.setOnItemSelectedListener(new OnLocationsSelectedListener());

        actvHoteles = (AutoCompleteTextView) mViewInfoFragment.findViewById(R.id.actvHoteles);

        setEntrada = (Button) mViewInfoFragment.findViewById(R.id.btnSetEntrada);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        setEntrada.setText(dateFormat.format(calendar.getTime()));

        setSalida = (Button) mViewInfoFragment.findViewById(R.id.btnSetSalida);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        setSalida.setText(dateFormat.format(calendar.getTime()));

        setEntrada.setOnClickListener(this);

        setSalida.setOnClickListener(this);

        // buttons to select quantity

        btnLessAdults = (Button) mViewInfoFragment.findViewById(R.id.btnLessAd);

        btnLessChild = (Button) mViewInfoFragment.findViewById(R.id.btnLessNin);

        btnLessHab = (Button) mViewInfoFragment.findViewById(R.id.btnLessHab);

        btnPlusAdults = (Button) mViewInfoFragment.findViewById(R.id.btnPlusAd);

        btnPlusChild = (Button) mViewInfoFragment.findViewById(R.id.btnPlusNin);

        btnPlusHab = (Button) mViewInfoFragment.findViewById(R.id.btnPlusHab);

        btnLessAdults.setOnClickListener(this);

        btnLessHab.setOnClickListener(this);

        btnLessChild.setOnClickListener(this);

        btnPlusAdults.setOnClickListener(this);

        btnPlusHab.setOnClickListener(this);

        btnPlusChild.setOnClickListener(this);

        // text views of quantity of adults, rooms, and children

        tvAdults = (TextView) mViewInfoFragment.findViewById(R.id.tvAdultos);

        tvChild = (TextView) mViewInfoFragment.findViewById(R.id.tvCantNin);

        tvHabs = (TextView) mViewInfoFragment.findViewById(R.id.tvCantHab);

        // final buttons

        btnBuscar = (Button) mViewInfoFragment.findViewById(R.id.btnBuscar);

        btnMasOpciones = (Button) mViewInfoFragment.findViewById(R.id.btnOtrasOpciones);

        btnBuscar.setOnClickListener(this);

        btnMasOpciones.setOnClickListener(this);
    }

    private void loadSpinners(){

        Map<Long, FullLocation> locations = AppController.getLocations();

        if(locations != null){
            Collection<Map.Entry<Long, FullLocation>> locationsData = locations.entrySet();
            locationsList = new ArrayList<String>();
            locationsIdList = new ArrayList<Long>();
            for (Map.Entry<Long, FullLocation> item : locationsData){
                locationsList.add(item.getValue().getName());
                locationsIdList.add(item.getValue().getId());
            }

            ArrayAdapter locationsAdapter = new ArrayAdapter<String>(this.getContext(),
                    android.R.layout.simple_spinner_dropdown_item, locationsList);
            locationsAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
            spDestinos.setAdapter(locationsAdapter);
        }
        else{
            spDestinos.setEnabled(false);
        }

        Map<Long, HotelFullDetails> hotels = AppController.getHotels();

        if(hotels != null){
            Collection<Map.Entry<Long, HotelFullDetails>> hotelsData = hotels.entrySet();
            hotelsList = new ArrayList<String>();
            for (Map.Entry<Long, HotelFullDetails> item : hotelsData){
                hotelsList.add(item.getValue().getName());
            }

            ArrayAdapter hotelsAdapter = new ArrayAdapter<String>(this.getContext(),
                    android.R.layout.simple_spinner_dropdown_item, hotelsList);
            hotelsAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
            actvHoteles.setAdapter(hotelsAdapter);
            actvHoteles.setThreshold(1);
        }
        else{
            spDestinos.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSetEntrada:
                showDatePicker(dpdCheckIn);
                break;
            case R.id.btnSetSalida:
                showDatePicker(dpdCheckOut);
                break;
            case R.id.btnLessAd:
                break;
            case R.id.btnLessHab:
                break;
            case R.id.btnLessNin:
                break;
            case R.id.btnPlusAd:
                break;
            case R.id.btnPlusHab:
                break;
            case R.id.btnPlusNin:
                break;
            case R.id.btnBuscar:
                search();
                break;
            case R.id.btnOtrasOpciones:
                break;
        }
    }

    private void initCalendarFilter() {
        // Get the date of tomorrow
        Calendar dateCheckIn = Calendar.getInstance();
        dateCheckIn.add(Calendar.DAY_OF_YEAR, 1);

        // By default the selected day is tomorrow
        dpdCheckIn = DatePickerDialog.newInstance(
                new CheckInDatePickerListener(),
                dateCheckIn.get(Calendar.YEAR),
                dateCheckIn.get(Calendar.MONTH),
                dateCheckIn.get(Calendar.DAY_OF_MONTH)
        );
        dpdCheckIn.setMinDate(dateCheckIn);

        Calendar dateCheckOut = Calendar.getInstance();
        dateCheckOut.add(Calendar.DAY_OF_YEAR, 1);
        dpdCheckOut = DatePickerDialog.newInstance(
                new CheckOutDatePickerListener(),
                dateCheckOut.get(Calendar.YEAR),
                dateCheckOut.get(Calendar.MONTH),
                dateCheckOut.get(Calendar.DAY_OF_MONTH)
        );
        dpdCheckOut.setMinDate(dateCheckOut);
    }

    private class CheckInDatePickerListener implements DatePickerDialog.OnDateSetListener {
        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link java.util.Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            setEntrada.setText(String.format("%d/%d/%d", dayOfMonth, (monthOfYear+1), year));
            Calendar checkOutCalendar = Calendar.getInstance();
            checkOutCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            checkOutCalendar.set(Calendar.MONTH, monthOfYear+1);
            checkOutCalendar.set(Calendar.YEAR, year);
            checkOutCalendar.add(Calendar.DAY_OF_YEAR, 1);
            setSalida.setText(String.format("%d/%d/%d", checkOutCalendar.get(Calendar.DAY_OF_MONTH),
                                                        checkOutCalendar.get(Calendar.MONTH),
                                                        checkOutCalendar.get(Calendar.YEAR)));
            dpdCheckOut.getSelectedDay().setDay(checkOutCalendar.get(Calendar.YEAR), checkOutCalendar.get(Calendar.MONTH),
                                                checkOutCalendar.get(Calendar.DAY_OF_MONTH));
            dpdCheckOut.setMinDate(checkOutCalendar);
        }
    }

    private class CheckOutDatePickerListener implements DatePickerDialog.OnDateSetListener {
        /**
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link java.util.Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            setSalida.setText(String.format("%d/%d/%d", dayOfMonth, (monthOfYear+1), year));
        }
    }

    private void showDatePicker(DatePickerDialog datePickerDialog) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show date picker dialog
            datePickerDialog.show(mActivity.getFragmentManager(), TAG);
        }
    }

    private void search(){
        try{

            int maxResults = 10;
            SearchHotelCriteria hotelCriteria = new SearchHotelCriteria();

            //Llenando el SearchHotelCriteria
            //1- Cantidad de noches

            DateFormat dateFormat = DateFormat.getDateInstance();
            Date checkIn = dateFormat.parse(setEntrada.getText().toString());
            Date checkOut = dateFormat.parse(setSalida.getText().toString());

            Long msCheckOut = checkOut.getTime();
            Long msCheckIn = checkIn.getTime();
            Long msDifference = msCheckOut - msCheckIn;
            long nights = msDifference / (1000 * 60 * 60 * 24);
            hotelCriteria.setNights((int) nights);
            GregorianCalendar checkOutCalendar= new GregorianCalendar();
            checkOutCalendar.setTime(checkOut);

            //2- Nombre del Hotel
            String hotelName = actvHoteles.getText().toString();
            if(hotelName.length() != 0)
                hotelCriteria.setResortName(actvHoteles.getText().toString());

            //3- Id del Destino
            if(idLocation != null)
                hotelCriteria.setLocationId(idLocation);

            //4- CheckIn
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            hotelCriteria.setCheckInDate(dateFormat.format(checkIn));

            //5- Habitaciones
            //TODO Esto hay que esperar a que termine JA para obtener bien los valores
            RoomAllocation roomAllocation = new RoomAllocation();
            roomAllocation.setQuantity(1);
            roomAllocation.setAdults(1);
            ArrayOfInt childrenAges = new ArrayOfInt();
            childrenAges.getInt().add(0);
            roomAllocation.setChildrenAges(childrenAges);

            hotelCriteria.getAllocation().getRoomAllocation().add(roomAllocation);

            SearchHotelRequest searchHotelRequest = new SearchHotelRequest();
            searchHotelRequest.setMaxResults(maxResults);
            searchHotelRequest.setCriteria(hotelCriteria);

            //Guardando los datos de la reservacion
            RoomReservationRequest roomReservationRequest = new RoomReservationRequest();
            roomReservationRequest.setCheckIn(dateFormat.format(checkIn));
            roomReservationRequest.setCheckOut(dateFormat.format(checkOut));
            roomReservationRequest.setPaymentMethod(PaymentMethodEnum.CREDIT_CAR);
            ArrayOfBookedRoom arrayBookedRoom = new ArrayOfBookedRoom();
            //Para cada una de las habitaciones:
            for(int i=0; i<countRooms; i++){
                BookedRoom bookedRoom = new BookedRoom();
                //TODO ver mecanismo para recoger los adultos de una habitacion
                bookedRoom.setAdults(1);
                //TODO Ver mecanismo para recoger el arreglo de edades de los ninnos
                bookedRoom.setChildrenAges(null);
                arrayBookedRoom.getBookedRoom().add(bookedRoom);
            }
            roomReservationRequest.setRooms(arrayBookedRoom);
            AppController.setRoomReservationRequest(roomReservationRequest);
            AppController.setSearchHotelCriteria(hotelCriteria);

            Gson gson = new Gson();
            String searchHotelRequestJson = gson.toJson(searchHotelRequest);
            //String searchHotelRequestJson = "{\"criteria\":{\"allocation\":{\"roomAllocation\":[{\"childrenAges\":{\"int\":[0]},\"adults\":2,\"quantity\":1}]},\"checkInDate\":\"2016-04-20\",\"locationId\":5,\"nights\":1},\"maxResults\":10}";
            //String searchHotelRequestJson = "{\"maxResults\":200,\"criteria\":{\"nights\":1,\"checkInDate\":\"2016-04-10\",\"allocation\":{\"roomAllocation\":[{\"childrenAges\":{\"int\":[]},\"quantity\":1,\"adults\":1},{\"childrenAges\":{\"int\":[]},\"quantity\":1,\"adults\":1}]}}}";

            WebServicesClient.get().searchHotels("SearchHotels", searchHotelRequestJson,
                    new Callback<HotelAvaibilityResponse>() {
                        @Override
                        public void success(HotelAvaibilityResponse hotelAvaibilityResponse, Response response) {
                            if(hotelAvaibilityResponse == null) {
                                Toast.makeText(getContext(), "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            else if(hotelAvaibilityResponse.getOperationMessage().equals("OK")){
                                AppController.setCurrentSearchResult(hotelAvaibilityResponse);
                                startActivity(new Intent(getContext(), HotelesListActivity.class));
                            }else{
                                //TODO Mostrar el error que me da el ws a traves de un alert
                            }
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            Toast.makeText(getContext(), "Por favor, comprueba tu conexión", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        catch (Exception e){
            String excep = e.getMessage();
        }
    }

    private class OnLocationsSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            idLocation = locationsIdList.get(position);
            /*Toast.makeText(parentView.getContext(), "Has seleccionado " +
                    parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();*/
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
