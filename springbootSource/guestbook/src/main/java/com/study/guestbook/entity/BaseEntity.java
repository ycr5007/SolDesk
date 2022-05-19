package com.study.guestbook.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/*
	Entity 작업 시 데이터의 등록 시간과 수정 시간을 자동으로 추가시키고 변경되어야 하는 Column 존재
		시간 입력 : 등록, 수정시간 ( 프로그램 내에서 처리하는 것보다 자동으로 처리되도록 설정 )
		
	@MappedSuperclass : 테이블로 생성하지 말것 명시
	
	@CreateDate : Entity 의 생성 시간
	@LasModifiedDate : Entity 의 최종 수정 시간
		=> Entity 변화가 생기면 자동으로 처리 ( Column 에 updatable 을 false 로 설정하여 변경 시 자동 처리 X )
		
	@EntityListeners(AuditingEntityListener.class) : Entity Manager가 관리하는 Persistence Context 변화를 감지하는 Listener
*/

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseEntity {
	
	@Column(name = "regdate", updatable = false)
	@CreatedDate
	private LocalDateTime regdate;
	
	@Column(name = "updatedate")
	@LastModifiedDate
	private LocalDateTime updatedate;
}
