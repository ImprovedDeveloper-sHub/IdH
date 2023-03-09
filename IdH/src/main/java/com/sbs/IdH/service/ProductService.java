package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProductVO;
import com.sbs.IdH.dto.Product_AttachVO;

public interface ProductService {
	
	
	// 리스트조회
		Map<String, Object> selectProductList(SearchCriteria cri) throws SQLException;

		// 글작성
		void registProduct(ProductVO product) throws SQLException;

		// 글읽기(조회수증가)
		ProductVO readProduct(int product_number) throws SQLException;

		// 글조회
		ProductVO selectProduct(int product_number) throws SQLException;

		// 글수정
		void modifyProduct(ProductVO product_number) throws SQLException;

		// 글삭제
		void removeProduct(int product_number) throws SQLException;

		Product_AttachVO getProduct_AttachByAno(int product_attach_number)throws SQLException;
		
	    void removeProduct_Attach(int product_attach_number)throws SQLException;
}
