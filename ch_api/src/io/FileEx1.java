package io;

import java.io.File;
import java.io.IOException;

public class FileEx1 {
	public static void main(String[] args) throws IOException {
		// 객체생성 방법 (Constructor) > 파일 생성 X
		File f1 = new File("D:/git/SolDesk/ch_api/src/temp/test1.txt");
		
		File f2 = new File("D:/git/SolDesk/ch_api/src/temp", "test2.txt");
		
		File dir = new File("D:/git/SolDesk/ch_api/src/temp");
		File f3 = new File(dir,"test3.txt");
		
		// 경로를 제외한 파일명을 구하는 방법
		String fileName = f1.getName();
		System.out.println("경로를 제외한 파일명 : " + fileName);
		
		// 확장자를 제외한 파일명
		String excludeExtension = fileName.substring(0, fileName.lastIndexOf("."));
		System.out.println("확장자를 제외한 파일명 : " + excludeExtension);
		
		// 파일의 확장자
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("확장자 : " + extension);
		
		// 경로를 포함한 파일명
		String path = f1.getPath();
		String abPath = f1.getAbsolutePath();
		File caPath = f1.getCanonicalFile();
		String paPath = f1.getParent();
		System.out.println("경로를 포함한 파일명 : " + path);
		System.out.println("파일의 절대경로 : " + abPath); // c:\temp\test1.txt
		System.out.println("파일의 정규경로 : " + caPath); // C:\Temp\test1.txt
		System.out.println("파일이 속해있는 부모경로 : " + paPath);
		
		System.out.println();
		System.out.println("File.pathSeparator - " + File.pathSeparator);
		System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
		System.out.println("File.separator - " + File.separator);
		System.out.println("File.separatorChar - " + File.separatorChar);
	}
}
