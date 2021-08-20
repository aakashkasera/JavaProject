package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeLoginDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Employee;

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO{
	
	private static Logger log=Logger.getLogger(EmployeeLoginDAOImpl.class);

	@Override
	public boolean isValidEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		boolean b=false;
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select emailId from employee where emailId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,emailId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) b= true;
			else {
				throw new BusinessException("Employee email id"+emailId+"does not exist");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return b;
	}

	@Override
	public boolean isValidPassword(String password) throws BusinessException {
		// TODO Auto-generated method stub
		
		boolean b=false;
		try(Connection connection=MySqlDbConnection.getConnection()){
		
			String sql="select password from employee where password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) b= true;
			else {
				throw new BusinessException("Invalid Password");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return b;
		
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		
		Employee employee=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select id,firstName,LastName from employee where emailId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,emailId);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				employee=new Employee();
				employee.setEmailId(emailId);
				employee.setId(resultSet.getInt("id"));
				employee.setFirstName(resultSet.getString("firstName"));
				employee.setLastName(resultSet.getString("lastName"));
			}else {
				throw new BusinessException("Employee email id\"+emailId+\"does not exist");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return employee;
		
		
	}

}
