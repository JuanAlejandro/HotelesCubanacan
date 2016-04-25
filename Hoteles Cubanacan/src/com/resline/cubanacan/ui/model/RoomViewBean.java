package com.resline.cubanacan.ui.model;

import java.util.List;

public class RoomViewBean {
    private int id;
    private String roomNumber;
    private List<RoomTypeViewBean> roomTypeList;

    public RoomViewBean(int id,String roomNumber, List<RoomTypeViewBean> roomTypeViewBeanList) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomTypeList = roomTypeViewBeanList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<RoomTypeViewBean> getRoomTypeList() {
        return roomTypeList;
    }

    public void setRoomTypeList(List<RoomTypeViewBean> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }
}
