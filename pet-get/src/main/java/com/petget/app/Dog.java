package com.petget.app;

/**
 * Created by Michael on 4/27/2017.
 */
public class Dog extends Pet {
    int legs;
    int tailLength;
    int height;
    String temperment;
    int length;
    String species;

    public Dog() {

    }

    public boolean isAdoptable() {
        return true;
    }
}
