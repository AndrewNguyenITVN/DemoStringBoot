package com.example.demo.service.imp;

import com.example.demo.dto.RatingRestaurantDTO;

import java.util.List;

public interface RatingRestaurantServiceImp {
    RatingRestaurantDTO addRating(RatingRestaurantDTO ratingRestaurantDTO);
    List<RatingRestaurantDTO> getRatingsForRestaurant(int resId);
}
