package com.fooddelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_items")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen2")
    @SequenceGenerator(name = "gen2",initialValue = 100)
	private Long foodId;
    
    @NotEmpty(message = "food name should not be empty!")
	private String foodName;
    
    @NotEmpty(message = "please provide product description")
	private String description;
    
   
	private double price;
    
	private Category category;
    
    @NotEmpty
	private String imageUrl;

}
