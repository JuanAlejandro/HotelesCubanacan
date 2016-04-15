package com.resline.cubanacan.src.ws.WSClass.Tpv;

import com.resline.cubanacan.src.ws.WSClass.EntityResponse;

public class TPVResponse extends EntityResponse{
    protected TPVData data;

    public TPVData getData() {
        return data;
    }

    public void setData(TPVData data) {
        this.data = data;
    }
}