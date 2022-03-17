package io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx2 {
	public static void main(String[] args) {
		int input = 0;
		// 반복문을 통해 문자열 전체 출력 (단, 한개의 바이트씩 끊어지기 때문에 한글 입력 시 깨짐)
		try (InputStream in = System.in;){ // try-with-resources : AutoClosable
			while((input = in.read()) != -1) {
				System.out.print((char)input);
			}
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}
