package com.ucsdextandroid2.android2final;

import com.google.gson.annotations.SerializedName;

public class ParkImage {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
