package exam;

import java.util.Scanner;

public abstract class Converter {
	abstract protected double convert(double src);
	abstract protected String getSrcString();
	abstract protected String getDestString();
	protected double ratio;
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println(getSrcString() + "을 " + getDestString() + " 로 바꿉니다.");
		System.out.print(getSrcString() + "을 입력하세요 >>");
		double val = sc.nextDouble();
		double res = convert(val);
		System.out.println("변환결과 : " + res + getDestString() + " 입니다.");
		sc.close();
	}
}
