package com.example.drake.parx.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.drake.parx.R;

public class HowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how);

        // Add up navigation to the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}