package com.sbs.IdH.Service;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProductVO;
import com.sbs.IdH.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestProductService {

	@Autowired
	private ProductService productService;

	@Test
	public void testSelectproduct() throws SQLException {
		ProductVO product = productService.selectProduct(1);

	}

	@Test
	public void testSelectProductList() throws SQLException {
		SearchCriteria cri = new SearchCriteria();
		productService.selectProductList(cri);
	}

	@Test
	public void testInsertProductList() throws SQLException {
		ProductVO product = new ProductVO(2,1,"aaa","aaaa",1,null,null,"IdH",1);
		productService.registProduct(product);
	}

	@Test
	public void testupdateProduct() throws SQLException {

		ProductVO product = productService.selectProduct(1);
		productService.modifyProduct(product);
		product = productService.selectProduct(1);

	}

	/*
	 * @Test public void testDeleteCowork() throws Exception{
	 * 
	 * }
	 */
}
