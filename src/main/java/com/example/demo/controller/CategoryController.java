package com.example.demo.controller;

import com.example.demo.payload.ResponseData;
import com.example.demo.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping()
    public ResponseEntity<?> getHomeCategory(){

        ResponseData responseData = new ResponseData();


        responseData.setData(categoryServiceImp.getCategoryHome());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
