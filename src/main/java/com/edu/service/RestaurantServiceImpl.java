package com.edu.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Restaurant;
import com.edu.error.GlobalException;
import com.edu.repository.RestaurantRepo;


@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public Restaurant addRestaurant(@Valid Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepo.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return restaurantRepo.findAll();
	}

	@Override
	public Restaurant findRestaurantByName(String restaurantName) {
		// TODO Auto-generated method stub
		return restaurantRepo.findByrestaurantName(restaurantName);

	}

	@Override
	public Restaurant findRestaurantById(@Valid Integer restaurantId) {
		// TODO Auto-generated method stub
		return restaurantRepo.findById(restaurantId).get();
	}

	@Override
	public String deleteRestaurantById(Integer restaurantId) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Restaurant> restaurant = restaurantRepo.findById(restaurantId);
		if (!restaurant.isPresent())
			throw new GlobalException("Restaurnat with id : " + restaurantId + " not exist");

		restaurantRepo.deleteById(restaurantId);
		return "restaurant with id " + restaurantId + " is deleted";

	}

	@Override
	public Restaurant updateRestaurantManagerName(Integer restaurantId, String managerName) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Restaurant> res = restaurantRepo.findById(restaurantId);
		if (!res.isPresent())
			throw new GlobalException("Restaurnat with id : " + restaurantId + " not exist");

		Restaurant restaurant = restaurantRepo.findById(restaurantId).get();
		restaurant.setManagerName(managerName);
		return restaurantRepo.save(restaurant);
		
	}

}
