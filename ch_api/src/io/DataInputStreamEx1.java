package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	DataInputStream / DataOutputStream : 메모리에 저장된 0 , 1 상태 읽기 쓰기
	4 => writeInt(4) > 일반적인 문자
*/

public class DataInputStreamEx1 {
	
	static final String PATH = "src\\temp\\";
	static final String CODE = "data.txt";
	
	public static void main(String[] args) {
		
		// 파일을 사용하는 순서 확인
		try(FileOutputStream fos = new FileOutputStream(PATH + CODE);
				DataOutputStream dos = new DataOutputStream(fos);
				FileInputStream fis = new FileInputStream(PATH + CODE);
				DataInputStream dis = new DataInputStream(fis);
				) {
			
			// 자료형에 맞게 자료 작성
			dos.writeUTF("홍길동");
			dos.writeDouble(95.5);
			dos.writeInt(5);
			
			dos.writeUTF("김자바");
			dos.writeDouble(96.5);
			dos.writeInt(6);
			
			// 자료 읽기
			for(int i = 0 ; i < 2; i++) {
				String name = dis.readUTF();
				double score = dis.readDouble();
				int num = dis.readInt();
				
				System.out.println(num + "." + name + "의 점수는 " + score + "점 입니다.");
			}
			
			// txt 파일의 데이터가 꺠진걸로 보임 (메모리 형식으로 txt 저장 후 메모리 형식으로 불러옴)
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
