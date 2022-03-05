package com.itexperts.projeto.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itexperts.projeto.model.User;
import com.itexperts.projeto.repository.UserRepository;

import java.util.List;
import java.util.Optional;
//import antlr.collections.List;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User create(User user) { 
		//return userRepository.save(user);
		User u= new User();
		u=userRepository.save(user);
		return u;
		 		
	}
	public void update(User user, Long id) { 
		Optional<User>userReturned= userRepository.findById(id);
		userReturned.orElseThrow(()-> new RuntimeException("User Not Found"));
		userReturned.get().setLastName(user.getName());
		userReturned.get().setLastName(user.getLastName());
		userRepository.save(userReturned.get());
		 		
	}
	
	@Transactional(readOnly = true)
	public User getById(Long id) {
		Optional<User> userReturned = userRepository.findById(id);
		userReturned.orElseThrow(() -> new RuntimeException("User not Found"));
		
		return userReturned.get();		
	}
	
	@Transactional(readOnly = true)
	public List<User> getAll(){		
		List<User> users = userRepository.findAll();		
		return users;
	}	
	
	@Transactional(readOnly = true)
	public Page<User> getAll(Pageable pageable){		
		Page<User> users = userRepository.findAll(pageable);		
		return users;
	}
	
}
