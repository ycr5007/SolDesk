package classtest;

import java.util.Arrays;

/*
	TV 객체를 배열로 생성
		배열 선언 및 생성 : Type(Class)[] arrName = new Type(Class)[]
*/

public class TVEx3 {
	public static void main(String[] args) {
		
		// 배열 생성 초기 값은, 객체가 담긴 상태가 아니기 떄문에 null
		TV[] tv = new TV[5];
		System.out.println(Arrays.toString(tv));
		// [null, null, null, null, null]
		
//		System.out.println(tv[0].channel);
		// java.lang.NullPointerException > 배열로는 생성이 되었지만, 객체로는 생성이 안된 상태이기 때문에 NullPointerException 에러 발생

		
//		tv[0] = new TV();
//		tv[0].channel = 10;
//		tv[1] = new TV();
//		tv[1].channel = 11;
//		tv[2] = new TV();
//		tv[2].channel = 12;
//		tv[3] = new TV();
//		tv[3].channel = 13;
//		tv[4] = new TV();
//		tv[4].channel = 14;
		
		int length = tv.length;
		for(int i = 0; i < length; i++) {
			tv[i] = new TV();
			tv[i].channel = 10 + i;
		}
		
		System.out.println(Arrays.toString(tv));
		// [classtest.TV@5aaa6d82, classtest.TV@73a28541, classtest.TV@6f75e721, classtest.TV@69222c14, classtest.TV@606d8acf]

	}
}
