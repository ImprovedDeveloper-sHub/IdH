package com.sbs.IdH.command;

import com.sbs.IdH.dto.BusinessVO;

public class BusinessModifyCommand extends BusinessRegistCommand {
	
	private int business_number;
	private int[] deleteFile;

	public int getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(int business_number) {
		this.business_number = business_number;
	}

	public int[] getDeleteFile() {
		return deleteFile;
	}

	public void setDeleteFile(int[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public BusinessVO toBusinessVO() {
		
		BusinessVO business = super.toBusinessVO();
		business.setBusiness_number(this.business_number);
		
		return business;
		
	}
	
}
