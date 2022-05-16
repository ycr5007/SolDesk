package com.study.myapp.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		System.out.println("───────────── 컨테이너 구동 전 ─────────────");
		
		
		// Spring 컨테이너 구동 ( xml 파일 불러오기 )
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		System.out.println("───────────── 컨테이너 구동 후 ─────────────");
		
		// Spring 컨테이너가 관리하는 객체 중, msg 를 요청 ( bean ID 값 )
		Message msg = (Message)ctx.getBean("ko");
		msg.sayHello("홍길동");
		
	}
}
