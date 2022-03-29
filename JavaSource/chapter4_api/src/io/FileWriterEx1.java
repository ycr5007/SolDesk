package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterEx1 {
	public static void main(String[] args) {
		try(Writer writer = new FileWriter("D:/git/SolDesk/ch_api/src/temp/file3.txt", true)) { // boolean 값은, 중복된 값 입력여부에 대한 내용이다.
			writer.write("FileWriter는 한글로 된\n");
			writer.write("문자열을 출력할 수 있다.");
			writer.write("Writer 클래스는 문자 단위의\n");
			writer.write("출력만 가능합니다.");
			// Enter : 한 줄 올리고, 커서를 맨 앞으로 이동(타자기)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
