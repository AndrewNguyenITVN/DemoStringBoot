package com.example.demo.repository.imp;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;

import java.util.List;

public interface LoginServiceimp {
    List<UserDTO> getAllUser();
    Boolean checkLogin(String username, String password) ;
}
