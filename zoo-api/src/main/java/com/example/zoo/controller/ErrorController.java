package com.example.zoo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/error")
public class ErrorController {

    public ErrorController() {

    }

    @GetMapping
    public ResponseEntity<String> testConnection() {
        return ResponseEntity.ok("You got an error...");
    }
}
