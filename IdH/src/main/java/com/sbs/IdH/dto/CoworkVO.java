package com.sbs.IdH.dto;

import java.util.Date;

public class CoworkVO {
	
	private int cowork_number;
	private Date cowork_regdate;
	private Date cowork_enddate;
	private String cowork_content;
	private int cowork_status;
	private String cowork_member_id;
	private int cowork_product_number;
	public int getCowork_number() {
		return cowork_number;
	}
	public void setCowork_number(int cowork_number) {
		this.cowork_number = cowork_number;
	}
	public Date getCowork_regdate() {
		return cowork_regdate;
	}
	public void setCowork_regdate(Date cowork_regdate) {
		this.cowork_regdate = cowork_regdate;
	}
	public Date getCowork_enddate() {
		return cowork_enddate;
	}
	public void setCowork_enddate(Date cowork_enddate) {
		this.cowork_enddate = cowork_enddate;
	}
	public String getCowork_content() {
		return cowork_content;
	}
	public void setCowork_content(String cowork_content) {
		this.cowork_content = cowork_content;
	}
	public int getCowork_status() {
		return cowork_status;
	}
	public void setCowork_status(int cowork_status) {
		this.cowork_status = cowork_status;
	}
	public String getCowork_member_id() {
		return cowork_member_id;
	}
	public void setCowork_member_id(String cowork_member_id) {
		this.cowork_member_id = cowork_member_id;
	}
	public int getCowork_product_number() {
		return cowork_product_number;
	}
	public void setCowork_product_number(int cowork_product_number) {
		this.cowork_product_number = cowork_product_number;
	}
	public CoworkVO() {}
	public CoworkVO(int cowork_number, Date cowork_regdate, Date cowork_enddate, String cowork_content,
			int cowork_status, String cowork_member_id, int cowork_product_number) {
		super();
		this.cowork_number = cowork_number;
		this.cowork_regdate = cowork_regdate;
		this.cowork_enddate = cowork_enddate;
		this.cowork_content = cowork_content;
		this.cowork_status = cowork_status;
		this.cowork_member_id = cowork_member_id;
		this.cowork_product_number = cowork_product_number;
	}
	

}
