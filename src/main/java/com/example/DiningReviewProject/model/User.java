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
@Table(name="USER") 
public class User {
    @Id
    @GeneratedValue
    private Long id; 

    @Column(unique=true, name="USERNAME")
    private String username;

    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="ZIPCODE")
    private int zipcode;

    @Column(name="PEANUT_ALLERGY")
    private Boolean peanutAllergy;
    @Column(name="EGG_ALLERGY")
    private Boolean eggAllergy;
    @Column(name="DAIRY_ALLERGY")
    private Boolean dairyAllergy;
}