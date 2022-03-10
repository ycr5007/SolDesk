package extend;

public class CaptionTVEx2 {
	public static void main(String[] args) {
		CaptionTV2 ctv = new CaptionTV2("black", true, 7, true);
		/*
			① CaptionTV2 의 생성자 접근
			② super(); 에서 TV2 클래스의 생성자에 접근
			③ TV2 생성자 및 CaptionTV2 에 인자값 전달
			④ CaptionTVEx2 에서 ctv 객체 생성
		*/
		
		
//		ctv.channel = 10;
		ctv.setChannel(10);
		ctv.channelUp();
//		System.out.println("현재 채널은 : " + ctv.channel);
		System.out.println("현재 채널은 : " + ctv.getChannel());
		ctv.display("Hello World");
		ctv.caption = true;
		ctv.display("Hello World");
	}
}
