package com.cognizant.truyum.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name="menu_item")
public class MenuItem {
	@Id
	@Column(name="me_id")
	private long id;
	@Column(name="me_name")
	private String name;
	@Column(name="me_price")
	private float price;
	@Column(name="me_active")
	private boolean active;
	@Column(name="me_date_of_launch")
	private Date dateOfLaunch;
	@Column(name="me_category")
	private String category;
	@Column(name="me_free_delivery")
	private boolean freeDelivery;
	
//	public MenuItem() {
//		super();
//	}
//	public MenuItem(long id, String name, float price, boolean active, Date dateOfLaunch, String category,
//			boolean freeDelivery) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.active = active;
//		this.dateOfLaunch = dateOfLaunch;
//		this.category = category;
//		this.freeDelivery = freeDelivery;
//	}
	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public float getPrice() {
//		return price;
//	}
//	public void setPrice(float price) {
//		this.price = price;
//	}
//	public boolean isActive() {
//		return active;
//	}
//	public void setActive(boolean active) {
//		this.active = active;
//	}
//	public Date getDateOfLaunch() {
//		return dateOfLaunch;
//	}
//	public void setDateOfLaunch(Date dateOfLaunch) {
//		this.dateOfLaunch = dateOfLaunch;
//	}
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public boolean isFreeDelivery() {
//		return freeDelivery;
//	}
//	public void setFreeDelivery(boolean freeDelivery) {
//		this.freeDelivery = freeDelivery;
//	}
	
	
	
}
