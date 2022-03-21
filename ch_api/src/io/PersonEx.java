package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonEx {
	
	static final String PATH = "src\\temp\\";
	static final String CODE = "serial.dat";
	
	public static void main(String[] args) {
		Person personLee = new Person("이순신", "엔지니어");
		Person personKim = new Person("김유신", "선생님");
		
		/*
			java.io.NotSerializableException
			
			객체 전송 시, 필요 개념 : 직렬화 (Serialization)
				> 전송할 객체에 implements ( Serializable )
		*/
		
		
		// 직렬화 : 객체를 저장한다.
		try(FileOutputStream fos = new FileOutputStream(PATH + CODE);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(personLee);
			oos.writeObject(personKim);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 역직렬화 : 객체를 다시 읽어온다.
		try(FileInputStream fis = new FileInputStream(PATH + CODE);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			for(int i = 0; i < 2; i++) {
				Person p = (Person) ois.readObject();
				System.out.println(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
