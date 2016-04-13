package com.resline.cubanacan.ui.model;

import android.net.Uri;
import com.resline.cubanacan.R;

import java.io.File;
import java.util.List;

public class CardViewBean {
    private Uri imgUri;
    private List<Uri> imgUris;
    private int imgRes;
    private String title;
    private String subtitle;
    private int id;
    private String date;
    private String shortData;
    private boolean recomendado;
    private int tipo;

    public CardViewBean(Uri imgUri, String title, String subtitle, int id, String date, String shortData,
                        boolean recomendado, int tipo) {
        this.imgUri = imgUri;
        this.title = title;
        this.subtitle = subtitle;
        this.id = id;
        this.date = date;
        this.shortData = shortData;
        this.recomendado = recomendado;
        this.tipo = tipo;
    }

    public CardViewBean(List<Uri> imgUris, String title, String subtitle, int id, String date, String shortData,
                        boolean recomendado, int tipo) {
        this.imgUris = imgUris;
        this.title = title;
        this.subtitle = subtitle;
        this.id = id;
        this.date = date;
        this.shortData = shortData;
        this.recomendado = recomendado;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uri getImgUri() {
        return imgUri;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShortData() {
        return shortData;
    }

    public void setShortData(String shortData) {
        this.shortData = shortData;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public List<Uri> getImgUris() {
        return imgUris;
    }

    public void setImgUris(List<Uri> imgUris) {
        this.imgUris = imgUris;
    }
}
