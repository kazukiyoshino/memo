package com.example.demo.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestCode {
	@Autowired
	ProductService productService;

	@Test
	public void Test() {

		Product product = productService.findProduct();
		assertEquals(new Product("ホッチキス",100),product);
	}


}
