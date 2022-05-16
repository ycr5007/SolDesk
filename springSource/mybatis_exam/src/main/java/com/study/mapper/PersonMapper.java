package com.study.mapper;

import org.apache.ibatis.annotations.Param;

import com.study.dto.PersonDTO;

public interface PersonMapper {
	
	// 바인딩 : ? 로 자리 잡은 변수를 Java 내 변수 값으로 연결
//	@Insert("insert into person(id, name) values(#{id}, #{name})")
		// #{val} , 바인딩변수 ' ? ' 내부 값을 val 로 설정 
//	public int insertPerson(@Param("id") String id, @Param("name") String name);
	
	// SQL 문이 복잡해질 경우, XML 에서 SQL 을 작성하는 방법 활용
	public int insert(@Param("id") String id, @Param("name") String name);
	public int update(@Param("id") String id, @Param("name") String name);
	public int delete(String id);
	public PersonDTO select(String id);
}
