package com.resline.cubanacan.ui.model;

/**
 * Created by David on 26/04/2016.
 */
public class MealPlanButtonTag {

    private int positionRoom;
    private int positionRoomType;

    public MealPlanButtonTag(int positionRoom, int positionRoomType) {
        this.positionRoom = positionRoom;
        this.positionRoomType = positionRoomType;
    }

    public int getPositionRoom() {
        return positionRoom;
    }

    public void setPositionRoom(int positionRoom) {
        this.positionRoom = positionRoom;
    }

    public int getPositionRoomType() {
        return positionRoomType;
    }

    public void setPositionRoomType(int positionRoomType) {
        this.positionRoomType = positionRoomType;
    }
}
