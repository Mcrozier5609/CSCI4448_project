package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class Snakes extends Pet {
    int length;
    boolean poisonous;
    String species;

    public Snakes() {

    }

    public boolean isAdoptable() {
        return true;
    }
}
