<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax로 요청하기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
	<script type="text/javascript">
		function methodA() {
			alert("methodA 호출")
			let pic = 5;
			$.ajax({
				type : "get",
				url : "b.jsp?id=" + pic + "$timestamp="
						+ new Date().getTime,
				dataType : "html",
				success : function(result) {
					console.log(result)
					$("#d_pic").html(result);
				},
			});
		}
	</script>
<body onLoad="methodA()">
</body>
<div id = "d_pic">5</div>
</html>