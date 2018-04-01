package com.example.tp.travelplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//will let user add new flights
//should display the details of flights specifc to the tirpFlight table
public class Flights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
    }

    //CLick listener checks to see if the addNewFlight was selected, will redirect to the add flight screen
    public void onclickAddNewFlight (View v)
    {
        //if the button is selected it will take find the id of the button
        if (v.getId() == R.id.bAddNewFlight)
        {
            //creates the launchAddNewFlight intent, and will open the main Trip page
            Intent launchAddNewFlight = new Intent(Flights.this, AddNewFlight.class);
            //will direct flights to process the intent created to start the addNewFlight activity
            startActivity(launchAddNewFlight);
        }
    }

}
