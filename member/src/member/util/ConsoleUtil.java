package member.util;

import java.util.Scanner;

import member.dto.MemberDTO;

public class ConsoleUtil {
	public MemberDTO getNewMember(Scanner sc) {
		MemberDTO dto = new MemberDTO();
		
		System.out.println("───────────────────── 멤버 정보 입력 ─────────────────────");
		System.out.print("1 . id >>");
		dto.setId(Integer.parseInt(sc.nextLine()));
		System.out.print("2 . name >>");
		dto.setName(sc.nextLine());
		System.out.print("3 . addr >>");
		dto.setAddr(sc.nextLine());
		System.out.print("4 . email >>");
		dto.setEmail(sc.nextLine());
		System.out.print("5 . age >>");
		dto.setAge(Integer.parseInt(sc.nextLine()));
		System.out.println("──────────────────────────────────────────────────────");
		return dto;
	}
	
	public void printAddSuccessMessage() {
		System.out.println("회원 정보 추가 성공");
	}

	public void printAddFailMessage() {
		System.out.println("회원 정보 추가 실패");
	}
}
