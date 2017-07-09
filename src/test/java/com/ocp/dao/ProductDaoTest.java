package com.ocp.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ocp.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate-beans.xml", "classpath:spring-beans.xml" })
public class ProductDaoTest {

	@Autowired
	ProductDao productDao;
	


	@Test
	public void saveTest() {

		for (int i = 0; i < 5; i++) {
			new Thread() {
				public void run() {

					Product p = new Product();
					p.setProductCatg("CA TESTING");
					p.setProductName("PA");
					productDao.saveProduct(p);
				}
			}.run();
		}
	}

	@Test
	public void updateTest() {

	

		ProductRunnable pth1 = new ProductRunnable();
		ProductRunnable pth2 = new ProductRunnable();

		pth1.run();
		pth2.run(); 
		

	}

	class ProductRunnable implements Runnable {
		public void run() {
			long threadId = Thread.currentThread().getId();

			System.out.println("thread id -> " + threadId);
			Product p = productDao.findProductById("4");
			System.out.println("product -> " + p + "thread id -> " + threadId);
			
			p.setProductCatg("CA " + threadId);
			productDao.updateProduct(p);
		}
	}

}
