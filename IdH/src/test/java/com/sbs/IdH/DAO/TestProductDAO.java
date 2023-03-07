package com.sbs.IdH.DAO;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ProductDAO;
import com.sbs.IdH.dto.ProductVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestProductDAO {

	@Autowired
	private ProductDAO productDAO;
	@Test
	public void testSelectProduct() throws Exception {
		productDAO.selectProduct(1);

	}
	@Test
	public void testSelectProductList() throws Exception {

		SearchCriteria cri = new SearchCriteria();
		List<ProductVO> productList = productDAO.selectProductCriteria(cri);

		for (ProductVO product : productList) {
			System.out.println(product);
		}
	}
	
	
	  @Test public void testInsertProductList() throws Exception {
	  
	  ProductVO product = new ProductVO(2,1,"aaa","aaaa",1,null,null,"IdH",1);
	  productDAO.insertProduct(product);
	  }
	 
	  
	 

	/*
	 * @Test public void testCoworkrule_SEQ() throws Exception {
	 * System.out.println(coworkruleDAO.selectSeqNextValue()); }
	 */
	 @Test
	public void testupdateProduct() throws Exception {
		 ProductVO product = productDAO.selectProduct(1);
		productDAO.updateProduct(product);

	}

	/*
	 * @Test public void testDeleteCoworkrule() throws Exception { CoworkruleVO
	 * coworkrule1 = coworkruleDAO.selectCoworkrule(1);
	 * coworkruleDAO.deleteCoworkrule(1); CoworkruleVO coworkrule2 =
	 * coworkruleDAO.selectCoworkrule(1); }
	 */
}
