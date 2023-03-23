package com.sbs.IdH.dto;

import java.util.Date;

public class ReplyVO {
	
	private int rno; 			//고유번호
	private int issue_number;			//게시글번호
	private String replytext;	//댓글내용
	private String replyer;		//작성자
	private Date regdate;		//등록일
	private Date updatedate;	//수정일
	
	
	public int getIssue_number() {
		return issue_number;
	}
	public void setIssue_number(int issue_number) {
		this.issue_number = issue_number;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
		
}
