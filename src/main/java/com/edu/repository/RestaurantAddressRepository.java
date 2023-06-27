package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.RestaurantAddress;

@Repository
public interface RestaurantAddressRepository extends JpaRepository<RestaurantAddress, Integer>{

}
