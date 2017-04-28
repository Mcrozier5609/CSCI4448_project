package com.petget.app;

/**
 * Created by Hunter on 4/27/2017.
 */
public class Appointment {

    public int id;
    public long datetime;

    public Appointment(int iDNumber, long dt){
        id = iDNumber;
        datetime = dt;

    }

    public void remindCustomer(){}

    public void remindStaff(){}
    
}
