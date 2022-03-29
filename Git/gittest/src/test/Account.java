package test;

import lombok.Data;

@Data
public class Account {
	private String ano;
	private int balance;
	private String owner;
	
	public void deposit() {
		System.out.println("deposit");
	}
	public void withdraw() {
		System.out.println("withdraw");
	}
	public void print() {
		System.out.println("print");
	}
	// 원격저장소에서 수정한 내용( 단, 원격에서 수정한 경우, 로컬저장소와 동기화를 해주어야 한다 )
	public void print2() {
		System.out.println("print");
	}
}
