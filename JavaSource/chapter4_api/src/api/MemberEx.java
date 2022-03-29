package api;

public class MemberEx {
	public static void main(String[] args) {
		Member member1 = new Member("blue");
		Member member2 = new Member("blue");
		Member member3 = new Member("red");
		
		// equals 오버라이딩 전
//		System.out.println("1 / 2 주소 비교 결과 : " + member1.equals(member2)); // false
//		System.out.println("1 / 3 주소 비교 결과 : " + member1.equals(member3)); // false
		
		// equals 오버라이딩 후
		System.out.println("1 / 2 갖고있는 값 비교 결과 : " + member1.equals(member2)); // true
		System.out.println("1 / 3 갖고있는 값 비교 결과 : " + member1.equals(member3)); // false
		
		// toString 오버라이딩 전
//		System.out.println("1 주소 값 " + member1); // api.Member@5aaa6d82
//		System.out.println("2 주소 값 " + member2); // api.Member@73a28541
//		System.out.println("3 주소 값 " + member3); // api.Member@6f75e721

		// toString 오버라이딩 후
		System.out.println("1 객체호출 값 " + member1); // api.Member@5aaa6d82
		System.out.println("2 객체호출 값 " + member2); // api.Member@73a28541
		System.out.println("3 객체호출 값 " + member3); // api.Member@6f75e721
		
	}
}
