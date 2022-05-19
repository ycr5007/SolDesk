package com.study.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.study.guestbook.entity.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>, QuerydslPredicateExecutor<Guestbook>{
	// CRUD 작업, 정렬, Pageing 메소드를 갖고 있음 ( 스프링이 자동으로 관리 )
		/*
			검색기능 => 동적 쿼리
				Querydsl 사용
					Q 도메인을 이용
					
			설정 작업
				
		*/
}
