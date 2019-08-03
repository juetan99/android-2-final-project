package com.ucsdextandroid2.android2final;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ParkDao {
    @Query("SELECT * FROM ParkEntity")
    List<ParkEntity> getAllParks();

    @Query("SELECT * FROM ParkEntity WHERE id = :parkId")
    List<ParkEntity> getParkById(String parkId);

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    void insertAll(ParkEntity...parkEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ParkEntity parkEntities);
}
