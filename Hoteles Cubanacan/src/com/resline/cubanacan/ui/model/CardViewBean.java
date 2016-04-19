package com.resline.cubanacan.ui.model;

import android.net.Uri;

public class CardViewBean {
    private int id;
    private Uri imgUri;
    private String title;
    private String subtitle;
    private String shortData;

    // "", i,i,i,i
    public CardViewBean(int id, Uri imgUri, String title, String subtitle, String shortData) {
        this.id = id;
        this.imgUri = imgUri;
        this.title = title;
        this.subtitle = subtitle;
        this.shortData = shortData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
