package com.petget.app;

/**
 * Created by Hunter on 4/27/2017.
 */
public class User {

    public int id;
    public String name;

    private String password;

    public User(){
        id = 0;
        name = "0";
    }

    public User(int iDNumber, String n){
        id = iDNumber;
        name = n;
    }

    public boolean testPassword(String test){
        return true;
    }



}