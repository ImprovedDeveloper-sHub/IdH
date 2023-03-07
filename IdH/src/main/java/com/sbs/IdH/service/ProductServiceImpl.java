package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ProductDAO;
import com.sbs.IdH.dto.ProductVO;

public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO;
		
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public Map<String, Object> selectProductList(SearchCriteria cri) throws SQLException {
		
			List<ProductVO> productList = productDAO.selectProductCriteria(cri);
			if (productList != null)
				for (ProductVO product : productList);
			
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(productDAO.selectProductCriteriaTotalCount(cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("productList", productList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		
	}
	@Override
	public void registProduct(ProductVO product) throws SQLException {
		
			int product_number = productDAO.selectProductSeqNextValue();
			product.setProduct_number(product_number);
			productDAO.insertProduct(product);

		
		}

	


	@Override
	public ProductVO readProduct(int product_number) throws SQLException {
		
		

			ProductVO product = productDAO.selectProduct(product_number);
			productDAO.increaseViewCnt(product_number);

			
			return product;

		
	}

	@Override
	public ProductVO selectProduct(int product_number) throws SQLException {
		

			ProductVO product = productDAO.selectProduct(product_number);

		
			
			return product;
		
	}

	@Override
	public void modifyProduct(ProductVO product_number) throws SQLException {
		
			productDAO.updateProduct(product_number);
	}


	@Override
	public void removeProduct(int product_number) throws SQLException {
		productDAO.deleteProduct(product_number);
	}

}
