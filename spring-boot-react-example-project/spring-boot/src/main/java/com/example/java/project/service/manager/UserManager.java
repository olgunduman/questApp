package com.example.java.project.service.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.java.project.entity.User;
import com.example.java.project.repository.UserRepository;
import com.example.java.project.service.UserService;

@Service
public class UserManager implements UserService {

	private UserRepository userRepository;

	public UserManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	@Override
	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		} else 
			return null;	

	}

	@Override
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}
}
