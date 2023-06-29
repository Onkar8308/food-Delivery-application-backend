package com.edu.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressid;
	
	@NotEmpty(message = "Please enter area")
	@NotBlank(message = "Please enter area")
	@Column(nullable = false)
	private String area;
	
	@NotEmpty(message = "Please enter city")
	@NotBlank(message = "Please enter city")
	@Column(nullable = false)
	private String city;
	
	@NotEmpty(message = "Please enter state")
	@NotBlank(message = "Please enter state")
	@Column(nullable = false)
	private String state;
	
	@NotEmpty(message = "Please enter country")
	@NotBlank(message = "Please enter country")
	@Column(nullable = false)
	private String country;
	
//	@NotEmpty(message = "Please enter pincode")
//	@NotBlank(message = "Please enter pincode")
	@Column(length = 6, nullable = false)
	@Min(value = 6, message = "Pincode must be 6 digit")
	@Max(value = 6, message = "Pincode must be 6 digit")
	private int pincode;
	
	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerAddress(String area, String city, String state, String country, int pincode) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "CustomerAddress [addressid=" + addressid + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
}