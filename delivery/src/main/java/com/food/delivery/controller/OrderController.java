package com.food.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.food.delivery.model.Cart;
import com.food.delivery.model.Order;
import com.food.delivery.model.Restaurant;
import com.food.delivery.service.OrderServiceImpl;

public class OrderController {

	@Autowired
	OrderServiceImpl os;
	
	@RequestMapping("/findRestaurents")
	public List<Restaurant> findRestaurantOnLocation(@RequestParam("locationId") long locationId){
		
		if(locationId>0){
			os.findRestaurantOnLocation(locationId);
		}
		
		return null;
		
	}
	@RequestMapping("/order")
	public Cart orderFood(@RequestParam("restaurantId") int restaurantId, @RequestParam("foodId") int foodId,  @RequestParam("locationId") long locationId,@RequestParam("user") String userName ){
		
		if(locationId<=0|| !userName.isEmpty() || foodId<=0 || restaurantId <=0){
			return null;
		}
		return os.orderFood(restaurantId, foodId, locationId, userName);
		
	}
	@RequestMapping("/updateOrder")
	public Cart modifyOrder(@RequestParam("cartId")int CartId,@RequestParam("order")Order order, @RequestParam("user")String user){
		Cart cart = os.viewCart(user);
		return os.modifyOrder(cart, order);
		
	}
	@RequestMapping("/clearCart")
	public boolean emptyCart(@RequestParam("user")String user){
		return os.emptyCart(user);
		
	}
	@RequestMapping("/openCart")
	public Cart viewCart(@RequestParam("user")String user){
		return os.viewCart(user);
		
	}
}
