package com.example.drake.parx.UI;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.drake.parx.AsyncTasks.StateParksAsyncTask;
import com.example.drake.parx.Data.AppWidgetData;
import com.example.drake.parx.Data.StatePark;
import com.example.drake.parx.Data.StateParkDao;
import com.example.drake.parx.Data.StateParkDatabase;
import com.example.drake.parx.Data.StateParkMarkers;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Request code used when invoking an external client
    private static final int RC_SIGN_IN = 9001;
    // Request code used when showing all achievement badges
    private static final int RC_ACHIEVEMENT_UI = 9003;
    // Account used to hold the signed in player
    public static GoogleSignInAccount signedInAccount;
    // ViewModel instance used by the live data observer
    private ParxViewModel parxViewModel;
//    private ParxViewModel stateParkViewModel;
    // Create database objects
    private StateParkDatabase parxDb;
    public static StateParkDao mainParxDao;
    // Variables needed for the geofences
    public static List<StatePark> parkList = new ArrayList<>();
    List<Geofence> parxGeofenceList = new ArrayList<>();
    StatePark geoPark;
    PendingIntent parxGeoPendingIntent;
    GeofencingClient parxGeofencingClient;
    // String variables used to update and increment the google play games achievements
    private List<String> updateBadges;
    private String updateOne;
    private List<String> incrementBadges;
    private String incrementOne;
    // Annotate views for use with Butterknife
    @BindView(R.id.main_toolbar) Toolbar mainToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);


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
        }

        // Observe the achievements live data for changes and update when necessary
        parxViewModel = ViewModelProviders.of(this).get(ParxViewModel.class);
        final Observer<List<Achievement>> achievementObserver = new Observer<List<Achievement>>() {
            @Override
            public void onChanged(@Nullable List<Achievement> achievements) {
                // Call recyclerview adapter setBadges method when the
                // live data list is updated to show the updates on screen
                BadgesFragment.badgesAdapter.setBadges(achievements);
                // Update background data for the widget when the achievements data changes
                int earned=0;
                int total=0;
                for (int i = 0;i<achievements.size();i++){
                    total++;
                    if (achievements.get(i).getState() == Achievement.STATE_UNLOCKED){
                        earned++;
                    }
                }
                AppWidgetData.setWidgetEarned(earned);
                AppWidgetData.setWidgetTotal(total);
            }
        };
        parxViewModel.getPlayerAchievementList().observe(this, achievementObserver);

        buildGeofences();
        // Add an observer for the state parks live data and rerun buildGeofences() when its data changes
//        parxViewModel = ViewModelProviders.of(this).get(ParxViewModel.class);
        final Observer<List<StatePark>> stateParkListObserver = new Observer<List<StatePark>>() {
            @Override
            public void onChanged(@Nullable List<StatePark> stateParks) {
                parkList = stateParks;
                // call buildGeofences when data updates
                buildGeofences();
            }
        };
        parxViewModel.getAllParxList().observe(this, stateParkListObserver);

        // Add an observer for the updated badges live data list and send the updates to google play games services
        final Observer<List<String>> updateBadgesListObserver = new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                updateBadges = strings;
                for (int i = 0; i < updateBadges.size(); i++){
                    updateOne = updateBadges.get(i);
                    Games.getAchievementsClient(
                            MainActivity.this,
                            GoogleSignIn.getLastSignedInAccount(
                                    MainActivity.this))
                            .unlock(updateOne);
                }
            }
        };
        parxViewModel.getUpdateBadgeList().observe(this, updateBadgesListObserver);
        // Add an observer for the incremented badges live data list and send the increments to gpgs
        final Observer<List<String>> incrementBadgesListObserver = new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                incrementBadges = strings;
                for (int i = 0; i < incrementBadges.size(); i++) {
                    incrementOne = incrementBadges.get(i);
                    Games.getAchievementsClient(
                            MainActivity.this,
                            GoogleSignIn.getLastSignedInAccount(
                                    MainActivity.this))
                            .increment(incrementOne, 1);
                }
            }
        };
        parxViewModel.getIncrementBadgeList().observe(this, incrementBadgesListObserver);
    } // *******************   End of onCreate method   *******************


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
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                    startActivity(aboutIntent, bundle);
                } else {
                    startActivity(aboutIntent);
                }
                break;
            case R.id.menu_how:
                // Open how it works activity
                Intent howIntent = new Intent(this, HowActivity.class);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                    startActivity(howIntent, bundle);
                } else {
                    startActivity(howIntent);
                }
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
        // Create the geofences if the list is not empty
        if (parkList != null && parkList.size() > 0){
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
                                StateParkMarkers.buildMapMarkers(MapFragment.parxFragMap,parkList);
                            }
                        })
                        .addOnFailureListener(this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                            }
                        });
            }catch (SecurityException se){
                Log.e("Add Geofences", "No Location Permissions");
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
        Intent intent = new Intent(MainActivity.this, GeofenceTransitionsUtility.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when
        // calling addGeofences() and removeGeofences().
        parxGeoPendingIntent = PendingIntent.getService(MainActivity.this, 0, intent, PendingIntent.
                FLAG_UPDATE_CURRENT);
        return parxGeoPendingIntent;
    }

    // Unlock achievements passed in from UpdateUtility
    public void achieveUnlock(String achieveId){
            Games.getAchievementsClient(this, GoogleSignIn.getLastSignedInAccount(MainActivity.this)).unlock(achieveId);
    }
    // Increment achievements passed in from UpdateUtilty
    public void achieveIncrement(String achieveId) {
        if (signedInAccount != null) {
            Games.getAchievementsClient(this, signedInAccount)
                    .increment(achieveId, 1);
        }
    }
}
