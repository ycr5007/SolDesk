package com.study.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	boot + thymeleaf + JPA
		thymeleaf : HTML 파일에서 Model, Session 에 담긴 값을 호출할 수 있다 ( HTML + 유사 JSTL )
		JPA : DB 접근, MyBatis 와 같은 역할 ( Python 의 Jango 와 유사 )
	
		thymeleaf 플러그인 설치 要
	
		thymelaef 장점
			- JSP 와 유사하게 ${} 사용 가능
			- Model에 담긴 객체를 화면에서 JavaScript 로 처리하기 편함
			- HTML 확장자 사용
*/

@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}

}
