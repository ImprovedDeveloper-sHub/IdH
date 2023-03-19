package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.ProductVO;

public class ProductRegistCommand {

		private String product_title;
		private int product_stage;
		private String product_content;
		private int product_status;
		private String product_member_id;
		private int product_project_number;
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





		public int getProduct_stage() {
			return product_stage;
		}





		public void setProduct_stage(int product_stage) {
			this.product_stage = product_stage;
		}





		public int getProduct_status() {
			return product_status;
		}





		public void setProduct_status(int product_status) {
			this.product_status = product_status;
		}








		public int getProduct_project_number() {
			return product_project_number;
		}





		public void setProduct_project_number(int product_project_number) {
			this.product_project_number = product_project_number;
		}





		public ProductVO toProductVO(){
			ProductVO product = new ProductVO();
			product.setProduct_content(this.product_content);
			product.setProduct_title(this.product_title);
			product.setProduct_member_id(this.product_member_id);
			product.setProduct_stage(this.product_stage);
			product.setProduct_status(this.product_status);
		    product.setProduct_project_number(this.product_project_number);
			return product;
		}
	}








