package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Product;
import com.example.demo.sample.ProductService;

@SpringBootApplication
@Configuration
@ImportResource({"classpath:applicationContext.xml","classpath:/META-INF/spring/beans-biz.xml"})
public class DemoApplication {

	//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		new DemoApplication().execute();

	}
	public void execute() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = ctx.getBean(ProductService.class);
		Product product = productService.findProduct();
		System.out.println(product);
	}

}
