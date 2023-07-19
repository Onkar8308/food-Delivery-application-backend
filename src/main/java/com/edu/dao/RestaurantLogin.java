package com.edu.dao;

import java.util.HashSet;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;



@Entity
public class RestaurantLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restloginid;
 
	@Column(nullable = false)
	private String restloginname;
	 
	@Column(length = 10 ,  nullable = false, unique =true)
	private long restloginmobilenumber;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}" , message = "invalid Email")
	@Column(unique = true)
	private String restloginemail;
	
	
//	@Pattern(regexp = "^(?=.[A-Za-z])(?=.\\d)(?=.[@$!%#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "enter proper password")
	private String password;

	public RestaurantLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantLogin( String restloginname, long restloginmobilenumber, String restloginemail, String password) {
		super();
		this.restloginname = restloginname;
		this.restloginmobilenumber = restloginmobilenumber;
		this.restloginemail = restloginemail;
		this.password = password;
	}

	public String getRestloginname() {
		return restloginname;
	}

	public void setRestloginname(String restloginname) {
		this.restloginname = restloginname;
	}

	public long getRestloginmobilenumber() {
		return restloginmobilenumber;
	}

	public void setRestloginmobilenumber(long restloginmobilenumber) {
		this.restloginmobilenumber = restloginmobilenumber;
	}

	public String getRestloginemail() {
		return restloginemail;
	}

	public void setRestloginemail(String restloginemail) {
		this.restloginemail = restloginemail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RestaurantLogin [restloginid=" + restloginid + ", restloginname=" + restloginname
				+ ", restloginmobilenumber=" + restloginmobilenumber + ", restloginemail=" + restloginemail
				+ ", password=" + password + "]";
	}	

}