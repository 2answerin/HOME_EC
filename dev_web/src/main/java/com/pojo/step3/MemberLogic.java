package com.pojo.step3;

import java.util.Map;

import org.apache.log4j.Logger;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao memberDao = new MemberDao();

	public Map<String, Object> login(Map<String, Object> pMap) {
		Map<String, Object> rMap = null; //rMap 조회결과
		
		rMap = memberDao.login(pMap); //pMap 사용자 아이디, 비번
		return rMap;
	}
}
