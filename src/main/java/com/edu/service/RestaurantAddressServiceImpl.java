package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.RestaurantAddress;
import com.edu.error.GlobalException;
import com.edu.repository.RestaurantAddressRepository;

@Service
public class RestaurantAddressServiceImpl implements RestaurantAddressService {
	
	@Autowired
	private RestaurantAddressRepository restaurantAddressRepository;

	@Override
	public RestaurantAddress saveRestaurantAddress(RestaurantAddress restaurantaddress) {
		// TODO Auto-generated method stub
		return restaurantAddressRepository.save(restaurantaddress);
	}

	@Override
	public List<RestaurantAddress> getAllRestaurantAddress() {
		// TODO Auto-generated method stub
		return restaurantAddressRepository.findAll();
	}

	@Override
	public void deleteRestaurantAddressById(Integer addressid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<RestaurantAddress> rob = restaurantAddressRepository.findById(addressid);
		if(!rob.isPresent()) {
			throw new GlobalException("Restaurant Address id=" + addressid + " does not exist");
		}
	
		restaurantAddressRepository.deleteById(addressid);
	}

	@Override
	public RestaurantAddress updateRestaurantAddressById(Integer addressid, RestaurantAddress restaurantaddress) throws GlobalException {
		// TODO Auto-generated method stub
		RestaurantAddress restaurant = null;
		Optional<RestaurantAddress> rob = restaurantAddressRepository.findById(addressid);
		if(!rob.isPresent()) {
			throw new GlobalException("Restaurant Address id=" + addressid + " does not exist");
		}
		else {
			restaurant = restaurantAddressRepository.findById(addressid).get();
			restaurant.setArea(restaurantaddress.getArea());
			restaurant.setCity(restaurantaddress.getCity());
			restaurant.setCountry(restaurantaddress.getCountry());
			restaurant.setPincode(restaurantaddress.getPincode());
			restaurant.setState(restaurantaddress.getState());
		}
		
		return restaurantAddressRepository.save(restaurant);
	}

}
