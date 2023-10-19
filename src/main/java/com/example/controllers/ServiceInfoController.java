package com.example.controllers;

import com.example.constant.AccountConstants;
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
        return new ResponseEntity<>(AccountConstants.SERVICE_IS_RUNNING.getMessage(), HttpStatus.OK);
    }
}
