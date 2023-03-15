package com.sbs.IdH.command;

import com.sbs.IdH.dto.IssueVO;

public class IssueModifyCommand extends IssueRegistCommand{
	
	private int issue_number;
	private int[] deleteFile;
	
	public int getIssue_number() {
		return issue_number;
	}
	public void setIssue_number(int issue_number) {
		this.issue_number = issue_number;
	}
	public int[] getDeleteFile() {
		return deleteFile;
	}
	public void setDeleteFile(int[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public IssueVO toIssueVO(){
		IssueVO issue = super.toIssueVO();
		issue.setIssue_number(this.issue_number);	
		
		return issue;
	}
}










