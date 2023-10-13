package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ServiceInfoController {

    @GetMapping
    public ResponseEntity<String> info() {
        return new ResponseEntity<>("service is up and running", HttpStatus.OK);
    }
}
