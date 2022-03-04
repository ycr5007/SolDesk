package array;

import java.util.Arrays;

/*
	1 ~ 45 번을 가지고 있는 카드 생성
	서로 섞은 후 출력
	
	swap (교환)
		int a = 10, b = 5;
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
*/

public class ArrayEx7 {
	public static void main(String[] args) {
		int card[] = new int[45];
		int temp = 0;
		
		for(int i = 0; i < card.length; i++) {
			card[i] = i + 1;
		}
		
		for(int i = 0; i < card.length; i++) {
			int shuffle = (int)(Math.random() * 45);
			temp = card[i];
			card[i] = card[shuffle];
			card[shuffle] = temp;
		}
		
		System.out.println(Arrays.toString(card));
	}
}
