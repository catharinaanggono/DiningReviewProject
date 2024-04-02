package com.example.DiningReviewProject.model;

import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="REVIEW") 
public class Review {
    @Id
    @GeneratedValue
    private Long id; 

    @Column(name="RESTAURANT_ID")
    @NotNull
    private String restaurantId;

    @Column(name="USERNAME")
    @NotNull
    private String username;

    @Column(name="PEANUT_SCORE")
    private int peanutScore;
    @Column(name="EGG_SCORE")
    private int eggScore;
    @Column(name="DAIRY_SCORE")
    private int dairyScore;

    @Column(name="COMMENTARY")
    private String commentary;

    @Column(name="STATUS")
    private String status;
}