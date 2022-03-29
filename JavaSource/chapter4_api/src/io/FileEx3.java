package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx3 {
	public static void main(String[] args) {
		File temp = new File("D:/git/SolDesk/ch_api/src/temp");
		File dir = new File("D:/git/SolDesk/ch_api/src/temp/dir");
		File file1 = new File("D:/git/SolDesk/ch_api/src/temp/file1.txt");
		File file2 = new File("D:/git/SolDesk/ch_api/src/temp/file2.txt");
		File file3 = new File(temp, "file3.txt");
		File file4 = new File(dir, "file4.txt");
		
		// 디렉토리 생성
		if(!dir.exists()) {
			/*
			File.mkdir() : 만들고자 하는 디렉토리의 상위 디렉토리가 존재하지 않을 경우, 생성 불가
			ex ) C:\base\want >> want 디렉토리를 만들고자 하는데, base 디렉토리가 없는 경우, 생성 불가
			
			File.mkdirs() : 만들고자 하는 디렉토리의 상위 디렉토리가 존재하지 않을 경우, 상위 디렉토리까지 생성
			ex ) C:\base\want >> want 디렉토리를 만들고자 하는데, base 디렉토리가 없는 경우, base 디렉토리까지 생성
			 */
			dir.mkdir(); // makeDirectory
		}
		
		try {
			if(!file1.exists()) {
				file1.createNewFile();
			}
			if(!file2.exists()) {
				file2.createNewFile();
			}
			if(!file3.exists()) {
				file3.createNewFile();
			}
			if(!file4.exists()) {
				file4.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		System.out.println("날짜\t\t시간\t형태\t\t크기\t\t이름");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
		
		File[] files = temp.listFiles();
		for(File f : files) {
			System.out.print(sdf.format(new Date(f.lastModified())));
			if(f.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t\t" + f.getName());
			}else {
				System.out.print("\t\t\t" + f.length() + "\t\t" + f.getName());
			}
			System.out.println();
		}
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
	}
}
