package com.example.drake.parx.Data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

@Database(entities = {StatePark.class}, version = 1)
public abstract class StateParkDatabase extends RoomDatabase {

    public abstract StateParkDao stateParkDao();

    public static StateParkDatabase INSTANCE;

    public static StateParkDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (StateParkDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StateParkDatabase.class,"statepark_database")
                            .fallbackToDestructiveMigration()
                            // This onCreate Callback should only run the first time to populate the database
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            getDatabase(context).stateParkDao().insertParkData(StatePark.staticData());
                                        }
                                    });
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
