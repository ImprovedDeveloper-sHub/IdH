package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<MemberVO> selectSearchMemberList(SearchCriteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();

		RowBounds rowBounds = new RowBounds(offset, limit);

		List<MemberVO> memberList = session.selectList("Member-Mapper.selectSearchMemberList", cri, rowBounds);
		return memberList;
	}

	@Override
	public int selectSearchMemberListCount(SearchCriteria cri) throws SQLException {
		int count = 0;
		count = session.selectOne("Member-Mapper.selectSearchMemberListCount", cri);
		return count;
	}

	@Override
	public MemberVO selectMember(String id) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMember", id);
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		session.update("Member-Mapper.insertMember", member);
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateMember", member);

	}

	@Override
	public void deleteMember(String id) throws SQLException {
		session.update("Member-Mapper.deleteMember", id);

	}

}
