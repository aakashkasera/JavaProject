package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {
	
	public int createCustomer(Customer customer) throws BusinessException;
	public Customer getCustomerByEmailId(String emailId) throws BusinessException;
	public List<Customer> getCustomerByFirstName(String firstName) throws BusinessException;
	public List<Customer> getCustomerByLastName(String lastName) throws BusinessException;
	public Customer getCustomerById(int id) throws BusinessException;

}
