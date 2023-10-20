package com.fooddelivery.serviceimpl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.entity.User;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.UserRepository;
import com.fooddelivery.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private UserRepository userRepository;

   

    @Override
    public User register(User user) {
    	System.out.println("user registred successfuly"+user);
        return userRepository.save(user);
    }



	@Override
	public User authenticate(User user) {
		return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword())
		.orElseThrow(()->new ResourceNotFoundException("User ", "Id ",user.getEmail()+"and password "+user.getPassword()));
		
	}



  
	

   
	
}


