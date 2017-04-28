package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class Cat extends Pet {
    int legs;
    int tailLength;
    int height;
    int length;
    String temperment;
    String species;

    public Cat() {

    }

    public boolean isAdoptable() {
        return true;
    }
}
