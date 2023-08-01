package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	@Query(value="insert into orders(customerid,restid,itemid,food_cart_id) values(?1,?2,?3,?4)",nativeQuery = true)
	void saveOrder(Integer custid, Integer restid, Integer itemid, Integer cartid);

}
