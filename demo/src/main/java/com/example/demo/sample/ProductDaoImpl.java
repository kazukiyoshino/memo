package com.example.demo.sample;

import org.springframework.stereotype.Component;

import com.example.demo.model.Product;

@Component
public class ProductDaoImpl implements ProductDao{
	public Product findProduct(String name) {
		return new Product(name,100);
	}


}
