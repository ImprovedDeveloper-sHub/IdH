package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.CompanyruleVO;

public class CompanyruleRegistCommand {

	private String companyrule_title;
	private String companyrule_content;
	private String companyrule_member_id;
	private List<MultipartFile> uploadFile;
	
	
	
	public String getCompanyrule_title() {
		return companyrule_title;
	}
	public void setCompanyrule_title(String companyrule_title) {
		this.companyrule_title = companyrule_title;
	}
	public String getCompanyrule_content() {
		return companyrule_content;
	}
	public void setCompanyrule_content(String companyrule_content) {
		this.companyrule_content = companyrule_content;
	}
	public String getCompanyrule_member_id() {
		return companyrule_member_id;
	}
	public void setCompanyrule_member_id(String companyrule_member_id) {
		this.companyrule_member_id = companyrule_member_id;
	}
	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public CompanyruleVO toCompanyruleVO(){
		CompanyruleVO companyrule = new CompanyruleVO();
		companyrule.setCompanyrule_content(this.companyrule_content);
		companyrule.setCompanyrule_title(this.companyrule_title);
		companyrule.setCompanyrule_member_id(this.companyrule_member_id);
		
		return companyrule;
	}
}






