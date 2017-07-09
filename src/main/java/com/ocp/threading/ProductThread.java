package com.ocp.threading;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ocp.dao.ProductDao;
import com.ocp.model.Product;

@Component
@Scope("prototype")
public class ProductThread extends Thread{
	
	@Autowired
	ProductDao  productDao  ; 

	@Override
	public void run() {

		long threadId = Thread.currentThread().getId();

		System.out.println("thread id -> " + threadId);
		Product p = productDao.findProductById("4");
		System.out.println("product -> " + p + "thread id -> " + threadId);
//		
//		p.setProductCatg("CA " + threadId);
//		productDao.updateProduct(p);
	}
	

}
