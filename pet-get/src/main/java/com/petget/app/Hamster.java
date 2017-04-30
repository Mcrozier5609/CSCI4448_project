package com.petget.app;

/**
 * Created by Michael Hamster on 4/27/2017.
 */
public class Hamster extends Pet {
    int legs;

    public Hamster(String name, int w, String c, int i) {
        nickname = name;
        weight = w;
        color = c;
        id = i;
    }

    public boolean isAdoptable() {
        return true;
    }
}
