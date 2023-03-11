package com.sbs.IdH.command;

import com.sbs.IdH.dto.CompanyruleVO;

public class CompanyruleModifyCommand extends CompanyruleRegistCommand{
	private int companyrule_number;
	private int[] deleteFile;
	
	public int getCompanyrule_number() {
		return companyrule_number;
	}
	public void setCompanyrule_number(int companyrule_number) {
		this.companyrule_number = companyrule_number;
	}
	public int[] getDeleteFile() {
		return deleteFile;
	}
	public void setDeleteFile(int[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public CompanyruleVO toCompanyruleVO(){
		 CompanyruleVO  companyrule = super.toCompanyruleVO();
		 companyrule.setCompanyrule_number(this.companyrule_number);	
		
		return companyrule;
	}
}







	
	