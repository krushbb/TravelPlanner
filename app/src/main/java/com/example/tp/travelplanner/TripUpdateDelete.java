package com.example.tp.travelplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


//user should be able to click on a button or the trip info on MainTrips to bring them to this page
//update and delete should update and delete the data
public class TripUpdateDelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_update_delete);
    }
}
