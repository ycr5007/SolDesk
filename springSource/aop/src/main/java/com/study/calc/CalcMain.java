package com.study.calc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Calc calc = (Calc)ctx.getBean("forc");
		System.out.println("10!  >>  " + calc.factorial(10));
		System.out.println();
		calc = (Calc)ctx.getBean("rec");
		System.out.println("10!  >>  " + calc.factorial(10));
	}
}
