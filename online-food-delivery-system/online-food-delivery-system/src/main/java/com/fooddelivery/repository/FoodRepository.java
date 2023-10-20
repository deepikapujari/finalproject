package com.fooddelivery.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.entity.Category;
import com.fooddelivery.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

	

	List<Food> findFoodByCategory(Category cId, Pageable pageable);

	

}
