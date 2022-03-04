package condition;

/*
	while 
	
	반복문의 기본 구조
		- 초기화 ( int i = 0; )
		- 조건식 ( i < 100; )
		- 증감식 ( i++ )
		
	for 기본 구조
		for(초기화; 조건식; 증감식){
			반복문장;
		}
		
	while 기본 구조
		초기화;
		while(조건식){
			반복문장;
			증감식;
		}
*/

public class WhileEx1 {
	public static void main(String[] args) {
		// for(int i = 0; i <= 10; i++) {	}
		
		int i = 0; // 초기화
		while(i <= 10) { // 조건식
			System.out.println(i + " ");
			i++; // 증감식
		}
	}
}
