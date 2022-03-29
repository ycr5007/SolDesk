package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

public class BufferedReaderEx1 {
	static final String PATH = "D:\\git\\SolDesk\\ch_api\\src\\temp\\";
	
	// txt 형식의 문서일 경우, Reader / Writer 사용
	public static void main(String[] args) {
		try(// Reader in = new FileReader(PATH + "file1.txt");
				InputStreamReader in = new InputStreamReader(new FileInputStream(PATH + "file1.txt")); // 인코딩 문제 해결방법 (MS949)
				BufferedReader bis = new BufferedReader(in);
				Writer out = new FileWriter(PATH + "output3.txt");
				BufferedWriter bos = new BufferedWriter(out)) {
			
			String str = null;
			while((str=bis.readLine()) != null) {
				bos.write(str);
				bos.newLine(); // 개행
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
