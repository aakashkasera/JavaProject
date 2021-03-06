package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		
		
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into customer(emailId,firstName,lastName,password) values(?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,customer.getEmailId());
			preparedStatement.setString(2,customer.getFirstName());
			preparedStatement.setString(3,customer.getLastName());
			preparedStatement.setString(4,customer.getPassword());
			
			c=preparedStatement.executeUpdate();
			if(c==1) {
				ResultSet resultSet=preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					customer.setId(resultSet.getInt(1));
				}
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
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
