package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
	img 파일 read
*/

public class BufferedInputStreamEx2 {
	static final String PATH = "D:\\git\\SolDesk\\ch_api\\src\\temp\\";
	
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream(PATH + "pawel.jpg");
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(PATH + "pawel_copy.jpg");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			
			int data;
			while((data = bis.read()) != -1) {
				bos.write(data);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
