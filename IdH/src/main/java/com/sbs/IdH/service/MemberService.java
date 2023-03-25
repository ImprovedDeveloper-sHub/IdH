package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.exception.InvalidPasswordException;
import com.sbs.IdH.exception.NotFoundIdException;

public interface MemberService {

		public Map<String,Object> selectMemberList(SearchCriteria cri)throws Exception;
		
		public MemberVO selectMember(String member_id) throws Exception;

		public void registMember(MemberVO member) throws Exception;

		public void modifyMember(MemberVO member) throws Exception;

		public void removeMember(String member_id) throws Exception;
		
		public void login(String member_id, String member_pwd) throws NotFoundIdException, InvalidPasswordException, SQLException;

		public Map<String, Object> selectMemberCountList(SearchCriteria cri) throws Exception; 

}
