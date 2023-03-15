package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Workreport_AttachVO;

public class Workreport_AttachDAOImpl implements Workreport_AttachDAO{
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Workreport_AttachVO> selectAttachesByWorkreport_number(int workreport_number) throws SQLException {
		List<Workreport_AttachVO> attachList=session.selectList("Workreport_Attach-Mapper.selectAttachByWorkreport_number",workreport_number);
		return attachList;
	}

	@Override
	public Workreport_AttachVO selectWorkreport_AttachByAno(int ano) throws SQLException {
		Workreport_AttachVO attach=session.selectOne("Workreport_Attach-Mapper.selectWorkreport_AttachByAno",ano);
		return attach;
	}

	@Override
	public void insertWorkreport_Attach(Workreport_AttachVO workreport_Attach) throws SQLException {
		session.update("Workreport_Attach-Mapper.insertWorkreport_Attach",workreport_Attach);
	}

	@Override
	public void deleteWorkreport_Attach(int ano) throws SQLException {
           session.update("Workreport_Attach-Mapper.deleteWorkreport_Attach",ano);		
		
	}

	@Override
	public void deleteAllWorkreport_Attach(int workreport_number) throws SQLException {
		session.update("Workreport_Attach-Mapper.deleteAllWorkreport_Attach",workreport_number);		
	}
}
