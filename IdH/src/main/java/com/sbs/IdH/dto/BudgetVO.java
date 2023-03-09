package com.sbs.IdH.dto;

import java.util.Date;

public class BudgetVO {

	private int budget_number;
	private int budget_status;
	private String budget_detail;
	private int budget_price;
	private int budget_project_number;
	private String budget_member_id;
	private Date budget_regdate;
	private String budget_name;
	private String budget_type;
	
	
	

	public BudgetVO() {}
	
	public int getBudget_number() {
		return budget_number;
	}
	public void setBudget_number(int budget_number) {
		this.budget_number = budget_number;
	}
	public int getBudget_status() {
		return budget_status;
	}
	public void setBudget_status(int budget_status) {
		this.budget_status = budget_status;
	}
	public String getBudget_detail() {
		return budget_detail;
	}
	public void setBudget_detail(String budget_detail) {
		this.budget_detail = budget_detail;
	}
	public int getBudget_price() {
		return budget_price;
	}
	public void setBudget_price(int budget_price) {
		this.budget_price = budget_price;
	}
	
	public int getBudget_project_number() {
		return budget_project_number;
	}

	public void setBudget_project_number(int budget_project_number) {
		this.budget_project_number = budget_project_number;
	}

	public String getBudget_member_id() {
		return budget_member_id;
	}
	public void setBudget_member_id(String budget_member_id) {
		this.budget_member_id = budget_member_id;
	}

	
	
	public Date getBudget_regdate() {
		return budget_regdate;
	}

	public void setBudget_regdate(Date budget_regdate) {
		this.budget_regdate = budget_regdate;
	}

	public String getBudget_name() {
		return budget_name;
	}

	public void setBudget_name(String budget_name) {
		this.budget_name = budget_name;
	}

	public String getBudget_type() {
		return budget_type;
	}

	public void setBudget_type(String budget_type) {
		this.budget_type = budget_type;
	}

	public BudgetVO(int budget_number, int budget_status, String budget_detail, int budget_price,
			int budget_project_number, String budget_member_id, Date budget_regdate, String budget_name,
			String budget_type) {
		super();
		this.budget_number = budget_number;
		this.budget_status = budget_status;
		this.budget_detail = budget_detail;
		this.budget_price = budget_price;
		this.budget_project_number = budget_project_number;
		this.budget_member_id = budget_member_id;
		this.budget_regdate = budget_regdate;
		this.budget_name = budget_name;
		this.budget_type = budget_type;
	}

	
	
	
}
