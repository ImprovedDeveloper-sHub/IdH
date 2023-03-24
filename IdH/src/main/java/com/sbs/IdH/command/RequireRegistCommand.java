package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.RequireVO;

public class RequireRegistCommand {

	private String require_title;
	private String require_detail;
	private String require_setter_id;
	private String require_getter_id;
	private int require_business_number;
	private String require_project;
	private int require_level;
	
	
	public String getRequire_project() {
		return require_project;
	}



	public void setRequire_project(String require_project) {
		this.require_project = require_project;
	}



	public int getRequire_business_number() {
		return require_business_number;
	}



	public void setRequire_business_number(int require_business_number) {
		this.require_business_number = require_business_number;
	}



	public int getRequire_level() {
		return require_level;
	}



	public void setRequire_level(int require_level) {
		this.require_level = require_level;
	}



	private List<MultipartFile> uploadFile;
	
	
	
	public String getRequire_title() {
		return require_title;
	}



	public void setRequire_title(String require_title) {
		this.require_title = require_title;
	}



	public String getRequire_detail() {
		return require_detail;
	}



	public void setRequire_detail(String require_detail) {
		this.require_detail = require_detail;
	}



	public String getRequire_setter_id() {
		return require_setter_id;
	}



	public void setRequire_setter_id(String require_setter_id) {
		this.require_setter_id = require_setter_id;
	}



	public String getRequire_getter_id() {
		return require_getter_id;
	}



	public void setRequire_getter_id(String require_getter_id) {
		this.require_getter_id = require_getter_id;
	}



	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}



	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}



	public RequireVO toRequireVO(){
		RequireVO require = new RequireVO();
		require.setRequire_title(this.require_title);
		require.setRequire_detail(this.require_detail);
		require.setRequire_setter_id(this.require_setter_id);
		require.setRequire_getter_id(this.require_getter_id);
		require.setRequire_business_number(this.require_business_number);
		require.setRequire_level(this.require_level);
		require.setRequire_project(this.require_project);
		
		return require;
	}
}






