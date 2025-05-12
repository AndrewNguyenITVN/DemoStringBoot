package com.example.demo.service.imp;

import com.example.demo.dto.CaterotyDTO;

import java.util.List;

public interface CategoryServiceImp {
    List<CaterotyDTO> getCategoryHome();
    boolean addCategory(String name);
    boolean updateCategory(int id, String newName);

}
