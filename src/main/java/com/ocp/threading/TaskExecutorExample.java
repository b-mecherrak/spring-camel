package com.ocp.threading;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.ocp.model.Product;
import com.ocp.service.ProductService;
@Service
public class TaskExecutorExample {

	private class MessagePrinterTask implements Runnable {

		ProductService productService;

		public MessagePrinterTask() {

		}

		public MessagePrinterTask(ProductService productService) {
			this.productService = productService;
		}

		public void run() {
			long threadId = Thread.currentThread().getId();
	
			 Product p = productService.findProductByCode("4");
			 System.out.println("product -> " + p + "thread id -> " +
			 threadId);
			//
			// p.setProductCatg("CA " + threadId);
			// productService.updateProduct(p);
		}

	}

	@Autowired
	ProductService productService;

	@Autowired
	private TaskExecutor taskExecutor;

	public void printMessages() {
		for (int i = 0; i < 5; i++) {
			taskExecutor.execute(new MessagePrinterTask(productService));
		}
	}
}