<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HTML 영역 -->
<% // 스크립틀릿
// 자바 영역(자바 코딩이 가능한 위치) ; 스크립틀릿
// localhost:9000/common/hangelTest.jsp?mem_name=김태연
// 쿼리스트링으로 넘어오는 한글 처리(GET방식) > server.xml문서 > URLEncoding = "UTF-8"
String name = request.getParameter("mem_name");
out.print(name); // null
%>
<!-- HTML 영역 --> 