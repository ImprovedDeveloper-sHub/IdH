package com.sbs.IdH.dto;

import java.util.Calendar;
import java.util.Date;

public class BusinessVO {
	
	private int business_number;
	private String business_name;
	private int business_people;
	private Date business_begin;
	private Date business_end;
	private String business_content;
	private String business_budget;
	private String business_nationbudget;
	private String business_companybudget;
	private String business_usebudget;
	private String business_member_id;
	
	public void setBusiness_number(int business_number) {
		this.business_number = business_number;
	}

	public int getBusiness_number() {
		return business_number;
	}
	
	public void setBusiness_numeber(int business_number) {
		this.business_number = business_number;
	}
	
	public String getBusiness_name() {
		return business_name;
	}
	
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	
	public int getBusiness_people() {
		return business_people;
	}
	
	public void setBusiness_people(int business_people) {
		this.business_people = business_people;
	}
	
	public Date getBusiness_begin() {
		return business_begin;
	}
	
	public void setBusiness_begin(Date business_begin) {
		this.business_begin = business_begin;
	}
	
	public Date getBusiness_end() {
		return business_end;
	}
	
	public void setBusiness_end(Date business_end) {
		this.business_end = business_end;
	}
	
	public String getBusiness_content() {
		return business_content;
	}
	
	public void setBusiness_content(String business_content) {
		this.business_content = business_content;
	}
	
	public String getBusiness_budget() {
		return business_budget;
	}
	
	public void setBusiness_budget(String business_budget) {
		this.business_budget = business_budget;
	}
	
	public String getBusiness_nationbudget() {
		return business_nationbudget;
	}
	
	public void setBusiness_nationbudget(String business_nationbudget) {
		this.business_nationbudget = business_nationbudget;
	}
	
	public String getBusiness_companybudget() {
		return business_companybudget;
	}
	
	public void setBusiness_companybudget(String business_companybudget) {
		this.business_companybudget = business_companybudget;
	}
	
	public String getBusiness_usebudget() {
		return business_usebudget;
	}
	
	public void setBusiness_usebudget(String business_usebudget) {
		this.business_usebudget = business_usebudget;
	}
	
	public String getBusiness_member_id() {
		return business_member_id;
	}
	
	public void setBusiness_member_id(String business_member_id) {
		this.business_member_id = business_member_id;
	}

	@Override
	public String toString() {
		return "BusinessVO [business_numeber=" + business_number + ", business_name=" + business_name
				+ ", business_people=" + business_people + ", business_begin=" + business_begin + ", business_end="
				+ business_end + ", business_content=" + business_content + ", business_budget=" + business_budget
				+ ", business_nationbudget=" + business_nationbudget + ", business_companybudget="
				+ business_companybudget + ", business_usebudget=" + business_usebudget + ", business_member_id="
				+ business_member_id + "]";
	}
	
	public BusinessVO() {}

	public BusinessVO(int business_number, String business_name, int business_people, Date business_begin,
			Date business_end, String business_content, String business_budget, String business_nationbudget,
			String business_companybudget, String business_usebudget, String business_member_id) {
		super();
		this.business_number = business_number;
		this.business_name = business_name;
		this.business_people = business_people;
		this.business_begin = business_begin;
		this.business_end = business_end;
		this.business_content = business_content;
		this.business_budget = business_budget;
		this.business_nationbudget = business_nationbudget;
		this.business_companybudget = business_companybudget;
		this.business_usebudget = business_usebudget;
		this.business_member_id = business_member_id;
	}
	
	public BusinessVO setTestRegistBusiness() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2199, 13, 31);
		
		BusinessVO testBusinessVO = new BusinessVO(9999, "testName", 9, null, new Date(cal.getTimeInMillis()), "testContent", "test원", "test원", "test원", "test원", "abcabc");
		
		return testBusinessVO;
		
	}
	
}
