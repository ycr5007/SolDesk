package array;

public class ArrayEx3 {
	public static void main(String[] args) {
		// score 배열명으로 5개의 int 값을 담는 배열 생성
		// int score[] = {0, 10, 20, 30 , 40};
		
		int score[] = new int[5];
		
		// score 각 인덱스에 값 대입
		for (int i = 0; i < score.length; i++) {
			score[i] = i * 10;
		}

		// score 모든 인덱스 값 출력
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		
		int score2[] = {48, 78, 25, 65, 36, 79};
		// score2 평균, 합계
		int sum = 0;
		for (int i = 0; i < score2.length; i++) {
			sum += score2[i];
		}
		System.out.println("sum : " + sum);
		System.out.println("avg : " + ((double)sum / score.length));
		
	}
}
