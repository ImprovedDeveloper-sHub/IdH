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

public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	private Product_AttachDAO product_attachDAO;
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	public void setProduct_attachDAO(Product_AttachDAO product_attachDAO) {
		this.product_attachDAO = product_attachDAO;
	}

	@Override
	public Map<String, Object> selectProductProceedList(SearchCriteria cri) throws SQLException {

		cri.setStatus(1);
		List<ProductVO> productProceedList = productDAO.selectProductCriteria(cri);
		if (productProceedList != null)
			for (ProductVO product : productProceedList)
		addAttachList(product);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productDAO.selectProductCriteriaTotalCount(cri));

		
		int proceedtotal=productDAO.selectProductCriteriaTotalCount(cri);
		cri.setStatus(2);//종료
		int endtotal=productDAO.selectProductCriteriaTotalCount(cri);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("endtotal", endtotal);
		dataMap.put("proceedtotal", proceedtotal);
		dataMap.put("productProceedList", productProceedList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;

	}
	@Override
	public Map<String, Object> selectProduct_CoworkList(SearchCriteria cri) throws SQLException {

		cri.setStatus(3);
		List<ProductVO> product_CoworkList = productDAO.selectProductCriteria(cri);
		if (product_CoworkList != null)
			for (ProductVO product : product_CoworkList)
				addAttachList(product);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productDAO.selectProductCriteriaTotalCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("product_CoworkList", product_CoworkList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;

	}
	@Override
	public Map<String, Object> selectProductEndList(SearchCriteria cri) throws SQLException {

		cri.setStatus(2);
		List<ProductVO> productEndList = productDAO.selectProductCriteria(cri);
		if (productEndList != null)
			for (ProductVO product : productEndList)
				addAttachList(product);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productDAO.selectProductCriteriaTotalCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("productEndList", productEndList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;

	}
	@Override
	public Map<String, Object> selectProductMyProceedList(SearchCriteria cri) throws SQLException {

		cri.setMember_id("loginUser");
		cri.setStatus(1);
		List<ProductVO> productMyProceedList = productDAO.selectProductCriteria(cri);
		if (productMyProceedList != null)
			for (ProductVO product : productMyProceedList)
				addAttachList(product);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productDAO.selectProductCriteriaTotalCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("productMyProceedList", productMyProceedList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;

	}
	@Override
	public Map<String, Object> selectProductMyEndList(SearchCriteria cri) throws SQLException {

		cri.setMember_id("loginUser");
		cri.setStatus(2);
		List<ProductVO> productMyEndList = productDAO.selectProductCriteria(cri);
		if (productMyEndList != null)
			for (ProductVO product : productMyEndList)
				addAttachList(product);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productDAO.selectProductCriteriaTotalCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("productMyEndList", productMyEndList);
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

	private void addAttachList(ProductVO product) throws SQLException {

		if (product == null)
			return;

		int product_number = product.getProduct_number();
		List<Product_AttachVO> attachList = product_attachDAO.selectAttachesByProduct_number(product_number);

		product.setProduct_AttachList(attachList);
	
	}

	@Override
	public Product_AttachVO selectProduct_AttachByAno(int ano) throws SQLException {

		Product_AttachVO product_attach = product_attachDAO.selectProduct_AttachByAno(ano);

		return product_attach;

	}

	@Override
	public void removeProduct_AttachByAno(int ano) throws SQLException {

		product_attachDAO.deleteProduct_Attach(ano);

	}
	
}
