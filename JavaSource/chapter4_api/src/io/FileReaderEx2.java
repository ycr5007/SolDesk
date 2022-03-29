package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

public class FileReaderEx2 {
	public static void main(String[] args) {
		// InputStream < Byte[] >
		// Reader < Char[] >
		try(Reader reader = new FileReader("D:/git/SolDesk/ch_api/src/temp/file1.txt", Charset.forName("UTF-8"))) { // Java Default : "UTF-8" , Windows Default : "MS949"
			int ch;
			while((ch = reader.read()) != -1) {
				System.out.print((char)ch);
			}
		} catch (IOException e) { // IOException 은 FileNotFoundException 을 포함한다
			e.printStackTrace();
		}
	}
}
