package com.ucsdextandroid2.android2final;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ParkDao {
    @Query("SELECT * FROM Park")
    List<Park> getAllParks();

    @Insert
    void insertAll(Park...parks);
}
