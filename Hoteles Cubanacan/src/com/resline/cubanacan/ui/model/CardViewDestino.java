package com.resline.cubanacan.ui.model;

import android.net.Uri;

public class CardViewDestino extends CardViewBean {

    private String subtitle1;
    private String subtitle2;

    public CardViewDestino(Long id, Uri imgUri, String title, String subtitle, String subtitle2, String subtitle1) {
        super(id, imgUri, title, subtitle, "");
        this.subtitle2 = subtitle2;
        this.subtitle1 = subtitle1;
    }

    public String getSubtitle1() {
        return subtitle1;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }
}
