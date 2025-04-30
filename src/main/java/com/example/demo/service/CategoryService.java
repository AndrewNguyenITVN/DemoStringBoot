package com.example.demo.service;

import com.example.demo.dto.CaterotyDTO;
import com.example.demo.dto.FoodDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Food;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CaterotyDTO> getCategoryHome() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));

        Page<Category> listCategory = categoryRepository.findAll(pageRequest);

        List<CaterotyDTO> listCategoryDTO = new ArrayList<>();

        for(Category data :listCategory){
            CaterotyDTO caterotyDTO = new CaterotyDTO();
            caterotyDTO.setName(data.getNameCate());

            List<FoodDTO> listFoodDTO = new ArrayList<>();

            for(Food dataFood: data.getListFood()){
                FoodDTO foodDTO = new FoodDTO();
                foodDTO.setImage(dataFood.getImage());
                foodDTO.setTitle(dataFood.getTitle());
                foodDTO.setTimeShip(dataFood.getTimeShip());

                listFoodDTO.add(foodDTO);

            }


            caterotyDTO.setMenus(listFoodDTO);
            listCategoryDTO.add(caterotyDTO);
        }


        return listCategoryDTO;
    }
}
