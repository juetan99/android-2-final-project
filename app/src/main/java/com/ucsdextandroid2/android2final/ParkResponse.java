package com.ucsdextandroid2.android2final;

import com.google.gson.annotations.SerializedName;
import com.ucsdextandroid2.android2final.Park;

import java.util.List;

public class ParkResponse {

    @SerializedName("data")
    private List<Park> parks;

    public List<Park> getParks() {
        return parks;
    }

    public void setParks(List<Park> parks) {
        this.parks = parks;
    }
}
