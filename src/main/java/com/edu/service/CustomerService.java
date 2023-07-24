package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import com.edu.dao.Customer;

public interface CustomerService {

	Customer saveCustomer(@Valid Customer customer);

	List<Customer> getAllCustomer();

	List<Customer> deleteCustomerById(Integer customerid);

	Customer updateCustomerById(Integer customerid, @Valid Customer customer);

	//List<Customer> findByCustomernameAndCustomerpassword(String cname, String cpass);

	//login
	Customer getCustomerByEmail(String email, String password);

	public Customer getCustomerById(Integer customerid);


}
