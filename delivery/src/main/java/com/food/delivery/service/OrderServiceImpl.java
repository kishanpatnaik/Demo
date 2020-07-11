package com.food.delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.food.delivery.dao.OrderDao;
import com.food.delivery.model.Cart;
import com.food.delivery.model.Dish;
import com.food.delivery.model.Order;
import com.food.delivery.model.Restaurant;

public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderdao;
	
	@Transactional
	@Override
	public List<Order> get(String username) {

		return null;
	}

	@Transactional
	@Override
	public void save(Order order) {

		
	}

	@Transactional
	@Override
	public void delete(String username) {

		
	}
	@Transactional
public List<Restaurant> findRestaurantOnLocation(long locationId){
		
		if(locationId>0){
			return orderdao.findRestaurants(locationId);
		}
		
		return null;
		
	}
	@Transactional
	public Cart orderFood( int restaurantId, int foodId, long locationId,String user ){
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(new Dish(foodId, restaurantId),restaurantId));
		return orderdao.addItemToCart(orders, user);
		 		
	}
	
	@Transactional
	public Cart modifyOrder(Cart Cart,Order orders){
		
		
		
		return null;	
	}
	@Transactional
	public boolean emptyCart(String user){
		return orderdao.emptyCart(user);
		
	}
	@Transactional
	public Cart viewCart(String user){
		return orderdao.getCart(user);
		
	}
	
	
}
