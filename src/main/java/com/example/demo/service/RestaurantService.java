package com.example.demo.service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.imp.FileServiceImp;
import com.example.demo.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean is_freeship, String address, String open_date) {
        boolean isInsertSuccess = false;
        try{
            boolean isSave = fileServiceImp.savefile(file);
            if(isSave){
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setAddress(address);
                restaurant.setFreeship(is_freeship);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date openDate = simpleDateFormat.parse(open_date);

                restaurant.setOpenDate(openDate);

                restaurantRepository.save(restaurant);
                isInsertSuccess = true;

            }
        }catch(Exception e){
            System.out.println("Loi crate restaurant " + e.getMessage());
        }
        return isInsertSuccess;
    }
}
