package emp.db3;

import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		EmpDAO dao = new EmpDAO(JdbcUtil.getConnection());
		EmpDTO dto = null;
		int empno = 0;
		int mgr = 0;
		
		while(flag) {
			System.out.println("─────────────────────────────────────────────────────");
			System.out.println("1 . EMP 전체 조회");
			System.out.println("2 . EMP 사원 조회");
			System.out.println("3 . EMP 사원 상사 수정");
			System.out.println("4 . EMP 사원 퇴사");
			System.out.println("5 . EMP 사원 입사");
			System.out.println("0 . 종료");
			System.out.println("─────────────────────────────────────────────────────");
			System.out.println();
			System.out.print("메뉴선택 >> ");
			int no = Integer.parseInt(sc.nextLine());
			
			switch(no) {
			case 1 :
				long start = System.currentTimeMillis();
				List<EmpDTO> list = dao.getList();
				for(EmpDTO li : list) {
					System.out.println(li.getEmpno() + "\t" + li.getEname() + "\t" + li.getJob() + "\t" + li.getMgr() + "\t" + li.getHiredate() + "\t" + li.getSal() + "\t" + li.getComm() + "\t" + li.getDeptno());
				}
				long end = System.currentTimeMillis();
				System.out.println("test : " + (end - start));
				break;
			case 2 :
				System.out.print("조회할 사원의 사원번호를 입력해주세요 >>");
				empno = Integer.parseInt(sc.nextLine());
				dto = dao.getRow(empno);
				if(dto == null) {
					System.out.println("존재하지 않는 사원입니다. 메인메뉴로 돌아갑니다.");
					continue;
				}
				System.out.println(dto.getEmpno() + "\t" + dto.getEname() + "\t" + dto.getJob() + "\t" + dto.getHiredate() + "\t" + dto.getDeptno());
				break;
			case 3 :
				System.out.print("수정할 사원의 사원번호를 입력해주세요 >>");
				empno = Integer.parseInt(sc.nextLine());
				System.out.print(empno + " 사원의 변경할 MGR 의 사원번호를 입력해주세요 >>");
				mgr = Integer.parseInt(sc.nextLine());
				if(dao.updateMgr(empno, mgr) > 0) {
					System.out.println("정상적으로 변경 되었습니다.");
				}else {
					System.out.println("데이터 수정에 실패했습니다.");
				}
				break;
			case 4 :
				System.out.print("퇴사하는 사원의 사원번호를 입력해주세요 >>");
				empno = Integer.parseInt(sc.nextLine());
				if(dao.deleteEmp(empno) > 0) {
					System.out.println(empno + " 사원의 퇴사가 정상적으로 처리 되었습니다.");
				}else {
					System.out.println("데이터 삭제에 실패했습니다.");
				}
				break;
			case 5 :
				dto = new EmpDTO();
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
				if(dao.insertEmp(dto) > 0) {
					System.out.println(empno + " 사원이 정상적으로 추가되었습니다.");
				}else {
					System.out.println("추가에 실패하였습니다.");
				}
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			default :
				System.out.println("잘못된 메뉴입니다. 다시선택해주세요.");
				break;
			}
		}
		
		sc.close();
	}
}
