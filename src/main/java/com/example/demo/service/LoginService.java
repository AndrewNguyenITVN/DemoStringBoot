package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Roles;
import com.example.demo.entity.Users;
import com.example.demo.modal.User;
import com.example.demo.payload.request.SignUpRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.imp.LoginServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceimp {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser(){
        List<Users> listUser = userRepository.findAll();
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

    @Override
    public Boolean checkLogin(String username, String password) {
        List<Users> listUser = userRepository.findByUsernameAndPassword(username, password);

        return listUser.size() > 0;
    }

    @Override
    public Boolean addUser(SignUpRequest signUpRequest){

        Roles role = new Roles();
        role.setId(signUpRequest.getRoleId());

        Users user = new Users();
        user.setUsername(signUpRequest.getMail());
        user.setFullName(signUpRequest.getFullname());
        user.setPassword(signUpRequest.getPassword());
        user.setRole(role);

        try{
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
