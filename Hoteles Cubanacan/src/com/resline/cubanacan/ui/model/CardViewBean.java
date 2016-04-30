package com.resline.cubanacan.ui.model;

import android.net.Uri;

public class CardViewBean {

    protected Long id;
    protected Uri imgUri;
    protected String title;
    protected String subtitle;
    protected String shortData;

    public CardViewBean(Long id, Uri imgUri, String title, String subtitle, String shortData) {
        this.id = id;
        this.imgUri = imgUri;
        this.title = title;
        this.subtitle = subtitle;
        this.shortData = shortData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Uri getImgUri() {
        return imgUri;
    }

    public void setImgUri(Uri imgUri) {
        this.imgUri = imgUri;
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

    public String getShortData() {
        return shortData;
    }

    public void setShortData(String shortData) {
        this.shortData = shortData;
    }
}
