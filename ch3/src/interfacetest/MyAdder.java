package interfacetest;

public class MyAdder implements Adder {
	@Override
	public int add(int x, int y) {
		return 0;
	}
	@Override
	public void print1() {
		
	}
	
	@Override
	public void print2() {
		// TODO Auto-generated method stub
		Adder.super.print2();
	}
	
//	@Override
//	public void print3() {
//		
//	}
	
	public void print3() {
		
	}
	
	/*
		public void print1();
	
		public default void print2() {	}
			> 오버라이딩 필수 X
		public static void print3() {	}
			> 오버라이딩 X , 클래스 직접 접근 후 수정
		int add(int x, int y);
	*/
}
