package com.example.simple_spring_app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class HelloController {

    @GetMapping
    public ResponseEntity<?> getRoot() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World from root!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }
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


    @GetMapping("/log")
    public ResponseEntity<?> getLog(@RequestParam int count) {
        Map<String, String> map = new HashMap<>();

        log.info("Hello World from log!");
        for (int i = 0; i < count; i++) {
            log.info("Hello World from log! " + i);
        }
        map.put("message", "Hello World from log!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }


    // Do the similar for log WARN, ERROR, DEBUG, TRACE
    @GetMapping("/logWarn")
    public ResponseEntity<?> getLogWarn(@RequestParam int count) {
        Map<String, String> map = new HashMap<>();

        log.warn("Hello World from log!");
        for (int i = 0; i < count; i++) {
            log.warn("Hello World from log! " + i);
        }
        map.put("message", "Hello World from log!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/logError")
    public ResponseEntity<?> getLogError(@RequestParam int count) {
        Map<String, String> map = new HashMap<>();

        log.error("Hello World from log!");
        for (int i = 0; i < count; i++) {
            log.error("Hello World from log! " + i);
        }
        map.put("message", "Hello World from log!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/logDebug")
    public ResponseEntity<?> getLogDebug(@RequestParam int count) {
        Map<String, String> map = new HashMap<>();

        log.debug("Hello World from log!");
        for (int i = 0; i < count; i++) {
            log.debug("Hello World from log! " + i);
        }
        map.put("message", "Hello World from log!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/logTrace")
    public ResponseEntity<?> getLogTrace(@RequestParam int count) {
        Map<String, String> map = new HashMap<>();

        log.trace("Hello World from log!");
        for (int i = 0; i < count; i++) {
            log.trace("Hello World from log! " + i);
        }
        map.put("message", "Hello World from log!");
        map.put("method", "GET");
        return ResponseEntity.ok(map);
    }
}
