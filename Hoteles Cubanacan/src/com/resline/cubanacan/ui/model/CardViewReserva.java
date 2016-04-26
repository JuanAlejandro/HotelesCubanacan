package com.resline.cubanacan.ui.model;

import android.net.Uri;

/**
 * Created by Juan Alejandro on 25/04/2016.
 */
public class CardViewReserva extends CardViewBean {
    // title = nombre del hotel
    // imgUri = ignore it
    // subtitle = cant de hab
    // shortData = precio

    private int cantNoches;

    private String dateIn;

    private String dateOut;

    public CardViewReserva(int id, String title, String subtitle, String shortData, int cantNoches,
                           String dateIn, String dateOut) {
        super(id, null, title, subtitle, shortData);
        this.cantNoches = cantNoches;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public int getCantNoches() {
        return cantNoches;
    }

    public void setCantNoches(int cantNoches) {
        this.cantNoches = cantNoches;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
}
