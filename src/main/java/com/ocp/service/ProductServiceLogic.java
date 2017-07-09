package com.ocp.service;

import java.util.List;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ocp.dao.ProductDao;
import com.ocp.model.Product;

@WebService(endpointInterface = "com.ocp.service.ProductService", serviceName = "productService")
@Service("productServiceLogic")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductServiceLogic implements ProductService {
	Logger logger = LoggerFactory.getLogger(ProductServiceLogic.class);

	@Autowired
	ProductDao productDao;

	@Override
	public void saveProduct(Product product) {
		
		logger.info("creating Product : " + product.toString());
		productDao.saveProduct(product);
		logger.info("created Product : " + product.toString());

	}

	@Override
	public List<Product> findAllProducts() {

		logger.info("Getting all products : ");
		return productDao.findAllProducts();
		
	}

	@Override
	public Product findProductByCode(String productCode) {

		logger.info("finding product by id : " + productCode);
		return productDao.findProductByCode(productCode);
	}

	@Override

	public void updateProduct(Product product) {
		logger.info("Updating product : " + product.toString());
		productDao.updateProduct(product);
		
		logger.info("Updated product : " + product.toString());
		

	}

	@Override
	public void deleteProductById(String productId) {
		productDao.deleteProductById(productId);
		logger.info("deleted product : " + productId);

	}


}