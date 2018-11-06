package com.example.drake.parx.Data;

import com.example.drake.parx.ViewModels.ParxViewModel;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class StateParkMarkers {

    static List<StatePark> parxList = new ArrayList<>();
    static List<Marker> parxMarkers = new ArrayList<>();

    public static void buildMapMarkers(GoogleMap thisMap){

        parxList = ParxViewModel.getAllParxList();

        if (parxList.size() > 0) {
            for (int i = 0; i < parxList.size(); i++) {
                StatePark thisPark = parxList.get(i);
                Marker listMarker = thisMap.addMarker(new MarkerOptions()
                        .position(new LatLng(thisPark.getLatitude(),thisPark.getLongitude()))
                        .title(thisPark.getName()));
                parxMarkers.add(listMarker);
            }
        }
    }
}
