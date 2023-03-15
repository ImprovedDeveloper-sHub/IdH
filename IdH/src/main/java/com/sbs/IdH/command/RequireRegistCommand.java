package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.RequireVO;

public class RequireRegistCommand {

	private String require_title;
	private String require_detail;
	private String require_writer_id;
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



	public String getRequire_writer_id() {
		return require_writer_id;
	}



	public void setRequire_writer_id(String require_writer_id) {
		this.require_writer_id = require_writer_id;
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
		require.setRequire_writer_id(this.require_writer_id);
		
		return require;
	}
}






