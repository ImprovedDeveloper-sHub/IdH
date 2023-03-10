package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.Co_AttachVO;
import com.sbs.IdH.dto.CompanyruleVO;

public interface CompanyruleService {
	// 리스트조회
				Map<String, Object> selectCompanyruleList(SearchCriteria cri) throws SQLException;

				// 글작성
				void registCompanyrule(CompanyruleVO companyrule) throws SQLException;

				// 글읽기(조회수증가)
				CompanyruleVO readCompanyrule(int companyrule_number) throws SQLException;

				// 글조회
				CompanyruleVO selectCompanyrule(int companyrule_number) throws SQLException;

				// 글수정
				void modifyCompanyrule(CompanyruleVO companyrule_number) throws SQLException;

				// 글삭제
				void removeCompanyrule(int companyrule_number) throws SQLException;

				Co_AttachVO selectCo_AttachByAno(int ano)throws SQLException;
				
			    void removeCo_AttachByAno(int ano)throws SQLException;
		}


