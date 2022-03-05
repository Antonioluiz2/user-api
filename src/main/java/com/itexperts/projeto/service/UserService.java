package com.itexperts.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itexperts.projeto.model.User;
import com.itexperts.projeto.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(User user) { 
		
		User u= new User();
		u=userRepository.save(user);
		return u;
		 		
	}
	
}
