package com.ocp.dao;

import java.util.List;

import com.ocp.model.Product;

public interface ProductDao {

	void saveProduct(Product product);

	List<Product> findAllProducts();

	Product findProductById(String id);

	void updateProduct(Product product);

	public void deleteProductById(String id ) ;

	Product findProductByCode(String productCode); 
}
