package interfacetest;

public interface Adder {
//	private int num; // Illegal modifier for the interface field Adder.num; only public, static & final are permitted
	public static final int SPADE = 1;
	int DIAMOND = 3;
	final int HEART = 2;
	static int CLOVER = 4;
	
//	public void print() {} // Abstract methods do not specify a body
	public void print1();
	
	public default void print2() {	}
	
	public static void print3() {	}
	
	int add(int x, int y);
}
