package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//개발자가 정의한 서블릿 - 표준 서블릿이 아님
//doService메소드는 요청처리에 대한 창구를 일원화 하기위해 개발자가 정의한 메소드임
//따라서 request객체와 response객체를 톰캣서버로 부터 주입받을 수 없음
//문제 해결을 위해서 *메소드 파라미터 자리를 이용하여 doGet, doPost메소드에서 주입받은
//request객체와 response객체를 넘겨받아서 사용함
public class FrontMVC1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(FrontMVC1.class);
	/*
	 * 이 메소드는 톰캣서버로부터 직접 요청객체와 응답객체를 주입받을 수 없음
	 * 따라서 doGet메소드와 doPost메소드 안에서 doService메소드 호출할 때 파라미터로 넘겨받음 
	 */
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출"); 
		String uri = req.getRequestURI(); //주소창에 입력된 값 중 도메인과 포트번호가 제외된 값만 받음
		logger.info(uri); // /dept/getDeptList.st1
		String context = req.getContextPath(); // "/" -> server.xml
		logger.info(context); // /dept/getDeptList.st1
		//http://localhost:9000/dept/getdeptList.st1
		//http://localhost:9000/업무명폴더명/getdeptList.st1
		//http://localhost:9000/board/getBoardList.st1
		//http://localhost:9000/member/getMemberList.st1
		//http://localhost:9000/board/boardInsert.st1
		String command = uri.substring(context.length() + 1); //context정보만 제외된 나머지 경로정보 담음
		System.out.println(command);
		int end = command.lastIndexOf("."); //16 - st1잘라내기위해 사용
		System.out.println(end); //16출력
		command = command.substring(0, end);
		System.out.println(command);
		String upmu[] = null;
		upmu = command.split("/"); //dept, getDeptList
		// split을 사용하여 / 기준으로 글자 잘라내기
		for (String imsi: upmu) {
			System.out.println(imsi);
		}
		ActionForward af = null;
		//게으른 인스턴스화, 아직 결정되지 않음
		DeptController deptController = null;
		EmpController empController = null;
		if("dept".equals(upmu[0])){
			//request객체는 저장소 - setAttribute, getAttribute
			//아래코드는 request저장소에 upmu배열의 주소번지를 원본을 저장하는 구문
			req.setAttribute("upmu", upmu);
			//인스턴스화 -> execute()호출을위해 -> 안하면 널포인트 -> 500번
			deptController = new DeptController();
			//왜 DeptController는 req,res를 주입받을 수 없냐, 서블릿이 아니기때문
			//그래서 파라미터로 doGet메소드가 주입받은 req,res 주소번지 원본을 넘겨줌
			//이렇게 넘기지 않으면 DeptController에서는 req,res를 누릴 수 없음
			//서블릿이 아닌 이유로 메소드를 하나만 가질 수 있음
			//다른 메소드를 정의하는 것은 자유이지만 req,res는 주입받을 수 없음
			//입력,수정,삭제,조회 4가지 메소드가 필요함 - 정의만 가능..
			//DeptLogic메소드 4가지를 호출해야하는데 upmu[1]방에 정보가 필요함
			af = deptController.execute(req,res);
		} else if ("emp".equals(upmu[0])) {
			//인스턴스화
			empController = new EmpController();
			af = empController.execute(req,res);
			//deptController는 서블릿이 아니어서  (요청)req,(응답)res를 톰캣서버(WAS)로부터 주입받을 수 없음
			//http를 상속받지 않았기 때문
		}
		//페이지 이동 처리 공통코드 만듦
		//1. res.sendRedirect("/dept/getDeptList.jsp"); //jsp -> 서블릿 -> jsp
		//1. res.sendRedirect("/dept/getDeptList.st1"); //jsp -> 서블릿 -> 서블릿 ->jsp
		if(af != null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
			} else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req,res);
			}
		}//end of 페이지 이동처리에 대한 공통 코드 부분
	}//end of doService

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet호출");
		doService(req, resp); //*여기서 호출하고 있음
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPost호출");
		doService(req, resp);

	}

}
