package com.example.drake.parx.UI;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.drake.parx.Data.StateParkMarkers;
import com.example.drake.parx.R;
import com.example.drake.parx.Utilities.PermissionsUtility;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

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
