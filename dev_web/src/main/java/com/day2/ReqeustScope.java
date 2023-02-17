package com.day2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//비상태 프로토콜은 요청이 끊어지는데 페이지가 이동되더라도 어떤 데이터를 유지하고 싶을 때 세션이나 쿠키를 사용
//요청이 유지되는 동안에 forward로 페이지를 이동하면 단점 값이 유지되지 않는 점을 해결
import org.apache.log4j.Logger;
//http://localhost:9000/day2/a 요청하면 RequestScope 서블릿 클래스의 doGet 메소드가 호출
//doGet메소드 안에서 sendRedirect대신 forward메소드가 호출되므로 주소는 그대로
//http://localhost:9000/day2/a를 가리키고 있는데 실제 페이지는 http://localhost:9000/day2/b.jsp를 찾고있음
//이것이 secdRedirect("b.jsp")로 이동할 때와 forward로 이동할 때 차이점
//sendRedirect로 페이지 이동시에는 값을 유지하려면 쿠키나 세션을 사용해야하지만
//forward로 이동시에는 forward메소드 호출시 첫번째 파라미터인 request객체에 담아서 넘길(유지시킬)수 있음

//어노테이션
@WebServlet("/day2/a")
public class ReqeustScope extends HttpServlet {
	Logger logger = Logger.getLogger(ReqeustScope.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet호출");
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("mem_id", "tomato");
		req.setAttribute("rmap", rmap);
		RequestDispatcher view = req.getRequestDispatcher("b.jsp");
		//day1/a로 요청한 경우 doGet메소드를 경유하게 되고 이 요청을 받았을 때 톰캣으로부터 서블릿이 생성되고
		//그 서블릿은 요청객체와 응답객체를 잡게되는데 b.jsp페이지에서 응답이 나갈때 파라미터에 요청객체 원본이
		//전달되니까 화면에서도 그 값을 공유할 수 있음
		view.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
