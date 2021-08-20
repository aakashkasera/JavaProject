package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Employee;

public interface EmployeeLoginDAO {
	
	public boolean isValidEmailId(String emailId) throws BusinessException;
	public boolean isValidPassword(String password) throws BusinessException;
	public Employee getEmployeeByEmailId(String emailId) throws BusinessException;

}
