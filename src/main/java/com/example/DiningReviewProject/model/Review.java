package com.example.DiningReviewProject.model;

import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="REVIEW") 
public class Review {
    @Id
    @GeneratedValue
    private Long id; 

    @Column(name="RESTAURANT_ID")
    @NotNull
    private Long restaurantId;

    @Column(name="USERNAME")
    @NotNull
    private String username;

    @Column(name="PEANUT_SCORE")
    private Integer peanutScore;
    @Column(name="EGG_SCORE")
    private Integer eggScore;
    @Column(name="DAIRY_SCORE")
    private Integer dairyScore;

    @Column(name="COMMENTARY")
    private String commentary;

    @Column(name="APPROVAL_STATUS", columnDefinition="boolean default false")
    private Boolean approvalStatus;

    public Long getRestaurantId(){
        return this.restaurantId;
    };

    public Integer getPeanutScore(){
        return this.peanutScore;
    };

    public Integer getEggScore(){
        return this.eggScore;
    };

    public Integer getDairyScore(){
        return this.dairyScore;
    };

    public Boolean getApprovalStatus(){
        return this.approvalStatus;
    };

    public void setApprovalStatus(Boolean newStatus){
        this.approvalStatus = newStatus;
    };
}