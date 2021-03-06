package com.app.cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.cart.service.CartService;
import com.app.dao.CartDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class CartServiceImpl implements CartService{
	CartDAO cartDAO=new CartDAOImpl();

	@Override
	public int addProductToCart(Cart cart) throws BusinessException {
	
		int c=0;
		if(!(cart.getProductId()>0)) {
			throw new BusinessException("Invalid Product Id "+cart.getProductId());
		}else if(!(cart.getCustomerId()>0)) {
			throw new BusinessException("Invalid Customer id "+cart.getCustomerId());
		}else {
			c=cartDAO.addProductToCart(cart);
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
		if(customerId<0) {
			throw new BusinessException("Invalid Customer Id");
		}else {
			cartList=cartDAO.viewCart(customerId);
		}
		
		return cartList;
	}

	

}
