package com.resline.cubanacan.src.ws.WSClass.General;

import com.resline.cubanacan.src.ws.WSClass.EntityResponse;

import java.util.List;

/**
 * Created by David on 28/04/2016.
 */
public class TitlesResponse extends EntityResponse {

    protected List<Title> titles;


    public List<Title> getTitleResult() {
        return titles;
    }

    public void setTitleResult(List<Title> value) {
        this.titles = value;
    }
}
