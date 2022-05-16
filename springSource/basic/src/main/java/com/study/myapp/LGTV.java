package com.study.myapp;

public class LGTV implements TV {
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
		System.out.println("LGTV 소리 UP");
	}
	@Override
	public void volumeUp() {
		System.out.println("LGTV 소리 DOWN");
	}
}
