package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.RestaurantLogin;

import java.util.List;

@Repository
public interface RestaurantLoginRepository extends JpaRepository<RestaurantLogin, Integer> {
	
	
	@Query(value="select * from restaurant_login where restloginname=? and password=?",nativeQuery = true)
	public List<RestaurantLogin> findByRestaurantLoginnameAndRestaurantLoginpassword(String uname, String pass);
	

	@Query(value = "select * from restaurant_login where restloginemail=? and password=?",nativeQuery = true)
	public RestaurantLogin getRestaurantByEmail(String email,String password);
}