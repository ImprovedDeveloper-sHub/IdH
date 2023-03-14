package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.WorkDAO;
import com.sbs.IdH.dto.WorkVO;

public class WorkServiceImpl implements WorkService{
	private WorkDAO workDAO;
	public void setWorkDAO(WorkDAO workDAO) {
		this.workDAO = workDAO;
	}
	//작성자 리스트
	@Override
	public Map<String, Object> selectWorkListByWriter(HttpServletRequest request,SearchCriteria cri) throws SQLException {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("loginUser");
		cri.setMember_id(userid);
		cri.setMemberStatus(1);
		List<WorkVO>workListByWriter = workDAO.selectSearchWorkList(cri);
		if(workListByWriter != null) {
			for(WorkVO work : workListByWriter);
		}
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(workDAO.selectWorkCriteriaTotalCount(cri));
		
		Map<String,Object>dataMap = new HashMap<String,Object>();
		dataMap.put("workListByWriter",workListByWriter);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}
	
	//결제자 리스트
		@Override
		public Map<String, Object> selectWorkListByApprover(HttpServletRequest request,SearchCriteria cri) throws SQLException {
			HttpSession session = request.getSession();
			String userid = (String)session.getAttribute("loginUser");
			cri.setMember_id(userid);
			cri.setMemberStatus(2);
			List<WorkVO>workListByApprover = workDAO.selectSearchWorkList(cri);
			if(workListByApprover != null) {
				for(WorkVO work : workListByApprover);
			}
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(workDAO.selectWorkCriteriaTotalCount(cri));
			
			Map<String,Object>dataMap = new HashMap<String,Object>();
			dataMap.put("workListByApprover",workListByApprover);
			dataMap.put("pageMaker",pageMaker);
			
			return dataMap;
		}

	@Override
	public void registWork(WorkVO work) throws SQLException {
		work.setWork_number(2);
		workDAO.insertWork(work);
	}
	

	@Override
	public WorkVO selectWork(int work_number) throws SQLException {
		WorkVO work = workDAO.selectWorkByWork_Number(work_number);
		return work;
	}

	@Override
	public void modifyWork(WorkVO work) throws SQLException {
		workDAO.updateWork(work);
		
	}

	@Override
	public void removeWork(int work_number) throws SQLException {
		workDAO.deleteWork(work_number);
		
	}
}
