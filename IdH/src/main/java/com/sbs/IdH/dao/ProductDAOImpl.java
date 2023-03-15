package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProductVO;

public class ProductDAOImpl implements ProductDAO {

	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public ProductVO selectProduct(int product_number) throws SQLException {
		ProductVO product = session.selectOne("Product-Mapper.selectProduct", product_number);

		return product;
	}

	@Override
	public void deleteProduct(int product_number) throws SQLException {
		session.update("Product-Mapper.deleteProdcut", product_number);
	}

	@Override
	public void insertProduct(ProductVO product) throws SQLException {
		session.update("Product-Mapper.insertProduct", product);
	}

	@Override
	public void updateProduct(ProductVO product) throws SQLException {
		session.update("Product-Mapper.updateProduct", product);
	}

	@Override
	public void increaseViewCnt(int product_number) throws SQLException {
		session.update("Product-Mapper.increaseViewCnt", product_number);
	}

	@Override
	public List<ProductVO> selectProductCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<ProductVO> productList = session.selectList("Product-Mapper.selectSearchProductList", cri, rowBounds);

		return productList;
	}

	@Override
	public int selectProductCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count=session.selectOne("Product-Mapper.selectSearchProductListCount",cri);
		return count;
	}

	@Override
	public int selectProductSeqNextValue() throws SQLException {
		int product_number=session.selectOne("Product-Mapper.selectProductSeqNext");
		return  product_number;
	}

	@Override
	public Map<String, Object> selectProductCountForChart(SearchCriteria cri) throws SQLException {
		Map<String,Object> colMap = new HashMap<String, Object>();
		int product_count = session.selectOne("Product-Mapper.selectSearchProductListCount", cri);
		colMap.put("v",product_count);
		return colMap;
	}
	
}
