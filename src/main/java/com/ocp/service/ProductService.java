package com.ocp.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ocp.model.Product;

@WebService
public interface ProductService {
	
	@WebMethod
	void saveProduct(Product product);
	
	 @WebMethod
	List<Product> findAllProducts();
	 
	@WebMethod
	Product findProductByCode(@WebParam(name = "productCode") String productCode);

	@WebMethod
	void updateProduct(@WebParam(name = "product") Product product);
	
	@WebMethod
	public void deleteProductById(@WebParam(name = "productId") String productId)  ; 
	
	
}