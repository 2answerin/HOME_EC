package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//서블릿은 java인데 브라우저에 출력할 수 있나? - 화면을 그리는데 서블릿을 사용
@WebServlet("/day1/html.do?gubun=2") //웹에서 접근 간으한 맵핑 주소
public class MimeHtmlServlet extends HttpServlet {
	Logger logger = Logger.getLogger(MimeHtmlServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		String gubun = req.getParameter("gubun");
		if(gubun == null) {
			res.setContentType("text/html;charset=UTF-8");
			//메소드를 통해서 객체 생성하는 코드 - 고급
			PrintWriter out = res.getWriter();
			out.print("<h2>안냥하샤요</h2>");
		}
		else {
			res.sendRedirect("./mimeHtmlResult.jsp");
		}
	}
}