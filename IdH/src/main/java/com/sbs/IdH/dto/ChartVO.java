
package com.sbs.IdH.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChartVO {
	
	
	private HashMap<String, Object> dataMap;
	private List<HashMap<String, Object>> cols;
	private List<HashMap<String, Object>> rows;
	
	public ChartVO(){
		this.dataMap = new HashMap<String, Object>();
		this.cols = new ArrayList<HashMap<String, Object>>();
		this.rows = new ArrayList<HashMap<String, Object>>();
		this.dataMap.put("cols", this.cols);
		this.dataMap.put("rows", this.rows);
	}

	public HashMap<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(HashMap<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List<HashMap<String, Object>> getCols() {
		return cols;
	}

	public void setCols(List<HashMap<String, Object>> cols) {
		this.cols = cols;
	}

	public List<HashMap<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<HashMap<String, Object>> rows) {
		this.rows = rows;
	}
	
	
	
	
}
