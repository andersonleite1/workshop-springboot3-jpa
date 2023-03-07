package com.anderson.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.project.entities.User;
import com.anderson.project.repositories.UserRepository;
import com.anderson.project.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> userObject = userRepository.findById(id);
		return userObject.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	
	public User update(Integer id, User user) {
		User userEntity = userRepository.getReferenceById(id);
		updateData(userEntity, user);
		return userRepository.save(userEntity);
	}

	private void updateData(User userEntity, User user) {
		userEntity.setName(user.getName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPhone(user.getPhone());
	}
}
