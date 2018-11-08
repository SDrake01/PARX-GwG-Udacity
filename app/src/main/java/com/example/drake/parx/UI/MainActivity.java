package com.example.drake.parx.UI;

import android.app.PendingIntent;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.drake.parx.AsyncTasks.StateParksAsyncTask;
import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.Data.StateParkDao;
import com.example.drake.parx.Data.StateParkDatabase;
import com.example.drake.parx.R;
import com.example.drake.parx.Utilities.AchievementsUtility;
import com.example.drake.parx.Utilities.GeofenceTransitionsUtility;
import com.example.drake.parx.ViewModels.ParxViewModel;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Request code used when invoking an external client
    private static final int RC_SIGN_IN = 9001;
    // Request code used when showing all achievement badges
    private static final int RC_ACHIEVEMENT_UI = 9003;
    // Account used to hold the signed in player
    public static GoogleSignInAccount signedInAccount;
    // Context variable used to pass this context to another class
    public static Context parxContext;
    // ViewModel instance used by the live data observer
    private ParxViewModel parxViewModel;
    // Create database objects
    private StateParkDatabase parxDb;
    public static StateParkDao mainParxDao;
    // Variables needed for the geofences
    List<StatePark> parkList = new ArrayList<>();
    List<Geofence> parxGeofenceList = new ArrayList<>();
    StatePark geoPark;
    Circle geoCircle;
    CircleOptions geoCircleOptions;
    PendingIntent parxGeoPendingIntent;
    GeofencingClient parxGeofencingClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Itialize parxContext
        // the database may eliminate the need for this
        parxContext = this;
        // Instantiate the GeofencingClient
        parxGeofencingClient = LocationServices.getGeofencingClient(this);

        // Initialize the State Park Database and Dao
        parxDb = StateParkDatabase.getDatabase(this);
        mainParxDao = parxDb.stateParkDao();

        // Start the async task to load park data into the viewmodel
        StateParksAsyncTask parksAsyncTask = new StateParksAsyncTask();
        parksAsyncTask.execute();

        if (isSignedIn()){
            AchievementsUtility.getAchievements(this, signedInAccount);
        }else {
//            Toast.makeText(this, "not signed in", Toast.LENGTH_LONG).show();
        }

        // Observe the achievements live data for changes and update when necessary
        parxViewModel = ViewModelProviders.of(this).get(ParxViewModel.class);
        final Observer<List<Achievement>> achievementObserver = new Observer<List<Achievement>>() {
            @Override
            public void onChanged(@Nullable List<Achievement> achievements) {
                // Call recyclerview adapter setBadges method when the
                // live data list is updated to show the updates on screen
                BadgesFragment.badgesAdapter.setBadges(achievements);
            }
        };
        parxViewModel.getPlayerAchievementList().observe(this, achievementObserver);

        buildGeofences();
    }
// *******************   End of onCreate method   *******************


    // Inflate the menu in the actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.parx_menu, menu);
        return true;
    }

    // Open selected activity from menu list
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_about:
                // Open about PARX activity
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                this.startActivity(aboutIntent);
                break;
            case R.id.menu_how:
                // Open how it works activity
                Intent howIntent = new Intent(this, HowActivity.class);
                this.startActivity(howIntent);
                break;
            case R.id.menu_badges:
                // Open default all achievements activity from Google Play Games API
                showAchievements();
                break;
            case R.id.menu_sign_in:
                // Open Google Play Games interactive sign in dialog
                startSignInIntent();
                break;
            case R.id.menu_sign_out:
                // Open Google Play Games sign out dialog
                signOut();
                break;
            case R.id.menu_exit:
                // Exit PARX app
                finish();
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isSignedIn(){
        if (GoogleSignIn.getLastSignedInAccount(this) != null){
            signedInAccount = GoogleSignIn.getLastSignedInAccount(this);
            return true;
        }else {
            return false;
        }
    }

    private void startSignInIntent() {
        GoogleSignInClient signInClient = GoogleSignIn.getClient(this,
                GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        Intent intent = signInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // The signed in account is stored in the result.
                signedInAccount = result.getSignInAccount();
                AchievementsUtility.getAchievements(this, signedInAccount);
            } else {
                String message = result.getStatus().getStatusMessage();
                if (message == null || message.isEmpty()) {
                    message = getString(R.string.signin_other_error);
                }
                new AlertDialog.Builder(this).setMessage(message)
                        .setNeutralButton(android.R.string.ok, null).show();
            }
        }
    }

    private void signOut(){
        GoogleSignInClient signOutClient = GoogleSignIn.getClient(this,
                GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        signOutClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(), getString(R.string.signout_success), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void showAchievements() {
        if (GoogleSignIn.getLastSignedInAccount(this) != null) {
            Games.getAchievementsClient(this, GoogleSignIn.getLastSignedInAccount(this))
                    .getAchievementsIntent()
                    .addOnSuccessListener(new OnSuccessListener<Intent>() {
                        @Override
                        public void onSuccess(Intent intent) {
                            startActivityForResult(intent, RC_ACHIEVEMENT_UI);
                        }
                    });
        } else {
            Toast.makeText(this, getString(R.string.signin_badges), Toast.LENGTH_LONG).show();
        }
    }

    public void buildGeofences(){
        // Load the list of parks
        if (ParxViewModel.getAllParxList() != null) {
            parkList = ParxViewModel.getAllParxList();
        }
        // Create the geofences if the list is not empty
        if (parkList.size() > 0){
            for (int i = 0; i < parkList.size(); i++) {
                geoPark = parkList.get(i);
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
            try {
                parxGeofencingClient.addGeofences(getGeofencingRequest(), getGeofencePendingIntent())
                        .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Add circles to the map so the player can see the geofences
//                                buildGeoCircles();
                                // Remove this after all 49 geofences get added without errors
                                Toast.makeText(MainActivity.this, "Geofences Added Successfully", Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Failed to add geofences", Toast.LENGTH_LONG).show();
                            }
                        });
            }catch (SecurityException se){
                Log.e("geofence permissions","permissions failed");
            }
        }
    }
    // Create a geofencing request used to add the geofences adding in the parxGeofenceList
    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(parxGeofenceList);
        return builder.build();
    }
    // Create the pending intent used to add the geofences
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
}
