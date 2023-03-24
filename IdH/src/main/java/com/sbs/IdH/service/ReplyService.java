package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ReplyVO;

public interface ReplyService {
	// 리스트보기
	Map<String, Object> getReplyList(int issue_number, SearchCriteria cri) throws SQLException;

	// 리스트 개수
	int getReplyListCount(int issue_number) throws SQLException;

	// 등록
	void registReply(ReplyVO reply) throws SQLException;

	// 수정
	void modifyReply(ReplyVO reply) throws SQLException;

	// 삭제
	void removeReply(int rno) throws SQLException;
}
