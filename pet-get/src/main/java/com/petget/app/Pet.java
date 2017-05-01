package com.petget.app;


/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class Pet extends PetFactory{
    int id;
    String nickname;
    int weight;
    String color;
    String url;

    public Pet() {
        id = 0;
        nickname = "0";
        weight = 0;
        color = "0";
        url = "0";
    }

    public Pet(int i, String name, int w, String c, String u) {
        id = i;
        nickname = name;
        weight = w;
        color = c;
        url = u;
    }



    boolean isAdoptable() {
        return true;
    }
}
