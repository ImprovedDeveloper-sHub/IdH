package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.MemberDAO;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.exception.InvalidPasswordException;
import com.sbs.IdH.exception.NotFoundIdException;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public Map<String, Object> selectMemberList(SearchCriteria cri) throws Exception {

		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<MemberVO> memberList = memberDAO.selectSearchMemberList(cri);
		dataMap.put("memberList", memberList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectSearchMemberListCount(cri));
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public MemberVO selectMember(String member_id) throws Exception {
		MemberVO member = memberDAO.selectMember(member_id);
		return member;
	}

	@Override
	public void registMember(MemberVO member) throws Exception {
		memberDAO.insertMember(member);

	}

	@Override
	public void modifyMember(MemberVO member) throws Exception {
		memberDAO.updateMember(member);

	}

	@Override
	public void removeMember(String member_id) throws Exception {
		memberDAO.deleteMember(member_id);

	}

	@Override
	public void login(String member_id, String member_pwd)
			throws NotFoundIdException, InvalidPasswordException, SQLException {

		MemberVO member = memberDAO.selectMember(member_id);
		if (member == null)	throw new NotFoundIdException();
		if (!member_pwd.equals(member.getMember_pwd())) throw new InvalidPasswordException();
		
		
	}

}
