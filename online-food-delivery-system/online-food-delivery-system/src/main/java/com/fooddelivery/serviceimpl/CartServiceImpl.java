package com.fooddelivery.serviceimpl;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.fooddelivery.entity.Cart;
import com.fooddelivery.entity.Food;
import com.fooddelivery.entity.User;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.CartRepository;
import com.fooddelivery.repository.FoodRepository;
import com.fooddelivery.repository.UserRepository;
import com.fooddelivery.services.CartService;
import com.fooddelivery.services.FoodService;



@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FoodRepository FoodRepository;
	
	@Autowired
	private FoodService foodService;

	
	@Override
	public Cart addToCart(Cart cart, long userId, long foodId, int quantity) {
		 Optional<User> findById = userRepository.findById(userId);
		 Optional<Food> findById2 = FoodRepository.findById(foodId);
		 if (findById.isPresent() && findById2.isPresent()) {
	            User user = findById.get();
	            Food food = findById2.get();
	            Cart existingCartItem  = cartRepository.findByUserAndFood(user, food);
	            if (existingCartItem != null) {
	                // If the user has an existing cart item, update it
	            	existingCartItem.setUser(existingCartItem.getUser());
	            	existingCartItem.setCartId(existingCartItem.getCartId());
	            	existingCartItem.setFood(existingCartItem.getFood());
	                existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
	                existingCartItem.setTotalPrice(existingCartItem.getTotalPrice() + (food.getPrice() * quantity));
	                return cartRepository.save(existingCartItem);
	            } else {
	                // If there's no existing cart item, create a new one
	                Cart newCartItem = new Cart();
	                newCartItem.setUser(user);
	                newCartItem.setFood(food);
	                newCartItem.setQuantity(quantity);
	                newCartItem.setTotalPrice(food.getPrice() * quantity);
	                return cartRepository.save(newCartItem);
	            }
	
	}
		return cart;
	 }


	@Override
	public List<Cart> getAllCart() {
		
		return cartRepository.findAll();
	}


	@Override
	public Cart getCartById(long cartId) {
		Cart cart = cartRepository.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("cart", "not", cartId));
		return cart;
	}


	@Override
	public Cart updateCart(Cart cart, long cartId) {
		Cart newCart = cartRepository.findById(cartId).get();
		newCart.setQuantity(cart.getQuantity());
		newCart.setTotalPrice(cart.getTotalPrice());
		newCart.setFood(cart.getFood());
		newCart.setUser(cart.getUser());
		return cartRepository.save(newCart);
		
	}


	@Override
	public void deleteCart(long cartId) {
		cartRepository.deleteById(cartId);
		
	}


	
	
}
