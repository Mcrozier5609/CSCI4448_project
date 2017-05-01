package com.petget.app;


/**
 * Created by Michael Crozier on 4/27/2017.
 */
public abstract class Pet extends PetFactory{
    int id;
    String nickname;
    int weight;
    String color;

    public Pet() {
        id = 0;
        nickname = "0";
        weight = 0;
        color = "0";
    }

    public Pet(int i, String name, int w, String c) {
        id = i;
        nickname = name;
        weight = w;
        color = c;
    }



    boolean isAdoptable() {
        return true;
    }
}
