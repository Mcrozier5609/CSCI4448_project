package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class Fish extends Pet {
    boolean freshWater;
    String species;

    public Fish(String name, int w, String c, int i, String u) {
        nickname = name;
        weight = w;
        color = c;
        id = i;
        url = u;
    }

    public boolean isAdoptable() {
        return true;
    }
}
