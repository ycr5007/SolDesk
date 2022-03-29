package array;

import java.util.Arrays;

/*
	oldArray 값을 newArray 값으로 복사
*/

public class ArrayEx8 {
	public static void main(String[] args) {
		int oldArray[] = {10, 20, 30};
		int newArray[] = new int[4];
		
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		System.out.println(Arrays.toString(newArray));
	}
}
