package com.example.tp.travelplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //information on the database
    private static final String DATABASE_NAME = "userTrips";
    private static final int DATABASE_VERSION = 1;

    //table information for users table
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USER_ID = "userID";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    //setting up the table information the trips table
    private static final String TABLE_TRIPS = "trips";
    private static final String COLUMN_TRIP_ID = "tripID";
    private static final String COLUMN_TRIP_NAME = "tripName";
    private static final String COLUMN_LOCATION_CODE = "locationCode";
    private static final String COLUMN_START_DATE = "startDate";
    private static final String COLUMN_END_DATE = "endDate";

    //setting up table information for flight table
    private static final String TABLE_FLIGHTS = "flights";
    private static final String COLUMN_FLIGHT_NUMBER = "flightNumber";
    private static final String COLUMN_AIRLINES = "airlines";
    private static final String COLUMN_DEPARTURE_AIRPORT = "departureAirport";
    private static final String COLUMN_ARRIVAL_AIRPORT = "arrivalAirport";
    private static final String COLUMN_DEPARTURE_DATE = "departureDate";
    private static final String COLUMN_ARRIVAL_DATE = "arrivalDate";
    private static final String COLUMN_DEPARTURE_TIME = "departureTime";
    private static final String COLUMN_ARRIVAL_TIME = "arrivalTime";

    //setting up table information for TripFlight table
    private static final String TABLE_TRIP_FLIGHT = "tripFlight";
    private static final String COLUMN_FLIGHT_NUMBER_TF = "flightNumber";
    private static final String COLUMN_TRIP_ID_TF = "tripID";

    //setting up table information for TripAccommodation table
    private static final String TABLE_TRIP_ACCOMODATION = "tripAccommodation";
    private static final String COLUMN_ACCO_CODE = "accoCode";
    private static final String COLUMN_CHECK_IN_DATE = "checkInDate";
    private static final String COLUMN_CHECK_OUT_DATE = "checkOutDate";
    private static final String COLUMN_USER_ID_TA = "userID";

    //Constructor
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    //creating the users table
    //SQL command to create the table.
    //identify first whether public or private class
    //create an variable name for the create table which is equal to:
    //the table name, the column name and what the data type is
    private static final String CREATE_TABLE_USERS =  " CREATE TABLE "
            + TABLE_USERS + " ("
            + COLUMN_USER_ID + "INTEGER PRIMARY KEY AUTO_INCREMENT,"
            + COLUMN_USERNAME + "TEXT NOT NULL,"
            + COLUMN_PASSWORD + "TEXT NOT NULL,"
            + ")";


    //create an variable name for the create table
    //is the set up to create the table
    //identifies the column name and the data type for that column
    private static final String CREATE_TABLE_TRIPS = "CREATE TABLE"
            + TABLE_TRIPS + "("
            + COLUMN_TRIP_ID + "INTEGER PRIMARY KEY,"
            + COLUMN_TRIP_NAME + "TEXT NOT NULL,"
            + COLUMN_LOCATION_CODE + "TEXT NOT NULL,"
            + COLUMN_START_DATE + "DATE NOT NULL,"
            + COLUMN_END_DATE + "DATE NOT NULL,"
            + ")";

    //create an variable name for the create table flights
    //is the set up to create the flights table
    //identifies the column name and the data type for that column
    private static final String CREATE_TABLE_FLIGHTS = "CREATE TABLE"
            + TABLE_FLIGHTS + "("
            + COLUMN_FLIGHT_NUMBER + "TEXT PRIMARY KEY NOT NULL,"
            + COLUMN_AIRLINES + "TEXT NOT NULL,"
            + COLUMN_DEPARTURE_AIRPORT + "TEXT NOT NULL,"
            + COLUMN_ARRIVAL_AIRPORT + "TEXT NOT NULL,"
            + COLUMN_DEPARTURE_DATE + "DATE NOT NULL,"
            + COLUMN_ARRIVAL_DATE + "DATE NOT NULL,"
            + COLUMN_DEPARTURE_TIME + "TIME NOT NULL,"
            + COLUMN_ARRIVAL_TIME + "TIME NOT NULL,"
            + ")";


    //is the set up to create the trip flights table
    //identifies the column name and the data type for that column
    private static final String CREATE_TABLE_TRIP_FLIGHT = "CREATE TABLE"
            + TABLE_TRIP_FLIGHT + "("
            + COLUMN_FLIGHT_NUMBER_TF + "TEXT PRIMARY KEY NOT NULL, FOREIGN KEY (COLUMN_FLIGHT_NUMBER_TF) REFERENCES TABLE_FLIGHTS(COLUMN_FLIGHT_NUMBER),"
            + COLUMN_TRIP_ID_TF + "PRIMARY KEY NOT NULL, FOREIGN KEY (COLUMN_FLIGHT_NUMBER_TF) REFERENCES TABLE_TRIPS(COLUMN_TRIP_ID),"
            + ")";

    //is the set up to create the trip flights table
    //identifies the column name and the data type for that column
    private static final String CREATE_TABLE_TRIP_ACCO = "CREATE TABLE"
            + TABLE_TRIP_ACCOMODATION + "("
            + COLUMN_ACCO_CODE + "TEXT PRIMARY KEY NOT NULL,"
            + COLUMN_CHECK_IN_DATE + "DATE NOT NULL,"
            + COLUMN_CHECK_OUT_DATE + "DATE NOT NULL,"
            + COLUMN_USER_ID_TA + "PRIMARY KEY NOT NULL, FOREIGN KEY (COLUMN_USER_ID_TA) REFERENCES TABLE_TRIPS(COLUMN_TRIP_ID),"
            + ")";


    //methods that are used to handle the database
    @Override
    //automatically created when a constructor for the DATABASEHELPER is selected
    //statements to create SQLite database,'db' is variable name that is used to access the database
    public void onCreate(SQLiteDatabase db) {
        //will create the database for users
        db.execSQL(CREATE_TABLE_USERS);


        //will create the database for trips
        db.execSQL(CREATE_TABLE_TRIPS);

        //will create the database for flights
        db.execSQL(CREATE_TABLE_FLIGHTS);

        //will create the database for trip flights
        db.execSQL(CREATE_TABLE_TRIP_FLIGHT);

        //will create the database for trip accommodation table
        db.execSQL(CREATE_TABLE_TRIP_ACCO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Will drop the user table if it is already existing
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
        //will create the database
        onCreate(db);

        //will drop the trips table if it already exists
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TRIPS);
        onCreate(db);

        //will drop the flights table if it already exists
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_FLIGHTS);
        onCreate(db);

        //will drop the flights table if it already exists
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TRIP_FLIGHT);
        onCreate(db);

        //will drop the flights table if it already exists
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TRIP_ACCOMODATION);
        onCreate(db);


    }

    //method to add user into database
    //method is public, method name, class it extends to and variable name associated with method
    public void addUser(users user){
        //to instantiate the database and enter values in database
        //have to use a writable database so tat information is stored
        SQLiteDatabase db = this.getWritableDatabase();
        //call the content values
        ContentValues values = new ContentValues();
        //putting values into database
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());
        //database inserts that values that were entered into the table
        db.insert(TABLE_USERS, null, values);
        //closing the database after insert - ensures data enter is sucessful
        db.close();
    }

    public void addTrip(trips trip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TRIP_NAME, trip.getTripName());
        values.put(COLUMN_LOCATION_CODE, trip.getLocationCode());
        values.put(COLUMN_START_DATE, trip.getStartDate());
        values.put(COLUMN_END_DATE, trip.getEndDate());
        db.insert(TABLE_TRIPS, null, values);
        db.close();
    }

    public void addFLights(flight flights) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FLIGHT_NUMBER, flights.getFlightNumber());
        values.put(COLUMN_AIRLINES, flights.getAirlines());
        values.put(COLUMN_DEPARTURE_AIRPORT, flights.getDepartureAirport());
        values.put(COLUMN_ARRIVAL_AIRPORT, flights.getArrivalAirport());
        values.put(COLUMN_DEPARTURE_DATE, flights.getDepartureDate());
        values.put(COLUMN_ARRIVAL_DATE, flights.getArrivalDate());
        values.put(COLUMN_DEPARTURE_TIME, flights.getDepartureTime());
        values.put(COLUMN_ARRIVAL_TIME, flights.getArrivalTime());
        db.insert(TABLE_FLIGHTS, null, values);
        db.close();
    }


    public void addAcc(accom acco) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ACCO_CODE, acco.getAccoCode());
        values.put(COLUMN_CHECK_IN_DATE, acco.getCheckInDate());
        values.put(COLUMN_CHECK_OUT_DATE, acco.getCheckOutDate());
        db.insert(TABLE_TRIP_ACCOMODATION, null, values);
        db.close();
    }

}
