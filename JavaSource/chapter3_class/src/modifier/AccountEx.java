package modifier;

import classtest.Account;

/*
	import 	: 다른 패키지에 있는 클래스를 사용할 때 필요
			: 자바에서 제공하는 package 중 java.lang 패키지는 import 구문 없이 사용 가능
			: Package가 다를 경우 import를 입력하지만, 같은 패키지의 경우 생략하여 사용 가능
*/

public class AccountEx {
	public static void main(String[] args) {
		// classtest 패키지의 Account 클래스
		Account account = new Account(null, null, 0);
		// 같은 패키지의 House 클래스
		House house = new House();
	}
}
