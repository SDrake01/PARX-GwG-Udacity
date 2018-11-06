package com.example.drake.parx.Data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.drake.parx.AsyncTasks.LoadParksAsyncTask;
import com.example.drake.parx.UI.MainActivity;

import java.util.concurrent.Executors;

@Database(entities = {StatePark.class}, version = 1)
public abstract class StateParkDatabase extends RoomDatabase {

    public abstract StateParkDao stateParkDao();

    public static StateParkDatabase INSTANCE;

    public static synchronized StateParkDatabase getDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StateParkDatabase.class, "statepark_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    if (MainActivity.mainParxDao.parxCount() == 0){
                                        LoadParksAsyncTask loadParksAsyncTask = new LoadParksAsyncTask();
                                        loadParksAsyncTask.execute(MainActivity.mainParxDao);
                                    }
                                }
                            });
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
