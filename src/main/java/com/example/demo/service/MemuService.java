package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.imp.FileServiceImp;
import com.example.demo.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class MemuService implements MenuServiceImp {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public boolean insertMenu(MultipartFile file, String title, String time_ship, Double price, int cate_id) {
        boolean isInsertSuccess = false;
        try{
            boolean isSave = fileServiceImp.savefile(file);
            if(isSave){
                Food food = new Food();
                food.setTitle(title);
                food.setPrice(price);
                food.setTimeShip(time_ship);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(time_ship);
                Category catetory = new Category();
                catetory.setId(cate_id);
                food.setCateId(catetory);
                foodRepository.save(food);
                isInsertSuccess = true;
            }
        }catch(Exception e){
            System.out.println("Loi crate menu " + e.getMessage());
        }
        return isInsertSuccess;
    }
}
