package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PerformanceEx1 {
	static final String PATH = "D:\\git\\SolDesk\\ch_api\\src\\temp\\";
	static final String IMG = "pawel.jpg"; // 3,776 KB
	static final String MP4 = "hold.mp4"; // 31,862 KB
	
	public static void main(String[] args) {
		
		// FileInputStream 만 사용
		try(FileInputStream fis = new FileInputStream(PATH + MP4);
				FileOutputStream fos = new FileOutputStream(PATH + "hold_speedtest1.mp4")) {
			int data1;
			long start = System.currentTimeMillis();
			while((data1 = fis.read()) != -1) {
				// IMG : FileInputStream 만 사용 : 9258ms
				// MP4 : FileInputStream 만 사용 : 76155ms
				fos.write(data1);
				// IMG : FileInputStream 만 사용 : 21125ms
				// MP4 : FileInputStream 만 사용 : 177627ms
			}
			long end = System.currentTimeMillis();
			
			System.out.println("FileInputStream 만 사용 : " + (end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// FileInputStream + BufferedInputStream 사용
		try(FileInputStream fis = new FileInputStream(PATH + MP4);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(PATH + "hold_speedtest2.mp4");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			int data2;
			long start = System.currentTimeMillis();
			while((data2 = bis.read()) != -1) {
				// IMG : FileInputStream + BufferedInputStream 사용 : 18ms
				// MP4 : FileInputStream + BufferedInputStream 사용 : 99ms
				bos.write(data2);
				// IMG : FileInputStream + BufferedInputStream 사용 : 74ms
				// MP4 : FileInputStream + BufferedInputStream 사용 : 227ms
			}
			long end = System.currentTimeMillis();
			
			System.out.println("FileInputStream + BufferedInputStream 사용 : " + (end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// FileInputStream + BufferedInputStream + byte[] 사용
		try(FileInputStream fis = new FileInputStream(PATH + MP4);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(PATH + "hold_speedtest3.mp4");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			byte[] data3 = new byte[4096];
			long start = System.currentTimeMillis();
			while(bis.read(data3) != -1) {
				// IMG : FileInputStream + BufferedInputStream 사용 : 3ms
				// MP4 : FileInputStream + BufferedInputStream + byte[] 사용 : 24ms
				bos.write(data3);
				// IMG : FileInputStream + BufferedInputStream + byte[] 사용 : 9ms
				// MP4 : FileInputStream + BufferedInputStream + byte[] 사용 : 89ms
			}
			long end = System.currentTimeMillis();
			
			System.out.println("FileInputStream + BufferedInputStream + byte[] 사용 : " + (end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
