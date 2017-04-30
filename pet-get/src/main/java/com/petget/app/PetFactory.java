package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public abstract class PetFactory {
    public Pet createPet(String type){
        Pet p = null;

        if(type.equals("Bird")){
            p = new Bird();

        } else if(type.equals("Dog")){
            p = new Dog();

        } else if(type.equals("Cat")){
            p = new Cat();

        } else if(type.equals("Snakes")){
            p = new Snakes();

        } else if(type.equals("Hamster")){
            p = new Hamster();

        } else if(type.equals("Spider")){
            p = new Spider();

        } else if(type.equals("Fish")){
            p = new Fish();
        }

        return p;
    }
}
