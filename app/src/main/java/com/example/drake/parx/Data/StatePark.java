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

    public StatePark(String id, String name, double latitude, double longitude, float radius){
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

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

    // Static Data used to pre-populate the StateParkDatabase on initial load
    public static StatePark[] staticData(){
        return new StatePark[]{
                new StatePark("01park01",
                        "Barren River State Park",
                        36.865011,
                        -86.069094,
                        500),
                new StatePark("02hist01",
                        "Big Bone Lick State Historic Site",
                        38.884040,
                        -84.752442,
                        500),
                new StatePark("03resort01",
                        "Blue Licks Battlefield State Resort Park",
                        38.432394,
                        -83.995528,
                        500),
                new StatePark("04park02",
                        "Breaks Interstate Park",
                        37.286368,
                        -82.294548,
                        500),
                new StatePark("05resort02",
                        "Buckhorn Lake State Resort Park",
                        37.306502,
                        -83.446001,
                        500),
                new StatePark("06park03",
                        "Carr Creek State Park",
                        37.232300,
                        -83.001149,
                        500),
                new StatePark("07resort03",
                        "Carter Caves State Resort Park",
                        38.369625,
                        -83.123696,
                        500),
                new StatePark("08park04",
                        "Columbus-Belmont State Park",
                        36.765685,
                        -89.110792,
                        500),
                new StatePark("09resort04",
                        "Cumberland Falls State Resort Park",
                        36.837741,
                        -84.343672,
                        500),
                new StatePark("10resort05",
                        "Dale Hollow Lake State Resort Park",
                        36.638973,
                        -85.298629,
                        500),
                new StatePark("11park05",
                        "Dawkins Line Rail Trail",
                        37.777780,
                        -82.802175,
                        500),
                new StatePark("12hist02",
                        "Dr. Thomas Walker State Historic Site",
                        36.839712,
                        -83.919291,
                        500),
                new StatePark("13park06",
                        "E.P. 'Tom' Sawyer State Park",
                        38.286374,
                        -85.557418,
                        500),
                new StatePark("14park07",
                        "Fort Boonesborough State Park",
                        37.893792,
                        -84.270606,
                        500),
                new StatePark("15park08",
                        "General Burnside Island State Park",
                        36.972579,
                        -84.598021,
                        500),
                new StatePark("16resort06",
                        "General Butler State Resort Park",
                        38.670761,
                        -85.154373,
                        500),
                new StatePark("17park09",
                        "Grayson Lake State Park",
                        38.202236,
                        -83.028227,
                        500),
                new StatePark("18park10",
                        "Green River Lake State Park",
                        37.273379,
                        -85.316753,
                        500),
                new StatePark("19resort07",
                        "Greenbo Lake State Resort Park",
                        38.480928,
                        -82.873414,
                        500),
                new StatePark("20hist03",
                        "Isaac Shelby Cemetery State Historic Site",
                        37.566354,
                        -84.8783756,
                        500),
                new StatePark("21hist04",
                        "Jefferson Davis State Historic Site",
                        36.841966,
                        -87.3000070,
                        500),
                new StatePark("22resort08",
                        "Jenny Wiley State Resort Park",
                        37.692827,
                        -82.725660,
                        500),
                new StatePark("23park11",
                        "John James Audubon State Park",
                        37.882356,
                        -87.557387,
                        500),
                new StatePark("24resort09",
                        "Kenlake State Resort Park",
                        36.759774,
                        -88.138662,
                        500),
                new StatePark("25resort10",
                        "Kentucky Dam Village State Resort Park",
                        36.998699,
                        -88.290722,
                        500),
                new StatePark("26park12",
                        "Kincaid Lake State Park",
                        38.724492,
                        -84.282887,
                        500),
                new StatePark("27park13",
                        "Kingdom Come State Park",
                        36.989369,
                        -82.984579,
                        500),
                new StatePark("28resort11",
                        "Lake Barkley State Resort Park",
                        36.849366,
                        -87.932055,
                        500),
                new StatePark("29resort12",
                        "Lake Cumberland State Resort Park",
                        36.930202,
                        -85.040820,
                        500),
                new StatePark("30park14",
                        "Lake Malone State Park",
                        37.079564,
                        -87.035399,
                        500),
                new StatePark("31park15",
                        "Levi Jackson Wilderness Road State Park",
                        37.081966,
                        -84.046188,
                        500),
                new StatePark("32park16",
                        "Lincoln Homestead State Park",
                        37.760735,
                        -85.214731,
                        500),
                new StatePark("33park17",
                        "Mineral Mound State Park",
                        37.062824,
                        -88.087648,
                        500),
                new StatePark("34park18",
                        "My Old Kentucky Home",
                        37.806462,
                        -85.454648,
                        500),
                new StatePark("35resort13",
                        "Natural Bridge State Resort Park",
                        37.777759,
                        -83.680316,
                        500),
                new StatePark("36park19",
                        "Nolin Lake State Park",
                        37.297261,
                        -86.212412,
                        500),
                new StatePark("37park20",
                        "Old Fort Harrod State Park",
                        37.761862,
                        -84.846334,
                        500),
                new StatePark("38hist05",
                        "Old Mulkey Meetinghouse State Historic Site",
                        36.677753,
                        -85.707155,
                        500),
                new StatePark("39park21",
                        "Paintsville Lake State Park",
                        37.842495,
                        -82.878918,
                        500),
                new StatePark("40resort14",
                        "Pennyrile Forest State Resort Park",
                        37.072855,
                        -87.663465,
                        500),
                new StatePark("41hist06",
                        "Perryville Battlefield State Historic Site",
                        37.674558,
                        -84.970345,
                        500),
                new StatePark("42resort15",
                        "Pine Mountain State Resort Park",
                        36.735805,
                        -83.737825,
                        500),
                new StatePark("43park22",
                        "Pine Mountain State Scenic Trail",
                        37.155703,
                        -82.633371,
                        500),
                new StatePark("44resort16",
                        "Rough River Dam State Resort Park",
                        37.610417,
                        -86.502052,
                        500),
                new StatePark("45park23",
                        "Taylorsville Lake State Park",
                        38.025064,
                        -85.264680,
                        500),
                new StatePark("46hist07",
                        "Waveland State Historic Site",
                        37.971392,
                        -84.536701,
                        500),
                new StatePark("47hist08",
                        "White Hall State Historic Site",
                        37.833201,
                        -84.352270,
                        500),
                new StatePark("48hist09",
                        "Wickliffe Mounds State Historic Site",
                        36.970782,
                        -89.092619,
                        500),
                new StatePark("49hist10",
                        "William Whitley House State Historic Site",
                        37.468384,
                        -84.549474,
                        500),
                new StatePark("50park11",
                        "Yatesville Lake State Park",
                        38.096871,
                        -82.683705,
                        500)
        };
    }
}
