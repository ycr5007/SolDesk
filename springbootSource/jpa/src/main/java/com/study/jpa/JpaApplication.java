package com.study.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	JPA ( Java Persistence API ) - MyBatis 대체
	
		객체지향 개념을 관계형 데이터베이스에 보존하는 기술
		
		DTO 생성 ==>	Entity 개념 적용
					테이블 생성, 데이터 삽입·삭제·수정·조회 가능
					
		property == 컬럼 Mapping
			ex ) private int bno == bno number()
		
		구현체 : Hibernate 
			↕
		Spring Data JPA ( Hibernate 와 연동해서 JPA 기술 사용 )
		
	REF URL : https://livenow14.tistory.com/70
		① Spring Data JPA
			Java Application 에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스 ( 인터페이스 이므로, 특정 기능을 하진 않음 ) 
			↕	
		② Hibernate ( ORM FrameWork )
			JPA 의 구현체로, JPA 인터페이스를 구현하며, 내부적으로 JDBC API 를 사용한다.
				* ORM( Object Relational Mapping ) 	: 객체 - 관계 매핑 ( 객체와 관계형 데이터 베이스의 데이터를 자동으로 연결해주는 것 )
				 									: 객체 ( Class ) , 관계형 DB ( TABLE )
			↕
		③ JDBC
			DB 작업을 위한 표준 : Java 프로그래밍 언어와 DB SQL 사이에서 독립적인 연결을 지원하는 표준
			↕
		④ DataBase
*/

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
