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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.parx_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_about:
                // Open about PARX activity
                Toast.makeText(this, "You selected - About PARX", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_how:
                // Open how it works activity
                Toast.makeText(this, "You selected - How It Works", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_badges:
                // Open all badges activity
                Intent intent = new Intent(this, AllBadgesActivity.class);
                this.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
