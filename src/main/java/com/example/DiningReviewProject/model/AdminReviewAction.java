package com.example.DiningReviewProject.model;

import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

@Getter @Setter @NoArgsConstructor
public class Review {
    private Boolean accept;
}