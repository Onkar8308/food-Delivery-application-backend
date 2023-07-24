package com.edu.repository;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.dao.FoodCart;

public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{

	
	@Query(value = "select * from food_cart where  cust_id =?",nativeQuery = true)
	FoodCart getCartByCustomerId(int custId); 
	
	

}
