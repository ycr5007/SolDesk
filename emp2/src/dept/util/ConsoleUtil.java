package dept.util;

import java.util.List;
import java.util.Scanner;

import dept.dto.DeptDTO;

public class ConsoleUtil {
	public void printList(List<DeptDTO> list) {
		System.out.println("─────────────── 전체 부서 조회 ───────────────");
		for(DeptDTO dto : list) {
			printRow(dto);
		}
	}
	
	public void printRow(DeptDTO dto) {
		System.out.println(dto.toString());
	}
	
	public int selectDeptno(Scanner sc) {
		System.out.print("부서번호를 입력해주세요 >>");
		return Integer.parseInt(sc.nextLine());
	}
	
	public DeptDTO insertData(Scanner sc) {
		DeptDTO dto = new DeptDTO();
		System.out.print("부서번호 > ");
		dto.setDeptno(Integer.parseInt(sc.nextLine()));
		System.out.print("부서명 > ");
		dto.setDname(sc.nextLine());
		System.out.print("지역 > ");
		dto.setLoc(sc.nextLine());
		return dto;
	}
	
	public void successMessage() {
		System.out.println("성공했습니다.");
	}

	public void failMessage() {
		System.out.println("실패했습니다.");
	}
	
	public String selectLoc(Scanner sc) {
		System.out.print("이전할 지역을 입력해주세요 >>");
		return sc.nextLine();
	}
}
