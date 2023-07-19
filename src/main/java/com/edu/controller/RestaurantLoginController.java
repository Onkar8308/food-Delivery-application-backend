package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.RestaurantLogin;
import com.edu.error.GlobalException;
import com.edu.service.RestaurantLoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestaurantLoginController {
	
	@Autowired
	private RestaurantLoginService restaurantLoginService;
	
	//http://localhost:9999/saveRestaurant
	@PostMapping("/saveRestaurantRegistration")
	public ResponseEntity<RestaurantLogin> saveRestaurantRegistration(@Valid @RequestBody RestaurantLogin reataurantLogin) {
		
		RestaurantLogin res = restaurantLoginService.saveRestaurantRegistration(reataurantLogin);
		return new ResponseEntity<RestaurantLogin>(res,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllRestaurantRegistration")
	public List<RestaurantLogin> getAllRestaurantRegistration()throws GlobalException {
		return restaurantLoginService.getAllRestaurantRegistration();
	}
	
	@DeleteMapping("/deleteRestaurantResgistrationById/{restid}")
	String deleteRestaurantById(@PathVariable("restid") Integer restloginid) throws GlobalException {
		restaurantLoginService.deleteRestaurantResgistrationById(restloginid);
		return "Restaurant deleted";
	}
	
	@PutMapping("/updateRestaurantRegistrationById/{restid}")
	RestaurantLogin updateRestaurantRegistrationById(@PathVariable("restid") Integer restloginid ,@Valid @RequestBody RestaurantLogin reataurantLogin){
		return restaurantLoginService.updateRestaurantRegistrationById(restloginid,reataurantLogin);
	}
	
	//login
	//http://localhost:8990/findByRestaurantLoginnameAndRestaurantLoginpassword/{cname}/{cpass}
	@GetMapping("/findByRestaurantLoginnameAndRestaurantLoginpassword/{rname}/{rpass}")
	List<RestaurantLogin> findByRestaurantLoginnameAndRestaurantLoginpassword(@PathVariable("rname") String rname, @PathVariable("rpass") String rpass){
		return restaurantLoginService.findByRestaurantLoginnameAndRestaurantLoginpassword(rname,rpass);
	}
	
	//sign in get by email
	@GetMapping("/getRestaurantByEmail/{email}/{password}")
	public RestaurantLogin getRestaurantByEmail(@PathVariable("email") String email,@PathVariable("password") String password) {
		return restaurantLoginService.getRestaurantByEmail(email,password);
	}

}