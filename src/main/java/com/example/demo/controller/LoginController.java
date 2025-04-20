package com.example.demo.controller;

import com.example.demo.payload.ResponseData;
import com.example.demo.payload.request.SignUpRequest;
import com.example.demo.repository.imp.LoginServiceimp;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        ResponseData responseData = new ResponseData();

        responseData.setData(loginServiceimp.addUser(signUpRequest));

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
