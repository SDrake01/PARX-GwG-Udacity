package com.example.drake.parx.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.drake.parx.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        }
        return super.onOptionsItemSelected(item);
    }
}
