package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

//	Restaurant findByrestaurantName(String restname);
	
	@Query(value="select * from restaurant where restname=? and password=?",nativeQuery = true)
	public List<Restaurant> findByRestaurantnameAndRestaurantpassword(String uname, String pass);
	

	@Query(value = "select * from restaurant where email=? and password=?",nativeQuery = true)
	public Restaurant getRestaurantByEmail(String email,String password);
	
}