package com.study.myapp.di;

public class LGTV implements TV {
	
	private Speaker speaker;
	
	public LGTV(Speaker speaker) {
		this.speaker = speaker;
	}
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
//		System.out.println("LGTV 소리 UP");
		speaker.volumeDown();
	}
	@Override
	public void volumeUp() {
//		System.out.println("LGTV 소리 DOWN");
		speaker.volumeUp();
	}
}
