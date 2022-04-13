package web2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class MemberDTO {
	private int id;
	private String name;
	private String addr;
	private String email;
	private int age;
}

/*
	CREATE TABLE member(
	    id NUMBER(8) CONSTRAINT member_pk PRIMARY KEY,
	    name VARCHAR2(20) NOT NULL,
	    addr VARCHAR2(50) NOT NULL,
	    email VARCHAR2(30) NOT NULL,
	    age NUMBER(3));
*/