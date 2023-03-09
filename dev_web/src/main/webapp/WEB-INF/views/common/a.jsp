<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1</h2>
<jsp:include page="b.jsp" />
<h2>include 다음</h2>
</body>
</html>
<!-- 
a.jsp 페이지 출력하다가 jsp include 만나면 그 자리에 b.jsp 페이지의 출력 내용 포함

a.jsp에는 자바 코드와 html 코드 둘 다 사용 가능
자바 코드는 어떻게 브라우저에서 실행 ??
; document.write("<b>굵은 글씨</b>");

자바 스크립트만으로도 화면 구성 가능
 -->