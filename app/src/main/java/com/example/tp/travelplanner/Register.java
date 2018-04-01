package com.example.tp.travelplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


//will allow the user to register into the system
//will be linked to the addUser method in the Database Helper
public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
