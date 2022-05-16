package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {
	
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원 OFF");
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 ON");
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
}
