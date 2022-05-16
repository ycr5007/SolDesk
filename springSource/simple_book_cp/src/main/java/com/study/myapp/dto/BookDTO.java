package com.study.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BookDTO {
	/*
		DTO 객체는, Spring 관리 X ( 필요시 생성 ) 
	*/
	
	private int code;
	private String title;
	private String writer;
	private int price;
}
