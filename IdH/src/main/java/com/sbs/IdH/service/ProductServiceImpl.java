package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ProductDAO;
import com.sbs.IdH.dao.Product_AttachDAO;
import com.sbs.IdH.dto.ProductVO;
import com.sbs.IdH.dto.Product_AttachVO;

public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO;
		
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	private Product_AttachDAO product_attachDAO;

	@Override
	public Map<String, Object> selectProductList(SearchCriteria cri) throws SQLException {
		
			List<ProductVO> productList = productDAO.selectProductCriteria(cri);
			if (productList != null)
				for (ProductVO product : productList);
			
			/*
			 * addProduct_AttachList(productList);
			 */
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
	@Override
	public Product_AttachVO getProduct_AttachByAno(int product_attach_number) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void removeProduct_Attach(int product_attach_number) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
