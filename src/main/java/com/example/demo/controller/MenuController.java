package com.example.demo.controller;

import com.example.demo.payload.ResponseData;
import com.example.demo.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuServiceImp menuServiceImp;

    @PostMapping()
    public ResponseEntity<?> createMenu(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String time_ship,
            @RequestParam Double price,
            @RequestParam int cate_id
    ){
        ResponseData responseData = new ResponseData();

        boolean isSuccess = menuServiceImp.insertMenu(file, title, time_ship, price, cate_id);

        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
