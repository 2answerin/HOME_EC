<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson"%>
<%
List<Map<String, Object>> memberList = new ArrayList<>();
Map<String, Object> map = new HashMap<>();
map.put("mem_id", "tomaot");
memberList.add(map);
map = new HashMap<>();
map.put("mem_id", "apple");
memberList.add(map);
map = new HashMap<>();
map.put("mem_id", "banana");
memberList.add(map);
//구글에서는 Gson.jar 라이브러리 지원
Gson g = new Gson();
String temp = g.toJson(memberList);
//out.prtint(temp);
//아래와 같이 자료구조를 줄력하면 JSON포맷 아님 - 자바스크립트에서 읽을 수 없음, 조회결과 없음
out.print(memberList);
%>