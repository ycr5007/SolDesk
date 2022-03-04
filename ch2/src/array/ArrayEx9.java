package array;

import java.util.Arrays;

/*
	2차원 배열
		[] 대괄호가 붙을때마다, 차원이 늘어남
*/

public class ArrayEx9 {
	public static void main(String[] args) {
		int scores[][] = new int[3][3];
		
		// 인덱스 개별 접근
			scores[0][0] = 10; scores[0][1] = 20; scores[0][2] = 30;
			scores[1][0] = 40; scores[1][1] = 50; scores[1][2] = 60;
			scores[2][0] = 70; scores[2][1] = 80; scores[2][2] = 90;
		
		// for 문을 이용한 접근
			for(int i = 0; i < scores.length; i++) {
				for(int j = 0; j < scores[i].length; j++) {
					System.out.print(scores[i][j] + " ");
				}
				System.out.println(Arrays.toString(scores[i]));
			}
		
		// 변형 for 문
			for(int score_row[] : scores) {
				for(int score_column : score_row) {
					System.out.print(score_column + " ");
				}
				System.out.println();
			}
	}
}
