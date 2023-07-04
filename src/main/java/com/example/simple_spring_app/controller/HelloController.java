package com.example.simple_spring_app.controller;

import com.example.simple_spring_app.entity.Address;
import com.example.simple_spring_app.entity.Person;
import com.example.simple_spring_app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private AppService appService;

    @GetMapping
    public ResponseEntity<?> getRoot() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World from root!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }

    @PostMapping("/person")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return ResponseEntity.ok(appService.addPerson(person));
    }

    @PostMapping("/sample-person")
    public ResponseEntity<?> addPerson() {
        return ResponseEntity.ok(appService.addSamplePerson());
    }

    @GetMapping("/person")
    public ResponseEntity<?> getPerson() {
        return ResponseEntity.ok(appService.getPerson());
    }

    @GetMapping("/address")
    public ResponseEntity<?> getAddress() {
        return ResponseEntity.ok(appService.getAddress());
    }

    @PostMapping("/person/{personId}/address")
    public ResponseEntity<?> addAddress(@PathVariable Long personId, @RequestBody Address address) {
        return ResponseEntity.ok(appService.addAddress(personId, address));
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        return ResponseEntity.ok(appService.deletePerson(id));
    }
    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        return ResponseEntity.ok(appService.deleteAddress(id));
    }

}
