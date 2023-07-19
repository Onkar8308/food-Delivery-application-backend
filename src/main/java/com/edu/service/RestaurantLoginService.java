package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import com.edu.dao.RestaurantLogin;


public interface RestaurantLoginService {

	RestaurantLogin saveRestaurantRegistration(@Valid RestaurantLogin reataurantLogin);

	List<RestaurantLogin> getAllRestaurantRegistration();

	void deleteRestaurantResgistrationById(Integer restloginid);

	RestaurantLogin updateRestaurantRegistrationById(Integer restloginid, @Valid RestaurantLogin reataurantLogin);

	List<RestaurantLogin> findByRestaurantLoginnameAndRestaurantLoginpassword(String rname, String rpass);

	RestaurantLogin getRestaurantByEmail(String email, String password);

}
