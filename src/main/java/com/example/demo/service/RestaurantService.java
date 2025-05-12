package com.example.demo.service;

import com.example.demo.dto.CaterotyDTO;
import com.example.demo.dto.FoodDTO;
import com.example.demo.dto.RestaurantDTO;
import com.example.demo.entity.Food;
import com.example.demo.entity.MenuRestaurant;
import com.example.demo.entity.RatingRestaurant;
import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.imp.FileServiceImp;
import com.example.demo.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public List<RestaurantDTO> getHomePageRestaurant() {
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 1);
        Page<Restaurant> listDate = restaurantRepository.findAll(pageRequest);

        for(Restaurant data : listDate) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubTitle(data.getSubtitle());
            restaurantDTO.setAddress(data.getAddress());
            restaurantDTO.setFreeship(data.isFreeship());
            restaurantDTO.setRating(calculatorRating(data.getListRatingRestaurant()));

            restaurantDTOS.add(restaurantDTO);
        }
        return restaurantDTOS;
    }

    @Override
    public RestaurantDTO getDetailRestaurant(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        if(restaurant.isPresent()){
            List<CaterotyDTO> caterotyDTOList = new ArrayList<>();
            Restaurant data = restaurant.get();
            restaurantDTO.setId((data.getId()));
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubTitle(data.getSubtitle());
            restaurantDTO.setAddress(data.getAddress());
            restaurantDTO.setFreeship(data.isFreeship());
            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setRating(calculatorRating(data.getListRatingRestaurant()));
            restaurantDTO.setOpenTime(data.getOpenDate());


            for(MenuRestaurant menuRestaurant :data.getListMenuRestaurant()) {
                CaterotyDTO caterotyDTO = new CaterotyDTO();
                List<FoodDTO> foodDTOList = new ArrayList<>();

                caterotyDTO.setName(menuRestaurant.getCateId().getNameCate());
                for(Food food:menuRestaurant.getCateId().getListFood()){
                    FoodDTO foodDTO = new FoodDTO();

                    foodDTO.setImage(food.getImage());
                    foodDTO.setTitle(food.getTitle());
                    foodDTO.setTimeShip(food.getTimeShip());

                    foodDTOList.add(foodDTO);
                }
                caterotyDTO.setMenus(foodDTOList);
                caterotyDTOList.add(caterotyDTO);

            }
            restaurantDTO.setCateroties(caterotyDTOList);
        }
        return  restaurantDTO;
    }


    private double calculatorRating(Set<RatingRestaurant> listRating){
        double totalPoint = 0;
        for(RatingRestaurant data : listRating){
            totalPoint += data.getRatePoint();
        }
        return totalPoint/listRating.size();
    }


    @Override
    public List<RestaurantDTO> getRestaurantByTitle(String title) {
        List<Restaurant> restaurantList = restaurantRepository.findByTitle(title);

        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        for(Restaurant data : restaurantList) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubTitle(data.getSubtitle());
            restaurantDTO.setAddress(data.getAddress());
            restaurantDTO.setFreeship(data.isFreeship());
            restaurantDTO.setRating(calculatorRating(data.getListRatingRestaurant()));

            restaurantDTOList.add(restaurantDTO);
        }
        return restaurantDTOList;
    }
}
