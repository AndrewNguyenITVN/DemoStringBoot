package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserInterface userInterface;

    public List<UserDTO> getAllUser(){
        List<Users> listUser = userInterface.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (Users user: listUser){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setFullName(user.getFullName());
            userDTO.setPassword(user.getPassword());

            userDTOList.add(userDTO);

        }
        return userDTOList;
    }
}
