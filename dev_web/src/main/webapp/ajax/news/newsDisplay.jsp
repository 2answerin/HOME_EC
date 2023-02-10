<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script>
	const autoReload = () => {
		console.log('autoReload 호출')
		//ajax함수는 jquery.min.js가 제공하는 api이다
		//ajax함수는 결국 XMLHttpRequest대신함
		//const ajax = new XMLHttpRequest();
		//ajax.open("GET", url, ture) ture는 비동기
		//ajax.send()
	 $.ajax({
          type: "GET",
          url: "newsList.jsp",
          success: function (data) { //성공했을 때
            $("#d_news").html(data) /* d_news 는 DOM */
          },
          error:function(request, status, error){
        	  console.log('error!!!!!!!!!!')
        	  console.log('error'+request.status)
        	  console.log('error'+request.responseText)
          }
        });
	}
</script>
</head>
<body>
	<script type="text/javascript">
	autoReload()
	//호출하지 않아도 자동실행
	//jquery(document)
	//window <- document <- ready(function(){실행문:변수선언,if문,switch문,i+j}) 함수
	$(document).ready(()=> {
		//실행문
		start = () => {
		setInterval(autoReload,2000);
		}
		start();
	}) //DOM 다 읽었으면 실행해줘
	
</script>
	<div id="d_news">뉴진스 준비중 ...</div> <!-- DOM 선언 -->
	<%
	out.print("<font color = 'red' size = 14>뉴진스의 하입보이요</font>");
	%>
</body>
</html>

<!-- 
html은 순차적으로 실행
자바스크립트 코드 위치에 따라서 document.querySelector(id or class or ele)
:선언이 먼저
자바스크립트 위치
1)head안에 - 전변선언, 함수선언할 때(호출해야 실행됨)

2)body안에 - 호출되지 않아도 실행됨(함수로 선언된 부분 제외)

 -->