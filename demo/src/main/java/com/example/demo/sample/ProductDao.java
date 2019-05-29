package com.example.demo.sample;

import com.example.demo.model.Product;

public interface ProductDao{
		Product findProduct(String name);
	}