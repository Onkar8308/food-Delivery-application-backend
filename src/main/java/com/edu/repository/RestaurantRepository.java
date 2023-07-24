
package com.edu.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

//	Restaurant findByrestaurantName(String restname);
	
//	@Query("SELECT r.restname FROM restaurant as r WHERE r.restname LIKE %?1%")
//	public List<Restaurant> search(String keyword);
//	
//	
//	@Query("SELECT r FROM restaurant r WHERE CONCAT(r.restname) LIKE %?1%")
//	public List<Restaurant> searchByRestaurantName(String keyword);


	public List<Restaurant> findByRestnameContainingIgnoreCase(String key1);

	public List<Restaurant> findAll();
	
	@Query(value="select * from restaurant where restname=? and password=?",nativeQuery = true)
	public List<Restaurant> findByRestaurantnameAndRestaurantpassword(String uname, String pass);
	

	@Query(value = "select * from restaurant where email=? and password=?",nativeQuery = true)
	public Restaurant getRestaurantByEmail(String email,String password);
	
}





