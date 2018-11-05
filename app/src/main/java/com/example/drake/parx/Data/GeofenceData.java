package com.example.drake.parx.Data;

import android.content.Context;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.GoogleMap;

public class GeofenceData {

    public static Geofence testGeofence;

    public static void addGeofences(Context thisContext, GoogleMap thisMap){

        testGeofence = new Geofence.Builder()
                .setRequestId("testCapitalGeofence")
                .setCircularRegion(38.185905,-84.875494,500)
                .build();

//        Geofence fenceBarrenRiver = new Geofence.Builder()
//                .setRequestId(thisContext.getString(R.string.fence_barren_river))
//                .setCircularRegion(
//                        Double.parseDouble(thisContext.getString(R.string.barren_river_lat)),
//                        Double.parseDouble(thisContext.getString(R.string.barren_river_long)),
//                        thisContext.getResources().getInteger(R.integer.barren_river_radius))
//                .build();


    }
}
