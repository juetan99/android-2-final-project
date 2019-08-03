package com.ucsdextandroid2.android2final;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ParkEntity {
    @PrimaryKey
    @NonNull
    public String id;
    @ColumnInfo(name="imageUrl")
    public String imageUrl;
    @ColumnInfo(name="name")
    public String name;

}
