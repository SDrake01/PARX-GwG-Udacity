package com.example.drake.parx.Data;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class StateParkMarkers {

    public static void buildMapMarkers(GoogleMap thisMap, List<StatePark> stateParkList){

        if (stateParkList.size() > 0) {
            for (int i = 0; i < stateParkList.size(); i++) {
                StatePark thisPark = stateParkList.get(i);
                thisMap.addMarker(new MarkerOptions()
                        .position(new LatLng(thisPark.getLatitude(),thisPark.getLongitude()))
                        .title(thisPark.getName()));

                CircleOptions circleOptions = new CircleOptions()
                        .center(new LatLng(thisPark.getLatitude(), thisPark.getLongitude()))
                        .radius(thisPark.getRadius());
                thisMap.addCircle(circleOptions);
            }
        }
    }
}
