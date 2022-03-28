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
}
