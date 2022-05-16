package com.study.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.service.PersonService;

public class PersonApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		PersonService service = (PersonService)ctx.getBean("person");
//		System.out.println(service.insertPerson("kang456", "강민섭") ? "Success Insert" : "Fail Insert");
		
//		System.out.println(service.updatePerson("kang456", "강호동") ? "Success Update" : "Fail Update");
		
//		System.out.println(service.deletePerson("kang456") ? "Success Delete" : "Fail Delete");
		
		System.out.println(service.selectPerson("kang456"));
	}
}
