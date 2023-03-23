package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Notice_attachVO;

public class Notice_attachDAOImpl implements Notice_attachDAO {

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public List<Notice_attachVO> selectNotice_attachsByNotice_number(int notice_number) throws SQLException {
		List<Notice_attachVO> attachList = session.selectList("Notice_attach-Mapper.selectNotice_attachesByNotice_number", notice_number);
	      return attachList;
	}
	@Override
	public Notice_attachVO selectAttachByAno(int ano) throws SQLException {
		Notice_attachVO attach = session.selectOne("Notice_attach-Mapper.selectNotice_attachByAno", ano);
	      return attach;
	}
	@Override
	public void insertNotice_attach(Notice_attachVO notice_attach) throws SQLException {
		session.update("Notice_attach-Mapper.insertNotice_attach", notice_attach);
		
	}
	@Override
	public void deleteNotice_attach(int ano) throws SQLException {
		session.update("Notice_attach-Mapper.deleteNotice_attach",ano);
		
	}
	@Override
	public void deleteAllNotice_attach(int notice_number) throws SQLException {
		session.update("Notice_attach-Mapper.deleteAllNotice_attach", notice_number);
		
	}


}
