package io;

import java.io.Serializable;

public class Person implements Serializable {

	// SerialVersionUID : 직렬화한 객체를 다시 읽어올 때 (역직렬화) 사용
	
	// generate
	private static final long serialVersionUID = -2806855282281182967L;
		// > 역 직렬화 시, 직렬화 된 것과 같은 클래스인지 구별하기 위한 serial 번호
	
	// default
//	private static final long serialVersionUID = 1L;
	
	private String name;
//	private String job;
	transient String job; // 해당 필드는 직렬화 하지 않는다.
	
	public Person(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Person [name : " + name + ", job : " + job + "]"; 
	}
	
	
}
