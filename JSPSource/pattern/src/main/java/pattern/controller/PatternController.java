package pattern.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.action.Action;
import pattern.action.ActionFactory;

@WebServlet("*.do")
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");

		String command = req.getRequestURI().substring(1, req.getRequestURI().indexOf(".do"));
		
		ActionFactory af = ActionFactory.getInstance();
		System.out.println("Controller : " + command);
		
		Action action = af.action(command);
		
		try {
			action.execute(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
	1 . uri 분석 : http://localhost:port/ ~ .do → requestURI() 추출
	2 . 추출된 request를 처리해 줄 Action 생성 → ActionFactory 이용
	3 . 생성된 Action 에게 작업 넘기기 ( request , response 전달 )
		→ form / get(QueryString) 으로 들어오는 요청은 Servlet 에게 넘어오게 됨
		→ Service 에게 요청 넘기기 ( getParameter 작업 )
			
			1) ~ Action 은 받은 요청을 이용해 Service 작업 호출 ( 필요 Parameter 전달 )
				→ Service 에서 DB 작업 실행 ( DAO )
			2) ~ Action 은 Service 작업 결과를 받아(boolean) path / 이동방식(redirect)이 들어간 ActionForward 를 Controller에게 전달
			
	4 . Controller 에서 Action 으로부터 전달받은 ActionForward 를 통해 페이지 이동
	5 . 종료
*/

