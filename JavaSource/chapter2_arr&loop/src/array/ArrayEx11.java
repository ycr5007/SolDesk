package array;

import java.util.Arrays;
import java.util.Scanner;

/*
	단어 맞추기 (euoms => mouse)
	
		char[] => String : new String(char[]);
		String => char[] : String.toCharArray();
		
*/

public class ArrayEx11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String words[] = {"television", "computer", "mouse", "phone"}; // char[] name = (String).toCharArray();
		char[][] shuffle = new char[words.length][]; // 가변 배열로, for문 내부에서 길이 설정
		char temp = ' '; // swap 을 위한 임시 저장변수
		
		for(int i = 0; i < shuffle.length; i++) {
			shuffle[i] = words[i].toCharArray();
			for(int j = 0; j < shuffle[i].length; j++) {
				int rand = (int)(Math.random() * shuffle[i].length);
				temp = shuffle[i][j];
				shuffle[i][j] = shuffle[i][rand];
				shuffle[i][rand] = temp;
			}
			boolean flag = true;
			String answer = "";
			
			while(flag) {
				System.out.println(Arrays.toString(shuffle[i]) + "\t PASS : 0");
				answer = sc.nextLine();
				if(answer.equals(words[i])) {
					System.out.println("정답입니다.");
					flag = false;
				}else if(answer.equals("0")) {
					System.err.println("패스 하셨습니다.\n정답은 " + words[i] + " 였습니다.");
					flag =false;
				}else {
					System.out.println("틀렸습니다.");
				}
			}
		}
		sc.close();
	}
}
