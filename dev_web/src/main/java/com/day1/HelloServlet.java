package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//form전송시 클라이언트측의 요청을 서블릿이 듣는다
//method = "get"이면 doGet호출
//post이면 doPost가 호출됨
//자바가 서블릿이 되기 위한 조건은 반드시 HttpServlet을 상속받는 것
//상속을 받으면 doGet과 doPost 오버라이딩 할 수 있는데 이 함수의 파라미터를 통해서
//request요청 객체와 response 응답 객체를 주입받는다
//톰캣 서버에서 주입해줌
//웹 서비스를 위해서는 URL등록이 필수 - 왜냐하면 브라우저가 실행 주체
//프로젝트에 필요한 URL등록은 annotation과 web.xml문서를 통해서 가능함
//annotion은 자동이고 편하기는 하지만 수동처리와 비교해서 추가작업이 불가능한 단점이 있음
//xml문서를 통해서 객체 등록하고 주입 받음
//이유는 spring 사용 시 메이븐 레포를 이용한 흐로젝트 생성인 경우에 xml문서로 환경을 설정함
//클래스 사이의 객체 주입 관계도 xml문서로 처리 가능
public class HelloServlet extends HttpServlet {
	Logger logger = Logger.getLogger(HelloServlet.class);

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.print("doGet호출");
		logger.info("doGet호출 성공");
		String mem_id = req.getParameter("mem_id");
		logger.info("사용자가 입력한 ID는"+mem_id);
		res.setContentType("text/html;charset=UTF-8");
		//인스턴스화에서 메소드를 사용하는 경우는 뭐가 다를까?
		 PrintWriter out = res.getWriter();
		 String msg = "누구세요? 나가주세요";
		 //브라우저에서 요청[get방식]으로 요청 시 응답으로 나가는 문자열
		 //문자열(1.텍스트파일:숫자의 경우 문자로 변환 후 씀 2.바이너리파일:데이터를 있는 그대로 읽고 씀)
		 //text 메인타입 html 서브타입 - 브라우저가 번역 - 태그는 없고 내용만 출력
	      out.print("<font size = 28px color= red>" + msg + "</font>");
	      }

	//추상클래스, 인터페이스 구현체 클래스 일때 오버라이드
	//맵 - 인터페이스, 해쉬맵 - 구현체 클래스
	//단위테스트 불가능 -> Postman사용하면 확인가능
	//Post는 브라우저 통해서 테스트 불가능
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		logger.info("doPost호출 성공");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print("<h3>dsPost</h3>호출");

	}
}

/* 웹서비스[요청하고 응답받기] 제공을 위한 언어
 * 요청을 어디에.. ->브라우저->URL
 * 요청방식에는 몇가지가 있지..
 * 요청을 위해서 무엇이 준비되어있어야 하지..
 * 
 * 
 * 
 * get방식
 * -서버측의 리소스(html,css,js..)를 가져오기 위해
 * -쿼리스트링 전송(소용량)
 * -노출되어있음
 * -공유하기 좋음
 * 
 * post방식
 * -서버에 데이터를 올리기 위해 설계됨
 * -보안에는 유리, 공유에는 불리
 * -데이터 메세지의 body에 담아 전송
 * -글쓰기, 로그인, 회원가입
 * 
 */
