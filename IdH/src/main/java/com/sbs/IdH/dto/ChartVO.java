
package com.sbs.IdH.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChartVO {
	private HashMap<String, Object> result;
	private List<HashMap<String, Object>> cols;
	private List<HashMap<String, Object>> rows;
	
	HashMap<String, Object> colMap1;
	HashMap<String, Object> colMap2;
	HashMap<String, Object> colMap3;
	HashMap<String, Object> colMap4;
	HashMap<String, Object> colMap5;
	
	public ChartVO() {
		cols = new ArrayList<HashMap<String, Object>>();
		rows = new ArrayList<HashMap<String, Object>>();
		colMap1 = new HashMap<String,Object>();
		colMap2 = new HashMap<String,Object>();
		colMap3 = new HashMap<String,Object>();
		colMap4 = new HashMap<String,Object>();
		colMap5 = new HashMap<String,Object>();
		result = new HashMap<String, Object>();
	}
	

	public void rowSet(HashMap<String, Object> rowMap) {
		rows.add(rowMap);
	}
	
	
	public void budgetColSet() {
		colMap1.put("label","예산");
		colMap1.put("type","string");
		colMap2.put("label","예산 금액");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
	}
	
	public void workforceColSet() {
		colMap1.put("label","인력");
		colMap1.put("type","string");
		colMap2.put("label","인력 숫자");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
	}
	
	public void unitworkforProgressColSet() {
		colMap1.put("label","진행률");
		colMap1.put("type","string");
		colMap2.put("label","진행중");
		colMap2.put("type","number");
		colMap3.put("label","지연");
		colMap3.put("type","number");
		colMap4.put("label","예정");
		colMap4.put("type","number");
		colMap5.put("label","완료");
		colMap5.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		cols.add(colMap3);
		cols.add(colMap4);
		cols.add(colMap5);
	}
	
	public void unitworkColSet() {
		colMap1.put("label","단위업무");
		colMap1.put("type","string");
		colMap2.put("label","개수");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
	}
	
	public void scheduleColSet() {
		colMap1.put("label","계획 일정");
		colMap1.put("type","string");
		colMap2.put("label","일정 수");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
	}
	
	
	public void issueColSet() {
		colMap1.put("label","이슈");
		colMap1.put("type","string");
		colMap2.put("label","개수");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
	}

	
	public void productColSet() {
		colMap1.put("label","산출물");
		colMap1.put("type","string");
		colMap2.put("label","개수");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
	}
	
	public void resultSet() {
		result.put("cols", cols);
		result.put("rows", rows);
	}
	
	public HashMap<String, Object> getResult() {
		return result;
	}
	
	
	
}
