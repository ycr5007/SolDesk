package com.study.myapp.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {
	public static void main(String[] args) {
		System.out.println("───────────── 컨테이너 구동 전 ─────────────");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		System.out.println("───────────── 컨테이너 구동 후 ─────────────");
		
		// NoSuchBeanDefinitionException : Bean 을 찾지 못했을 때 에러 발생	
		// NoUniqueBeanDefinitionException : Bean 검색 결과가 한 개 이상 조회되었을 때 ( @Autowired 에서 자동 주입과정에서 Error )
//		TV tv = (TV)ctx.getBean("lg");
		TV tv = (TV)ctx.getBean("samsung");
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		
	}
}
