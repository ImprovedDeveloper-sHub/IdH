package com.sbs.IdH.command;

import com.sbs.IdH.dto.NoticeVO;

public class NoticeModifyCommand extends NoticeRegistCommand{
	private int notice_number;
	private int[] deleteFile;
	
	public int getNotice_number() {
		return notice_number;
	}
	public void setNotice_number(int notice_number) {
		this.notice_number = notice_number;
	}
	public int[] getDeleteFile() {
		return deleteFile;
	}
	public void setDeleteFile(int[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public NoticeVO toNoticeVO(){
		 NoticeVO  notice = super.toNoticeVO();
		 notice.setNotice_number(this.notice_number);	
		
		return notice;
	}
}







	
	