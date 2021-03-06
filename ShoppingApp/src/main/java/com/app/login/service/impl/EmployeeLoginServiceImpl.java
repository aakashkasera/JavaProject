package com.app.login.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.dao.CustomerLoginDAO;
import com.app.dao.EmployeeLoginDAO;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.dao.impl.EmployeeLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.login.service.EmployeeLoginService;
import com.app.model.Employee;

public class EmployeeLoginServiceImpl implements EmployeeLoginService{
	
	private EmployeeLoginDAO employeeLoginDAO=new EmployeeLoginDAOImpl();

	@Override
	public boolean isValidEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		
		boolean b=false;
		String regex ="^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";
		 Pattern pattern = Pattern.compile(regex); 
		 Matcher matcher = pattern.matcher(emailId); 
		 if(!matcher.matches())
		 {
			 throw new BusinessException("Invalid email Id "+emailId);
		 }else {
			 b=employeeLoginDAO.isValidEmailId(emailId);
		 }
		 return b;
		
	}

	@Override
	public boolean isValidPassword(String password) throws BusinessException {
		// TODO Auto-generated method stub
		

		boolean b=false;
		
		b=employeeLoginDAO.isValidPassword(password);
		
		return b;
		
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		Employee employee=null;
		String regex = "^(.+)@(.+)$";
		 Pattern pattern = Pattern.compile(regex); 
		 Matcher matcher = pattern.matcher(emailId); 
		 if(!matcher.matches())
		 {
			 throw new BusinessException("Invalid email Id "+emailId);
		 }else {
			 employee=employeeLoginDAO.getEmployeeByEmailId(emailId);
		 }
		 return employee;
	}

}
