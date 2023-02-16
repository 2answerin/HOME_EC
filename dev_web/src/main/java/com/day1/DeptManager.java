package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/*
 * 자바로는 웹 서비스가 불가능 -> request, response가 없어서..
 * http(s:security + 인증서)프로토콜을 지원하는 API가 없음
 * 자바에는 URL(프로토콜://도메인:포트번호/경로/페이지 이름)을 등록할 수 없음
 * Server + Applet(JFrame-html태그에서 호출이 가능한 유일한 자바클래스)
 * 
 * 톰캣[자바 파일로 변환] ->.java -> (컴파일:servlet-api.jar) -> .class
 * 
 * 웹 페이지 출력
 * request - 쿼리스트링 - get방식 - RESTful API[get,post,put,delete]
 * response
 * 
 * document.writer("<b>메세지</b>")
 * PrintWriter out = res.getWriter();
 * out.print("<b>메세지</b>")
 * 
 * 웹서비스의 시작은 요청에서부터 시작됨
 */
public class DeptManager extends HttpServlet {
	Logger logger = Logger.getLogger(DeptManager.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
		logger.info("[[ goGet호출 성공 ]]");
		String u_deptno = req.getParameter("deptno");
		String u_dname = req.getParameter("dname");
		String u_loc = req.getParameter("loc");
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(u_deptno+","+u_dname+","+u_loc);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
	}
}
