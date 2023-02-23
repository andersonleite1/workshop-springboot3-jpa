package com.anderson.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.project.entities.Order;
import com.anderson.project.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository OrderRepository;
	
	public List<Order> findAll() {
		return OrderRepository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> OrderObject = OrderRepository.findById(id);
		return OrderObject.get();
	}
}
