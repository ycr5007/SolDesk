package emp.db2;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	DTO(Data Transfer Object) : DB의 Value 값 => 객체
		
		접근하고자 하는 테이블의 필드와 동일하게 생성
*/

/*
	lombok : getter / setter, Constructor 등 생성을 간편하게 작성할 수 있도록 도와주는 도구
*/

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@ToString

@NoArgsConstructor
@AllArgsConstructor // @Data 의 Default 생성자가 사라짐 ( 생성자 명시로 인해 )
@Data // getter / setter / NoArgsConsructor / hashcode / equals / toString ...
public class EmpDTO {
	/*
		EXAM_EMP (TABLE)
			empno (NUMBER)
			ename (VARCHAR2)
			job (VARCHAR2)
			mgr (NUMBER)
			hiredate (DATE)
			sal (NUMBER)
			comm (NUMBER)
			deptno (NUMBER)
	*/
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
}
