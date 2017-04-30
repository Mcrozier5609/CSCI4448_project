package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class Spider extends Pet {
    int diameter;
    String species;
    boolean poisonous;

    public Spider(String name, int w, String c, int i) {
        nickname = name;
        weight = w;
        color = c;
        id = i;
    }

    public boolean isAdoptable(){
        return true;
    }
}
