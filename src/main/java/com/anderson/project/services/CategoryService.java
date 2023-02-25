package com.anderson.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.project.entities.Category;
import com.anderson.project.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository CategoryRepository;
	
	public List<Category> findAll() {
		return CategoryRepository.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> CategoryObject = CategoryRepository.findById(id);
		return CategoryObject.get();
	}
}
