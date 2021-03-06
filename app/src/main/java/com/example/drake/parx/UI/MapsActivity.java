package com.example.drake.parx.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.Data.StateParkMarkers;
import com.example.drake.parx.R;
import com.example.drake.parx.Utilities.PermissionsUtility;
import com.example.drake.parx.ViewModels.ParxViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap parxActMap;
    ParxViewModel mapViewModel;
    List<StatePark> mapParkList;
    // Annotate views for use with Butterknife
    @BindView(R.id.maps_toolbar) Toolbar mapsToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
//        Toolbar mapsToolbar = findViewById(R.id.maps_toolbar);
        setSupportActionBar(mapsToolbar);
        // Add up navigation to the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_explore_ky_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        parxActMap = googleMap;
        LatLng recLatLong = getIntent().getExtras().getParcelable("latLong");

        // Add an observer for the state parks live data and rerun buildGeofences() when its data changes
        mapViewModel = ViewModelProviders.of(this).get(ParxViewModel.class);
        final Observer<List<StatePark>> stateParkObserver = new Observer<List<StatePark>>() {
            @Override
            public void onChanged(@Nullable List<StatePark> stateParks) {
                mapParkList = stateParks;
                StateParkMarkers.buildMapMarkers(parxActMap,mapParkList);
            }
        };
        mapViewModel.getAllParxList().observe(this, stateParkObserver);

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
