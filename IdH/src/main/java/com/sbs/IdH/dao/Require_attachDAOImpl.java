package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Require_attachVO;

public class Require_attachDAOImpl implements Require_attachDAO {

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Require_attachVO> selectRequire_attachsByRequire_number(int require_number) throws SQLException {
		
		List<Require_attachVO> attachList = session.selectList("Require_attach-Mapper.selectRequire_attachesByRequire_number", require_number);
	      return attachList;

	}

	@Override
	public Require_attachVO selectAttachByAno(int ano) throws SQLException {
		
		Require_attachVO attach = session.selectOne("Require_attach-Mapper.selectRequire_attachByAno", ano);
	      return attach;

	}

	@Override
	public void insertRequire_attach(Require_attachVO require_attach) throws SQLException {
		session.update("Require_attach-Mapper.insertRequire_attach", require_attach);
		
	}

	@Override
	public void deleteRequire_attach(int ano) throws SQLException {
		session.update("Require_attach-Mapper.deleteRequire_attach",ano);      
		
	}

	@Override
	public void deleteAllRequire_attach(int require_number) throws SQLException {
		session.update("Require_attach-Mapper.deleteAllRequire_attach", require_number);
		
	}

}
