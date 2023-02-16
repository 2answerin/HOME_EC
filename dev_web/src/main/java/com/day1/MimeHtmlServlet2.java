package com.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//서블릿은 java인데 브라우저에 출력할 수 있나? - 화면을 그리는데 서블릿을 사용
@WebServlet("/day1/html2.do") //웹에서 접근 간응한 맵핑 주소
public class MimeHtmlServlet2 extends HttpServlet {
	Logger logger = Logger.getLogger(MimeHtmlServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doGet 호출");
		HttpSession session = req.getSession();
		String myName = new String("이우주");
		int age = 35;
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("mem_id","tomato");
		rmap.put("mem_pw","111");
		rmap.put("mem_name","토마토");
		List<Map<String,Object>> mList = new ArrayList<>();
		if(rmap != null) {
			rmap.clear(); //비우기
		}
		rmap = new HashMap<>();
		rmap.put("mem_id","tomato");
		rmap.put("mem_pw","111");
		rmap.put("mem_name","토마토");
		mList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("mem_id","kiwi");
		rmap.put("mem_pw","222");
		rmap.put("mem_name","키위");
		mList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("mem_id","banana");
		rmap.put("mem_pw","333");
		rmap.put("mem_name","바나나");
		mList.add(rmap);
		session.setAttribute("myName", myName);
		session.setAttribute("age", age);
		session.setAttribute("rmap", rmap);
		session.setAttribute("mList", mList);
		res.sendRedirect("./mimeHtmlResult.jsp");
		//html2.do와 요청이 끊어졌다가 새로 서버가 열림
	}
}