package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartDAO {
	
	public int addProductToCart(Cart cart) throws BusinessException;
	public int deleteProductFromCart(Cart cart)throws BusinessException;
	public List<Cart> viewCart(int customerId) throws BusinessException;

}
