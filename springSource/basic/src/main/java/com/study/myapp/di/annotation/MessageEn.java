package com.study.myapp.di.annotation;

public class MessageEn implements Message {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello, Mr." + name + " !!");
	}
}
