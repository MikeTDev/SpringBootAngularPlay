package com.example.zoo.model;

import com.example.zoo.enums.AnimalType;
import com.example.zoo.interfaces.Flyable;

public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        super(name, AnimalType.BIRD);
    }

    @Override
    public void speak() {
        System.out.println(name + " chirps.");
    }

    @Override
    public void fly() {
        System.out.println(name + " flies around.");
    }
}
