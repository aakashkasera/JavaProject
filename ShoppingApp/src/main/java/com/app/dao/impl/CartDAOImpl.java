package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;

public class CartDAOImpl implements CartDAO{
	
	private static Logger log=Logger.getLogger(CustomerLoginDAOImpl.class);

	@Override
	public int addProductToCart(Cart cart) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="insert into cart(productId,customerId) values(?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, cart.getProductId());
			preparedStatement.setInt(2, cart.getCustomerId());

			c=preparedStatement.executeUpdate();
			
			if(c==1) {
				ResultSet resultSet=preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					cart.setId(resultSet.getInt(1));
				}
			}else {
				throw new BusinessException("Product of product id "+cart.getProductId()+" dost not exist");
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return c;
	}

	@Override
	public int deleteProductFromCart(Cart cart) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cart> viewCart(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Cart> cartList=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			
			String sql="select cart.id,customerId,cart.productId,name,manufacturerName,category,price from cart Inner Join product ON product.Id=cart.productId where cart.customerId=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,customerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				Cart cart=new Cart();
				cart.setId(resultSet.getInt("id"));
				cart.setCustomerId(resultSet.getInt("customerId"));
				cart.setProductId(resultSet.getInt("productId"));
				Product product=new Product();
				product.setName(resultSet.getString("name"));
				product.setManufacturerName(resultSet.getString("manufacturerName"));
				product.setCategory(resultSet.getString("category"));
				product.setPrice(resultSet.getInt("price"));
				cart.setProduct(product);
				cartList.add(cart);
			}
			if(cartList.size()==0) {
				throw new BusinessException("No item in cart of customer Id "+customerId);
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		
		return cartList;
	}

}
