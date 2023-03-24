package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.TimeVO;

public class TimeDAOImpl implements TimeDAO {
	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<TimeVO> selectTimeList(String member_id) throws SQLException {
		
		List<TimeVO> timeList = session.selectList("Time-Mapper.selectTimeList", member_id);

		return timeList;
		
	}
	
	

	@Override
	public int selectTimeSequenceNextValue() throws SQLException {
		int seq_num = session.selectOne("Time-Mapper.selectTimeSeqNextValue");
		return seq_num;
		
	}

	@Override
	public void insertTime(TimeVO time) throws SQLException {
		session.update("Time-Mapper.insertTime", time);
	}
	
}
