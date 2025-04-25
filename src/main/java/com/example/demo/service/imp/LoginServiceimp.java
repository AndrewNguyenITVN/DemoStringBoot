package com.example.demo.service.imp;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceimp {
    List<UserDTO> getAllUser();
    Boolean checkLogin(String username, String password) ;
    Boolean addUser(SignUpRequest signUpRequest);
}
