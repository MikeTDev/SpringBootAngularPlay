package com.example.zoo.controller;

import com.example.zoo.dto.AnimalDto;
import com.example.zoo.dto.CreateAnimalRequest;
import com.example.zoo.service.ZooService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController extends ZooController {
    private final ZooService zooService;

    public AnimalController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping
    public List<AnimalDto> getAllAnimals() {
        return zooService.getAllAnimals();
    }

    @GetMapping("/{name}")
    public ResponseEntity<AnimalDto> getAnimalByName(@PathVariable String name) {
        return zooService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AnimalDto> addAnimal(@RequestBody CreateAnimalRequest request) {
        AnimalDto created = zooService.addAnimal(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}