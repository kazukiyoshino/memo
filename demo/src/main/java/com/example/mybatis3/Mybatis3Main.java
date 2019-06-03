package com.example.mybatis3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.mybatis3.dataaccess.PetDao;
import com.example.mybatis3.model.Pet;

public class Mybatis3Main {

	public static void main(String[] args) {//mapperインターフェースを利用する方法にて作成,spring連携

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.MyBatis3.xml");
        PetDao petDao = ctx.getBean(PetDao.class);

        Pet pet= petDao.findPetById(1);
        System.out.println("pet_id="+pet.getPetId()+"の…");
        System.out.println("ペット名="+pet.getPetName());
        System.out.println("オーナー名="+pet.getOwnerName());
        System.out.println("値段="+pet.getPrice());
        System.out.println("誕生日="+pet.getBirthDate());

	}

}
