package com.petget.app;

/**
 * Created by Hunter on 4/27/2017.
 */
public class Shelter {

    public Pet[] pets = new Pet[100];
    public AdoptionRequest[] requests = new AdoptionRequest[50];


    public Pet addPet(Pet p){
        return p;
    }

    public Pet remove(Pet p){
        return p;
    }

    public Pet[] getAllPets(){
        return pets;
    }

    public void addRequest(AdoptionRequest ar){}

    public AdoptionRequest[] getRequests(){
        return requests;
    }

    public void addAppointment(Appointment a){}

}
