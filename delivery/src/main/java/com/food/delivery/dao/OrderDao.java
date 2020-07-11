package com.food.delivery.dao;

import java.util.List;

import com.food.delivery.model.Cart;
import com.food.delivery.model.Dish;
import com.food.delivery.model.Order;
import com.food.delivery.model.Restaurant;



public interface OrderDao {
	
	List<Order> get(String username);
	void save(Order order);
	void delete(String username);
	
	public List<Restaurant> findRestaurants(long location);
	
	public Cart addItemToCart(List<Order> order,String username);
	
	public Cart UpdateOrdersInCart(Cart cart,Order order);
	
	public Cart getCart(String user);
	
	public boolean emptyCart(String user);
	
	public List<Dish> getMenu(int id);

}
