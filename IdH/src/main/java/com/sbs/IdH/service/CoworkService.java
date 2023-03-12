package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CoworkVO;

public interface CoworkService {
	// 리스트조회
			Map<String, Object> selectCoworkList(SearchCriteria cri) throws SQLException;

			// 글작성
			void registCowork(CoworkVO cowork) throws SQLException;

			// 글읽기(조회수증가)
			CoworkVO readCowork(int cowork_number) throws SQLException;

			// 글조회
			CoworkVO selectCowork(int cowork_number) throws SQLException;

			// 글수정
			void modifyCowork(CoworkVO cowork) throws SQLException;

			// 글삭제
			void removeCowork(int cowork_number) throws SQLException;

	}


