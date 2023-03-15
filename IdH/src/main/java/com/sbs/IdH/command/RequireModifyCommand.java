package com.sbs.IdH.command;

import com.sbs.IdH.dto.RequireVO;

public class RequireModifyCommand extends RequireRegistCommand{
	private int require_number;
	private int[] deleteFile;
	
	public int getRequire_number() {
		return require_number;
	}
	public void setRequire_number(int require_number) {
		this.require_number = require_number;
	}
	public int[] getDeleteFile() {
		return deleteFile;
	}
	public void setDeleteFile(int[] deleteFile) {
		this.deleteFile = deleteFile;
	}
	
	@Override
	public RequireVO toRequireVO(){
		 RequireVO  require = super.toRequireVO();
		 require.setRequire_number(this.require_number);	
		
		return require;
	}
}







	
	