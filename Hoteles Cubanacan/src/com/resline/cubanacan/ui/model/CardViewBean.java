package com.resline.cubanacan.ui.model;

import android.net.Uri;
import com.resline.cubanacan.R;

import java.io.File;
import java.util.List;

public class CardViewBean {
    private Long id;
    private Uri imgUri;
    private String title;
    private String subtitle;
    private String shortData;

    // "", i,i,i,i
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
}
