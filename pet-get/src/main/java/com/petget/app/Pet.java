package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class Pet implements PetFactory{
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

    public Pet(int id, String nickname, int weight, String color) {

    }

    public Pet createPet() {
        Pet tempDoggo = new Pet();
        return tempDoggo;
    }

    boolean isAdoptable() {
        return true;
    }
}
