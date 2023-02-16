package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc.dao.TestDao;

public class TestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(TestServlet.class);
	//사용자 정의 메소드이므로 오버라이드 X
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.fatal("doService 호출");
		logger.debug("doService 호출");
		logger.info("doService 호출");
		logger.warn("doService 호출");
		logger.error("doService 호출");
		TestDao tDao = new TestDao();
		List<Map<String,Object>> mList = tDao.getBookMember();
		//페이지 이동
		//페이지 이름 getMemberList.jsp
		//페이지의 물리적인 경로는 어디를 바라보고 있는가? -> web.xml -> servlet-mapping -> url-pattern
		//- 경로명/요청을 처리하는 이름.do[뒤에 온 확장자 do는 의미없음 - 해당 요청을 인터셉트해서 해당업무를 담당하는
		// 클래스에 연결(FrontController.java설계 - 각 업무별 XXXController필요)을 해야함]
		//페이지처리는 JSP에게 맡김
		//서블릿은 요청을 받아서 업무 담당자에게 연결
		//이것을 어떻게 나눌 것인가.. 요청은 업무 담당자, 사용자 선택에 따라 결정
		//결정에 대응하는 클래스를 FrontController연결
		//FrontController에서 실제 업무를 담당하는 XXXController에 전달할 때 요청객체와 응답객체 또한 전달되어야 함
		//요청 객체로 무엇을 누릴 수있나.. 사용자가 입력한 값을 듣기위해 필요
		//request -> getParameter("") : String / 세션 -> getAttribute("") : Object
		//request.getParameter("XXX");
		//HttpSession session = request.getSession(); -> 세션객체생성
		//http 프로토콜이 비상태 프로토콜이므로 상태값을 관리하는 별도의 메카니즘이 필요 -> 쿠키(최근에 본 상품)와 세션(시간,로그인 연장..?)
		// 쿠키와 세션 <- List,Map <- 객체배열[{}] <- 배열 <- 원시형타입(변수)
		//response.setContentType(); 마임타입을 정한다
		//서블릿인데 json, 서블릿인데 html, 서블릿인데 xml
		//response.setContentType("application/json);
		//response.setContentType("text/html,,xml,,css등등);
		//res.sendRedirect("페이지 이름") -> 페이지 이동
		//주소창이 바뀌, 기존 요청이 끊어지고 새로운 요청이 발생 -> 쿠키, 세션에 담아둠 비상태 프로토콜(그래야 상태 유지)
		//쿠키는 문자열, 객체 받지못함 / 세션은 캐시메모리, 객체 받음
		//아래 코드를 만나기 전까지는 http://localhost:9000/test/test.do
		//를 보여주다가 아래 문자를 만나면 그때 http://localhost:9000/test/getMeberList.jsp를 요청
res.sendRedirect("./getMemberList.jsp");
//String cTime = tDao.testDate();
//logger.info("today : "+cTime);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		doService(req, res);
	}
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		
	}
}
