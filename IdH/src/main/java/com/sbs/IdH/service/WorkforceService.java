package com.sbs.IdH.service;

import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ChartVO;
import com.sbs.IdH.dto.WorkforceVO;

public interface WorkforceService {

	
	public void registWorkforce(WorkforceVO workforce) throws Exception;
	
	public void modifyWorkforce(WorkforceVO workforce) throws Exception;
	
	public void removeWorkforce(int workforce_number) throws Exception;
	
	public WorkforceVO selectWorkforce(int workforce_number) throws Exception;
	
	public Map<String,Object> selectWorkforceList(SearchCriteria cri) throws Exception;
	
	
	public ChartVO selectChart(int project_number)throws Exception;

	public ChartVO selectChartForComparison(int project_number, int project_number2)throws Exception;
	
	public void updateWorkforceForRegistProject(int workforce_number, int project_number)  throws Exception;
}
