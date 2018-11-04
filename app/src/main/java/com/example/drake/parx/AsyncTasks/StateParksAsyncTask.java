package com.example.drake.parx.AsyncTasks;

import android.app.Application;
import android.os.AsyncTask;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.Data.StateParkRepository;
import com.example.drake.parx.ViewModels.ParxViewModel;

import java.util.List;

public class StateParksAsyncTask extends AsyncTask<Application,Void,List<StatePark>> {

    @Override
    protected List<StatePark> doInBackground(Application... applications) {
        Application asyncApplication = applications[0];

        StateParkRepository asyncRepo = new StateParkRepository(asyncApplication);
        return asyncRepo.repoGetAllParks();
    }

    protected void onPostExecute(List<StatePark> returnedParks){
        ParxViewModel.setAllParxList(returnedParks);
    }
}
