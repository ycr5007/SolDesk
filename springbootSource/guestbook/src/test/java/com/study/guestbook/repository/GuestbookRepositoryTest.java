package com.study.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.study.guestbook.entity.Guestbook;
import com.study.guestbook.entity.QGuestbook;

@SpringBootTest
public class GuestbookRepositoryTest {
	
	@Autowired
	private GuestbookRepository repository;
	
//	@Test
//	public void insert() {
//		IntStream.rangeClosed(1, 300).forEach(i -> {
//			GuestBook guestbook = GuestBook.builder()
//											.title("Guest Title..." + i)
//											.content("Guest Content..." + i)
//											.writer("user" + (i % 10))
//											.build();
//			
//			System.out.println(repository.save(guestbook));
//		});
//	}
	
//	@Test
//	public void update() {
//		// 600 번 찾은 후 수정
//		repository.findById(600L).ifPresent(guest -> {
//			guest.setTitle("Changed Title ...");
//			guest.setContent("Changed Contetn ...");
//			repository.save(guest);
//		});
//		
//	}
	
	// Querydsl 테스트
		// 단일항목으로 검색하는 경우 ( 검색, 내용, 작성자 )
		// 혼합항목으로 검색하는 경우 ( 2 개 이상의 타입 )
		
//	@Test
//	public void searchQuery() {
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
//		
//		// Q도메인 클래스 이용
//		QGuestBook qGuestBook = QGuestBook.guestBook;
//		
//		// title 에 1 이 들어가 있는 게시물 검색
//		String keyword = "1";
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		
//		BooleanExpression expression = qGuestBook.title.contains(keyword);
//		
//		builder.and(expression);
//		
//		// 페이징
//		Page<GuestBook> result = repository.findAll(builder, pageable);
//		result.stream().forEach(guestBook -> {
//			System.out.println(guestBook);
//		});
//	}

//	@Test
//	public void searchQuery() {
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
//		
//		// Q도메인 클래스 이용
//		QGuestbook qGuestBook = QGuestbook.guestbook;
//		
//		// title 에 1 이 들어가 있는 게시물 검색 ( where gno > 0 and (title like '%1%' or content like '%1%')
//		String keyword = "1";
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		
//		BooleanExpression expressionTitle = qGuestBook.title.contains(keyword);
//		BooleanExpression expressionContent = qGuestBook.content.contains(keyword);
//		
//		BooleanExpression expAll = expressionTitle.or(expressionContent);
//		
//		builder.and(expAll);
//		
//		builder.and(qGuestBook.gno.gt(0L));
//		
//		// 페이징
//		Page<Guestbook> result = repository.findAll(builder, pageable);
//		result.stream().forEach(guestBook -> {
//			System.out.println(guestBook);
//		});
//	}
	
	
}
