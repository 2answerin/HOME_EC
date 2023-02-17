<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		String smem_id = (String)session.getAttribute("smem_id");
		String smem_name = (String)session.getAttribute("smem_name");
		out.print("세션에서 꺼내온 값 ==> " +smem_id+","+smem_name);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Application</title>
<%@include file="../common/easyUI_common.jsp"%>
<style type="text/css">
a{
	text-decoration: none;
}
</style>
<script type="text/javascript">
const login = () => {
	/* 
	테스트 :com.mvc.dao.Member.xml
	xml : com.mybatis.mapper에 member.xml
	SELECT mem_name FROM book_member
	 WHERE mem_id =: id
	   AND mem_pw =: pw */
	   
	   //사용자가 입력한 아이디 가져오기
	   const userid = $("#_easyui_textbox_input1").val();
	   //사용자가 입력한 비밀번호 가져오기
	   const userpw = $("#_easyui_textbox_input2").val();
	   alert(userid + userpw);
}
</script>
</head>
<body>
	<h2>Fluid Layout</h2>
	<p>Percentage width of region panel in a layout.</p>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 1000px; height: 550px;">
		<!-- 메뉴 구성 [로그인화면과 트리메뉴] -->
		<div id="p" data-options="region:'west'" title="West"
			style="width: 200px; padding: 10px">
			<!-- ==================[[ 로그인 화면 ]]================== -->
			<div id="d_login" align="center">
				<input id="tb_id" type="text" style="width: 130px">
				<script>
					$('#tb_id').textbox({
						iconCls : 'icon-man',
						iconAlign : 'right',
						prompt : '아이디'
					})
				</script>
				<div style="margin: 5px 0;"></div>
				<input id="pb_pw" type="text" style="width: 130px">
				<script>
					$('#pb_pw').passwordbox({
						prompt : 'Password',
						showEye : true
					});
				</script>
				<div style="margin: 3px 0;"></div>
				<a id="btn_login" href="javascript:login()">로그인</a>
				<script>
					$('#btn_login').linkbutton({
						iconCls : 'icon-man'
					});
				</script>
				<a id="btn_member" href="javascript:memberShip()">회원가입</a>
				<script>
					$('#btn_member').linkbutton({
						iconCls : 'icon-add'
					});
				</script>
			</div>
			<!-- ==================[[ 로그아웃 화면 ]]================== -->
			<div id="d_logout" align="center"></div>
			<!-- 메뉴 구성 [로그인화면, 트리메뉴] -->
			<div style="margin: 3px 0;"></div>
			<ul id="tre_menu" class="easyui-tree">
				<li data-options="state:'closed'">
				<span>친구관리</span>
					<ul>
						<li><a href="#">친구목록</a></li>
						<li><a href="#">친구등록</a></li>
						<li><a href="#">친구삭제</a></li>

			</ul>
			</li>
				<li data-options="state:'closed'">
				<span>쪽지관리</span>
					<ul>
					<li><a href="#">받은쪽지함</a></li>
					<li><a href="#">보낸쪽지함</a></li>
					</ul>
					</li>
				<li data-options="state:'closed'">
				<span>기타</span>
					<ul>
					<li><a href="#">우편번호검색기</a></li>
					<li><a href="#">방명록</a></li>
					</ul>
					</li>
					</ul>
		</div>
		<!-- 메뉴 화면 [게시판, 온라인시험, 쪽지관리(받은,보낸쪽지함), 회원관리(회원목록,회원등록,회원삭제), 우편번호검색기] -->
		<div data-options="region:'center'" title="Center"></div>
		<!-- 메뉴 화면 [게시판, 온라인시험, 회원관리, 우편번호검색기] -->
	</div>
</body>
</html>
<!-- 
	부트스트랩 - 리액트 - 스프링, 리액트 연계 - 프로젝트 적용
	반응형지원, CSS라이브러리사용
	jEasyUI
	이벤트처리(jquery)
	
	로그인 테스트 흐름도
	1. intro 아래 index.jsp실행
	2. 아이디와 비밀번호를 입력받음
	3. 로그인버튼을 누른다 -> 자바스크립트 login()호출
	4. login.do호출 -> 로그인 처리를 하는 서블릿 호출 - doGet(), doPost()
	5. com.mvc.dao.MemberDao클래스의 인스턴스화
	6. 메소드 호출 - 로그인 처리
	7. MemberDao의 login(Map[(사용자가 입력한)mem_id와 mem_pw있음)메소드 호출
	8. 리턴타입으로 Map을 받아옴(mem_id, mem_name)
	9. 8번에서 돌려받은 Map을 오라클서버에서 조회된 아이디와 이름을 세션에 담기
	10. 페이지 이동은 SendRedirect나 forward 가능
	단, forward로 응답을 처리한 경우 인증 후 다른서비스를 forward로 처리하는 것이 불가능 - 주의
 -->