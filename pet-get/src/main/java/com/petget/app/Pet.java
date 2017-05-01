package com.petget.app;


public class Pet extends PetFactory{
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

    public Pet createPet() {
        Pet tempDoggo = new Pet();
        return tempDoggo;
    }

    boolean isAdoptable() {
        return true;
    }
}
