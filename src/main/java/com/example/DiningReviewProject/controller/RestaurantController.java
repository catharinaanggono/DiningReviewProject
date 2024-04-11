package com.example.DiningReviewProject.controller;

import java.lang.Iterable;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.DiningReviewProject.model.Restaurant;
import com.example.DiningReviewProject.repository.RestaurantRepository;

@RequestMapping("/restaurant")
@RestController

public class RestaurantController{
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(final RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") Long restaurantId){
        Optional<Restaurant> optionalExistingRestaurant = this.restaurantRepository.findById(restaurantId);
        Restaurant existingRestaurant = optionalExistingRestaurant.get();

        if(!optionalExistingRestaurant.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return existingRestaurant;
    }

    @GetMapping("/zipcode/{zipcode}")
    public Restaurant getRestaurantByZipcode(@PathVariable("zipcode") Integer zipcode){
        // Optional<Restaurant> optionalExistingRestaurant = this.restaurantRepository.findRestaurantsByZipcode(zipcode);
        Optional<Restaurant> optionalExistingRestaurant = this.restaurantRepository.findRestaurantsByZipcodeAndOverallRatingNotNullOrderByOverallRatingDesc(zipcode);

        Restaurant existingRestaurant = optionalExistingRestaurant.get();

        if(!optionalExistingRestaurant.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return existingRestaurant;
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurantBody){
        validateName(restaurantBody);
        validateZipcode(restaurantBody);

        Restaurant newRestaurant = this.restaurantRepository.save(restaurantBody);
        return newRestaurant;
    }

    public void validateName(Restaurant restaurantBody){
        if(restaurantBody.getName() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Optional<Restaurant> optionalExistingRestaurant = this.restaurantRepository.findRestaurantsByName(restaurantBody.getName());

        if(optionalExistingRestaurant.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        
    }

    public void validateZipcode(Restaurant restaurantBody){
        if(restaurantBody.getZipcode() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Optional<Restaurant> optionalExistingRestaurant = this.restaurantRepository.findRestaurantsByZipcode(restaurantBody.getZipcode());

        if(optionalExistingRestaurant.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        
    }
}