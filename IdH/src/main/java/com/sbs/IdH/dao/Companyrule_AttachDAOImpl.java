package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Companyrule_AttachVO;


public class Companyrule_AttachDAOImpl implements Companyrule_AttachDAO{

	private SqlSession session;
	@Override
	public List<Companyrule_AttachVO> selectAttachesByCompanyrule_attach_number(int companyrule_attach_number) throws SQLException {
		List<Companyrule_AttachVO> attachList=session.selectList("Companyrule_Attach-Mapper.selectAttachByProduct_attach_number",companyrule_attach_number);
		return attachList;
	}

	@Override
	public Companyrule_AttachVO selectCompanyrule_AttachByAno(int ano) throws SQLException {
		Companyrule_AttachVO attach=session.selectOne("Companyrule_Attach-Mapper.selectCompanyrule_AttachByAno",ano);
		return attach;
	}

	@Override
	public void insertCompanyrule_Attach(Companyrule_AttachVO companyrule_Attach) throws SQLException {
		session.update("Companyrule_Attach-Mapper.insertCompanyrule_Attach",companyrule_Attach);
	}

	@Override
	public void deleteCompanyrule_Attach(int ano) throws SQLException {
           session.update("Companyrule_Attach-Mapper.deleteCompanyrule_Attach",ano);		
		
	}

	@Override
	public void deleteAllCompanyrule_Attach(int companyrule_attach_number) throws SQLException {
		session.update("Companyrule_Attach-Mapper.deleteAllCompanyrule_Attach",companyrule_attach_number);		
	}
	

}
