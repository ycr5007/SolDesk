package com.study.myapp;

public class TVMain {
	public static void main(String[] args) {
//		TV samsung = new SamsungTV(new SonySpeaker());
		
		TV samsung = new SamsungTV();
		
//		((SamsungTV) samsung).setSpeaker(new SonySpeaker());
		
		((SamsungTV) samsung).setSpeaker(new AppleSpeaker());
		
		samsung.powerOn();
		samsung.volumeUp();
			// NullPointerException : 객체를 초기화 하지 않은 채, 객체에 접근 ( 메소드, 변수 ... ) 하는 경우
		samsung.powerOff();
		
//		String str = null;
//		System.out.println(str);
//		System.out.println(str.toString()); Error
	}
}
