package exam;

import java.util.Scanner;

public class CalcEx {
	public static void main(String[] args) {
		Calc cal;
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		
		System.out.print("Input Num1 : ");
		a = Integer.parseInt(sc.nextLine());
		System.out.print("Input Num2 : ");
		b = Integer.parseInt(sc.nextLine());
		System.out.print("Input operator : ");
		String user = sc.nextLine();
		switch(user) {
			case "+":
				cal = new Add();
				cal.setValue(a, b);
				System.out.println(cal.calculate());
				break;
			case "-":
				cal = new Sub();
				cal.setValue(a, b);
				System.out.println(cal.calculate());
				break;
			case "*":
				cal = new Mul();
				cal.setValue(a, b);
				System.out.println(cal.calculate());
				break;
			case "/":
				cal = new Div();
				cal.setValue(a, b);
				System.out.println(cal.calculate());
				break;
		}
		sc.close();
	}
}
