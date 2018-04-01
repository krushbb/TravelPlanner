package com.example.tp.travelplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//main trips will display the trips the user has created
//will fetch data from the database

public class MainTrips extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trips);
    }

    //CLick listener checks to see if the addNewTrip was selected, will redirect to the main screen
    public void onclickAddNewTrip(View v)
    {
        //if the button is selected it will take find the id of the button
        if (v.getId() == R.id.bAddNewTrip)
        {
            //creates the launchMainTrip intent, and will open the main Trip page
            Intent launchAddNewTrip = new Intent(MainTrips.this, AddNewTrip.class);
            //will direct mainTrips to process the intent created to start the Add New Trip activity
            startActivity(launchAddNewTrip);
        }
    }
}