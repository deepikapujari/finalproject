package com.fooddelivery.services;






import java.util.List;

import com.fooddelivery.entity.Category;
import com.fooddelivery.entity.Food;

public interface FoodService {

	Food addFoodItem(Food food);
	List<Food> getAllFoodItems(int pageNo, int pageSize, String sortBy, String sortDir);
	
	List<Food> getFoodByCategory(Category category,int pageNo, int pageSize, String sortBy, String sortDir);
	Food getFoodById(long foodId);
	void deleteFoodById(long foodId);
	Food updateFood(Food food, long foodId);

}
