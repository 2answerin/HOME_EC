package com.day1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//GenericServlet(service()) <- HttpServlet(doGet, doPost)
//WebServlet 어노테이션이 있는 서블릿은 컨트롤 계층을 담당
//서블릿은 구조상 뷰 계층을 담당하지 않음
@WebServlet("/lifecycle")//spring @Conrtoller + @RequestMapping
public class LifeCycleServlet extends HttpServlet {
	 Logger logger = Logger.getLogger(LifeCycleServlet.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//입력,처리,출력을 담당
		//사용자의 요청을 받는 메소드
		//2번째 요청부터 init을 건너뛰고 들어오기때문에 속도가 빠름
		logger.info("service호출");
	}

	@Override
	public void destroy() {
		//서블릿이 메모리에서 제거될 때 서블릿 컨테이너에 의해 자동호출
		logger.info("destroy호출");
	}

	@Override
	public void init() throws ServletException {
		//서블릿이 초기화될 때 자동호출되는 메소드
		//서블릿이 초기화 작업 담당
		//개발자가 호출하는 메소드가 아님
		logger.info("init호출");
	}

}
