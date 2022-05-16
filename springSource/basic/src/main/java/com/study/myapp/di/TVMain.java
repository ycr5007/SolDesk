package com.study.myapp.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {
	public static void main(String[] args) {
//		TV samsung = new SamsungTV();
//		
//		((SamsungTV) samsung).setSpeaker(new AppleSpeaker());
		
		System.out.println("───────────── 컨테이너 구동 전 ─────────────");
		// config.xml 을 호출함과 동시에, beans 에 있는 객체들을 모두 생성한다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		System.out.println("───────────── 컨테이너 구동 후 ─────────────");
		
		TV tv = (LGTV)ctx.getBean("LTV");
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		
	}
}
