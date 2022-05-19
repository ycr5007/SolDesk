package com.study.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
	DataBase Entity ( 테이블 )
		데이터베이스 상에서 데이터로 관리하는 대상
		상품, 회사, 직원 등과 같이 명사이면서 업무와 관련된 데이터
*/

@Builder // 
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "memotbl")
@SequenceGenerator(name = "mem_seq_gen", sequenceName = "mem_seq", allocationSize = 1)
@Entity // 클래스가 Entity 임을 명시 ( Entity Manager 에서 관리 )
public class Memo {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_seq_gen")
	@Id
	private Long mno;
	
	@Column(length = 200, nullable = false)
	private String memoText;
}


/*
	@Entity
		@Entity 가 붙은 클래스는 primary key 에 해당하는 특정 필드를 @Id 로 지정해야만 한다.
	
	@Table(name = "") 
		@Entity 와 같이 사용, Entity 클래스를 어떤 테이블로 생성할 것인가
						
	@Id
		PK 지정
	@GeneratedValue(strategy = , generator = "")
		PK 를 어떤 방식으로 삽입할 것인지
		- GenerationType.SEQUENCE		: 오라클 SEQUENCE ( @SequenceGenerator 과 함께 사용 ) 	
		- GenerationType.IDENTITY		: 사용하는 데이터베이스가 Key 생성을 결정 (MySQL, Maria)
		- GenerationType.AUTO(default)	: 특정 데이터베이스 (MySQL, MariaDB) 에 맞게 자동으로 생성됨
		- GenerationType.TABLE			: Key 생성 전용 테이블 사용, @TableGenerator 와 함께 사용
		
		generator : @SequenceGenerator 에서 생성한 name 값을 넣어준다.
		
	@SequenceGenerator(name = "", sequenceName = "", allocationSize = var)
		- name : Sequence Generator Name
		- sequenceName : Sequence Name
		- allocationSize : Increment Size
*/
