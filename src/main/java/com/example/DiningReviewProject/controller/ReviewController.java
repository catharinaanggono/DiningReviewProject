package com.example.DiningReviewProject.controller;

import java.lang.Iterable;
import java.util.Optional;
import java.text.DecimalFormat;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.DiningReviewProject.model.Review;
import com.example.DiningReviewProject.model.Restaurant;
import com.example.DiningReviewProject.repository.ReviewRepository;
import com.example.DiningReviewProject.repository.RestaurantRepository;

@RequestMapping("/review")
@RestController
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewController(final ReviewRepository reviewRepository, RestaurantRepository restaurantRepository){
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/{restaurantId}")
    public Iterable<Review> getApprovedReviews(@PathVariable("restaurantId") Long restaurantId){
        return this.reviewRepository.findByApprovalStatusTrueAndRestaurantId(restaurantId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review){
        if(review.getPeanutScore() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(review.getEggScore() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(review.getDairyScore() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Review newReview = this.reviewRepository.save(review);

        return newReview;
    }

    @GetMapping("/admin/pending")
    public Iterable<Review> getPendingReviews(){
        return this.reviewRepository.findByApprovalStatusNull();
    }

    @PutMapping("/admin/{reviewId}")
    public Review updateReviewApprovalStatus(@PathVariable("reviewId") Long reviewId){
        Optional<Review> optionalReviewToUpdate = this.reviewRepository.findById(reviewId);
        Review reviewToUpdate = optionalReviewToUpdate.get();

        if(!optionalReviewToUpdate.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        reviewToUpdate.setApprovalStatus(true);

        Review updatedReview = this.reviewRepository.save(reviewToUpdate);

        updateRestaurantScore(updatedReview.getRestaurantId());

        return updatedReview;
    }

    public void updateRestaurantScore(Long restaurantId){
        Iterable<Review> reviews = this.reviewRepository.findByApprovalStatusTrueAndRestaurantId(restaurantId);
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(restaurantId);
        Restaurant restaurant = optionalRestaurant.get();

        if(!optionalRestaurant.isPresent()){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(!reviews.iterator().hasNext()){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Integer peanutTotal = 0;
        Integer eggTotal = 0;
        Integer dairyTotal = 0;
        Integer peanutCount = 0;
        Integer eggCount = 0;
        Integer dairyCount = 0;

        for (Review r : reviews){
            if(r.getPeanutScore() > 0 && r.getPeanutScore() != null){
                peanutTotal += r.getPeanutScore();
                peanutCount++;
            }
            if(r.getEggScore() > 0 && r.getEggScore() != null){
                eggTotal += r.getEggScore();
                eggCount++;
            }
            if(r.getDairyScore() > 0 && r.getDairyScore() != null){
                dairyTotal += r.getDairyScore();
                dairyCount++;
            }
        }

        Integer scoreTotal = peanutTotal + eggTotal + dairyTotal;
        Integer countTotal = peanutCount + eggCount + dairyTotal;

        // (float) is to cast one of the operands to a float to avoid incompatible types error
        Float overallScore = (float) scoreTotal / countTotal;
        // restaurant.setOverallRating(new DecimalFormat("0.00").format(overallScore));
        restaurant.setOverallRating(overallScore);

        if (peanutCount > 0){
            Float peanutScore = (float) peanutTotal / peanutCount;
            // restaurant.setPeanutScore(new DecimalFormat("0.00").format(peanutScore));
            restaurant.setPeanutScore(peanutScore);
        }

        if (eggCount > 0){
            Float eggScore = (float) eggTotal / eggCount;
            // restaurant.setEggScore(new DecimalFormat("0.00").format(eggScore));
            restaurant.setEggScore(eggScore);

        }

        if (dairyCount > 0){
            Float dairyScore = (float) dairyTotal / dairyCount;
            // restaurant.setDairyScore(new DecimalFormat("0.00").format(dairyScore));
            restaurant.setDairyScore(dairyScore);
        }

        this.restaurantRepository.save(restaurant);

    }

}
