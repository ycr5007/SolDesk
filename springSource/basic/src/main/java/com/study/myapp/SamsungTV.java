package com.study.myapp;

public class SamsungTV implements TV {
	
//	private SonySpeaker speaker; // 초기화 필요 ( 생성자, setter )
	private Speaker speaker;
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}
	
	public SamsungTV() {	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

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
//		System.out.println("SamsungTV 소리 DOWN");
		speaker.volumeDown();
	}
	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV 소리 UP");
		speaker.volumeUp();
	}
}
