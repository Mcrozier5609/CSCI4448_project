package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class Dog extends Pet {
    int legs;
    int tailLength;
    int height;
    String temperment;
    int length;
    String species;
    String url;

    public Dog(String name, int w, String c, int i, String u) {
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
