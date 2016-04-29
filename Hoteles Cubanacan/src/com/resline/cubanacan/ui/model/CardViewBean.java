package com.resline.cubanacan.ui.model;

import android.net.Uri;

public class CardViewBean {

    private Long id;
    private Uri imgUri;
    private String title;
    private int stars;
    private String subtitle1;
    private String subtitle2;
    private String shortData;

    public CardViewBean(Long id, Uri imgUri, String title, String subtitle1, String subtitle2, String shortData, int stars) {
        this.id = id;
        this.imgUri = imgUri;
        this.title = title;
        this.stars = stars;
        this.subtitle1 = subtitle1;
        this.subtitle2 = subtitle2;
        this.shortData = shortData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Uri getImgUri() {
        return imgUri;
    }

    public String getShortData() {
        return shortData;
    }

    public void setShortData(String shortData) {
        this.shortData = shortData;
    }

    public int getStars(){return stars;}

    public void setStars(int stars) {
        this.stars = stars;
    }
}
