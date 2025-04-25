package com.example.demo.controller;

import com.example.demo.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController = @Controller + @ResponseBody
 * @RequestMapping register URL
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){

            return new ResponseEntity<>(userServiceImp.getAllUsers(), HttpStatus.OK);
        }

    }
