<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp[WEB-INF]</title>
</head>
<body>
b.jsp 페이지 입니다
</body>
</html>
<!-- 
WEB-INF 아래있는 jsp페이지는 절대로 본인 URL접근이 불가능
반드시 서블릿을 경유하여 RequestDispatcher를 사용하여 요청하자!
그러면 WEB-INF아래있는 경로여도 페이지 호출 가능
다만 scope는 request scope를 갖게된다는 점을 주의
 -->