<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서관리2</title>
<%@ include file = "../../common/easyUI_common.jsp" %>
</head>
<body>
<table>
<script type="text/javascript">
	window.addEventListener("load", function(event) {
		
	//jquery에서 제공하는 ready함수 - 돔 구성이 되었을 때
		$('#dg').datagrid({
			title:"부서관리",
		    url:'datagrid_data.json',
		    columns:[[
		        {field:'deptno',title:'부서번호',width:100},
		        {field:'dname',title:'부서명',width:100},
		        {field:'loc',title:'지역',width:100,align:'right'}
   			 ]]
		})
	});
</script>
<table id = "dg"></table>
</body>
</html>