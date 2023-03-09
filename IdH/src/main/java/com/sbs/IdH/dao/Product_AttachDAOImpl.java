package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Product_AttachVO;

public class Product_AttachDAOImpl implements Product_AttachDAO{

	private SqlSession session;
	@Override
	public List<Product_AttachVO> selectAttachesByProduct_attach_number(int product_attach_number) throws SQLException {
		List<Product_AttachVO> attachList=session.selectList("Product_Attach-Mapper.selectAttachByProduct_attach_number",product_attach_number);
		return attachList;
	}

	@Override
	public Product_AttachVO selectProduct_AttachByAno(int ano) throws SQLException {
		Product_AttachVO attach=session.selectOne("Product_Attach-Mapper.selectProduct_AttachByAno",ano);
		return attach;
	}

	@Override
	public void insertProduct_Attach(Product_AttachVO product_Attach) throws SQLException {
		session.update("Product_Attach-Mapper.insertProduct_Attach",product_Attach);
	}

	@Override
	public void deleteProduct_Attach(int ano) throws SQLException {
           session.update("Product_Attach-Mapper.deleteProduct_Attach",ano);		
		
	}

	@Override
	public void deleteAllProduct_Attach(int product_attach_number) throws SQLException {
		session.update("Product_Attach-Mapper.deleteAllProduct_Attach",product_attach_number);		
	}
	

}
