package com.petget.app;

/**
 * Created by Hunter on 4/27/2017.
 */
public class Shelter {

    public Pet[] pets = new Pet[100];
    public AdoptionRequest[] requests = new AdoptionRequest[50];


    public Pet addPet(Pet p){
        pets[p.id] = p;
        return p;
    }

    public Pet remove(Pet p){
        Pet nullPet = new Pet();
        pets[p.id] = nullPet;
        return p;
    }

    public Pet[] getAllPets(){
        return pets;
    }

    public void addRequest(AdoptionRequest ar){
        requests[ar.id] = ar;
    }

    public AdoptionRequest[] getRequests(){
        return requests;
    }

    public void addAppointment(Appointment a){
        a.remindCustomer();
        a.remindStaff();
    }

}
