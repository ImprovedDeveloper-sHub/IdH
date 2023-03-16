package com.sbs.IdH.service;

import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ChartVO;
import com.sbs.IdH.dto.UnitworkVO;

public interface UnitworkService {

	
	public void registUnitwork(UnitworkVO unitwork) throws Exception;
	
	public void registUnitworkPlan(UnitworkVO unitwork) throws Exception;
	
	public void modifyUnitwork(UnitworkVO unitwork) throws Exception;
	
	public void removeUnitwork(int unitwork_number) throws Exception;
	
	public UnitworkVO selectUnitwork(int unitwork_number) throws Exception;
	
	public Map<String,Object> selectUnitworkList(SearchCriteria cri) throws Exception;
	
	public ChartVO selectChart(int project_number) throws Exception;
	
	public ChartVO selectChartForComparison(int project_number1, int project_number2) throws Exception;
	
	public void updateUnitworkForRegistProject(int unitwork_number, int project_number)throws Exception;

}
