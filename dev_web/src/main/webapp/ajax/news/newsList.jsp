<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    int x = 1; //전변 선언하기
    public String newstitle(String[] news){
    	StringBuilder sb = new StringBuilder();
    	for(int i =0; i<news.length; i++){
    		if(i == (x-1)){
    	sb.append("<table width = '700x' border ='1px'>");
    	sb.append("<tr><td>"+ news[i] +"</td></tr>");
    	sb.append("</table>");
    }
    } //end of newstitle
    	String choice = sb.toString();
    	return choice;
    }
    %>
<%
//스크립틀릿 - 자바 땅
String news[] = {"'재벌2세 이다빈' 사실 '폰재벌2세'로 밝혀져",
		"KH정보교육원 여은경 학생 알고보니 '일본인 아이돌 출신' 남편 있어",
		"[속보] 배구황제 김연경 만난지 오래된 연인이 있다고 밝혀..",
		"2022년 올스타전 MVP 보쿠토 코타로, 세레머니로 여자친구 암시?",
		"요즘 주목받고 있는 천재고양이 이우주, 어제 꾹꾹이 했다?!"};
String data ="";
switch(x){
case 1:
	data = newstitle(news);
  x++;
  break;
case 2:
	data = newstitle(news);
  x++;
  break;
case 3:
	data = newstitle(news);
  x++;
  break;
case 4:
	data = newstitle(news);
  x++;
  break;
case 5:
	data = newstitle(news);
  x=1;
  break;
} //end of switch
//기존에 읽어온 기사정보 지우기
out.clear();
out.print(data);
%>