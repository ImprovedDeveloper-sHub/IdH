package com.sbs.IdH.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface TimeService {

	Map<String, Object> selectTimeList(HttpServletRequest request) throws Exception;
	
}
