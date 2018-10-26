package com.example.drake.parx.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.drake.parx.Data.StateParks;
import com.example.drake.parx.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    View view;
    private GoogleMap parxFragMap;
    MapView parxMapView;
    static final LatLng kyStartPoint = new LatLng(37.781769169474, -85.812174864113);

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

        StateParks.addParks(parxFragMap);

        parxFragMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                LatLng mapCenter = parxFragMap.getCameraPosition().target;
                Intent mapIntent = new Intent(getContext(), MapsActivity.class);
                mapIntent.putExtra("latLong", mapCenter);
                startActivity(mapIntent);
            }
        });
    }
}
