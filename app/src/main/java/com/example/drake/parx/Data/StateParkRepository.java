package com.example.drake.parx.Data;

import android.app.Application;

import java.util.List;

public class StateParkRepository {

    private List<StatePark> repoStateParkList;

    public StateParkRepository(Application application){
        StateParkDatabase repoDb = StateParkDatabase.getDatabase(application);
        StateParkDao repoDao = repoDb.stateParkDao();
        repoStateParkList = repoDao.getAllParks();
    }

    public List<StatePark> repoGetAllParks(){
        return repoStateParkList;
    }
}
