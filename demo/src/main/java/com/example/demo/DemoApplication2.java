package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Product;
import com.example.demo.sample.ProductService;
import com.example.demo.service.TestService;


public class DemoApplication2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = ctx.getBean(ProductService.class);
		Product product = productService.findProduct();
		System.out.println(product);
		TestService testService = ctx.getBean(TestService.class);



	}
	public void execute() {

	}

}
