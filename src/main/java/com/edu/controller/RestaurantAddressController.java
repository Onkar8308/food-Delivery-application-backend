package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.RestaurantAddress;
import com.edu.error.GlobalException;
import com.edu.service.RestaurantAddressService;

@RestController
public class RestaurantAddressController {

	@Autowired
	private RestaurantAddressService restaurantAddressService;
	
	// http://localhost:8990/saveRestaurantAddress
//	@PostMapping("/saveRestaurantAddress")
//	RestaurantAddress saveRestaurantAddress(@RequestBody RestaurantAddress restaurantaddress) {
//		return restaurantAddressService.saveRestaurantAddress(restaurantaddress);
//	}
	
	@PostMapping("/saveRestaurantAddress")
	public ResponseEntity<RestaurantAddress> saveRestaurantAddress(@Valid @RequestBody RestaurantAddress restaurantaddress){
		RestaurantAddress cust = restaurantAddressService.saveRestaurantAddress(restaurantaddress);
		return new ResponseEntity<RestaurantAddress>(cust, HttpStatus.CREATED);
	}
	
	//http://localhost:8990/getAllRestaurantAddress
	@GetMapping("/getAllRestaurantAddress")
	List<RestaurantAddress> getAllRestaurantAddress(){
		return restaurantAddressService.getAllRestaurantAddress();
	}
	
	//http://localhost:8990/deleteRestaurantAddressById/{addid}
	@DeleteMapping("/deleteRestaurantAddressById/{addid}")
	String deleteRestaurantAddressById(@PathVariable("addid") Integer addressid) throws GlobalException {
		restaurantAddressService.deleteRestaurantAddressById(addressid);
		return "Record Deleted";
	}
	
	//http://localhost:8990/updateRestaurantAddressById/{addid}
	@PutMapping("/updateRestaurantAddressById/{addid}")
	RestaurantAddress updateRestaurantAddressById(@PathVariable("addid") Integer addressid, @RequestBody RestaurantAddress restaurantaddress) throws GlobalException {
		return restaurantAddressService.updateRestaurantAddressById(addressid, restaurantaddress);
	}
}
