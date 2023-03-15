package com.sbs.IdH.command;

import com.sbs.IdH.dto.WorkreportVO;

public class WorkreportModifyCommand extends WorkreportRegistCommand{
	
	private int workreport_number;
	private int[] deleteFile;
	
	public int getWorkreport_number() {
		return workreport_number;
	}
	public void setWorkreport_number(int workreport_number) {
		this.workreport_number = workreport_number;
	}
	public int[] getDeleteFile() {
		return deleteFile;
	}
	public void setDeleteFile(int[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public WorkreportVO toWorkreportVO(){
		WorkreportVO workreport = super.toWorkreportVO();
		workreport.setWorkreport_number(this.workreport_number);	
		
		return workreport;
	}
}










