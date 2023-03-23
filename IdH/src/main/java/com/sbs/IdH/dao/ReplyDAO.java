package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ReplyVO;

public interface ReplyDAO {

	List<ReplyVO> selectReplyListPage(int issue_number, SearchCriteria cri) throws SQLException;

	int countReply(int issue_number) throws SQLException;

	int selectReplySeqNextValue() throws SQLException;

	void insertReply(ReplyVO reply) throws SQLException;

	void updateReply(ReplyVO reply) throws SQLException;

	void deleteReply(int rno) throws SQLException;

}
