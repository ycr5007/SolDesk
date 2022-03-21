package thread;

// 대문자 A ~ Z 출력과 동시에 소문자 a ~ z 도 출력

public class BigLetters {
	public static void main(String[] args) {
		
		// 같이 수행할 클래스 지정
		SmallLetters t1 = new SmallLetters();
		t1.start();

		Runnable r = new NumPrint();
		Thread t2 = new Thread(r);
		t2.start();
		
		// >> A B a b c d e f g h i j k l m n o p q r s t u v w x y z C D E F G H I J K L M N O P Q R S T U V W X Y Z 
			// main 과 SmallLetters 가 동시에 실행 됨
		
		// a b c d e f g h i j k l m n o p q r s t u v w x y z A B C D E F 1 G 2 3 4 5 H 6 I 7 J 8 K 9 L 10 M 11 N 12 13 O 14 P 15 Q R S T U V W X Y Z 
		
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch + " ");
		}

		// 절차에 따라 진행
//		for(char ch = 'a'; ch <= 'z'; ch++) {
//			System.out.print(ch + " ");
//		}
		
	}
}
