package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.NoticeVO;

public class NoticeRegistCommand {

	private String notice_title;
	private String notice_content;
	private String notice_member_id;
	private List<MultipartFile> uploadFile;
	
	
	public String getNotice_title() {
		return notice_title;
	}


	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}


	public String getNotice_content() {
		return notice_content;
	}


	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}


	public String getNotice_member_id() {
		return notice_member_id;
	}


	public void setNotice_member_id(String notice_member_id) {
		this.notice_member_id = notice_member_id;
	}


	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}


	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}


	public NoticeVO toNoticeVO(){
		NoticeVO notice = new NoticeVO();
		notice.setNotice_content(notice_content);
		notice.setNotice_title(notice_title);
		notice.setNotice_member_id(notice_member_id);
		
		return notice;
	}
}






