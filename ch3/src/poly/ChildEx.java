package poly;

public class ChildEx {
	public static void main(String[] args) {
		Child child = new Child();
		
		child.method1();
		child.method2();
		child.method3();
		
		System.out.println();
		
		Parent parent = new Child();
		parent.method1();
		parent.method2();
		
		/*
			parent-method1()
			child-method2() >> 오버라이딩 된 메소드 호출
		*/
		
//		Child c = (Child) new Parent(); // Type mismatch: cannot convert from Parent to Child
//		c.method1(); // java.lang.ClassCastException
		
		
//		Parent parent = new Child2();
	}
}
