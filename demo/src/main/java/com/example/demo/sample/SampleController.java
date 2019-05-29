package com.example.demo.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Product;

@Controller("/")
public class SampleController {

//	@Autowired
//	ProductService productService;

	@RequestMapping("/sample")
	@ResponseBody
	public String sample() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService productService = ctx.getBean(ProductService.class);
		Product product = productService.findProduct();
		return product.getName();
	}
}
