package com.pojo.step1;

public class ActionForward {
	// 페이지 이동 방법
	// 1 res.sendRedirect("XXX.jsp):표준 서블릿이 요청 받음 <- MVC 패턴 Xxx
	//   res.sendRedirect("dept/getDeptList.kh"):서블릿이 요청 받음 <- MVC 패턴 Oooo
	// jsp가 요청 받는 것이 왜 문제 ??? WAS마다 명명규칙이 다르기 때문에 인스턴스화를 할 수 없다
	// 인스턴스화를 한다고 하더라도 request와 response 객체를 주입 받지 못하는 장애 발생 ; mimetype 결정 Xxxㅡ
	private String path  = null; // path == 응답 페이지의 이름 또는 서블릿의 이름이 와야함
	// sendRedirect로 페이지 이동 ? 아니면 forward로 페이지 이동할 것인지 여부 결정
	private boolean isRedirect = false; // true:redirect(insert|update|delete), false:forward(select)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
/*
ActionForward 클래스를 만드는 이유 ??
웹 서비스에서는 main 메서드 대신에 URL로 요청 보냄
누가 ? 클라이언트가
누구에게 ? 톰캣 서버에게
요청 시에 URL을 사용
 */