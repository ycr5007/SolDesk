package com.study.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.study.jpa.entity.Memo;

/*
	Spring Data JPA 는 여러 종류의 인터페이스 기능을 통해 JPA 관련 작업을 처리한다. ( CRUD, 페이징, 정렬 등을 인터페이스 메소드 호출러 처리 )
		JpaRepository 인터페이스
*/

// 테스트 클래스 안에 작성하는 메소드는 void 이고, 하나만 존재해야한다.
@SpringBootTest
public class MemoRepositoryTest {
	
	@Autowired
	private MemoRepository repository;
	
	// C ( insert : save(Entity 객체) ) : Entity Manager 가 Entity를 관리하면서 객체를 비교한 후 없으면 insert, 있으면 update 실행
	// R ( select : findById(Key 타입), getOne(Key 타입) )
	// U ( update : save(Entity 객체) )
	// D ( delete : deleteById(Key 타입), delete(Entity 객체) )
	// Paging ( findAll(Pageable 인터페이스) )
		// Pageable ( org.springframework.data.domain.Pageable ) : 페이지 처리에 필요한 정보를 전달하는 객체 
	
//	@Test
//	public void testInsert() {
//		
//		IntStream.rangeClosed(1, 100).forEach(i -> {
////			Memo memo = new Memo();
////			memo.setMemoText("Sample Data .... " + i);
//			
//			// @Build (Entity) 사용 시
//			Memo memo = Memo.builder()
//							.memoText("Sample Data .... " + i)
//							.build();
//			
//			repository.save(memo);
//		});
//		
//	}
	
//	@Test
//	public void testRead() {
//		// Optional : 반환되는 값이 있을수도, 없을수도 있음
//		Optional<Memo> result = repository.findById(90L);
//		
//		// isPresent() : return 값이 있다면 true
//		if(result.isPresent()) {
//			System.out.println(result.get());
//		}
//	}
	
//	@Test
//	public void testUpdate() {
//		// 수정 내용
//		Memo memo = Memo.builder()
//						.mno(90L)
//						.memoText("Modify Memo")
//						.build();
//		
//		System.out.println(repository.save(memo));
//	}
	
//	@Test
//	public void testDelete() {
//		repository.deleteById(90L);
//	}
	
//	@Test
//	public void testPaging() {
//		// 페이지 번호는 0번부터 시작
//		
//		// ASC 
////		Pageable pageable = PageRequest.of(0, 20);
////		Page<Memo> result = repository.findAll(pageable);
//		
//		// DESC
//		Sort sort = Sort.by("mno").descending();
//		Pageable pageable = PageRequest.of(0, 10, sort);
//		Page<Memo> result = repository.findAll(pageable);
//		
//		System.out.println(result);
//		
//		System.out.println("----------------------------------------");
//		System.out.println("총 페이지 수 >> " + result.getTotalPages());
//		System.out.println("전체 게시물 수 >> " + result.getTotalElements());
//		System.out.println("현재 페이지 번호 >> " + result.getNumber());
//		System.out.println("페이지 당 데이터 개수(amount) >> " + result.getSize());
//		System.out.println("다음 페이지 존재 여부 >> " + result.hasNext());
//		System.out.println("시작 페이지 여부 >> " + result.isFirst());
//		System.out.println("----------------------------------------");
//		
//		for(Memo memo : result.getContent()) {
//			System.out.println(memo);
//		}
//	}
	
//	@Test
//	public void testCreateQuery() {
//		List<Memo> list = repository.findByMnoBetweenOrderByMnoDesc(40L, 80L);
//		list.forEach(memo -> System.out.println(memo));
//	}
	
	@Test
	public void testCreateQuery() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		Page<Memo> result = repository.findByMnoBetween(40L, 80L, pageable);
		result.getContent().forEach(memo -> System.out.println(memo));
	}
}
