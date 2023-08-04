package com.edu.dao;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderid;
	
	
	
	@Column
	private String status;
	
	@Column
	private String orderDate;
	
	@Column
	private Integer quantity;

	
public Integer getQuantity() {
		return quantity;
	}





	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}





	//	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="restid" , referencedColumnName="restid")
	Restaurant res;

//	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="itemid" , referencedColumnName="itemid")
	Item item;
	
//	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="customerid" , referencedColumnName="customerid")
	Customer cus;
	
//	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="foodCart_Id" , referencedColumnName="foodCart_Id")
	FoodCart foodcart;
	

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	





	public Orders(String status, String orderDate, Integer quantity, Restaurant res, Item item, Customer cus,
			FoodCart foodcart) {
		super();
		this.status = status;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.res = res;
		this.item = item;
		this.cus = cus;
		this.foodcart = foodcart;
	}





	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Restaurant getRes() {
		return res;
	}


	public void setRes(Restaurant res) {
		this.res = res;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public Customer getCus() {
		return cus;
	}


	public void setCus(Customer cus) {
		this.cus = cus;
	}


	public FoodCart getFoodcart() {
		return foodcart;
	}


	public void setFoodcart(FoodCart foodcart) {
		this.foodcart = foodcart;
	}
	
	


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}





	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", status=" + status + ", orderDate=" + orderDate + ", quantity="
				+ quantity + ", res=" + res + ", item=" + item + ", cus=" + cus + ", foodcart=" + foodcart + "]";
	}





	


		
	
}
