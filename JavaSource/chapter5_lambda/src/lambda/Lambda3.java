package lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
	대부분의 추상 메소드는 타입이 비슷하기 때문에 자주 쓰이는 형식의 메소드를 함수형 인터페이스로 제공
		java.util.function.Supplier;
			Supplier 인터페이스 ( T get() ) 	: 매개변수 없이 값을 반환받고자 할 때 사용
		java.util.function.Consumer;
			Consumer 인터페이스 ( T accept() ) 	: 매개변수로 받아, 반환 없이 값을 사용
		java.util.function.Predicate;
			Predicate 인터페이스 ( T test() )	: 
*/

public class Lambda3 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
		System.out.println(s.get());
		
		Consumer<Integer> c = k -> System.out.println(k);
		c.accept(555);
		
		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(5));
	}
}
