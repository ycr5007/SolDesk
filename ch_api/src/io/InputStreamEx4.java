package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamEx4 {
	public static void main(String[] args) {
		
		byte arr[] = new byte[1000];
		try(InputStream in = System.in; OutputStream out = System.out) {
			while(in.read(arr) != -1) { // 입력받을 때 바이트 배열공간할당을 하여, 문제없이 한글 출력 가능
				out.write(arr);
				// 남아있는 빈 바이트공간도 출력 ...
				// io 시스템의 구조적 문제로 버퍼를 비워주는 과정이 추가로 필요하다.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
