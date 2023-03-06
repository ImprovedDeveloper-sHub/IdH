package com.sbs.IdH.dto;

import java.util.Date;

public class ProductVO {

	private int product_number;
    private int product_stage;
    private String product_title;
    private String product_content;
    private int product_status;
    private Date product_regdate;
    private Date product_modifydate;
    private String product_member_id;
    private int product_project_number;
    
    

	
	
	public int getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
		
	}

	public int getProduct_stage() {
		return product_stage;
	}

	public void setProduct_stage(int product_stage) {
		this.product_stage = product_stage;
	}

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

	public int getProduct_status() {
		return product_status;
	}

	public void setProduct_status(int product_status) {
		this.product_status = product_status;
	}

	public Date getProduct_regdate() {
		return product_regdate;
	}

	public void setProduct_regdate(Date product_regdate) {
		this.product_regdate = product_regdate;
	}

	public Date getProduct_modifydate() {
		return product_modifydate;
	}

	public void setProduct_modifydate(Date product_modifydate) {
		this.product_modifydate = product_modifydate;
	}

	public String getProduct_member_id() {
		return product_member_id;
	}

	public void setProduct_member_id(String product_member_id) {
		this.product_member_id = product_member_id;
	}

	public int getProduct_project_number() {
		return product_project_number;
	}

	public void setProduct_project_number(int product_project_number) {
		this.product_project_number = product_project_number;
	}
    public ProductVO() {}
	public ProductVO(int product_number, int product_stage, String product_title, String product_content,
			int product_status, Date product_regdate, Date product_modifydate, String product_member_id,
			int product_project_number) {
		super();
		this.product_number = product_number;
		this.product_stage = product_stage;
		this.product_title = product_title;
		this.product_content = product_content;
		this.product_status = product_status;
		this.product_regdate = product_regdate;
		this.product_modifydate = product_modifydate;
		this.product_member_id = product_member_id;
		this.product_project_number = product_project_number;
	}
	
}
