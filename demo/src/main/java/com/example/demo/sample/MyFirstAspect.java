package com.example.demo.sample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyFirstAspect {
	@Before("execution(* com.example.demo.sample.ProductDao.findProduct(String))")
	public void before(JoinPoint jp) {
		Signature sig=jp.getSignature();
		System.out.println("Before! Aspect="+sig);
	}

	@After("execution(* com.example.demo.sample.SampleController.sample())")
	public void after(JoinPoint jp) {
	Signature sig=jp.getSignature();
	System.out.println("After! Aspect="+sig);

	}

//	@Before("execution(* com.example..*.*(..))")
//	public void before2(JoinPoint jp) {
//		Signature sig=jp.getSignature();
//		System.out.println("Before! Aspect="+sig);
//	}
}
