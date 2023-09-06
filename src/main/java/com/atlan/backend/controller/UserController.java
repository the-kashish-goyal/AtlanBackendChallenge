package com.atlan.backend.controller;

import com.atlan.backend.entity.User;
import com.atlan.backend.entity.isValid;
import com.atlan.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        Object response = userService.addUser(user);
        if(response instanceof isValid){
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }else{
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }
}
