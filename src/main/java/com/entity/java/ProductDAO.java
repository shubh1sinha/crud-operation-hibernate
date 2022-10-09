package com.entity.java;

import java.util.List;
/**
 * 
 * @author shusinha5
 *
 */
public interface ProductDAO {
	public Product findProduct(int productId) throws ProductNotFoundException;
	public String addProduct(Product p) throws ProductExistsException;
	public List<Product> listAllProducts();

}
