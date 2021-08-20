package com.app.cart.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface CartService {
	
	public int addProductToCart(Cart cart) throws BusinessException;
	public int deleteProductFromCart(Cart cart)throws BusinessException;
	public List<Cart> viewCart(int customerId) throws BusinessException;

}
