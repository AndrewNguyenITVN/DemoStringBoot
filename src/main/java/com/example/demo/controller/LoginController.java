package com.example.demo.controller;

import com.example.demo.payload.ResponseData;
import com.example.demo.repository.imp.LoginServiceimp;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceimp loginServiceimp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, String password) {
        ResponseData responseData = new ResponseData();
        if(loginServiceimp.checkLogin(username, password)){
            responseData.setData(true);

        }else {
            responseData.setData(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
