package com.MoneyGram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MoneyGram.model.User;
import com.MoneyGram.service.UserService;

@RestController
@RequestMapping("/user")//path
public class UserController {

	
	
	@Autowired//
	private UserService service;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {	
		return service.addUser(user);
	}
	
	@GetMapping("/all")
	public List<User> getUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping("/findBy/{userId}")
	public User getUser(@PathVariable String userId) {
		return service.getUserByUserId(userId);
	}
		
//	@GetMapping("/name/{name}")
//	public List<User> getUserByName(String name){
//		return service.getUserByName(name);
//		
//	}
	
	@PutMapping("/update")
	public User modifyUser(@RequestBody User user) {
		return service.updatUser(user);
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable String userId) {		
		return service.deleteUser(userId);
	}
}
