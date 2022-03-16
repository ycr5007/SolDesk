package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
	Scanner 를 사용하여 5개의 실수 값을 사용자로부터 받아서 ArrayList에 저장한 후 검색하여 가장 큰 수 출력
	
	ex)	in : 3.14 2.1 -5.5 99.9 33.7
		out : 가장 큰 수는 99.9
*/

public class ListEx8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Double> list = new ArrayList<Double>();
		System.out.print("입력값 : ");
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		while(st.hasMoreTokens()) {
			list.add(Double.parseDouble(st.nextToken()));
		}
		// way1
		double max = 0;
		for(Double value : list) {
			if(max < value) {
				max = value;
			}
		}
		System.out.println("출력값 : 가장 큰 수는 " + max);

		// way2
		list.sort(Comparator.reverseOrder());
		System.out.println("출력값 : 가장 큰 수는 " + list.get(0));
		
		// way3
		System.out.println("출력값 : 가장 큰 수는 " + Collections.max(list));
		sc.close();
	}
}
