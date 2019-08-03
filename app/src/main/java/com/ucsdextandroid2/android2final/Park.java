package com.ucsdextandroid2.android2final;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Park implements Parcelable {
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
    @SerializedName("weatherInfo")
    private String weather;
    @SerializedName("images")
    private List<ParkImage> images;

    public double lat;
    public double lng;
    private String imageUrl;

    public Park(String id, String states, String name, String description, String url, String latLong, List<ParkImage> images){
        this.id = id;
        this.states = states;
        this.name = name;
        this.description = description;
        this.url = url;
        this.latLong = latLong;
        this.images = images;
        splitLatLng(latLong);
        this.imageUrl = images.get(0).getUrl();
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

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
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

    public String getImageUrl(){ return imageUrl;}

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(weather);
    }

    protected Park(Parcel in){
        id = in.readString();
        name=in.readString();
        description = in.readString();
        imageUrl = in.readString();
        weather = in.readString();
    }

    public static final Creator<Park> CREATOR =new Creator<Park>() {
        @Override
        public Park createFromParcel(Parcel source) {
            return new Park(source);
        }

        @Override
        public Park[] newArray(int size) {
            return new Park[0];
        }
    };
}

