package com.example.java.project.service;

import java.util.List;

import com.example.java.project.entity.User;

public interface UserService  {

	List<User> getAllUsers();

	User saveOneUser(User newUser);

	User getOneUserById(Long userId);

	User updateOneUser(Long userId, User newUser);

	void deleteById(Long userId);

	
	
	
}
