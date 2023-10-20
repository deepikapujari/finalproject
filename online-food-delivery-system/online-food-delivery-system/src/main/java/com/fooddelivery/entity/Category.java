package com.fooddelivery.entity;

import java.util.HashMap;
import java.util.Map;

public enum Category {
	    BIRYANI(0),
	    PIZZA(1),
	    NORTH_INDIAN(2),
	    CHINESE(3),
	    SOUTH_INDIAN(4),
	    SWEETS(5),
	    BEVERAGES(6),
	    THALI(7),
	    CHICKEN(8);
	
	private int value;
	
	private static Map<Integer, Category> map = new HashMap<>();
	
	private Category(int value) {
		this.value=value;
	}

	public int getValue() {
		return value;
	}

	static {
		for(Category category:Category.values()) {
			map.put(category.value, category);
		}
	}
	
	 public static Category valueOf(int category) {
	        return (Category) map.get(category);
	    }
	
	
	    
}
