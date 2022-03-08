package classtest;

public class Numbers {
	int[] num;
	
	public Numbers(int[] num) {
		this.num = num;
	}
	
	// 합계
	int sum() {
		int sum = 0;
		for(int i : num) {
			sum += i;
		}
		return sum;
	}
	
	// 평균
	double avg() {
		return (double)sum() / num.length;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 30, 70, 100, 25, 3};
		Numbers num = new Numbers(arr);
		System.out.println("sum : " + num.sum());
		System.out.println("avg : " + num.avg());
	}
}
