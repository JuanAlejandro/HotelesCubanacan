package com.resline.cubanacan.ui.model;

import android.net.Uri;

/**
 * Created by Juan Alejandro on 22/04/2016.
 */
public class CardViewGeneral extends CardViewBean{
    private Long id;
    private Uri imgUri;
    private String title;
    private String subtitle;

    public CardViewGeneral(Long id, Uri imgUri, String title, String subtitle) {
        super(id, imgUri,title, subtitle, "", "", 0);
        this.id = id;
        this.imgUri = imgUri;
        this.title = title;
        this.subtitle = subtitle;
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
}
