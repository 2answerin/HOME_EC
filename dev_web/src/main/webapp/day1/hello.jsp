<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="f_test" method="get" action="/day1/hello.kh">
<input type="button" id="btnSend" value="전송">
<script type="text/javascript">
	const btnSend = document.querySelector("#btnSend");
	btnSend.addEventListener('click',() =>{
		alert("전송")
		document.querySelector("#f_test").submit()
	})
</script> 
</form>
</body>
</html>

<!-- method방식이 get이냐 post냐에 따라 이동하는 페이지가 다름(출력되는 화면) -->