package com.petget.app;

/**
 * Created by Michael on 4/27/2017.
 */
public class Bird extends Pet{
    int wingspan;
    boolean canFly;
    int legs;
    String temperment;
    int height;
    String species;

    public Bird(){

    }

    public boolean isAdopted() {
        return true;
    }
}
