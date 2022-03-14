package exception;

import java.io.FileInputStream;

public class FileInputEx {
	public static void main(String[] args) {
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("file.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally { // 자원 해제 
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		// 자동으로 자원해제 진행 ( Java 7 버전 이후 )
		try (FileInputStream fis = new FileInputStream("file.txt")) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
