package com.example.tp.travelplanner;


//class will be used to link the user table values to the database
public class users {

    private int userID;
    private String username;
    private String password;

    //creating constructor
    public users(String user) {
    }

    //methods (getters) used to get values from users table
    //methods (setters) used to set values from user table
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
