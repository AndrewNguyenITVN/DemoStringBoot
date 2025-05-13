package com.example.demo.repository;

import com.example.demo.entity.RatingRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRestaurantRepository extends JpaRepository<RatingRestaurant, Integer> {
    List<RatingRestaurant> findByResIdId(int resId);
    List<RatingRestaurant> findByUserIdId(int userId);
}
