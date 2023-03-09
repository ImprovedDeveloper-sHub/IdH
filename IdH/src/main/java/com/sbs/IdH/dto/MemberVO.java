package com.sbs.IdH.dto;

import java.util.Date;

public class MemberVO {
	
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_mail;
	private String member_phone;
	private Date member_regdate;
	private int member_status;
	private int member_rank;
	private String member_specialty;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_mail() {
		return member_mail;
	}
	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public Date getMember_regdate() {
		return member_regdate;
	}
	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}
	public int getMember_status() {
		return member_status;
	}
	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}
	public int getMember_rank() {
		return member_rank;
	}
	public void setMember_rank(int member_rank) {
		this.member_rank = member_rank;
	}
	public String getMember_specialty() {
		return member_specialty;
	}
	public void setMember_specialty(String member_specialty) {
		this.member_specialty = member_specialty;
	}
	
	public MemberVO() {}
	public MemberVO(String member_id, String member_pwd, String member_name, String member_mail, String member_phone,
			Date member_regdate, int member_status, int member_rank, String member_specialty) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.member_mail = member_mail;
		this.member_phone = member_phone;
		this.member_regdate = member_regdate;
		this.member_status = member_status;
		this.member_rank = member_rank;
		this.member_specialty = member_specialty;
	}
	
	
	
}
