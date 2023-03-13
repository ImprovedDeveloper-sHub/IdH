package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.WorkVO;

public class WorkRegistCommand {

	private String work_title;
	private String work_content;
	private String work_member_id;
	private List<MultipartFile> uploadFile;
	
	
	
	public String getWork_title() {
		return work_title;
	}



	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}



	public String getWork_content() {
		return work_content;
	}



	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}



	public String getWork_member_id() {
		return work_member_id;
	}



	public void setWork_member_id(String work_member_id) {
		this.work_member_id = work_member_id;
	}



	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}



	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}



	public WorkVO toWorkVO(){
		WorkVO work = new WorkVO();
		work.setWork_title(work_title);
		work.setWork_content(this.work_content);
		work.setWork_member_id(this.work_member_id);
		
		return work;
	}
}






