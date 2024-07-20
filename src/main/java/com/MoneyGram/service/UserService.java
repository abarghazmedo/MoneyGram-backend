package com.MoneyGram.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoneyGram.model.User;
import com.MoneyGram.repository.UserRepository;



@Service
public class UserService {
	
	
	@Autowired	
	private UserRepository repository;

	
	//CRUD create , read , update , delete

	public User addUser(User user) {	
		user.setUserId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(user);
	}
	
	public boolean authenticateUser(User user) {
	    User u = repository.findByEmail(user.getEmail());
	    if (user != null && user.getPassword().equals(u.getPassword())) {
	        return true;
	    }
	    return false;
	}

	


	public List<User> findAllUsers(){
		return repository.findAll();
	}

	public User getUserByUserId(String userId) {
		return repository.findById(userId).get();
	}


//	public List<User> getUserByName(String name){
//		return repository.getUsersByName(name);
//	}
	
	public User updatUser(User userRequest) {
		
		 User existingUser =repository.findById(userRequest.getUserId()).get();
		 existingUser.setName(userRequest.getName());
		 existingUser.setEmail(userRequest.getEmail());
		 existingUser.setPassword(userRequest.getPassword());
		 existingUser.setGender(userRequest.getGender());
		 existingUser.setPhoneNumbre(userRequest.getPhoneNumbre());
		 existingUser.setPhoneNumbre(userRequest.getPhoneNumbre());
		 existingUser.setProfil(userRequest.getProfil());
		 return repository.save(existingUser);
	}

	public String deleteUser(String userId) {
		repository.deleteById(userId);
		return userId+"user deleted Done!";
	}

}
