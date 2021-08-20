package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductServiceDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductServiceDAOImpl implements ProductServiceDAO{
	
	private static Logger log=Logger.getLogger(CustomerLoginDAOImpl.class);

	@Override
	public List<Product> getProductByName(String name) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select id,name,manufacturerName,category,price from product where name=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setManufacturerName(resultSet.getString("manufacturerName"));
				product.setCategory(resultSet.getString("category"));
				product.setPrice(resultSet.getInt("price"));
				productList.add(product);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return productList;
	}

	@Override
	public List<Product> getProductByManufacturerName(String manufacturerName) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select id,name,manufacturerName,category,price from product where manufacturerName=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,manufacturerName);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setManufacturerName(resultSet.getString("manufacturerName"));
				product.setCategory(resultSet.getString("category"));
				product.setPrice(resultSet.getInt("price"));
				productList.add(product);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return productList;
		
	}

	@Override
	public List<Product> getProductByCategory(String category) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Product> productList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select id,name,manufacturerName,category,price from product where category=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,category);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setManufacturerName(resultSet.getString("manufacturerName"));
				product.setCategory(resultSet.getString("category"));
				product.setPrice(resultSet.getInt("price"));
				productList.add(product);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return productList;
		
	}

	@Override
	public int addProduct(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProduct(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
