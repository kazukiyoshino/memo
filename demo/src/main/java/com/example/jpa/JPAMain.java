package com.example.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration
//@ImportResource("classpath:applicationContext.xml")
public class JPAMain {
	public static void main(String[] args) {

	ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "applicationContext.jpa.xml");
    GroupDao groupDao = ctx.getBean(GroupDao.class);

    List<Group> groups = groupDao.findGroupByName("foo");
    for (Group group : groups) {
        System.out.println("group id = " + group.getId());
        System.out.println("group name = " + group.getName());
        System.out.println("members:");
        for (Member member : group.getMembers()) {
            System.out.print("\tid:" + member.getId());
            System.out.print("\tname:" + member.getName());
            System.out.print("\tdetail:" + member.getDetail());
            System.out.println();
        }
    }

    Group group = new Group();
    group.setName("NEW");
    groupDao.insertGroup(group);

    groupDao.removeGroup(group);//何故かシークエンス：1→-46(postgreSQLシークエンスの最大値は2の63乗-1、降順でも-1)

}
}
