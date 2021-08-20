package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductServiceDAO {
	
	public List<Product> getProductByName(String name) throws BusinessException;
	public List<Product> getProductByManufacturerName(String manufacturerName) throws BusinessException;
	public List<Product> getProductByCategory(String category) throws BusinessException;
	public int addProduct(Product product) throws BusinessException;
	public int deleteProduct(int id) throws BusinessException;
	public int updateProduct(int id) throws BusinessException;

}
