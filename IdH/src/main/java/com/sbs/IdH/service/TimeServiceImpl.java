package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sbs.IdH.dao.TimeDAO;
import com.sbs.IdH.dto.MemberVO;

public class TimeServiceImpl implements TimeService {

	
	private TimeDAO timeDAO;
	
	public void setTimeDAO(TimeDAO timeDAO) {
		this.timeDAO = timeDAO;
	}
	
	@Override
	public Map<String, Object> selectTimeList(HttpServletRequest request) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		MemberVO member = (MemberVO)request.getSession().getAttribute("loginUser");
		dataMap.put("timeList",timeDAO.selectTimeList(member.getMember_id()));
		return dataMap;
	}

	
	
	
	
	
	

}
