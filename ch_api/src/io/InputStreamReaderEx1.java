package io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
	Byte 기반으로 읽는 InputStream
	문자 기반으로 읽는 Reader
		InputStreamReader(문자 변환 보조스트림) > 읽은 내용이 문자라면 Byte 기반으로 된 내용을 문자로 읽어들임
*/

public class InputStreamReaderEx1 {
	static final String PATH = "D:\\git\\SolDesk\\ch_api\\src\\temp\\";
	public static void main(String[] args) {
		
		
		
		try(InputStream in = new FileInputStream(PATH + "file1.txt")) {
			InputStreamReader reader = new InputStreamReader(in); // new InputStreamReader(InputStream, CharSet)
			
			char cbuf[] = new char[100];
//			InputStream.read(byte[])
//			InputStreamReader.read(char[])
			while(reader.read(cbuf) != -1) {
				System.out.println(cbuf);
			}
		} catch (Exception e) {
			
		}
	}
}
