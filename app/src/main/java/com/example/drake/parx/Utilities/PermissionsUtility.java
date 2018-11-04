package com.example.drake.parx.Utilities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.drake.parx.R;
import com.google.android.gms.maps.GoogleMap;

import java.util.Objects;

public class PermissionsUtility {

    private static final int RC_PERMISSION_CHECK = 42;
    private static GoogleMap mapPermission;

    public static void checkLocationPermission(final Activity thisActivity, GoogleMap thisMap) {
        // Set mapPermission to passed in map for result method
        mapPermission = thisMap;
        // Check for permissions to show the players current location on the map
        if (ContextCompat.checkSelfPermission(Objects.requireNonNull(thisActivity),
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            thisMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
            if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Explain to the player why this app needs permission to run MyLocation
                AlertDialog.Builder permissionBuilder = new AlertDialog.Builder(thisActivity);
                permissionBuilder.setTitle(thisActivity.getResources().getString(R.string.perm_request_title));
                permissionBuilder.setMessage(thisActivity.getResources().getString(R.string.perm_request_message));
                // Setup button and on click listener for the player to grant permission
                permissionBuilder.setPositiveButton(thisActivity.getString(R.string.perm_rationale_ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                ActivityCompat.requestPermissions(thisActivity,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        RC_PERMISSION_CHECK);
                            }
                });
                permissionBuilder.show();
            } else {
                // Request permissions without explanation
                ActivityCompat.requestPermissions(thisActivity,
                        new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
                        RC_PERMISSION_CHECK);
            }
        }
    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] granted){
        if (requestCode == RC_PERMISSION_CHECK){
            if (granted.length == 1 && granted[0] == PackageManager.PERMISSION_GRANTED){
                try {
                    mapPermission.setMyLocationEnabled(true);
                }catch (SecurityException e) {
//                    mapPermission.setMyLocationEnabled(false);
                }
            }
        }
    }
}
