package com.petget.app;

/**
 * Created by Michael Hamster on 4/27/2017.
 */
public class Hamster extends Pet {
    int legs;

    public Hamster(String name, int w, String c, int i, String u) {
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
