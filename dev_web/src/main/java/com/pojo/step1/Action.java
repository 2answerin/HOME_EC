package com.pojo.step1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 클래스 설계에 인터페이스 필요
// 인터페이스 중심의 코딩 전개하는 것이 결합도를 낮춤 ; 의존성 낮다 -> 단위 테스트를 가능하게 해 줌으로서 신뢰도를 높이는 코드

// HttpServlet에서 강제(Override: doGet, doPost)하는 void를 다른 타입으로 바꾸어 사용해 보자
// 아래와 같이 void 변경하였지만 파라미터 자리의 req, res는 개발자가 인스턴스화 하는 것이 아니고 톰캣이 주입
// 이러한 문제를 어떻게 해결하는지 관전 포인트로 삼자
public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}
