package com.example.drake.parx.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.R;
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
        Context thisContext = contextRef.get();
        String enteredName = returnedOne.getName();
        // Build the notification from here
        String CHANNEL_ID = "9";
        NotificationCompat.Builder enterBuilder = new NotificationCompat.Builder(thisContext, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("PARX Badge Progress Notice")
                .setContentText("For visiting "+enteredName)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        NotificationManagerCompat notification = NotificationManagerCompat.from(thisContext);
        notification.notify(9,enterBuilder.build());
    }
}
