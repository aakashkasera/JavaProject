package com.app.login.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.dao.*;
import com.app.dao.impl.*;
import com.app.exception.BusinessException;
import com.app.login.service.CustomerLoginService;
import com.app.model.Customer;

public class CustomerLoginServiceImpl implements CustomerLoginService{

	private CustomerLoginDAO customerLoginDAO=new CustomerLoginDAOImpl();

	
	public boolean isValidEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		
		boolean b=false;
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";
		 Pattern pattern = Pattern.compile(regex); 
		 Matcher matcher = pattern.matcher(emailId); 
		 if(!matcher.matches())
		 {
			 throw new BusinessException("Invalid email Id "+emailId);
		 }else {
			 b=customerLoginDAO.isValidEmailId(emailId);
		 }
		 return b;
		
		
	}

	
	public boolean isValidPassword(String password) throws BusinessException {
		// TODO Auto-generated method stub
		
		boolean b=false;
		
		b=customerLoginDAO.isValidPassword(password);
		
		return b;
	}


	@Override
	public Customer getCustomerByEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		
		Customer customer=null;
		String regex = "^(.+)@(.+)$";
		 Pattern pattern = Pattern.compile(regex); 
		 Matcher matcher = pattern.matcher(emailId); 
		 if(!matcher.matches())
		 {
			 throw new BusinessException("Invalid email Id "+emailId);
		 }else {
			 customer=customerLoginDAO.getCustomerByEmailId(emailId);
		 }
		 return customer;
		
		
	}


	public Customer getCustomerById(String id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> getCustomerByFirstName(String firstName) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> getCustomerByLastName(String firstName) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
