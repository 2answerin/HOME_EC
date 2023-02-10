<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String menu = request.getParameter("menu"); //info or login or board or google
out.print(menu);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>짭네이버</title>
<style>
a {
	text-decoration: none;
}
</style>
</head>
<body>
  <!-- newDisplay에서 코드 가져옴 -->
  <script type="text/javascript">
    const autoReload = () => {
        $.ajax({
                type:"GET",
                url: "newsList.jsp",
                success: function(data){
                    //console.log(data);
                    $("#d_news").html(data)
                    },
                });
    }
</script>

  <!-- newDisplay에서 코드 가져옴 -->
  <script type="text/javascript">
    //호출하지 않아도 자동 실행
    //jquery(document)
    //window <- documnet <- ready(function(){실행문:변수선언, if문, switch문, i+j})함수 
        $(document).ready(() => { 
            //실행문
            start = () => {
                setInterval(autoReload, 2000); //일급함수
            } 
            //function start(){}
            start();
        })//end of ready - DOM을 다 읽었으면 실행
    </script>

	<!-- 태그는 중첩해서 사용 가능함 -->
	<!-- 크기는 % 로 주는 것이 좋다. 가변적이니까 -->
	<table border="1" align="center" width="1000px">
		<tr>
			<td width="100%" height="50px">
				<!--=================== top 시작 =================--> <%@ include
					file="top.jsp"%> <!--=================== top 끝 =================-->
			</td>
		</tr>
		<tr>
			<td>
				<!--=================== body 시작 =================-->
				<table>
					<tr>
						<!--=================== 메뉴 시작 =================-->
						<td width="200px" height="400px"><%@ include file="menu.jsp"%>
						</td>
						<!--=================== 메뉴 끝 ===================-->
						<td width="800px" height="400px">
							<%
							if (menu == null) {
							%> 
							<%@ include file="main.jsp"%>
							<%
							} else if ("info".equals(menu)) {
							%> <%@ include file="info.jsp"%>
							<%
				            }else if("login".equals(menu)){
				            %>
				            <%@ include file="login.jsp" %>
				            <%
				            }else if("board".equals(menu)){
				            %>   
				            <%@ include file="board.jsp" %>
				            <%
				            }else if("google".equals(menu)){
				             %>   
				            <%@ include file="google.jsp" %>
				            <%
				            }
				            %>   
							
						</td>
					</tr>
				</table> <!--=================== body 끝 =================-->
			</td>
		</tr>
		<tr>
			<td width="1000px" height="30px">
				<!--=================== bottom 시작 =================--> <%@ include
					file="bottom.jsp"%> <!--=================== bottom 끝 =================-->
			</td>
		</tr>
	</table>
</body>
</html>