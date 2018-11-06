package com.example.drake.parx.UI;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.Data.StateParkMarkers;
import com.example.drake.parx.R;
import com.example.drake.parx.Utilities.GeofenceTransitionsUtility;
import com.example.drake.parx.Utilities.PermissionsUtility;
import com.example.drake.parx.ViewModels.ParxViewModel;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap parxActMap;
    private GeofencingClient parxGeofencingClient;
    private Geofence capitalGeofence;
    List<Geofence> parxGeofenceList = new ArrayList<>();
    private PendingIntent parxGeoPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Instantiate the GeofencingClient
        parxGeofencingClient = LocationServices.getGeofencingClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_explore_ky_map);
        mapFragment.getMapAsync(this);

        // Create a geofencing object
        // I don't know if I need to do this here, but I also don't know any better
        // so here goes
//        capitalGeofence = new Geofence.Builder()
//                .setRequestId("I see you are at work right now!")
//                .setCircularRegion(38.202031,-84.874209,300)
//                .setExpirationDuration(60*60*1000)
//                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER|Geofence.GEOFENCE_TRANSITION_EXIT)
//                .build();

        // One single geofence works here, so now I'll try a list of them
        // from the google Developers example
        //
        // Now I have to change all the ArrayList identifiers throughout back to List identifiers
        //
        // fuck!
        //
        //

        List<StatePark> parkList = ParxViewModel.getAllParxList();
        // Add geofences to the map activity if the list is not null
        if (parkList.size() > 0) {
            for (int i = 0; i < parkList.size(); i++) {
                StatePark geoPark = parkList.get(i);
                parxGeofenceList.add(new Geofence.Builder()
                        .setRequestId(
                                geoPark.getId())
                        .setCircularRegion(
                                geoPark.getLatitude(),
                                geoPark.getLongitude(),
                                geoPark.getRadius())
                        .setExpirationDuration(60 * 60 * 1000)
                        .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT)
                        .build());
            }
            // Looks like I need to add the geofences here
            // not like I know any better and the instructions are vague as usual
            // also it needs to be enclosed within a location permissions check
            try {
                parxGeofencingClient.addGeofences(getGeofencingRequest(), getGeofencePendingIntent())
                        .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Remove this after all 49 geofences get added without errors
                                Toast.makeText(MapsActivity.this, "Geofences Added Success", Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MapsActivity.this, "Geofences Added Failed", Toast.LENGTH_LONG).show();
                            }
                        });
            } catch (SecurityException e) {
                // insert empty catch block here
            }
        }else {Toast.makeText(this, "No Geofences To Add", Toast.LENGTH_SHORT).show();}
    }

    // This is for testing purposes only
    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(parxGeofenceList);
        return builder.build();
    }

    private PendingIntent getGeofencePendingIntent() {
        // Reuse the PendingIntent if we already have it.
        if (parxGeoPendingIntent != null) {
            return parxGeoPendingIntent;
        }
        Intent intent = new Intent(this, GeofenceTransitionsUtility.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when
        // calling addGeofences() and removeGeofences().
        parxGeoPendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.
                FLAG_UPDATE_CURRENT);
        return parxGeoPendingIntent;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        parxActMap = googleMap;
        LatLng recLatLong = getIntent().getExtras().getParcelable("latLong");

//        StateParkMarkers.addParks(parxActMap);
        StateParkMarkers.buildMapMarkers(parxActMap);
        parxActMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recLatLong, 14));

        // Verify has granted permission for fine location access
        // and request permission if not granted
        PermissionsUtility.checkLocationPermission(this, parxActMap);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            parxActMap.setMyLocationEnabled(false);
        }catch (SecurityException e){
            // Not really necessary, just trying to turn off location access when the app is not being used
            // to reduce battery use
        }
    }
}
