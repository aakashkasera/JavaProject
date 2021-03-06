package com.app.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.ProductServiceDAO;
import com.app.dao.impl.ProductServiceDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.product.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	private ProductServiceDAO productServiceDAO=new ProductServiceDAOImpl();

	public List<Product> getProductByName(String name) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Product> productList=new ArrayList<>();
		if(name.length()<2 ||name.length()>12)
		{
			throw new BusinessException("Invalid Product Name");
		}else {
			productList=productServiceDAO.getProductByName(name);
		}
		
		return productList;
	}

	@Override
	public List<Product> getProductByManufacturerName(String manufacturerName) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Product> productList=new ArrayList<>();
		if(manufacturerName.length()<2 ||manufacturerName.length()>12)
		{
			throw new BusinessException("Invalid Product Manufacturer Name");
		}else {
			productList=productServiceDAO.getProductByManufacturerName(manufacturerName);
		}
		
		return productList;
		
		
	}

	@Override
	public List<Product> getProductByCategory(String category) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Product> productList=new ArrayList<>();
		if(category.length()<2 ||category.length()>12)
		{
			throw new BusinessException("Invalid Product category");
		}else {
			productList=productServiceDAO.getProductByCategory(category);
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
