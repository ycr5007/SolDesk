package condition;

// 8 ~ 11사이의 정수

public class SwitchEx2 {
	public static void main(String[] args) {
		int time = (int)(Math.random() * 4) + 8;
		
		System.out.println("[현재시간 : " + time + " 시]");
		
		System.out.println("===== 해야할 일 =====");
		switch(time) {
			case 8 :
				System.out.println("출근하기");
			case 9 :
				System.out.println("회의하기");
			case 10 :
				System.out.println("업무하기");
			default :
				System.out.println("외근하기");
				break;
		}
	}
}
