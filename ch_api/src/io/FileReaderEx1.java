package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderEx1 {
	public static void main(String[] args) {
		// InputStream < Byte[] >
		// Reader < Char[] >
		try(Reader reader = new FileReader("c:\\temp\\file1.txt")) {
			int ch;
			while((ch = reader.read()) != -1) {
				System.out.print((char)ch);
			}
		} catch (IOException e) { // IOException 은 FileNotFoundException 을 포함한다
			e.printStackTrace();
		}
	}
}
