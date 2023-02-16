<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "java.util.Map, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MimeHtmlServlet2 응답페이지</title>
</head>
<body>
<h2>MimeHtmlServlet2 응답완료</h2>
<%
	String myName = null;
	myName = (String)session.getAttribute("myName");
	out.print(myName);
	Integer age = null;
	out.print("<hr>");
	age = (Integer)session.getAttribute("age");
	out.print(age);
	out.print("<hr>");
	//map을 불러오는 코드, import 해야됨
	Map<String,Object> rmap = (Map<String,Object>)session.getAttribute("rmap");
	if(rmap!=null){ //NullpointerException 방어코드
	Object keys[] = rmap.keySet().toArray();
	for(int i = 0; i<keys.length; i++){
		out.print(rmap.get(keys[i])+"<br/>");
		}
	}
	out.print("<hr>");
	//getAttribute의 리턴타입은 Object (getParameter의 리턴타입은 String)
	List<Map<String,Object>> mList = (List<Map<String,Object>>)session.getAttribute("mList");
	if(mList != null){
	for(int i =0; i<mList.size();i++){
		Map<String,Object> rMap = mList.get(i);
		out.print(rMap.get("mem_id")+","+rMap.get("mem_pw")+","+rMap.get("mem_name"));
	}
		
	}
%>
</body>
</html>