package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Restaurant;
import com.edu.error.GlobalException;
import com.edu.service.RestaurantService;


@RestController
public class RestaurantController {

	@Autowired
	RestaurantService restaurantSerice;

	@RequestMapping(method = RequestMethod.POST, value = "/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant) {
		Restaurant addedRestaurant = restaurantSerice.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(addedRestaurant, HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllRestaurant")
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		List<Restaurant> existedRestaurant = restaurantSerice.getAllRestaurant();
		return new ResponseEntity<>(existedRestaurant, HttpStatus.FOUND);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/findByName/{name}")
	public ResponseEntity<Restaurant> findRetaurantByName(@PathVariable("name") String restaurantName) {
		Restaurant restaurant  = restaurantSerice.findRestaurantByName(restaurantName);
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.FOUND);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/findRestaurantById/{id}")
	public ResponseEntity<Restaurant> findRestaurantById(@Valid @PathVariable Integer restaurantId) {
		Restaurant restaurant = restaurantSerice.findRestaurantById(restaurantId);
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/deleteRestaurantById/{id}")
	public ResponseEntity<String> deleteRestaurantById(@PathVariable("id") Integer  restaurantId) throws GlobalException {
		String msg = restaurantSerice.deleteRestaurantById(restaurantId);
		return new ResponseEntity<String>(msg,HttpStatus.GONE);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/updateManagerName/{id}/{managerName}")
	public ResponseEntity<Restaurant> updaterestaurantManagerName(@Valid @PathVariable("id") Integer id,@Valid  @PathVariable("managerName") String managerName) throws GlobalException {
		Restaurant restaurant = restaurantSerice.updateRestaurantManagerName(id, managerName);
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.ACCEPTED);
	}

}
