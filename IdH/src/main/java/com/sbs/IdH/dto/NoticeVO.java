package com.sbs.IdH.dto;

import java.util.Calendar;
import java.util.Date;

public class NoticeVO {
	
	private int notice_number;
	private String notice_title;
	private String notice_content;
	private String notice_member_id;
	private Date notice_regdate;
	private int notice_level;
	private int notice_count;
	
	public int getNotice_number() {
		return notice_number;
	}

	public void setNotice_number(int notice_number) {
		this.notice_number = notice_number;
	}

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

	public Date getNotice_regdate() {
		return notice_regdate;
	}

	public void setNotice_regdate(Date notice_regdate) {
		this.notice_regdate = notice_regdate;
	}

	public int getNotice_level() {
		return notice_level;
	}

	public void setNotice_level(int notice_level) {
		this.notice_level = notice_level;
	}
	
	public int getNotice_count() {
		return notice_count;
	}

	public void setNotice_count(int notice_count) {
		this.notice_count = notice_count;
	}

	@Override
	public String toString() {
		return "NoticeVO [notice_number=" + notice_number + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_member_id=" + notice_member_id + ", notice_regdate=" + notice_regdate
				+ ", notice_level=" + notice_level + ", notice_count=" + notice_count + "]";
	}
	
	public NoticeVO() {}

	public NoticeVO(String notice_title, String notice_content, String notice_member_id,
			Date notice_regdate, int notice_level, int notice_count) {
		super();
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_member_id = notice_member_id;
		this.notice_regdate = notice_regdate;
		this.notice_level = notice_level;
		this.notice_count = notice_count;
	}
	
	public NoticeVO setTestNoticeExample() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2199, 13, 31);
		
		NoticeVO noticeExample = new NoticeVO("testTitle", "testContent", "IdH", new Date(cal.getTimeInMillis()), 3, 9);
		
		return noticeExample;
		
	}
	
}
