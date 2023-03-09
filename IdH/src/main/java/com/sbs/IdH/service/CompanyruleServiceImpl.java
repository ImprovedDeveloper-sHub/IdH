package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.CompanyruleDAO;
import com.sbs.IdH.dto.CompanyruleVO;
import com.sbs.IdH.dto.CoworkVO;

public class CompanyruleServiceImpl implements CompanyruleService {

	private CompanyruleDAO companyruleDAO;

	public void setCompanyruleDAO(CompanyruleDAO companyruleDAO) {
		this.companyruleDAO = companyruleDAO;
	}

	@Override
	public Map<String, Object> selectCompanyruleList(SearchCriteria cri) throws SQLException {
		List<CompanyruleVO> companyruleList = companyruleDAO.selectCompanyruleCriteria(cri);
		if (companyruleList != null)
			for (CompanyruleVO companyrule : companyruleList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(companyruleDAO.selectCompanyruleCriteriaTotalCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("companyruleList", companyruleList);
		dataMap.put("pageMaker", pageMaker);
		System.out.println(companyruleList.get(0));
		return dataMap;

	}

	@Override
	public void registCompanyrule(CompanyruleVO companyrule) throws SQLException {
		int companyrule_number = companyruleDAO.selectCompanySeqNextValue();
		companyrule.setCompanyrule_number(companyrule_number);
		companyruleDAO.insertCompanyrule(companyrule);

	}

	@Override
	public CompanyruleVO readCompanyrule(int companyrule_number) throws SQLException {
		CompanyruleVO companyrule = companyruleDAO.selectCompanyrule(companyrule_number);
		companyruleDAO.increaseViewCnt(companyrule_number);

		return companyrule;

	}

	@Override
	public CompanyruleVO selectCompanyrule(int companyrule_number) throws SQLException {
		CompanyruleVO companyrule = companyruleDAO.selectCompanyrule(companyrule_number);

		return companyrule;
	}

	@Override
	public void modifyCompanyrule(CompanyruleVO companyrule_number) throws SQLException {
		companyruleDAO.updateCompanyrule(companyrule_number);
	}

	@Override
	public void removeCompanyrule(int companyrule_number) throws SQLException {
		companyruleDAO.deleteCompanyrule(companyrule_number);
	}

}
