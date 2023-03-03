package com.anderson.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.project.entities.User;
import com.anderson.project.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> userObject = userRepository.findById(id);
		return userObject.get();
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
}
