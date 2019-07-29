package com.ucsdextandroid2.android2final;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity
public class Park {
    @SerializedName("id")
    @PrimaryKey
    @NonNull
    private String id;
    @SerializedName("fullName")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("latLong")
    private String latLong;

    @ColumnInfo(name = "latitude")
    public double lat;
    @ColumnInfo(name="longitude")
    public double lng;

    public Park(String id, String name, String description, String url, String latLong){
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.latLong = latLong;
        splitLatLng(latLong);

    }

    public String getId() {
        return id;
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

}
