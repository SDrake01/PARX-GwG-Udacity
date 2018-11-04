package com.example.drake.parx.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "statepark_table")
public class StatePark {

    @PrimaryKey
    @NonNull
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private float radius;

    public void setId(String newId){this.id = newId;}
    public void setName(String newName){this.name = newName;}
    public void setLatitude(double newLat){this.latitude = newLat;}
    public void setLongitude(double newLong){this.longitude = newLong;}
    public void setRadius(float newRadius){this.radius = newRadius;}

    public String getId(){return id;}
    public String getName(){return name;}
    public double getLatitude(){return latitude;}
    public double getLongitude(){return longitude;}
    public float getRadius(){return radius;}
}
