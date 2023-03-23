package com.sbs.IdH.command;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.BusinessgroupVO;

public class BusinessRegistCommand {
	
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
	
	private int businessgroup_number;
	private String businessgroup_member_id;
	
	private List<MultipartFile> business_uploadFile;
	
	private int business_progress;

	public int getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(int business_number) {
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

	public int getBusinessgroup_number() {
		return businessgroup_number;
	}

	public void setBusinessgroup_number(int businessgroup_number) {
		this.businessgroup_number = businessgroup_number;
	}

	public String getBusinessgroup_member_id() {
		return businessgroup_member_id;
	}

	public void setBusinessgroup_member_id(String businessgroup_member_id) {
		this.businessgroup_member_id = businessgroup_member_id;
	}

	public List<MultipartFile> getBusiness_attachList() {
		return business_uploadFile;
	}

	public void setBusiness_attachList(List<MultipartFile> business_attachList) {
		this.business_uploadFile = business_attachList;
	}

	public int getBusiness_progress() {
		return business_progress;
	}

	public void setBusiness_progress(int business_progress) {
		this.business_progress = business_progress;
	}
	
	public BusinessVO toBusinessVO() {
		
		BusinessVO business = new BusinessVO();
		
		business.setBusiness_number(this.business_number);
		business.setBusiness_name(this.business_name);
		business.setBusiness_people(this.business_people);
		business.setBusiness_begin(this.business_begin);
		business.setBusiness_end(this.business_end);
		business.setBusiness_content(this.business_content);
		business.setBusiness_budget(this.business_budget);
		business.setBusiness_nationbudget(this.getBusiness_nationbudget());
		business.setBusiness_companybudget(this.business_companybudget);
		business.setBusiness_usebudget(this.getBusiness_usebudget());
		business.setBusiness_member_id(this.business_member_id);
		
		business.setBusiness_progress(this.business_progress);
		
		return business;
		
	}
	
	public BusinessgroupVO toBusinessgroupVO() {
		
		BusinessgroupVO businessgroup = new BusinessgroupVO();
		
		businessgroup.setBusinessgroup_number(this.businessgroup_number);
		businessgroup.setBusinessgroup_member_id(this.businessgroup_member_id);
		
		return businessgroup;
		
	}
	
}
