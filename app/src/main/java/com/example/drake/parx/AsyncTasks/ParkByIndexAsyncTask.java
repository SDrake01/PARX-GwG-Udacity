package com.example.drake.parx.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.UI.MainActivity;

import java.lang.ref.WeakReference;

public class ParkByIndexAsyncTask extends AsyncTask<String, Void, StatePark> {

    private WeakReference<Context> contextRef;

    public ParkByIndexAsyncTask(Context context) {
        contextRef = new WeakReference<>(context);
    }

    @Override
    protected StatePark doInBackground(String... strings) {

        return MainActivity.mainParxDao.getIdStatePark(strings[0]);
    }

    protected void onPostExecute(StatePark returnedOne){
        String enteredName = returnedOne.getName();
    }
}
