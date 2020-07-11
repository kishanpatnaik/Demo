package com.food.delivery.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Order")
public class Order {
	
	@Id
	@Column(name="order_id")
	private int id;
	@Column
	private int restaurentId;
	
	@ManyToOne
    private Cart cart;
	@Column
	private Dish dish;
	
	
	public Order(Dish food, int rid) {
		super();
		this.dish = food;
		this.restaurentId = rid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	
	

}
