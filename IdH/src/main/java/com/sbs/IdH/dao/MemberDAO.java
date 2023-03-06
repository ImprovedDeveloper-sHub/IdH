package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MemberVO;

public interface MemberDAO {

	List<MemberVO> selectSearchMemberList(SearchCriteria cri) throws Exception;

	int selectSearchMemberListCount(SearchCriteria cri) throws SQLException;

	MemberVO selectMember(String id) throws SQLException;

	public void insertMember(MemberVO member) throws SQLException;

	public void updateMember(MemberVO member) throws SQLException;

	void deleteMember(String id) throws SQLException;
	
}
