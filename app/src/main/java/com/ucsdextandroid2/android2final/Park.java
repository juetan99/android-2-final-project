package com.ucsdextandroid2.android2final;

import com.google.gson.annotations.SerializedName;

public class Park {
    @SerializedName("id")
    private String id;
    @SerializedName("fullName")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;

    public Park(String id, String name, String description, String url){
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
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
}
