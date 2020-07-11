package com.food.delivery.model;


import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;



@Embeddable
public  class Dish {

	
	private int id;
	
	private String name;
	
	private int price;
	
	private int restaurantId;
	
	
	
	
	public Dish(int id, int restaurantId) {
		super();
		this.id = id;
		this.restaurantId = restaurantId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
