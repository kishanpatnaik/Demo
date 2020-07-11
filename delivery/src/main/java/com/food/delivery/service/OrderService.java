package com.food.delivery.service;

import java.util.List;

import com.food.delivery.model.Order;

public interface OrderService {

	List<Order> get(String username);
	void save(Order order);
	void delete(String username);
	
}
