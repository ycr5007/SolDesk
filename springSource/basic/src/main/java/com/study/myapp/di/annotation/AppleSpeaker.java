package com.study.myapp.di.annotation;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("AppleSpeaker 생성");
	}
	
	public void volumeUp() {
		System.out.println("AppleSpeaker 소리 Up");
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker 소리 Down");
	}
}
