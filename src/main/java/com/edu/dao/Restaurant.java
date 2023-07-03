package com.edu.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
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
	
	
	

}
