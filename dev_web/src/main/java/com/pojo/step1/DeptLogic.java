package com.pojo.step1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
	public List<Map<String, Object>> getDeptList() {
		logger.info("getDeptList호출");
		List<Map<String,Object>> deptList = new ArrayList<>();
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("deptno", 10);
		rmap.put("dename", "강아지발부");
		rmap.put("loc", "강아지나라");
		deptList.add(rmap);
		rmap.put("deptno", 20);
		rmap.put("dename", "고양이발부");
		rmap.put("loc", "고양이나라");
		deptList.add(rmap);
		rmap.put("deptno", 30);
		rmap.put("dename", "우주발부");
		rmap.put("loc", "우주나라");
		deptList.add(rmap);
		return deptList;
	}

	public String jsonDeptList() {
		logger.info("jsonDeptList호출");
		List<Map<String,Object>> deptList = new ArrayList<>();
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("deptno", 10);
		rmap.put("dename", "강아지발부");
		rmap.put("loc", "강아지나라");
		deptList.add(rmap);
		rmap.put("deptno", 20);
		rmap.put("dename", "고양이발부");
		rmap.put("loc", "고양이나라");
		deptList.add(rmap);
		rmap.put("deptno", 30);
		rmap.put("dename", "우주발부");
		rmap.put("loc", "우주나라");
		deptList.add(rmap);
		Gson g = new Gson();
		String temp = g.toJson(deptList);
		return temp; //JSON포맷으로 전달 - 리액트에서 조회시 사용
	}
	
	public int deptInsert() {
		logger.info("deptInsert호출");
		return 0;
	}

	public int deptUpdate() {
		logger.info("deptUpdate호출");
		return 0;
	}

	public int deptDelete() {
		logger.info("deptDelete호출");
		return 0;
	}

}
