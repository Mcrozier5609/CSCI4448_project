package com.petget.app;

/**
 * Created by Hunter on 4/27/2017.
 */
public class Customer extends User{

    public String address;
    public String phoneNumber;
    public String email;

    public Customer () {

    }

    public Customer(String add, String phone, String mail){
        address = add;
        phoneNumber = phone;
        email = mail;

    }

    public void makeAppointment(Appointment a){}

}