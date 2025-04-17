package com.example.demo.controller;

import com.example.demo.modal.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController = @Controller + @ResponseBody
 * @RequestMapping register URL
 */

@RestController
@RequestMapping("/user")
public class userController {
    @GetMapping("/getAllUser")
//    public String getAllUser(){
//        return "Hello getAllUser";
//    }
    public ResponseEntity<?> getAllUser(){
        User user = new User();
        user.setId(1);
        user.setPasswd("123456");
        user.setUsername("Nguyen Van A");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/add")
    public String addUser(@RequestParam("username") String username, @RequestParam int id){
        return "hello add user" + " " + username + " " + id;
    }
    //http://localhost:8080/user/add?username=Nhut&id=123

    @GetMapping("/getDetail/{id}/{username}")
    public String getDetail(@PathVariable("id") int id, @PathVariable() String username){
        return "hello " + id + " " + username;
    }
    //http://localhost:8080/user/getDetail/123/Nhut

    @PostMapping("/update")
    public String updateUssr(@RequestBody List<User> user){ //RequestBody nhận đói tượng, và trả về bằng JSON
        String s = "";
        for(User data : user)
            s += data.getUsername() + " " +data.getId() + " ";
        return s;
    }

}
