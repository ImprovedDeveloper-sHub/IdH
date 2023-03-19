package com.sbs.IdH.command;

import com.sbs.IdH.dto.ProductVO;

public class ProductModifyCommand extends ProductRegistCommand{
	
		private int product_number;
		private int[] deleteFile;
		
		public int getProduct_number() {
			return product_number;
		}
		public void setProduct_number(int product_number) {
			this.product_number = product_number;
		}
		public int[] getDeleteFile() {
			return deleteFile;
		}
		public void setDeleteFile(int[] deleteFile) {
			this.deleteFile = deleteFile;
		}
		
		@Override
		public ProductVO toProductVO(){
			ProductVO  product = super.toProductVO();
			product.setProduct_number(this.product_number);	
			
			return product;
		}
	}







		
		
