package com.example.zoo.model;

import com.example.zoo.enums.AnimalType;


public abstract class Animal {
    protected String name;
    protected AnimalType type;

    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public void move() {
        System.out.println(name + " moves around.");
    }

    public abstract void speak();
}
