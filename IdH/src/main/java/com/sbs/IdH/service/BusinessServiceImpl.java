package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.DateMaker;
import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.BudgetDAO;
import com.sbs.IdH.dao.BusinessDAO;
import com.sbs.IdH.dao.Business_attachDAO;
import com.sbs.IdH.dao.BusinessgroupDAO;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dao.WorkforceDAO;
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.Business_attachVO;
import com.sbs.IdH.dto.BusinessgroupVO;
import com.sbs.IdH.dto.WorkforceVO;

public class BusinessServiceImpl implements BusinessService {
	
	private BusinessDAO businessDAO;
	
	public void setBusinessDAO(BusinessDAO businessDAO) {
		this.businessDAO = businessDAO;
	}
	
	private BusinessgroupDAO businessgroupDAO;
	
	public void setBusinessgroupDAO(BusinessgroupDAO businessgroupDAO) {
		this.businessgroupDAO = businessgroupDAO;
	}
	
	private Business_attachDAO business_attachDAO;
	
	public void setBusiness_attachDAO(Business_attachDAO business_attachDAO) {
		this.business_attachDAO = business_attachDAO;
	}
	
	private WorkforceDAO workforceDAO;
	
	public void setWorkforceDAO(WorkforceDAO workforceDAO) {
		this.workforceDAO = workforceDAO;
	}
	
	private BudgetDAO budgetDAO;
	
	public void setBudgetDAO(BudgetDAO budgetDAO) {
		this.budgetDAO = budgetDAO;
	}
	
	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	private void addBusiness_attachList(BusinessVO business) throws SQLException {
		
		if (business == null) {return;}
		
		int business_number = business.getBusiness_number();
		
		List<Business_attachVO> business_attachList = business_attachDAO.selectAllBusiness_attachByBusiness_number(business_number);
		
		business.setBusiness_attachList(business_attachList);
		
	}
	
