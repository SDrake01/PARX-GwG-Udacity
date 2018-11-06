package com.example.drake.parx.AsyncTasks;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.UI.MainActivity;
import com.example.drake.parx.ViewModels.ParxViewModel;

import java.util.List;

public class StateParksAsyncTask extends AsyncTask<Void,Void,List<StatePark>> {

    @Override
    protected List<StatePark> doInBackground(Void... voids) {

        return MainActivity.mainParxDao.getAllParks();
    }

    protected void onPostExecute(List<StatePark> returnedParks){
        ParxViewModel.setAllParxList(returnedParks);
        Toast.makeText(MainActivity.parxContext, String.valueOf(returnedParks.size())+" Parks Loaded", Toast.LENGTH_LONG).show();
    }
}
