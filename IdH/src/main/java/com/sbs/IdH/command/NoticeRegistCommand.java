package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.NoticeVO;

public class NoticeRegistCommand {

	private String notice_title;
	private String notice_content;
	private String notice_writer;
	private List<MultipartFile> uploadFile;
	
	public String getTitle() {
		return notice_title;
	}
	public void setTitle(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getContent() {
		return notice_content;
	}
	public void setContent(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getWriter() {
		return notice_writer;
	}
	public void setWriter(String notice_writer) {
		this.notice_writer = notice_writer;
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
		notice.setNotice_member_id(notice_writer);
		
		return notice;
	}
}