	@Override
	public Map<String, Object> getBusinessList(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<BusinessVO> businessList = businessDAO.selectBusinessCriteria(cri);
		
		if (businessList != null) {
			for (BusinessVO business : businessList) {
				addBusiness_attachList(business);
				business.setBusiness_usebudget((int)(selectBusinessBudgetList(business.getBusiness_number()).get("use_total")));
			}
		}
		
		int totalCount = businessDAO.selectBusinessCriteriaTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("businessList", businessList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
		
	}
	
	@Override
	public Map<String, Object> getWorkforceOfBusinessList(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<BusinessVO> businessList = businessDAO.selectBusinessCriteria(cri);
		
		if (businessList != null) {
			for (BusinessVO business : businessList) {
				addBusiness_attachList(business);
			}
		}
		
		for (BusinessVO business : businessList) {
			
			List<WorkforceVO> workforceList = workforceDAO.selectSearchWorkforceList(cri);
			List<String> business_workforce_member_id = new ArrayList<String>();
			
			for (WorkforceVO workforce : workforceList) {
				business_workforce_member_id.add(workforce.getWorkforce_member_id());
			}
			
			business.setBusiness_workforce_member_id(business_workforce_member_id);
			
		}
		
		int totalCount = businessDAO.selectBusinessCriteriaTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("businessList", businessList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
		
	}
	
	@Override
	public BusinessVO getBusiness(int business_number) throws SQLException {
		
//		Map<String, Object> dataMap = new HashMap<String, Object>();
//		String businessMember = businessDAO.selectBusiness_number(business_number).getBusiness_member_id();
		
		BusinessVO business = businessDAO.selectBusiness_number(business_number);
		business.setBusiness_usebudget((int)(selectBusinessBudgetList(business.getBusiness_number()).get("use_total")));
		
//		dataMap.put(businessMember, businessMember);
//		dataMap.put("business", business);
		
		return business;
		
	}
	
	@Override
	public BusinessVO getBusinessTeamLeader(int business_number) throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		cri.setType(2);
		
		
		BusinessVO business = businessDAO.selectBusiness_number(business_number);
		addBusiness_attachList(business);
		
		
		List<String> business_workforce_member_id = new ArrayList<String>();
		
		List<WorkforceVO> workforceList = workforceDAO.selectSearchWorkforceList(cri);
		for (WorkforceVO workforce : workforceList) {
			business_workforce_member_id.add(workforce.getWorkforce_member_id());
		}
			business.setBusiness_workforce_member_id(business_workforce_member_id);
//		dataMap.put(businessMember, businessMember);
//		dataMap.put("business", business);
		
		return business;
		
	}
	
	@Override
	public BusinessVO getBusinessForModify(int business_number) throws SQLException {
		
		BusinessVO business = businessDAO.selectBusiness_number(business_number);
		
		return business;
		
	}
	
	@Override
	public void regist(BusinessVO business) throws SQLException {
		
		int business_number = businessDAO.selectBusinessSequenceNextValue();
		
		business.setBusiness_number(business_number);
		
		businessDAO.insertBusiness(business);
		
	}

	@Override
	public void modify(BusinessVO business) throws SQLException {
		
		businessDAO.updateBusiness(business);
		
	}
	
	@Override
	public void modifyForBudget(BusinessVO business) throws SQLException {
		
		businessDAO.updateBusiness_budget(business);
		
	}
	
	@Override
	public void modifyForGroup(BusinessgroupVO businessgroup) throws SQLException {
		
		businessgroupDAO.updateBusinessgroup(businessgroup);
		
	}
	
	@Override
	public void remove(int business_number) throws SQLException {
		
		businessDAO.deleteBusiness(business_number);
		
	}

	@Override
	public Business_attachVO getBusiness_attachByAno(int ano) throws SQLException {
		
		Business_attachVO business_attach = business_attachDAO.selectBusiness_attachByAno(ano);
		
		return business_attach;
		
	}

	@Override
	public void removeBusiness_attachByAno(int ano) throws SQLException {
		
		business_attachDAO.deleteBusiness_attach(ano);
		
	}
	
	//추가 시작
	
	@Override
	public Map<String, Object> getBusinessListNotRowBound(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("businessList",businessDAO.selectBusinessCriteriaNotRowBound(cri));
		return dataMap;
	}
	
	@Override
	public Map<String, Object> getBusinessgroupListForModify(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<BusinessVO> businessgroupList = businessgroupDAO.selectSearchBusinessgroupList(cri);
		
		dataMap.put("businessgorupList", businessgroupList);
		
		return dataMap;
		
	}
	
	@Override
	   public List<Map<String,Object>> selectBusinessScheduleListForCalendar(SearchCriteria cri) throws Exception {
	      DateMaker dateMaker = new DateMaker();
	      List<BusinessVO> businessList = businessDAO.selectBusinessCriteria(cri);
	      for(BusinessVO business : businessList) {
	         dateMaker.setParamBusinessSchedule(business);
	      }
	      return dateMaker.getParamList();
	   }
	
	//추가 종료
	
	
	
	@Override
	public Map<String, Object> selectBusinessBudgetList(int business_number) throws SQLException {
		Map<String,Object>dataMap = new HashMap<String,Object>();
		
		int human_budget = 0;
		int fixtures_budget = 0;
		int transportation_budget = 0;
		int meal_budget = 0;
		int use_total = 0;
		List<Integer> project_numberList =  projectDAO.selectProjectByBusinessNumber(business_number);
		
		for(Integer project_number : project_numberList) {
			List<BudgetVO> budgetList = budgetDAO.selectSearchBudgetListForProject(project_number);
			for(BudgetVO budget : budgetList) {
				int type = budget.getBudget_type();
				if(type == 1 ) 
					human_budget += budget.getBudget_price();
				else if(type == 2 ) 
					fixtures_budget += budget.getBudget_price();
				else if(type == 3 ) 
					transportation_budget += budget.getBudget_price();
				else if(type == 4 ) 
					meal_budget += budget.getBudget_price();
				
			}
			
		}
		use_total += human_budget;
		use_total += fixtures_budget;
		use_total += transportation_budget;
		use_total += meal_budget;
		
		dataMap.put("human_budget",human_budget);
		dataMap.put("fixtures_budget",fixtures_budget);
		dataMap.put("transportation_budget",transportation_budget);
		dataMap.put("meal_budget",meal_budget);
		dataMap.put("use_total",use_total);
		
		return dataMap;
	}
	
	@Override
	public List<Map<String, Object>> selectBusinessListForCalendar(SearchCriteria cri) throws Exception {
		DateMaker dateMaker = new DateMaker();
		List<BusinessVO> businessList = businessDAO.selectBusinessCriteriaNotRowBound(cri);
		for (BusinessVO business : businessList) {
			dateMaker.setParamBusiness(business);
		}
		return dateMaker.getParamList();
	}
	
}
