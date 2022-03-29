package member.util;

import java.util.List;
import java.util.Scanner;

import member.dto.MemberDTO;

public class ConsoleUtil {
	public MemberDTO getNewMember(Scanner sc) {
		MemberDTO dto = new MemberDTO();
		
		System.out.println("───────────────────── 멤버 정보 입력 ─────────────────────");
		System.out.print("1 . name >> ");
		dto.setName(sc.nextLine());
		System.out.print("2 . addr >> ");
		dto.setAddr(sc.nextLine());
		System.out.print("3 . email >> ");
		dto.setEmail(sc.nextLine());
		System.out.print("4 . age >> ");
		dto.setAge(Integer.parseInt(sc.nextLine()));
		System.out.println("──────────────────────────────────────────────────────");
		return dto;
	}
	
	public int selectModifyMenu(Scanner sc) {
		System.out.println("───────────────────── 수정 메뉴 선택 ─────────────────────");
		System.out.println("1 . addr");
		System.out.println("2 . email");
		System.out.println("──────────────────────────────────────────────────────");
		System.out.print("메뉴 선택 >> ");
		int no = Integer.parseInt(sc.nextLine());
		if(no != 1 && no != 2) {
			System.out.println("잘못된 메뉴를 선택하셨습니다.");
			selectModifyMenu(sc);
		}
		return no;
	}
	
	public int selectId(Scanner sc) {
		System.out.print("회원의 ID 를 입력해주세요 >> ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public String modifyMember(Scanner sc) {
		System.out.print("수정 내용을 입력해주세요 >> ");
		return sc.nextLine();
	}
	
/*───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────*/	
	
	public void printSuccessMessage() {
		System.out.println("정상적으로 반영되었습니다.");
	}

	public void printFailMessage() {
		System.out.println("반영에 실패했습니다.");
	}
	
	public void printMemberList(List<MemberDTO> list) {
		System.out.println("───────────────────── 전체 멤버 조회 ─────────────────────");
		System.out.println("No\tName\tAddr\t\tEmail\t\tAge");
		for(MemberDTO dto : list) {
			System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getAddr() + "\t" + dto.getEmail() + "\t" + dto.getAge());
		}
	}
}
