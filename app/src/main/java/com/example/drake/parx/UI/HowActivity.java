package com.example.drake.parx.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.drake.parx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HowActivity extends AppCompatActivity {

    // Annotate views for use with Butterknife
    @BindView(R.id.how_toolbar) Toolbar howToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how);
        ButterKnife.bind(this);
//        Toolbar howToolbar = findViewById(R.id.how_toolbar);
        setSupportActionBar(howToolbar);
        // Add up navigation to the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
