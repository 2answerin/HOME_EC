<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//스크립틀릿 선언 - 자바영역
//<input type = "test" name = "mem_id">
String mem_id = request.getParameter("mem_id"); //여기에 사용되는 속성이 name
out.print("사용자가 입력한 아이디 => " + mem_id);//tomato 이것은 로컬이 아니라 브라우저 출력됨 (다른점 - 여기의 자바는 서블릿)

String mem_pw = request.getParameter("mem_pw");
out.print("비밀번호는 " + mem_pw);
%>