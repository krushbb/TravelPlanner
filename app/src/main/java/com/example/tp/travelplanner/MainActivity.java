package com.example.tp.travelplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//the login activity that is displayed to the user when the enter the application

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //CLick listener checks to see if the enterSystem was selected, will redirect to the main screen
    public void onClickEnterSystem (View v)
    {
        //if the button is selected it will take find the id of the button
        if (v.getId() == R.id.bEnterSystem)
        {
            //creates the launchMainTrip intent, and will open the main Trip page
            Intent launchMainTrip = new Intent(MainActivity.this, MainTrips.class);
            //will direct login activity to process the intent created to start the main trip activity
            startActivity(launchMainTrip);
        }
    }

    //CLick listener checks to see if the Register text was selected, will redirect to registerScreen
    public void onClickRegister(View v)
    {
        //if the button is selected it will take find the id of the button
        if (v.getId() == R.id.tvSignUpHere)
        {
            //creates the launchMainTrip intent, and will open the main Trip page
            Intent launchRegister = new Intent(MainActivity.this, Register.class);
            //will direct login activity to process the intent created to start the register activity
            startActivity(launchRegister);
        }
    }
}
