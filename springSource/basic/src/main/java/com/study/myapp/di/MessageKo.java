package com.study.myapp.di;

public class MessageKo implements Message {
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요 ! " + name + " 님 !!");
	}
}
