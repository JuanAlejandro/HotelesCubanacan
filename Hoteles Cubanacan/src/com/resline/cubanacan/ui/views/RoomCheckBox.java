package com.resline.cubanacan.ui.views;

import android.content.Context;
import android.widget.CheckBox;

/**
 * Created by David on 26/04/2016.
 */
public class RoomCheckBox extends CheckBox {

    private int roomPosition;
    private int roomTypePosition;

    public RoomCheckBox(Context context) {
        super(context);
    }

    public int getRoomPosition() {
        return roomPosition;
    }

    public void setRoomPosition(int roomPosition) {
        this.roomPosition = roomPosition;
    }

    public int getRoomTypePosition() {
        return roomTypePosition;
    }

    public void setRoomTypePosition(int roomTypePosition) {
        this.roomTypePosition = roomTypePosition;
    }
}
