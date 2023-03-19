package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProductVO;

public interface ProductDAO {
	
	//product number로 조회
	 ProductVO selectProduct(int product_number) throws SQLException;
	
	 void deleteProduct(int product_number)throws SQLException;
	
     void insertProduct(ProductVO product)throws SQLException; 
     
     void updateProduct(ProductVO product) throws SQLException ;
     
     void increaseViewCnt(int product_number) throws SQLException ;
    
     List<ProductVO> selectProductCriteria(SearchCriteria cri) throws SQLException ;
     

 	int selectProductCriteriaTotalCount(SearchCriteria cri) throws SQLException ;
 	
 	 int selectProductSeqNextValue() throws SQLException ;
 	
 	
     
     //추가
 	Map<String,Object> selectProductCountForChart(SearchCriteria cri)throws SQLException;
    
    
	
}
