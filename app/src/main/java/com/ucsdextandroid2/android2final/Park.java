package com.ucsdextandroid2.android2final;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Park {
    @SerializedName("id")
    private String id;
    @SerializedName("fullName")
    private String name;
    @SerializedName("states")
    private String states;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("latLong")
    private String latLong;
    @SerializedName("images")
    private List<ParkImage> images;
    public double lat;
    public double lng;

    public Park(String id, String states, String name, String description, String url, String latLong, List<ParkImage> images){
        this.id = id;
        this.states = states;
        this.name = name;
        this.description = description;
        this.url = url;
        this.latLong = latLong;
        this.images = images;
        splitLatLng(latLong);

    }

    public String getId() {
        return id;
    }

    public String getStates() {
        return states;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLatLong() {
        return latLong;
    }

    private void splitLatLng(String latLng){
        String[] latLngArray = latLng.split(",");
        String[] latArray = latLngArray[0].split(":");
        this.lat = Double.parseDouble(latArray[1]);

        String[] lngArray = latLngArray[1].split(":");
        this.lng = Double.parseDouble(lngArray[1]);

    }

    public List<ParkImage> getImages() {
        return images;
    }

    public void setImages(List<ParkImage> images) {
        this.images = images;
    }
}

