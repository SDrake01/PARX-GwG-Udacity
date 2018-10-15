package com.example.drake.parx.Data;

import android.content.res.Resources;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class StateParks {

    // Colors used for the state park polygons
    // I couldn't use colors from the res folder without passing in
    // the context, so these are hard-coded here along with outline width
    static int parkOutlineWidth = 5;
    static int parkOutline = 0x4D388E3C;
    static int parkFill = 0x40388E3C;

    public static void addParks(GoogleMap thisMap){

        Polygon polyFtHarrod = thisMap.addPolygon(StateParks.parkOldFortHarrod);
        Marker markFtHarrod = thisMap.addMarker(markOldFortHarrod);
        Polygon polyBlueLick = thisMap.addPolygon(StateParks.parkBlueLick);
        Marker markBlueLick = thisMap.addMarker(markBlueLickBattlefield);
    }


    // Polygon object for Old Fort Harrod State Park
    public static PolygonOptions parkOldFortHarrod = new PolygonOptions()
            .add(new LatLng(37.762456, -84.845753),
                    new LatLng(37.762873, -84.851236),
                    new LatLng(37.761628, -84.851318),
                    new LatLng(37.761296, -84.846531),
                    new LatLng(37.761398, -84.846470),
                    new LatLng(37.761424, -84.846346),
                    new LatLng(37.761424, -84.846193),
                    new LatLng(37.761405, -84.845836))
            .strokeWidth(parkOutlineWidth)
            .strokeColor(parkOutline)
            .fillColor(parkFill);
    // Marker and Info Window Data for Old Fort Harrod State Park
    static LatLng coordFtHarrod = new LatLng(37.761862, -84.846334);
    public static MarkerOptions markOldFortHarrod = new MarkerOptions()
            .position(coordFtHarrod)
            .title("Old Fort Harrod State Park")
            .snippet("Earn the Blockade Badge here");

    // Polygon object for Blue Lick Battlefield State Resort Park
    public static PolygonOptions parkBlueLick = new PolygonOptions()
            .add(new LatLng(38.440648, -83.998188),
                    new LatLng(38.440014, -83.997868),
                    new LatLng(38.438971, -83.997565),
                    new LatLng(38.438324, -83.997497),
                    new LatLng(38.437915, -83.997396),
                    new LatLng(38.437590, -83.997302),
                    new LatLng(38.437264, -83.997290),
                    new LatLng(38.436466, -83.997201),
                    new LatLng(38.436013, -83.997153),
                    new LatLng(38.435336, -83.997207),
                    new LatLng(38.434398, -83.997135),
                    new LatLng(38.433044, -83.997052),
                    new LatLng(38.432727, -83.996998),
                    new LatLng(38.430528, -83.997117),
                    new LatLng(38.429071, -83.997421),
                    new LatLng(38.427064, -83.998089),
                    new LatLng(38.425654, -83.998965),
                    new LatLng(38.425122, -83.997374),
                    new LatLng(38.424865, -83.995288),
                    new LatLng(38.423511, -83.995711),
                    new LatLng(38.422956, -83.995210),
                    new LatLng(38.421807, -83.996182),
                    new LatLng(38.420808, -83.997862),
                    new LatLng(38.420491, -83.997695),
                    new LatLng(38.420239, -83.997380),
                    new LatLng(38.419739, -83.996360),
                    new LatLng(38.419356, -83.995610),
                    new LatLng(38.418399, -83.993548),
                    new LatLng(38.418282, -83.992940),
                    new LatLng(38.418259, -83.991712),
                    new LatLng(38.418586, -83.990187),
                    new LatLng(38.419478, -83.989025),
                    new LatLng(38.419916, -83.988775),
                    new LatLng(38.420243, -83.988691),
                    new LatLng(38.420733, -83.988751),
                    new LatLng(38.421334, -83.988966),
                    new LatLng(38.421947, -83.989388),
                    new LatLng(38.422792, -83.990112),
                    new LatLng(38.423907, -83.991054),
                    new LatLng(38.424702, -83.991501),
                    new LatLng(38.425355, -83.991638),
                    new LatLng(38.426272, -83.991591),
                    new LatLng(38.431801, -83.989843),
                    new LatLng(38.432256, -83.991150),
                    new LatLng(38.434894, -83.991387),
                    new LatLng(38.433290, -83.993740),
                    new LatLng(38.440841, -83.997211))
            .strokeWidth(parkOutlineWidth)
            .strokeColor(parkOutline)
            .fillColor(parkFill);
    // Marker and Info Window Data for Blue Lick Battlefield State Resort Park
    static LatLng coordBlueLick = new LatLng(38.432394, -83.995528);
    public static MarkerOptions markBlueLickBattlefield = new MarkerOptions()
            .position(coordBlueLick)
            .title("Blue Lick Battlefield State Resort Park")
            .snippet("Earn the Sheltowee Badge here");
}
