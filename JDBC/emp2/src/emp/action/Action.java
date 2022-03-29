package emp.action;

import java.util.Scanner;

// 모든 작업에 대해, 공통된 명령어를 통해 작업할 수 있도록 처리

public interface Action {
	void execute(Scanner sc) throws Exception;
}
