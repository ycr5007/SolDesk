package com.study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	boot + JSP + MyBatis
		JSP 사용 설정
			1) spring framework 에서 사용했던 구조 이용
				main - webapp - WEB-INF - views
			2 ) InternalResourceViewResolver ( prefix / suffix ) 설정
				application.properties 설정 :: spring.mvc.view.prefix / suffix
			3 ) 라이브러리 추가 ( JSTL, Tomcat 컴파일 라이브러리 )
			
	Spring FrameWork : 초창기 모델 ( 현재 5 . X 버전까지 유지 )
		=> Java 웹 개발 EJB 가 사용 불편해서 FrameWork 개발
		
		단점
			설정 파일 多 ( servlet-context.xml / root-context.xml ... )
			>> 자바 환경설정이 생김
	Spring Boot : Spring FrameWork 의 단점 개선
		=> 자동으로 환경 설정이 되어 있음 ( 적당한 라이브러리 자동설정, XML 없는 환경 구축 가능 )
		=> 테스트 용이
		=> 내장 Tomcat 사용
		=> .jsp 가 view 기본으로 설정되어 있지 않음
	
		* 자동화된 라이브러리 관리
			Maven : Dependency , 네트워크 통해 라이브러리 import
			Gradle : 
*/

/*
	src/main/java : 자바소스 파일 위치

	src/main/resources 	- static : 정적 웹 리소스 위치 (html, css, js, img)
						- application.properties : 프로젝트 전체에서 사용할 여러가지 속성 정보 설정
	
	src - main : 동적인 웹 리소스 (jsp) 파일 위치
	build.gradle : 라이브러리 의존성 설정 및 프로젝트 전반의 환경설정
*/
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
