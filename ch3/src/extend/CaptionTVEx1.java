package extend;

public class CaptionTVEx1 {
	public static void main(String[] args) {
		CaptionTV ctv = new CaptionTV();
		
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println("현재 채널은 : " + ctv.channel);
		ctv.display("Hello World");
		ctv.caption = true;
		ctv.display("Hello World");
	}
}
