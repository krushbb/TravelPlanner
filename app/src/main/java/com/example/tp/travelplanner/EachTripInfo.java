package com.example.tp.travelplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//display the functions for the details of each trip
//will allow the user to direct to the page they select
//when each button is selected the details for that trip should be displayed
public class EachTripInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_trip_info);
    }

    //CLick listener checks to see if the enterSystem was selected, will redirect to the main screen
    public void onClickFlights (View v)
    {
        //if the button is selected it will take find the id of the button
        if (v.getId() == R.id.bflights)
        {
            //creates the launchFlights intent, and will open the main flights page
            Intent launchFlights = new Intent(EachTripInfo.this, Flights.class);
            //will direct trip info activity to process the intent created to start the flight activity
            startActivity(launchFlights);
        }
    }
}
