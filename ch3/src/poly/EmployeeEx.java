package poly;

public class EmployeeEx {
	public static void main(String[] args) {
		Employee[] emp = new Employee[4];
		emp[0] = new Employee();
		emp[0].setName("홍길동");
		emp[0].setPosition("사원");
		work(emp[0]);
		
		emp[1] = new Ceo();
		emp[1].setName("성춘향");
		emp[1].setPosition("회장");
		work(emp[1]);

		emp[2] = new PartTime();
		emp[2].setName("이몽룡");
		emp[2].setPosition("알바");
		work(emp[2]);

		emp[3] = new Adminstrator();
		emp[3].setName("변사또");
		emp[3].setPosition("관리자");
		work(emp[3]);
	}
	
	// 매개변수의 다형성
	public static void work(Employee emp) {
		// Employee emp = emp[0](Employee);
		// Employee emp = emp[1](Ceo);
//			public static void work(Ceo emp) {
//				emp.work();
//			}
		// Employee emp = emp[2](PartTime);
//			public static void work(PartTime emp) {
//				emp.work();
//			}
		// Employee emp = emp[3](Adminstrator);
//			public static void work(Adminstrator emp) {
//				emp.work();
//			}
		emp.work();
	}
}
