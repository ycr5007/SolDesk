package com.study.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.entity.Memo;

// JpaRepository 를 상속받으면 자동으로 Bean 이 생성된다.
public interface MemoRepository extends JpaRepository<Memo, Long>{
	// 사용할 수 있는 기본적인 메소드들이 제공 ( CRUD, Pageing 처리 )
	
	// 새로운 메소드 생성 가능 :: 쿼리메소드 ( https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation )
	
	/*
		findBy~
		getBy~
	*/
	
	// mno 를 기준으로 BETWEEN 구문 사용 후 ORDER BY 적용 == > 여러개 행 조회
		// select * from memotbl where mno between 10 and 20 order by mno desc;
	List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
	
	Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
	
	// JPA 에서 지정해준 문법이 아닌 다른 이름으로 할 경우 함수 실행 X ( @Query 어노테이션을 통해 쿼리문 직접 입력 가능 )
//	@Query("select * from memotbl order by mno desc")
//	List<Memo> getListDesc();
//	
//	@Query("update memotbl set memoText = :memoText where mno = :mno")
//	int updateMemoText(@Param("mno") Long mno,@Param("memoText") String memoText);
//	
//	// nativeQuery SQL 처리 : 원래 SQL 구문 그대로 사용 ( Join 사용 등 )
//	@Query(value="select mno from memotbl order by mno desc", nativeQuery = true)
//	List<Memo> getNativeListDesc();
}
