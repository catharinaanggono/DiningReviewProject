package com.example.DiningReviewProject.model;

import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

// import org.springframework.stereotype.Component;
// import org.springframework.boot.autoconfigure.domain.Entity;
// @Component
// @EntityScan
@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="USERS") 
public class Users {
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
    private Integer zipcode;

    @Column(name="PEANUT_ALLERGY")
    private Boolean peanutAllergy;
    @Column(name="EGG_ALLERGY")
    private Boolean eggAllergy;
    @Column(name="DAIRY_ALLERGY")
    private Boolean dairyAllergy;

    public String getUsername(){
        return this.username;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public Integer getZipcode(){
        return this.zipcode;
    }

    public Boolean getPeanutAllergy(){
        return this.peanutAllergy;
    }

    public Boolean getEggAllergy(){
        return this.eggAllergy;
    }

    public Boolean getDairyAllergy(){
        return this.dairyAllergy;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZipcode(Integer zipcode){
        this.zipcode = zipcode;
    }

    public void setPeanutAllergy(Boolean peanutAllergy){
        this.peanutAllergy = peanutAllergy;
    }

    public void setEggAllergy(Boolean eggAllergy){
        this.eggAllergy = eggAllergy;
    }

    public void setDairyAllergy(Boolean dairyAllergy){
        this.dairyAllergy = dairyAllergy;
    }
}