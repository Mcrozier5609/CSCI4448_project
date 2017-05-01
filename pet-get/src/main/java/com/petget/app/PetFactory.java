package com.petget.app;

/**
 * Created by Michael Crozier on 4/27/2017.
 */
public class PetFactory {
    public static Pet createPet(String type, String name, int weight, String color, int id){
        Pet p = null;

        if(type.equals("Bird")){
            p = new Bird(name, weight, color, id);

        } else if(type.equals("Dog")){
            p = new Dog(name, weight, color, id);

        } else if(type.equals("Cat")){
            p = new Cat(name, weight, color, id);

        } else if(type.equals("Snake")){
            p = new Snakes(name, weight, color, id);

        } else if(type.equals("Hamster")){
            p = new Hamster(name, weight, color, id);

        } else if(type.equals("Spider")){
            p = new Spider(name, weight, color, id);

        } else if(type.equals("Fish")){
            p = new Fish(name, weight, color, id);
        }

        return p;
    }
}
