package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.WorkreportDAO;
import com.sbs.IdH.dao.Workreport_AttachDAO;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.dto.WorkreportVO;
import com.sbs.IdH.dto.Workreport_AttachVO;

public class WorkreportServiceImpl implements WorkreportService{
	private WorkreportDAO workreportDAO;
	public void setWorkreportDAO(WorkreportDAO workreportDAO) {
		this.workreportDAO = workreportDAO;
	}
	private Workreport_AttachDAO workreport_attachDAO;
	public void setWorkreport_AttachDAO(Workreport_AttachDAO workreport_attachDAO) {
		this.workreport_attachDAO = workreport_attachDAO;
	}

	@Override
	public Map<String, Object> selectWorkreportList(SearchCriteria cri) throws SQLException {
		List<WorkreportVO>workreportList = workreportDAO.selectSearchWorkreportList(cri);
		if(workreportList != null) {
			for(WorkreportVO workreport : workreportList) {
				addAttachList(workreport);				
			}
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(workreportDAO.selectWorkreportCriteriaTotalCount(cri));
		
		Map<String,Object>dataMap = new HashMap<String,Object>();
		dataMap.put("workreportList",workreportList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}
	

	@Override
	public void registWorkreport(WorkreportVO workreport) throws SQLException {
		workreport.setWorkreport_number(2);
		workreportDAO.insertWorkreport(workreport);
	}
	

	@Override
	public WorkreportVO selectWorkreport(int workreport_number) throws SQLException {
		WorkreportVO workreport = workreportDAO.selectWorkreportByWorkreport_Number(workreport_number);
		return workreport;
	}

	@Override
	public void modifyWorkreport(WorkreportVO workreport) throws SQLException {
		workreportDAO.updateWorkreport(workreport);
		
	}

	@Override
	public void removeWorkreport(int workreport_number) throws SQLException {
		workreportDAO.deleteWorkreport(workreport_number);
		
	}
	
	@Override
	public Map<String, Object> selectMyWorkreportList(SearchCriteria cri, HttpServletRequest request) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		cri.setMember_id(member.getMember_id());
		cri.setMemberStatus(1);
		dataMap.put("myWorkreportList", workreportDAO.selectSearchWorkreportList(cri));
		return dataMap;
	}
	
	@Override
	public Map<String, Object> selectGetterWorkreportList(SearchCriteria cri, HttpServletRequest request) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		cri.setMember_id(member.getMember_id());
		cri.setMemberStatus(2);
		dataMap.put("getterWorkreportList", workreportDAO.selectSearchWorkreportList(cri));
		return dataMap;
	}

	private void addAttachList(WorkreportVO workreport) throws SQLException {

		if (workreport == null)
			return;

		int workreport_number = workreport.getWorkreport_number();
		List<Workreport_AttachVO> attachList = workreport_attachDAO.selectAttachesByWorkreport_number(workreport_number);

		workreport.setAttachList(attachList);
		
	}

	@Override
	public Workreport_AttachVO selectWorkreport_AttachByAno(int ano) throws SQLException {

		Workreport_AttachVO workreport_attach = workreport_attachDAO.selectWorkreport_AttachByAno(ano);

		return workreport_attach;

	}

	@Override
	public void removeWorkreport_AttachByAno(int ano) throws SQLException {

		workreport_attachDAO.deleteWorkreport_Attach(ano);

	}
	
	
}
