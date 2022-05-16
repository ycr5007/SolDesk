package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {
	
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	
	@Override
	public void powerOff() {
		System.out.println("LGTV 전원 OFF");
	}
	@Override
	public void powerOn() {
		System.out.println("LGTV 전원 ON");
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
