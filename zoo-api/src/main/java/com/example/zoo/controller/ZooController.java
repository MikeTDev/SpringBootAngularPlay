package com.example.zoo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public abstract class ZooController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @GetMapping("/testConnection")
    public ResponseEntity<String> testConnection() {
        return ResponseEntity.ok("Yay...");
    }

    @GetMapping("/breakme")
    public String iWillBreak() {
        throw new IllegalArgumentException("This is a test error.");
    }
}
