package com.food.delivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table
public class Cart {
	@Id
	
	private long cart_id;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL)
	@JoinColumn(name="order_fid", nullable=false, referencedColumnName="order_id")
	private List<Order> orders;
	@Column
	private String address;
	@Column
	private long totalCartValue;
	@Column
	private String username;
	
	
	public Cart(){
		super();
	}
	public Cart(List<Order> orders) {
		super();
		this.orders = orders;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getTotalCartValue() {
		int sum = 0;
		for(Order order:this.orders){
			sum+=order.getDish().getPrice();
		}
		setTotalCartValue(sum);
		return totalCartValue;
	}
	public void setTotalCartValue(long totalCartValue) {
		this.totalCartValue = totalCartValue;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cart [orders=");
		builder.append(orders);
		builder.append(", address=");
		builder.append(address);
		builder.append(", totalCartValue=");
		builder.append(totalCartValue);
		builder.append("]");
		return builder.toString();
	}
	
	
}
