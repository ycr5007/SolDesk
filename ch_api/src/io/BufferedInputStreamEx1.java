package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamEx1 {
	static final String PATH = "D:\\git\\SolDesk\\ch_api\\src\\temp\\";
	
	
	public static void main(String[] args) {
		// 파일 자동생성 ?
//		File file = new File(PATH + "output2.txt");
//		
//		if(!file.exists()) {
//			try {
//				file.createNewFile();
//				System.out.println(PATH + "에 파일이 생성되었습니다.");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(PATH + "file1.txt")); /* Buffer 입력 보조스트림 */
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(PATH + "output2.txt"));) /* Buffer 출력 보조 스트림 */ {
			
			// 파일 읽기 => 파일 쓰기
			byte[] b = new byte[1024];
			while(bis.read(b) != -1) {
				bos.write(b);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
