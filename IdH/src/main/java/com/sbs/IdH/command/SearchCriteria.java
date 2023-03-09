
package com.sbs.IdH.command;

public class SearchCriteria {
	
	private int page=1;
	private int perPageNum=10;
	private String searchType="";
	private String keyword="";
	//private int project_number;
	private int status;
	private int startRowNum=0;
	
	
	public SearchCriteria() {}
	
	
	  public SearchCriteria(int page, int perPageNum, String searchType, String keyword) { parseSearchCriteria(page,perPageNum,searchType,keyword); }
	/* 이건 확인해봐야할 문제긴한데. 생성자로 가능하다? 받아오면서? 애초에 생성자로 값넣어주는건지.
	 * 
	 * public SearchCriteria(String page, String perPageNum, String searchType,
	 * String keyword)throws NotNumberException { try {
	 * 
	 * parseSearchCriteria(Integer.parseInt(page),Integer.parseInt(perPageNum),
	 * searchType, keyword);
	 * 
	 * }catch(NumberFormatException e) { throw new NotNumberException(); } }
	 */
	
	private void parseSearchCriteria(int page, int perPageNum,
			 String searchType, String keyword) {
		this.page = page;
		this.perPageNum = perPageNum;
		this.searchType = searchType;
		this.keyword = keyword;
		setStartRowNum();
	}	
	
	
	
	
	/*
	 * public SearchCriteria(int page, int perPageNum, String searchType, String
	 * keyword, int project_number, int status, int startRowNum) { super();
	 * this.page = page; this.perPageNum = perPageNum; this.searchType = searchType;
	 * this.keyword = keyword; this.project_number = project_number; this.status =
	 * status; this.startRowNum = startRowNum; }
	 */


	public SearchCriteria(int page, int perPageNum, String searchType, String keyword, int status, int startRowNum) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		this.searchType = searchType;
		this.keyword = keyword;
		this.status = status;
		this.startRowNum = startRowNum;
	}


	public int getPage() {
		return page;
	}
	public void setPage(int page) {		
		if(page>0) {
			this.page = page;
		}
		setStartRowNum();
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum > 0 && perPageNum<101) {
			this.perPageNum = perPageNum;
		}
		setStartRowNum();
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private void setStartRowNum() {
		this.startRowNum = (this.page-1)* this.perPageNum;	
	}
	
	public int getStartRowNum() {
		return this.startRowNum;
	}

	/*
	 * public int getProject_number() { return project_number; }
	 * 
	 * public void setProject_number(int project_number) { this.project_number =
	 * project_number; }
	 */
	
}
