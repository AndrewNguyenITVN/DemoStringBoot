package com.example.demo.service.imp;

import com.example.demo.dto.FoodDTO;
import com.example.demo.dto.RestaurantDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MenuServiceImp {
    boolean insertMenu(MultipartFile file,
                        String title,
                        String time_ship,
                        Double price,
                        int cate_id);
}
