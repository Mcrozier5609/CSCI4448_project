package com.petget.app;

/**
 * Created by Michael Crozieron 4/27/2017.
 */
public class Bird extends Pet{
    int wingspan;
    boolean canFly;
    int legs;
    String temperment;
    int height;
    String species;

    public Bird(String name, int w, String c, int i){
        nickname = name;
        weight = w;
        color = c;
        id = i;
    }

    public boolean isAdopted() {
        return true;
    }
}
