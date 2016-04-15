package com.resline.cubanacan.src.ws.WSClass.Tpv;

public class TPVInfoRequest {
    protected String id;
    protected String language;
    protected String titular;

    public String getId(){
        return  id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getLanguage(){
        return  language;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public String getTitular(){
        return  titular;
    }

    public void setTitular(String titular){
        this.titular = titular;
    }
}