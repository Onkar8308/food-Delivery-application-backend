package com.edu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 10,name = "restaurant_id")
	private Integer  restaurantId;
	
	@NonNull
	@NotBlank(message = "Restaurant name should not be blank")
	@NotEmpty(message = "Restaurant name should not be empty")
	@Column(length = 20,name = "restaurant_name")
	private String restaurantName;
	
	@NonNull
	@NotBlank(message = "Manager name should not be blank")
	@NotEmpty(message = "Manager name should not be empty")
	@Column(length = 20,name = "manager_name")
	private String managerName;
	
	@NonNull
	@NotBlank(message = "contact number should not be blank")
	@NotEmpty(message = "contact number should not be empty")
	@Column(name = "contact_number")
	private String contactNumber;
	
	@OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
	private List<Item> itemList = new ArrayList<>() ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_address_id",referencedColumnName ="addressid" )
	private RestaurantAddress restaurantAdd;
	
	

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Restaurant(Integer restaurantId,String restaurantName, String managerName, String contactNumber,
			List<Item> itemList, RestaurantAddress restaurantAdd) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.itemList = itemList;
		this.restaurantAdd = restaurantAdd;
	}

	
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + ", itemList=" + itemList + ", restaurantAdd="
				+ restaurantAdd + "]";
	}


	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public RestaurantAddress getRestaurantAdd() {
		return restaurantAdd;
	}

	public void setRestaurantAdd(RestaurantAddress restaurantAdd) {
		this.restaurantAdd = restaurantAdd;
	}
	
	
	
	
	
	

}
