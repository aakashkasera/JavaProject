package com.app.customer.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.customer.service.CustomerService;
import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDAO customerDAO=new CustomerDAOImpl();

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";
		 Pattern pattern = Pattern.compile(regex); 
		 Matcher matcher = pattern.matcher(customer.getEmailId()); 
		 if(!matcher.matches())
		 {
			 
			 throw new BusinessException("Invalid email Id "+customer.getEmailId());
		 }else if(!(customer.getFirstName().length()<2 && customer.getFirstName().length()>12)){
			 throw new BusinessException("Invalid First name"+customer.getFirstName());
		 }else if(!(customer.getLastName().length()<2 && customer.getLastName().length()>12)){
			 c=customerDAO.createCustomer(customer);
		 }
		
		return c;
	}

	@Override
	public Customer getCustomerByEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerByLastName(String lastName) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
