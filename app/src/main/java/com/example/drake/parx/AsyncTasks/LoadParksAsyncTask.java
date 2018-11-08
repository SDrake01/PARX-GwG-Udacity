package com.example.drake.parx.AsyncTasks;

import android.os.AsyncTask;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.Data.StateParkDao;

// This async task loads the initial data into the database
// it only runs once when the user first install the app
public class LoadParksAsyncTask extends AsyncTask<StateParkDao,Void,String> {

    @Override
    protected String doInBackground(StateParkDao... stateParkDaos) {

        stateParkDaos[0].insertParkData(StatePark.staticData());
        return String.valueOf(stateParkDaos[0].parxCount());
    }

    protected void onPostExecute(String returnedCount){
        // Run the StateParksAsyncTask after the database has been populated
        StateParksAsyncTask stateParksAsyncTask = new StateParksAsyncTask();
        stateParksAsyncTask.execute();
    }
}
