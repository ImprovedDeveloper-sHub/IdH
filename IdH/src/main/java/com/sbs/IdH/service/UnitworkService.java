package com.sbs.IdH.service;

import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.UnitworkVO;

public interface UnitworkService {

	
	public void registUnitwork(UnitworkVO unitwork) throws Exception;
	
	public void updateUnitwork(UnitworkVO unitwork) throws Exception;
	
	public void removeUnitwork(int unitwork_number) throws Exception;
	
	public UnitworkVO selectUnitwork(int unitwork_number) throws Exception;
	
	public Map<String,Object> selectUnitworkList(SearchCriteria cri) throws Exception;
	
}
