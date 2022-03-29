package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/*
	사용자로부터 데이터 입력받기 : Scanner
	output1.txt 파일 생성
	입력받은 데이터를 파일 출력 : output1.txt
*/

public class FileWriterEx2 {
	static final String FILEPATH = "D:/git/SolDesk/ch_api/src/temp/output1.txt";
	static final File FILE = new File(FILEPATH);

	public static void main(String[] args) {
		if(!FILE.exists()) {
			System.out.println(FILEPATH);
			try {
				FILE.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try(Writer writer = new FileWriter(FILE, true); Scanner sc = new Scanner(System.in)) {
			while(true) {
				System.out.print(FILE.getName() +" 파일에 입력 > ");
				String input = sc.nextLine();
				if(input.equalsIgnoreCase("q")) {
					System.out.println("종료합니다.");
					break;
				}
				writer.write(input);
				writer.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
