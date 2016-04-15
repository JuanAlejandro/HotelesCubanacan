package com.resline.cubanacan.src.ws.WSClass.Tpv;

public class TPVData{
    protected String dispatchUrl;
    protected int reservationId;
    protected TPVPostData tpvPostData;

    public String getDispatchUrl() {
        return dispatchUrl;
    }

    public void setDispatchUrl(String dispatchUrl) {
        this.dispatchUrl = dispatchUrl;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public TPVPostData getTpvPostData() {
        return tpvPostData;
    }

    public void setTpvPostData(TPVPostData tpvPostData) {
        this.tpvPostData = tpvPostData;
    }
}