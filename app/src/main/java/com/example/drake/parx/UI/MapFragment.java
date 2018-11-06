package com.example.drake.parx.UI;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.R;
import com.example.drake.parx.Utilities.PermissionsUtility;
import com.example.drake.parx.ViewModels.ParxViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    View view;
    public static GoogleMap parxFragMap;
    MapView parxMapView;
    static final LatLng kyStartPoint = new LatLng(37.781769169474, -85.812174864113);
    int parxFragOrientation;
    static List<StatePark> parxList = new ArrayList<>();
    static List<Marker> parxMarkers = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        parxMapView = (MapView) view.findViewById(R.id.mv_fragment_mapView);
        if (parxMapView != null) {
            parxMapView.onCreate(null);
            parxMapView.onResume();
            parxMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        parxFragMap = googleMap;

        parxFragMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        parxFragMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kyStartPoint, 6.65f));
        // Set a different zoom level if the device is in landscape mode
        parxFragOrientation = getResources().getConfiguration().orientation;
        if (parxFragOrientation == Configuration.ORIENTATION_LANDSCAPE){
            parxFragMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kyStartPoint, 6.3f));
        }

        parxFragMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                LatLng mapCenter = parxFragMap.getCameraPosition().target;
                Intent mapIntent = new Intent(getContext(), MapsActivity.class);
                mapIntent.putExtra("latLong", mapCenter);
                startActivity(mapIntent);
            }
        });

        // Verify has granted permission for fine location access
        // and request permission if not granted
        PermissionsUtility.checkLocationPermission(getActivity(), parxFragMap);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            parxFragMap.setMyLocationEnabled(false);
        }catch (SecurityException e){
            // Not really necessary, just trying to turn off location access when the app is not being used
            // to reduce battery use
        }
    }

    public static void buildMapMarkers(){

        parxList = ParxViewModel.getAllParxList();

        if (parxList.size() > 0) {
            for (int i = 0; i < parxList.size(); i++) {
                StatePark thisPark = parxList.get(i);
                Marker listMarker = parxFragMap.addMarker(new MarkerOptions()
                        .position(new LatLng(thisPark.getLatitude(),thisPark.getLongitude()))
                        .title(thisPark.getName()));
                parxMarkers.add(listMarker);
            }
        }
    }
}
