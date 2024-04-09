package com.example.DiningReviewProject.model;

import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  

import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
// @Component
@Getter @Setter @NoArgsConstructor
@Table(name="RESTAURANT") 
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id; 

    @Column(name="NAME")
    private String name;

    @Column(name="ADDRESS")
    private String address;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="ZIPCODE")
    private int zipcode;

    @Column(name="PHONE")
    private int phone;

    @Column(name="OVERALL_RATING")
    private int overallRating;
    @Column(name="PEANUT_SCORE")
    private int peanutScore;
    @Column(name="EGG_SCORE")
    private int eggScore;
    @Column(name="DAIRY_SCORE")
    private int dairyScore;
}