package com.example.tp.travelplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Accommodation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);
    }

    //CLick listener checks to see if the enterSystem was selected, will redirect to the main screen
    public void onClickAddNewAcco (View v)
    {
        //if the button is selected it will take find the id of the button
        if (v.getId() == R.id.bAddNewAcco)
        {
            //creates the launchNewAcco intent, and will open the new accommodation page
            Intent launchNewAcco = new Intent(Accommodation.this, AddNewAccommodation.class);
            //will direct accommodation to process the intent created to start the new accommodation activity
            startActivity(launchNewAcco);
        }
    }
}
