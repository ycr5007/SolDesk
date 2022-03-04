package array; 

/*
	10 명의 점수를 배열로 생성
	최대값, 최소값 출력
*/	

public class ArrayEx6 {
	public static void main(String[] args) {
		
		int score[] = {77, 22, 33, 44, 56, 12, 39, 98, 86, 52};
		int max = score[0];
		int min = score[0];
		
		for(int x : score) {
			if(max < x) {
				max = x;
			}
		}
		
		for(int i = 1; i < score.length; i++) {
			if(min > score[i]) {
				min = score[i];
			}
		}
		
		System.out.println("max : " + max + " / min : " + min);
	}
}
