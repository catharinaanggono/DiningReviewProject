package com.example.DiningReviewProject.model;

import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
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