package com.resline.cubanacan.ui.model;

import java.util.List;

/**
 * Created by David on 26/04/2016.
 */
public class RoomChoice {

    private Long idRoomType;
    private Long idMealPlan;
    private List<Long> idOptionalAmenities;

    public Long getIdRoomType() {
        return idRoomType;
    }

    public void setIdRoomType(Long idRoomType) {
        this.idRoomType = idRoomType;
    }

    public Long getIdMealPlan() {
        return idMealPlan;
    }

    public void setIdMealPlan(Long idMealPlan) {
        this.idMealPlan = idMealPlan;
    }

    public List<Long> getIdOptionalAmenities() {
        return idOptionalAmenities;
    }

    public void setIdOptionalAmenities(List<Long> idOptionalAmenities) {
        this.idOptionalAmenities = idOptionalAmenities;
    }
}
