package com.example.drake.parx.UI;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.drake.parx.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

//    // Client used to sign in with Google APIs
//    private GoogleSignInClient parxGoogleSignInClient = null;
    // Request code used when invoking an external client
    private static final int RC_SIGN_IN = 9001;
    // Account used to hold the signed in player
    private static GoogleSignInAccount signedInAccount;
    String gamerId = "nope";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //* * * * * * SIGN IN TO GOOGLE PLAY GAMES * * * * * *
        //****************************************************
        // First determine if the user is already signed in
        if (isSignedIn()){
            // player is signed in
            // get the player's user account info
            // get badges from the server for the user account
            Toast.makeText(this, "signed in as: "+String.valueOf(signedInAccount), Toast.LENGTH_SHORT).show();
        }else {
            // player is not signed in
            // cannot use silent sign-in if trying to release as 'family values' app
            Toast.makeText(this, "Not signed in", Toast.LENGTH_SHORT).show();
            //startSignInIntent();
        }
    }


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
                // Open all badges activity
                Intent badgeIntent = new Intent(this, AllBadgesActivity.class);
                this.startActivity(badgeIntent);
                break;
            case R.id.menu_sign_in:
                // Open Google Play Games interactive sign in dialog
                startSignInIntent();
                break;
            case R.id.menu_sign_out:
                // Open Google Play Games sign out dialog
                signOut();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isSignedIn(){
        return GoogleSignIn.getLastSignedInAccount(this) != null;
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
                gamerId = String.valueOf(signedInAccount);
                Toast.makeText(this, "Signed in: "+gamerId, Toast.LENGTH_LONG).show();
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
                        Toast.makeText(getApplicationContext(), "Signed Out", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
