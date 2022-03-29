package emp.util;

import java.util.List;
import java.util.Scanner;

import emp.dto.EmpDTO;

public class ConsoleUtil {
	
	// 4-1 . Service 에게 넘겨주기 위한 객체 생성 및 반환
	// 사원 INSERT 에서 사원의 정보를 입력 받는 메소드
	public EmpDTO getNewEmp(Scanner sc) {
		EmpDTO dto = new EmpDTO();
		System.out.println("========== 신규사원등록 ==========");
		System.out.print("사원번호 : ");
		dto.setEmpno(Integer.parseInt(sc.nextLine()));
		System.out.print("사원명 : ");
		dto.setEname(sc.nextLine());
		System.out.print("직무 : ");
		dto.setJob(sc.nextLine());
		System.out.print("매니저번호 : ");
		dto.setMgr(Integer.parseInt(sc.nextLine()));
		System.out.print("급여 : ");
		dto.setSal(Integer.parseInt(sc.nextLine()));
		System.out.print("보너스 : ");
		dto.setComm(Integer.parseInt(sc.nextLine()));
		System.out.print("소속부서 : ");
		dto.setDeptno(Integer.parseInt(sc.nextLine()));
		
		return dto;
	}
	
	public void printAddSuccessMessage(EmpDTO newEmp) {
		System.out.println(newEmp.getEname() + "의 사원정보 추가 성공");
	}

	public void printAddFailMessage(EmpDTO newEmp) {
		System.out.println(newEmp.getEname() + "의 사원정보 추가 실패");
	}
	
	// EmpListAction
	public void printEmpList(List<EmpDTO> list) {

		System.out.println();
		System.out.println("==================== 사원 정보 ====================");
		System.out.println();
		System.out.println("사번\t성명\t직무\t매니저\t입사일\t\t급여\t추가수당\t부서번호");
		
		for(EmpDTO dto : list) {
			System.out.println(dto.getEmpno() + "\t" + dto.getEname() + "\t" + dto.getJob() + "\t" + dto.getMgr() + "\t" + dto.getHiredate() + "\t" + dto.getSal() + "\t" + dto.getComm() + "\t" + dto.getDeptno());
		}
	}
	
	// EmpRowAction
	public int printRowMessage(Scanner sc) {
		System.out.print("조회할 사원의 번호를 입력해주세요 >>");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void printEmpRow(EmpDTO dto) {
		System.out.println("사번\t성명\t직무\t입사일\t\t부서번호");
		System.out.println(dto.getEmpno() + "\t" + dto.getEname() + "\t" + dto.getJob() + "\t" + dto.getHiredate() + "\t" + dto.getDeptno());
	}
	
	
	// ModifyAction
	public EmpDTO printModifyMessage(Scanner sc) {
		EmpDTO dto = new EmpDTO();
		System.out.print("담당자를 변경할 사원의 번호를 입력해주세요 >>");
		dto.setEmpno(Integer.parseInt(sc.nextLine()));
		System.out.print("바뀌는 담당자의 사원번호를 입력해주세요 >>");
		dto.setMgr(Integer.parseInt(sc.nextLine()));
		return dto;
	}
	
	public void printModifySuccessMessage(int empno) {
		System.out.println("사원번호 " + empno + " 의 사원정보 변경 성공");
	}

	public void printModifyFailMessage() {
		System.out.println("사원정보 변경 실패");
	}
	
	// RemoveAction
	public int printRemoveMessage(Scanner sc) {
		System.out.print("삭제할 정보를 가진 사원의 번호를 입력해주세요 >>");
		return Integer.parseInt(sc.nextLine());
	}
	
	public void printRemoveSuccessMessage(int empno) {
		System.out.println("사원번호 " + empno + " 의 사원정보 삭제 성공");
	}

	public void printRemoveFailMessage() {
		System.out.println("사원정보 삭제 실패");
	}
}
