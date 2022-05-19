package com.study.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	com.study.book : 기본 패키지 ( @SpringBootApplication > 자동으로 Component Scan 실행 )
		
		기본 패키지를 기준으로 생성 ( 기준 패키지 하위 모든 내용을 자동으로 Component Scan )
			> @Service, @Controller 등 자동으로 인식
		
*/

@SpringBootApplication
public class BootBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBookApplication.class, args);
	}

}
