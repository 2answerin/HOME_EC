<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
   확장자는 jsp이지만 마임타입은 html이다.
   브라우저는 이 파일을 html문서로 판단함
   왜냐하면 1번 page 다이렉티브에 contentType에 설정된 마임 타입 때문
   실행함 - URL주소에 해당페이지를 요청하면
   c.jsp -> (jsp-api.jar:jsp엔진,jsp컨테이너,톰캣에 있음) -> c_jsp.java로 변경됨 -> (setvlet-api.jar:서블릿엔진)
    -> c_jsp.class로 변경됨 -> out.print() out은 jsp가 제공하는 내장객체 - dos창이 아닌 브라우저에 사용
    -> 자바스크립트와 같은 원리로 자바이지만 브라우저에서도 동작이 가능
 -->

<script>
document.write("<b>굵은 글씨</b>");
</script>

<!-- 
   test/html문서 전체를 받는 객체가 document
 -->