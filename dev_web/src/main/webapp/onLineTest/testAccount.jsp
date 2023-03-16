<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키 정보는 사용자 컴터에 저장되어 있음
	//그래서 서버는 요청을 해야함 - 사용자 컴터에세
	//서버는 사용자를 어떻게 구분하나요? - JSessoinID 발급 - 쿠키에 저장 - 쿠키값 기준으로 너를 알아봄
	String users[] = new String[5];

	Cookie cs[] = request.getCookies();
	int size = 0;
	size = cs.length;
	for(int i = 0;i<size;i++){
		String csname = cs[i].getName();
		if("testForm1".equals(csname)){
			users[0] = cs[0].getValue();
		}
		if("testForm2".equals(csname)){
			users[1] = cs[1].getValue();
		}
		if("testForm3".equals(csname)){
			users[2] = cs[2].getValue();
		}
		if("testForm4".equals(csname)){
			users[3] = cs[3].getValue();
		}
		if("testForm5".equals(csname)){
			users[4] = cs[4].getValue();
		}
	}

	//문제당 배점
	int jumsu = 20;
	//합격 기준 점수
	int pass = 60;
	//맞춘 개수
	int cnt = 0;
	//합격 여부
	boolean isPass = false;
	//정답표
	String daps[] = {"3","4","1","2","4"};
	
	//채점하는 로직 구현
	for(int i = 0; i<daps.length; i++){
		for(int j = 0; j<users.length; j++){
			if(daps[i].equals(users[j])){
				if(i==j){
					cnt++;
				}
			}
		}	
	}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
<script>
		const cookieDelete=()=>{
		event.preventDefault();
		location.href="cookieDelete.jsp";
	}
</script>
</head>
<body>
<h3>맞힌 문제 수 : <%=cnt %></h3>
<h2>점수 :  <%=cnt*jumsu %> 점</h2>
<div>
<!-- 리액트:onClick class > className 
	함수로 화면을 그린다
	함수 안에서 UI를 담당하는 예약어 : return
	리렌더링 - useState, props(주소번지를 넘김-이벤트핸들러 넘길 수 있음, state hook)
-->
<button onClick="cookieDelete()">쿠키삭제</button>
<%
	if((jumsu*cnt) >= pass){
		out.print("합격입니다");
	}else{
		out.print("불합격입니다");
	}
%>
</div>
</body>
</html>