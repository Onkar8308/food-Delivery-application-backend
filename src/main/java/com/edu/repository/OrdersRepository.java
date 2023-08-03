package com.edu.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "insert into orders(status,customerid,restid,itemid,food_cart_id) values(?1,?2,?3,?4,?5)", nativeQuery = true)
	void saveOrder(String status,Integer custid, Integer restid, Integer itemid, Integer cartid);
	
	@Query(value = " select * from orders where restid=?1 and status='paid'",nativeQuery = true)
	List<Orders> getOrderByrestId(Integer restID);
	
	@Query(value = " select * from orders where customerid=?1",nativeQuery = true)
	List<Orders> getOrderByCustomerID(Integer id);

	@Query(value = " select * from orders where customerid=? and status='paid'",nativeQuery = true)
	List<Orders> getOrderByCustomerIdAndStatuPaid(int custId);
	
	@Query(value = " select * from orders where customerid=? and status='unpaid'",nativeQuery = true)
	List<Orders> getOrderByCustomerIdAndStatuUnpaid(int custId);

}