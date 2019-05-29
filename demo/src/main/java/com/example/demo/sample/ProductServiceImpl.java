package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;

@Component
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	public Product findProduct() {
		return productDao.findProduct("ホッチキス");
	}

	public void setSampleDiStudyingDao(ProductDao productDao) {
		this.productDao=productDao;
	}
}
