package com.resline.cubanacan.src.ws.WSClass;

public class EntityResponse{

    protected String operationMessage;


    public String getOperationMessage() {
        return operationMessage;
    }

    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }

    public boolean isOk(){
        return this.operationMessage.equals("OK");
    }

    public String getError(){
        return this.operationMessage;
    }
}
