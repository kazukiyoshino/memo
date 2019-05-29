package com.example.demo.sample;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;

@Transactional
	public interface ProductService{
		Product findProduct();
	}
