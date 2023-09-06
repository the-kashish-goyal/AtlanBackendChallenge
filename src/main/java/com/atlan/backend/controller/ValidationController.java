package com.atlan.backend.controller;


import com.atlan.backend.entity.User;
import com.atlan.backend.entity.isValid;
import com.atlan.backend.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationController {
    @Autowired
    UserValidationService UserValidationService;

    @GetMapping("/validateUser")
    public ResponseEntity<isValid> validateUser(@RequestBody User user) {
        return new ResponseEntity<>(UserValidationService.validateUser(user), HttpStatus.OK);
    }
}
