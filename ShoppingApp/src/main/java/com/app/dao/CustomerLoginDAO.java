package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerLoginDAO {
	
	public boolean isValidEmailId(String emailId) throws BusinessException;
	public boolean isValidPassword(String password) throws BusinessException;
	public Customer getCustomerByEmailId(String emailId) throws BusinessException;
	public Customer getCustomerById(String id) throws BusinessException;
	public List<Customer> getCustomerByFirstName(String firstName) throws BusinessException;
	public List<Customer> getCustomerByLastName(String firstName) throws BusinessException;

}
