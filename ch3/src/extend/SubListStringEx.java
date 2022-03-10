package extend;

public class SubListStringEx {
	public static void main(String[] args) {
		SubListString sub = new SubListString();
		sub.list(); // 오버라이딩 이전 > 홍길동 상위 클래스 ( 부모클래스 ListString 의 name 값 출력 )
					// 오버라이딩 이후 > 성춘향 하위 클래스 ( 자식클래스 SubListString 의 name 값 출력 )
					// super.list() 삽입 후	> 부모, 자식클래스 둘 다 출력
											// 홍길동 상위 클래스
											// 성춘향 하위 클래스
		sub.writer();

	}
}
