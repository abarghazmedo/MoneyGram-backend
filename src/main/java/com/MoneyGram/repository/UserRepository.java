package com.MoneyGram.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.MoneyGram.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query("{ name: ?0 }")//get by query
	List<User> getUsersByName(String name);
//	User findByUsername(String username);
	User findByEmail(String email);
}
