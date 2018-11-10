package com.example.drake.parx.Utilities;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.drake.parx.AsyncTasks.ParkByIndexAsyncTask;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

public class GeofenceTransitionsUtility extends IntentService {

    public GeofenceTransitionsUtility(){
        super("GeofenceTransitionUtility");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        // Handle errors if present
        if (geofencingEvent.hasError()){
            int fenceError = geofencingEvent.getErrorCode();
            Log.e("GeofenceUtility", "Location services error: " + fenceError);
            // Add a redundant toast for testing purposes only
            Toast.makeText(this, "Location Services error code: "+fenceError,Toast.LENGTH_LONG).show();
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
            } // *************** End of GEOFENCE_TRANSITION_ENTER handler ***************
            else if (Geofence.GEOFENCE_TRANSITION_EXIT == transitionCode){
                // During testing, show a toast notifying the player
                // they have left a geofence and naming the exited geofence
                String exitFenceId = geofencingEvent.getTriggeringGeofences().get(0).getRequestId();
                // Create a toast showing what geofence the player exited
                Toast.makeText(this, "Geofence exited: "+exitFenceId, Toast.LENGTH_LONG).show();
            } // *************** End of GEOFENCE_TRANSITION_EXIT handler ***************
        }
    }
}
