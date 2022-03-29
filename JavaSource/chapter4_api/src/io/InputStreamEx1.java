package io;

import java.io.IOException;
import java.io.InputStream;

/*
	InputStream 과 OutputStream
	
		- 바이트기반 스트림 : 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 받고 보내는 것 가능
			InputStream / OutputStream
		- 문자기반 스트림 : 문자만 받고 보낼 수 있도록 특화 ( 문자 전용 )
			Reader / Writer
		
*/

public class InputStreamEx1 {
	public static void main(String[] args) {
		// 키보드를 통한 입력 ( Scanner 의 하위버전 )
		InputStream in = System.in; // System.in ( 키보드를 통한 입력 ) <=> System.out ( 화면을 통한 출력 )
		
		try {
			int input = in.read(); // read() : 한 개의 바이트만 읽어옴 ex) In > abc => Out > 97(a 의 ASCII 값)
									// 한글 : 3Byte ( 깨짐 )
			System.out.println((char)input);
		} catch (IOException e) { // IOException (Checked Exception)
			e.printStackTrace();
		}
	}
}
