package poly;

public class Child extends Parent {
	public void method3() {
		System.out.println("child-method3()");
	}
	
	@Override
	public void method2() {
		System.out.println("child-method2()");
	}
}
