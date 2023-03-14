package com.sbs.IdH.dto;

public class WorkforceVO {
	private int workforce_number;
	private int workforce_staus;
	private int workforce_project_number;
	private String workforce_detail;
	private String workforce_member_id;
	
	
	public WorkforceVO() {}
	
	public WorkforceVO(int workforce_number, int workforce_staus, int workforce_project_number, String workforce_detail,
			String workforce_member_id) {
		super();
		this.workforce_number = workforce_number;
		this.workforce_staus = workforce_staus;
		this.workforce_project_number = workforce_project_number;
		this.workforce_detail = workforce_detail;
		this.workforce_member_id = workforce_member_id;
	}
	public String getWorkforce_detail() {
		return workforce_detail;
	}
	public void setWorkforce_detail(String workforce_detail) {
		this.workforce_detail = workforce_detail;
	}
	public int getWorkforce_number() {
		return workforce_number;
	}
	public void setWorkforce_number(int workforce_number) {
		this.workforce_number = workforce_number;
	}
	public int getWorkforce_staus() {
		return workforce_staus;
	}
	public void setWorkforce_staus(int workforce_staus) {
		this.workforce_staus = workforce_staus;
	}
	public int getWorkforce_project_number() {
		return workforce_project_number;
	}
	public void setWorkforce_project_number(int workforce_project_number) {
		this.workforce_project_number = workforce_project_number;
	}
	public String getWorkforce_member_id() {
		return workforce_member_id;
	}
	public void setWorkforce_member_id(String workforce_member_id) {
		this.workforce_member_id = workforce_member_id;
	}
	@Override
	public String toString() {
		return "WorkforceVO [workforce_number=" + workforce_number + ", workforce_staus=" + workforce_staus
				+ ", workforce_project_number=" + workforce_project_number + ", workforce_detail=" + workforce_detail
				+ ", workforce_member_id=" + workforce_member_id + "]";
	}
	
	
}
