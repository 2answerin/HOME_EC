<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="root"></div>
  <script
    crossorigin
    src="https://unpkg.com/react@18/umd/react.development.js"
  ></script>
  <script
    crossorigin
    src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"
  ></script>
  <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script type="text/babel">
	const rootElement = document.querySelector("#root");
		//h1Element.textContent = "DOM Make"; 같은 효과
		//React는 react.development.js에서 참조하는 객체
	const h1Element = React.createElement("h1",{children:"DOM Make"});
		//Client side rendering시 앞에가 주입할 대상, 뒤에가 root위치
		//rootElement.appendChild(h1Element);
		//react-dom.deveolpment.js에서 참조하는 객체
	ReactDOM.createRoot(rootElement).render(h1Element);
</script>
</body>
</html>

<!-- 
확장자는 jsp이지만 mime type이 html이므로 html문서다

바닐라 스크립트는 순수한 자바스크립트를 말함
특정 라이브러리나 프레임워크를 사용하지 않는 자바스크립트 그 자체

샌드박스 - playground
코드샌드박스 - React등 다양한 환경에 대한 기본 설정이 다 되어있음
 -->