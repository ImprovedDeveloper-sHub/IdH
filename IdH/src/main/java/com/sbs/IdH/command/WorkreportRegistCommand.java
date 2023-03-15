package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.WorkreportVO;

public class WorkreportRegistCommand {

	private String workreport_title;
	private String workreport_content;
	private String workreport_member_id;
	private List<MultipartFile> uploadFile;
	
	
	
	public String getWorkreport_title() {
		return workreport_title;
	}



	public void setWorkreport_title(String workreport_title) {
		this.workreport_title = workreport_title;
	}



	public String getWorkreport_content() {
		return workreport_content;
	}



	public void setWorkreport_content(String workreport_content) {
		this.workreport_content = workreport_content;
	}



	public String getWorkreport_member_id() {
		return workreport_member_id;
	}



	public void setWorkreport_member_id(String workreport_member_id) {
		this.workreport_member_id = workreport_member_id;
	}



	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}



	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}



	public WorkreportVO toWorkreportVO(){
		WorkreportVO workreport = new WorkreportVO();
		workreport.setWorkreport_title(workreport_title);
		workreport.setWorkreport_content(this.workreport_content);
		workreport.setWorkreport_member_id(this.workreport_member_id);
		
		return workreport;
	}
}






