package com.food.delivery.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="T_RESTAURANT")
public class Restaurant {

	@Id
	private int rId;
	@ElementCollection
	private List<Dish> menu;
	@Column
	private long locationId;
	
	
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public List<Dish> getMenu() {
		return menu;
	}
	public void setMenu(Dish menu) {
		this.menu.add(menu);
	}
	public void setMenu(List<Dish> menu) {
		this.menu.addAll(menu);
	}
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant [rId=");
		builder.append(rId);
		builder.append(", menu=");
		builder.append(menu);
		builder.append(", locationId=");
		builder.append(locationId);
		builder.append("]");
		return builder.toString();
	}
	
	
}

