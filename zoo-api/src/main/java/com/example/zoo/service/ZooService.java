package com.example.zoo.service;

import com.example.zoo.dto.AnimalDto;
import com.example.zoo.dto.CreateAnimalRequest;
import com.example.zoo.model.Animal;
import com.example.zoo.model.Bird;
import com.example.zoo.model.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ZooService {
    private final List<Animal> animals = new ArrayList<>();

    public ZooService() {
        animals.add(new Dog("Rex"));
        animals.add(new Bird("Tweety"));
        animals.add(new Dog("Buddy"));
    }

    public List<AnimalDto> getAllAnimals() {
        return animals.stream()
                .map(a -> new AnimalDto(a.getName(), a.getType().name()))
                .toList();
    }

    public Optional<AnimalDto> findByName(String name) {
        return animals.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(a -> new AnimalDto(a.getName(), a.getType().name()));
    }

    public AnimalDto addAnimal(CreateAnimalRequest request) {
        if (request == null || request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }

        if (request.type() == null || request.type().isBlank()) {
            throw new IllegalArgumentException("Type is required.");
        }

        String normalizedType = request.type().trim().toUpperCase(Locale.ROOT);

        Animal animal = switch (normalizedType) {
            case "DOG" -> new Dog(request.name().trim());
            case "BIRD" -> new Bird(request.name().trim());
            default -> throw new IllegalArgumentException("Supported types: DOG, BIRD");
        };

        animals.add(animal);
        return new AnimalDto(animal.getName(), animal.getType().name());
    }
}
