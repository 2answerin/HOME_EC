<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, java.util.Map"%>
<%
List<Map<String, Object>> zList = (List<Map<String, Object>>) request.getAttribute("zList");
if (zList != null) {
   for (int i = 0; i < zList.size(); i++) {
      out.print(zList.get(i));
   }
} else {
   out.print("zList가 null입니다.");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
</head>
<body>
	우편번호 검색
</body>
</html>