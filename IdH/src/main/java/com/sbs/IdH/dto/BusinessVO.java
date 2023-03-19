package com.sbs.IdH.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BusinessVO {
	
	private int business_number;
	private String business_name;
	private int business_people;
	private Date business_begin;
	private Date business_end;
	private String business_content;
	private int business_budget;
	private int business_nationbudget;
	private int business_companybudget;
	private int business_usebudget;
	private String business_member_id;
	
	private List<Business_attachVO> business_attachList;
	
	private int business_progress;
	
	public int getBusiness_progress() {
		return business_progress;
	}

	public void setBusiness_progress(int business_progress) {
		this.business_progress = business_progress;
	}

	public List<Business_attachVO> getBusiness_attachList() {
		return business_attachList;
	}

	public void setBusiness_attachList(List<Business_attachVO> business_attachList) {
		this.business_attachList = business_attachList;
	}

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
	
	public int getBusiness_budget() {
		return business_budget;
	}
	
	public void setBusiness_budget(int business_budget) {
		this.business_budget = business_budget;
	}
	
	public int getBusiness_nationbudget() {
		return business_nationbudget;
	}
	
	public void setBusiness_nationbudget(int business_nationbudget) {
		this.business_nationbudget = business_nationbudget;
	}
	
	public int getBusiness_companybudget() {
		return business_companybudget;
	}
	
	public void setBusiness_companybudget(int business_companybudget) {
		this.business_companybudget = business_companybudget;
	}
	
	public int getBusiness_usebudget() {
		return business_usebudget;
	}
	
	public void setBusiness_usebudget(int business_usebudget) {
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
		return "BusinessVO [business_number=" + business_number + ", business_name=" + business_name
				+ ", business_people=" + business_people + ", business_begin=" + business_begin + ", business_end="
				+ business_end + ", business_content=" + business_content + ", business_budget=" + business_budget
				+ ", business_nationbudget=" + business_nationbudget + ", business_companybudget="
				+ business_companybudget + ", business_usebudget=" + business_usebudget + ", business_member_id="
				+ business_member_id + ", business_attachList=" + business_attachList + "]";
	}

	public BusinessVO() {}
	
	public BusinessVO(int business_number, String business_name, int business_people, Date business_begin,
			Date business_end, String business_content, int business_budget, int business_nationbudget,
			int business_companybudget, int business_usebudget, String business_member_id,
			List<Business_attachVO> business_attachList) {
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
		this.business_attachList = business_attachList;
	}

	public BusinessVO setTestRegistBusiness() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2199, 13, 31);
		
		List<Business_attachVO> business_attachListSample = new ArrayList<Business_attachVO>();
		Business_attachVO testBusiness_attachSample = new Business_attachVO();
		testBusiness_attachSample = testBusiness_attachSample.testBusiness_attachSample();
		
		business_attachListSample.add(testBusiness_attachSample);
		
		BusinessVO testBusinessVO = new BusinessVO(999, "testName", 9, null, new Date(cal.getTimeInMillis()), "testContent", 999, 444, 555, 333, "IdH", business_attachListSample);
		
		return testBusinessVO;
		
	}
	
}
