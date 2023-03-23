package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Product_AttachVO;

public interface Product_AttachDAO {
	
	
	public List<Product_AttachVO> selectAttachesByProduct_number(int product_number)throws SQLException;
	
	/*
	 * public List<Product_AttachVO> selectAttachesByCowork_number(int
	 * cowork_number)throws SQLException;
	 */
	public Product_AttachVO selectProduct_AttachByAno(int ano)throws SQLException;
	
	public void insertProduct_Attach(Product_AttachVO product_Attach) throws SQLException;

	public void deleteProduct_Attach(int ano) throws SQLException;

	public void deleteAllProduct_Attach(int product_number)throws SQLException;
	
}




