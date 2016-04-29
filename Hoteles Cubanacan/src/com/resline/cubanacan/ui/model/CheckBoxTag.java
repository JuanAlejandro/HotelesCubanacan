package com.resline.cubanacan.ui.model;

/**
 * Created by David on 26/04/2016.
 */
public class CheckBoxTag {

    private int roomPosition;
    private int roomTypePosition;
    private double price;
    private Long idMealPlan;
    private double mealPlanPrice;

    public CheckBoxTag(int roomPosition, int roomTypePosition, double price, Long idMealPlan, double mealPlanPrice) {
        this.roomPosition = roomPosition;
        this.roomTypePosition = roomTypePosition;
        this.price = price;
        this.idMealPlan = idMealPlan;
        this.mealPlanPrice = mealPlanPrice;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMealPlanPrice() {
        return mealPlanPrice;
    }

    public void setMealPlanPrice(double mealPlanPrice) {
        this.mealPlanPrice = mealPlanPrice;
    }

    public Long getIdMealPlan() {
        return idMealPlan;
    }

    public void setIdMealPlan(Long idMealPlan) {
        this.idMealPlan = idMealPlan;
    }
}
