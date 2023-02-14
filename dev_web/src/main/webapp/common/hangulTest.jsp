<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 여기는 HTML땅 -->
<%
	//여기는 자바땅
	//localhost:9000/common/hangulTest.jsp?mem_name=고먀미
	//쿼리스트링으로 넘어오는 한글처리 -? server.xml문서 -> URLEncoding="UTF-8"
	String name = request.getParameter("mem_name");
	out.print(name);
%>
<!-- 여기는 HTML땅 -->