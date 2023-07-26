package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer>{

	@Modifying
	@Query(value = "delete from customer_address where customerid=?",nativeQuery = true)
	public List<CustomerAddress> deleteByCustomerId(Integer custid);

}
