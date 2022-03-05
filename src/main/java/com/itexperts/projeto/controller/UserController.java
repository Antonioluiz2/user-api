package com.itexperts.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itexperts.projeto.model.User;
import com.itexperts.projeto.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		User u=new User();
		u= userService.create(user);
		return ResponseEntity.ok().body(u);
	}
}
