package com.example.zoo.model;

import com.example.zoo.enums.AnimalType;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, AnimalType.DOG);
    }

    @Override
    public void speak() {
        System.out.println(name + " barks.");
    }

   public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }
}
