package com.example.DiningReviewProject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.DiningReviewProject.model.Restaurant;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
    Optional<Restaurant> findRestaurantsByName(String name);
    Optional<Restaurant> findRestaurantsByZipcode(Integer zipcode);
    Optional<Restaurant> findRestaurantsByZipcodeAndOverallRatingNotNullOrderByOverallRatingDesc(Integer zipcode);
}