package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ReplyDAO;
import com.sbs.IdH.dto.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	@Override
	public Map<String, Object> getReplyList(int issue_number, SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
			List<ReplyVO> replyList = replyDAO.selectReplyListPage(issue_number, cri);			
			
			int count = replyDAO.countReply(issue_number);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(count);
	
			dataMap.put("replyList", replyList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		
		
	}

	@Override
	public int getReplyListCount(int issue_number) throws SQLException {
			int count = replyDAO.countReply(issue_number);
			return count;
		
	}

	@Override
	public void registReply(ReplyVO reply) throws SQLException {
			int rno = replyDAO.selectReplySeqNextValue();
			reply.setRno(rno);

			replyDAO.insertReply(reply);
		
		

	}

	@Override
	public void modifyReply(ReplyVO reply) throws SQLException {

			replyDAO.updateReply(reply);
	}

	@Override
	public void removeReply(int rno) throws SQLException {
			replyDAO.deleteReply(rno);
	}
}
