package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.ProductVO;

public class ProductRegistCommand {

		private String product_title;
		private String product_content;
		private String product_member_id;
		private List<MultipartFile> uploadFile;
		
		
		
		
		
		public String getProduct_title() {
			return product_title;
		}





		public void setProduct_title(String product_title) {
			this.product_title = product_title;
		}





		public String getProduct_content() {
			return product_content;
		}





		public void setProduct_content(String product_content) {
			this.product_content = product_content;
		}





		public String getProduct_member_id() {
			return product_member_id;
		}





		public void setProduct_member_id(String product_member_id) {
			this.product_member_id = product_member_id;
		}





		public List<MultipartFile> getUploadFile() {
			return uploadFile;
		}





		public void setUploadFile(List<MultipartFile> uploadFile) {
			this.uploadFile = uploadFile;
		}





		public ProductVO toProductVO(){
			ProductVO product = new ProductVO();
			product.setProduct_content(this.product_content);
			product.setProduct_title(this.product_title);
			product.setProduct_member_id(this.product_member_id);
			
			return product;
		}
	}








