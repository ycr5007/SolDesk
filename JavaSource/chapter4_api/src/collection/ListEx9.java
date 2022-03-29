package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
	한 어린이의 키를 2015 ~ 2021년 사이에 1년 단위로 입력받아 ArrayList에 저장, 가장 키가 많이 자란 연도 출력하기
	
	ex) 입력값	: 120 122 125 130 139 145 149
		출력값	: 9
*/

public class ListEx9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		System.out.print("입력값 : ");
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int max = 0;
		int year = 0;
		for(int i = 1; i < list.size(); i++) {
			int grow = list.get(i) - list.get(i - 1);
			if(max < grow) {
				max = grow;
				year = i;
			}
		}
		System.out.println("출력값 : 가장 키가 많이 자란 년도는 " + (year + 2015) + "년 " + max + "cm 키가 컸습니다.");
		
		sc.close();
	}
}
