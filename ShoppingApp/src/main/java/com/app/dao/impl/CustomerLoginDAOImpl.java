package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerLoginDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerLoginDAOImpl implements CustomerLoginDAO{

	private static Logger log=Logger.getLogger(CustomerLoginDAOImpl.class);
	@Override
	public boolean isValidEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		boolean b=false;
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select emailId from customer where emailId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,emailId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) b= true;
			else {
				throw new BusinessException("Customer email id"+emailId+"does not exist");
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
		
			String sql="select password from customer where password=?";
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
	public Customer getCustomerByEmailId(String emailId) throws BusinessException {
		// TODO Auto-generated method stub
		Customer customer=null;
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select id,firstName,LastName from customer where emailId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,emailId);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				customer=new Customer();
				customer.setEmailId(emailId);
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
			}else {
				throw new BusinessException("Customer email id\"+emailId+\"does not exist");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return customer;
	}
	@Override
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
