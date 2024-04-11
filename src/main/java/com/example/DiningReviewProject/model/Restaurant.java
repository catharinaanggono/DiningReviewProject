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
    private Integer zipcode;

    @Column(name="PHONE")
    private Integer phone;

    @Column(name="OVERALL_RATING", columnDefinition = "float default 0.0")
    private Float overallRating;
    @Column(name="PEANUT_SCORE", columnDefinition = "float default 0.0")
    private Float peanutScore;
    @Column(name="EGG_SCORE", columnDefinition = "float default 0.0")
    private Float eggScore;
    @Column(name="DAIRY_SCORE", columnDefinition = "float default 0.0")
    private Float dairyScore;

    public String getName(){
        return this.name;
    }

    public Integer getZipcode(){
        return this.zipcode;
    }

    public void setOverallRating(Float overallRating){
        this.overallRating = overallRating;
    }

    public void setPeanutScore(Float peanutScore){
        this.peanutScore = peanutScore;
    }

    public void setEggScore(Float eggScore){
        this.eggScore = eggScore;
    }

    public void setDairyScore(Float dairyScore){
        this.dairyScore = dairyScore;
    }
}