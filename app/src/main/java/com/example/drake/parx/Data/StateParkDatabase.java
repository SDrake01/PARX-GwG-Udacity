package com.example.drake.parx.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {StatePark.class}, version = 1)
public abstract class StateParkDatabase extends RoomDatabase {

    public abstract StateParkDao stateParkDao();

    public static StateParkDatabase INSTANCE;

    public static StateParkDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (StateParkDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StateParkDatabase.class, "statepark_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
