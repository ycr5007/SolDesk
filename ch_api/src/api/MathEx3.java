package api;

public class MathEx3 {
	public static void main(String[] args) {
		// 반복, 숫자를 1 ~ 3 까지 3개 생성한 뒤 한 줄에 출력
		// 모두 같은 수가 나올때까지 반복, 모두 같은 수이면 종료
		
		int[] arr = new int[3];
		while(true) {
			for(int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random() * 3 ) + 1;
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			if(arr[0] == arr[1] && arr[0] == arr[2]) {
				break;
			}
		}
	}
}
