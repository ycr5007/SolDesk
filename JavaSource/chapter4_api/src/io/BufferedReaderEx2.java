package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
	.java 파일을 읽어서 화면에 출력
	src/io/PerformanceEx1.java
	출력문 앞에 번호를 붙여 화면에 보여주기
*/

public class BufferedReaderEx2 {
	static final String PATH = "src\\io\\";
	static final String CODE = "PerformanceEx1.java";
	public static void main(String[] args) {
		try(InputStreamReader in = new InputStreamReader(new FileInputStream(PATH + CODE));
				BufferedReader bis = new BufferedReader(in)) {
			
			String str = null;
			int lnum = 1;
			while((str = bis.readLine()) != null) {
				System.out.println((lnum++) + " " + str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
