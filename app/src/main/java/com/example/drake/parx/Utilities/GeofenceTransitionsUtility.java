package com.example.drake.parx.Utilities;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.drake.parx.AsyncTasks.ParkByIndexAsyncTask;
import com.example.drake.parx.R;
import com.example.drake.parx.UI.MainActivity;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

public class GeofenceTransitionsUtility extends IntentService {

    private final String TAG = getString(R.string.geofence_transition_tag);
    private final String ERROR = getString(R.string.geofence_transition_location_error);
    private final String EXITED = getString(R.string.geofence_transition_fence_exited);

    private final String CHANNEL_ID = getString(R.string.notification_channel);
    private final String NOTIFY_TITLE = getString(R.string.notification_title);
    private final String NOTIFY_TEXT = getString(R.string.notification_text);


    public GeofenceTransitionsUtility(){
        super("GeofenceTransitionUtility");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        // Handle errors if present
        if (geofencingEvent.hasError()){
            int fenceError = geofencingEvent.getErrorCode();
            Log.e(TAG, ERROR + fenceError);
            // Add a redundant toast for testing purposes only
            Toast.makeText(this, ERROR+fenceError,Toast.LENGTH_LONG).show();
        } else {
            // Determine the transition type
            int transitionCode = geofencingEvent.getGeofenceTransition();
            // Proceed based on the type of transition received either
            // GEOFENCE_TRANSITION_ENTER or GEOFENCE_TRANSITION_EXIT
            // add a handler for dwell if that is implemented in the future
            if (Geofence.GEOFENCE_TRANSITION_ENTER == transitionCode){
                // Get the geofence id that was triggered
                // PARX will only ever trigger one geofence at a time
                // so use ...get(0)... to get the geofence id
                String enterFenceId = geofencingEvent.getTriggeringGeofences().get(0).getRequestId();
                ParkByIndexAsyncTask parkByIndexAsyncTask = new ParkByIndexAsyncTask(this);
                parkByIndexAsyncTask.execute(enterFenceId);
                // Send enteredFenceId to UpdateUtility.updatePark to update the players progress
                UpdateUtility.updatePark(enterFenceId);
                // Build the notification so the player can see their progress is recorded
                String enteredName = MainActivity.mainParxDao.getIdStatePark(enterFenceId).getName();
                NotificationCompat.Builder enterBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(NOTIFY_TITLE)
                        .setContentText(NOTIFY_TEXT+enteredName)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);
                NotificationManagerCompat notification = NotificationManagerCompat.from(this);
                notification.notify(9,enterBuilder.build());
            } // *************** End of GEOFENCE_TRANSITION_ENTER handler ***************
            else if (Geofence.GEOFENCE_TRANSITION_EXIT == transitionCode){
                // During testing, show a toast notifying the player
                // they have left a geofence and naming the exited geofence
                String exitFenceId = geofencingEvent.getTriggeringGeofences().get(0).getRequestId();
                // Create a toast showing what geofence the player exited
                Toast.makeText(this, EXITED+exitFenceId, Toast.LENGTH_LONG).show();
            } // *************** End of GEOFENCE_TRANSITION_EXIT handler ***************
        }
    }
}
