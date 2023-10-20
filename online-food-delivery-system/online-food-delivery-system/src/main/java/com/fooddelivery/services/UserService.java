package com.fooddelivery.services;

import com.fooddelivery.entity.User;

public interface UserService {
	User register(User user);
	User authenticate(User user);
   
}
