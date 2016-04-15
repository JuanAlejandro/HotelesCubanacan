package com.resline.cubanacan.src.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertinigr@gmail.com on 6/5/15.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 14L;

    private String _id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String phone;
    private double longitude;
    private double latitude;
    private String avatar;
    private String createdAt;
    private String updatedAt;

    public User() {
        this._id = "";
        this.username = "";
        this.name = "";
        this.password = "";
        this.email = "";
        this.phone = "";
        this.longitude = 0;
        this.latitude = 0;
        this.avatar = "";
        this.createdAt = "";
        this.updatedAt = "";
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isLocationAvailable() {
        return (longitude != 0  && latitude != 0);
    }

}
