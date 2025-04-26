package com.example.demo.service.imp;

import com.example.demo.dto.RestaurantDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceImp {

    boolean insertRestaurant(MultipartFile file,
                              String title,
                              String subtitle,
                              String description,
                              boolean is_freeship,
                              String address,
                              String open_date);

    List<RestaurantDTO> getHomePageRestaurant();
}
