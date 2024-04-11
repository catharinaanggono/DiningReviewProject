package com.example.DiningReviewProject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.DiningReviewProject.model.Review;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long>{
    public List<Review> findByApprovalStatusTrueAndRestaurantId(Long restaurantId);
    public List<Review> findByApprovalStatusNull();
}