package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//javascropt기반의 UI API
//바닐라 스트립트
//리액트 = 바닐라스크립트 + ES6(주요이슈 - spread, module, arrow), ES7 + html 섞어쓰기

//Controller3을 implements하는 클래스가 여러개 있다.
//Board3Controller, CommonController, MemberController
public interface Controller3 {
	public Object login(HttpServletRequest req, HttpServletResponse res);
	public Object logout(HttpServletRequest req, HttpServletResponse res);
	public Object zipcodeList(HttpServletRequest req, HttpServletResponse res);
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res);
	public Object imageGet(HttpServletRequest req, HttpServletResponse res);
	public Object imageDownload(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException;
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException;
}