package com.sbs.IdH.dto;

public class Project_authorityVO {

	private int project_authority_number;
	private int project_authority;
	private int project_authority_pro_number;
	private String project_authority_member_id;
	
	public int getProject_authority_number() {
		return project_authority_number;
	}
	public void setProject_authority_number(int project_authority_number) {
		this.project_authority_number = project_authority_number;
	}
	public int getProject_authority() {
		return project_authority;
	}
	public void setProject_authority(int project_authority) {
		this.project_authority = project_authority;
	}
	public int getProject_authority_pro_number() {
		return project_authority_pro_number;
	}
	public void setProject_authority_pro_number(int project_authority_pro_number) {
		this.project_authority_pro_number = project_authority_pro_number;
	}
	public String getProject_authority_member_id() {
		return project_authority_member_id;
	}
	public void setProject_authority_member_id(String project_authority_member_id) {
		this.project_authority_member_id = project_authority_member_id;
	}
	
	public Project_authorityVO() {}
	public Project_authorityVO(int project_authority_number, int project_authority,
			int project_authority_pro_number, String project_authority_member_id) {
		super();
		this.project_authority_number = project_authority_number;
		this.project_authority = project_authority;
		this.project_authority_pro_number = project_authority_pro_number;
		this.project_authority_member_id = project_authority_member_id;
	}
	
	
	
	
	
}
