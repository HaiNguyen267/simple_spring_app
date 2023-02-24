package com.example.simple_spring_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<?> getHello() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }

    @PostMapping("/hello")
    public ResponseEntity<?> postHello() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World!");
        map.put("method", "POST");
        return ResponseEntity.ok(map);
    }
}
