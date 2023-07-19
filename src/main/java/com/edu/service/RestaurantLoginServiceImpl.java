package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.RestaurantLogin;
import com.edu.repository.RestaurantLoginRepository;

@Service
public class RestaurantLoginServiceImpl implements RestaurantLoginService {
	
	@Autowired
	private RestaurantLoginRepository restaurantLoginRepository;
	

	@Override
	public RestaurantLogin saveRestaurantRegistration(RestaurantLogin restaurantLogin) {
		// TODO Auto-generated method stub
		return restaurantLoginRepository.save(restaurantLogin);
	}

	@Override
	public List<RestaurantLogin> getAllRestaurantRegistration() {
		// TODO Auto-generated method stub
		return restaurantLoginRepository.findAll();
	}

	

	@Override
	public void deleteRestaurantResgistrationById(Integer restid) {
		// TODO Auto-generated method stub
		restaurantLoginRepository.deleteById(restid);
	}
	
	@Override
	public RestaurantLogin updateRestaurantRegistrationById(Integer restloginid, @Valid RestaurantLogin restaurantLogin) {
	    RestaurantLogin res = restaurantLoginRepository.findById(restloginid).orElse(null);
	    if (res != null) {
	        res.setRestloginname(restaurantLogin.getRestloginname());
	        res.setRestloginmobilenumber(restaurantLogin.getRestloginmobilenumber());
	        res.setRestloginemail(restaurantLogin.getRestloginemail());
	        res.setPassword(restaurantLogin.getPassword());
	        restaurantLoginRepository.save(res);
	    }
	    return res;
	}

	@Override
	public List<RestaurantLogin> findByRestaurantLoginnameAndRestaurantLoginpassword(String rname, String rpass) {
		// TODO Auto-generated method stub
		return restaurantLoginRepository.findByRestaurantLoginnameAndRestaurantLoginpassword(rname, rpass);
	}

	@Override
	public RestaurantLogin getRestaurantByEmail(String email,String password) {
		// TODO Auto-generated method stub
		return restaurantLoginRepository.getRestaurantByEmail(email,password);
	}

	



}