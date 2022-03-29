package io;

import java.io.File;

public class FileEx2 {
	public static void main(String[] args) {
		// 디렉토리가 존재하는지 여부 확인
		if(args.length != 1) {
			System.out.println("사용법 : java FileEx2 디렉토리명");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		
		if(!f.exists() | !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		// 해당 디렉토리에 있는 파일 / 폴더를 모두 검색 및 확인
		File[] files = f.listFiles();
		for(File f1 : files) {
			System.out.println(f1.isDirectory() ? "[" + f1.getName() + "]" : f1.getName());
		}
	}
}
