package com.pojo.step1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DeptController implements Action {
Logger logger = Logger.getLogger(DeptController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ActionForward af = new ActionForward();
		//아래는 FrontMVC클래스에서 request 객체에 저장된 배열을 꺼내는 코드
		String upmu[] = (String[])req.getAttribute("upmu");
		DeptLogic deptLogic = new DeptLogic();
		String path = null;
		boolean isRedirect = false;
		//너 부서목록 조회하려고?
		if("getDeptList".equals(upmu[1])) {
			List<Map<String,Object>> deptList = deptLogic.getDeptList();
			req.setAttribute("deptList", deptList);
			//응답페이지 이름 결정
			path = "getDeptList.jsp";
			//redirect로 할지 forward로 할지 결정
			isRedirect = false; //false 이면 forward - 요청이 유지 - 주소창은 그대로, 페이지는 변경됨
		}
		else if("jsonDeptList".equals(upmu[1])) {
			String jsonDoc = deptLogic.jsonDeptList();
			req.setAttribute("jsonDoc", jsonDoc);
			path = "jsonDeptList.jsp";
			isRedirect = false; //false 이면 forward - 요청이 유지 - 주소창은 그대로, 페이지는 변경됨
		}
		//너 부서등록 하려고?
		else if("deptInsert".equals(upmu[1])) {
			//insert into dept(deptno, dname, loc) values(?,?,?)
			int result = deptLogic.deptInsert();
		}
		//너 부서정보 수정하려고?
		else if("deptUpdate".equals(upmu[1])) {
			int result = deptLogic.deptUpdate();
		}
		//너희 부서 없어졌다
		else if("deptDelete".equals(upmu[1])) {
			int result = deptLogic.deptDelete();
		}
		af.setPath(path);
		af.setRedirect(isRedirect);
		
		return af;
	}
	public ActionForward getDeptList() {
		return null;
		//res가 없으면 res.sendRedirect()가 없음
		//web.xml에 *st1이 있음 - 확장자가 있어야함 - 경유
	}
}
