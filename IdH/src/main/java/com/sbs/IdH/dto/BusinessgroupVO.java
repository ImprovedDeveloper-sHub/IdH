package com.sbs.IdH.dto;

public class BusinessgroupVO {
	
	BusinessVO business = new BusinessVO();
	
	private int businessgroup_number = business.getBusiness_number();
	private String businessgroup_member_id;
	
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
	
}
