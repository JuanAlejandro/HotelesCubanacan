package com.resline.cubanacan.ui.model;

import android.net.Uri;

public class CardViewHotel extends CardViewBean {

    private int stars;
    private String subtitle2;

    public CardViewHotel(Long id, Uri imgUri, String title, String subtitle, String shortData, String subtitle2, int stars) {
        super(id, imgUri, title, subtitle, shortData);
        this.stars = stars;
        this.subtitle2 = subtitle2;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }
}
