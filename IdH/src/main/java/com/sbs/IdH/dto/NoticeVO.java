package com.sbs.IdH.dto;

import java.util.Date;
import java.util.List;

public class NoticeVO {
	
	private int notice_number;
	private String notice_title;
	private String notice_content;
	private String notice_member_id;
	private Date notice_regdate;
	private int notice_level;
	private int notice_count;
	
	private List<Notice_attachVO> notice_attachList;
	
	public List<Notice_attachVO> getNotice_attachList() {
		return notice_attachList;
	}

	public void setNotice_attachList(List<Notice_attachVO> notice_attachList) {
		this.notice_attachList = notice_attachList;
	}

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
				+ ", notice_level=" + notice_level + ", notice_count=" + notice_count + ", notice_attachList="
				+ notice_attachList + "]";
	}

	public NoticeVO() {}
	
	public NoticeVO(int notice_number, String notice_title, String notice_content, String notice_member_id,
			Date notice_regdate, int notice_level, int notice_count, List<Notice_attachVO> notice_attachList) {
		super();
		this.notice_number = notice_number;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_member_id = notice_member_id;
		this.notice_regdate = notice_regdate;
		this.notice_level = notice_level;
		this.notice_count = notice_count;
		this.notice_attachList = notice_attachList;
	}

	/*
	 * public NoticeVO setTestNoticeExample() {
	 * 
	 * Calendar cal = Calendar.getInstance(); cal.set(2199, 13, 31);
	 * 
	 * List<Notice_attachVO> notice_attachListSample = new
	 * ArrayList<Notice_attachVO>(); Notice_attachVO testNotice_attachSample = new
	 * Notice_attachVO(); testNotice_attachSample =
	 * testNotice_attachSample.testNotice_attachSample();
	 * 
	 * notice_attachListSample.add(testNotice_attachSample);
	 * 
	 * NoticeVO noticeExample = new NoticeVO("testTitle", "testContent", "IdH", new
	 * Date(cal.getTimeInMillis()), 3, 9, testNotice_attachSample);
	 * 
	 * return noticeExample;
	 * 
	 * }
	 */
	
}
