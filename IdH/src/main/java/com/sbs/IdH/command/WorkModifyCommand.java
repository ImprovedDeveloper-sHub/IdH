package com.sbs.IdH.command;

import com.sbs.IdH.dto.WorkVO;

public class WorkModifyCommand extends WorkRegistCommand{
	
	private int work_number;
	private int[] deleteFile;
	
	public int getWork_number() {
		return work_number;
	}
	public void setWork_number(int work_number) {
		this.work_number = work_number;
	}
	public int[] getDeleteFile() {
		return deleteFile;
	}
	public void setDeleteFile(int[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public WorkVO toWorkVO(){
		WorkVO work = super.toWorkVO();
		work.setWork_number(this.work_number);	
		
		return work;
	}
}










