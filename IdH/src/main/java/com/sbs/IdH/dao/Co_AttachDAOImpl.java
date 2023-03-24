package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Co_AttachVO;

public class Co_AttachDAOImpl implements Co_AttachDAO{

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	
	@Override
	public List<Co_AttachVO> selectAttachesByCo_number(int co_number) throws SQLException {
		List<Co_AttachVO> attachList=session.selectList("Co_Attach-Mapper.selectAttachByCo_number",co_number);
		return attachList;
	}

	@Override
	public Co_AttachVO selectCo_AttachByAno(int ano) throws SQLException {
		Co_AttachVO attach=session.selectOne("Co_Attach-Mapper.selectCo_AttachByAno",ano);
		return attach;
	}

	@Override
	public void insertCo_Attach(Co_AttachVO co_Attach) throws SQLException {
		session.update("Co_Attach-Mapper.insertCo_Attach",co_Attach);
	}

	@Override
	public void deleteCo_Attach(int ano) throws SQLException {
		 session.update("Co_Attach-Mapper.deleteCo_Attach",ano);		
			
		}

	@Override
	public void deleteAllCo_Attach(int co_number) throws SQLException {
		session.update("Co_Attach-Mapper.deleteAllCo_Attach",co_number);		
	}


	//@Override
	//public int selectCo_AttachSeqNextValue() throws SQLException {
	//	int ano=session.selectOne("Co_Attach-Mapper.selectCo_AttachSeqNext");
	//	return  ano;
	//}

}
