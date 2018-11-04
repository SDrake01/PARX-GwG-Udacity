package com.example.drake.parx.Data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StateParkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertParkData(StatePark... stateParks);

    @Update
    void updateOnePark(StatePark statePark);

    @Query("SELECT * FROM statepark_table ORDER BY name ASC")
    List<StatePark> getAllParks();

    @Query("SELECT * FROM statepark_table WHERE name = :nameIn")
    StatePark getOneStatePark(String nameIn);

}
