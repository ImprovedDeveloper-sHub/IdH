<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--chart-->
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <!--   <script>alert('${test}');</script> -->
          
 <div class= "content">
    <div class="row">

      <!--col-6시작-->
      <div class="col-6">
      	<div id="content" class="card">
         <div class="card-header">
            <h3 class="card-title">일정관리</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							
						</select>
                  <input type="text" name="keyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getProceeding', $('.proceedingThead'),$('#proceedingProject-list-template'))">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
         <button type="button" class="btn btn-block btn-info btn-sm"
            style="width: 80px; " onclick="OpenWindow('registScheduleForm','등록',500,400);">등록</button>
            
            </div>
         <div id="table-content">
            <div  class="card-body table-responsive p-0">
               <table  class="table table-hover">
                  <thead class="proceedingThead" class="text-left">
	                <tr>
	                  <th style="width:20%">일정 이름</th>
	                  <th style="width:30%">일정 상태</th>
	                  <th style="width:20%">시작 날짜</th>
	                  <th style="width:15%">종료 날짜</th>
	                  <th style="width:15%">일정 설명</th>
	                </tr>
              	</thead>
              
              <tbody class="proceedingProjectLi" class="text-left">
              	<c:if test="${empty scheduleList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${scheduleList }" var="schedule">
					 <tr>
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${schedule.schedule_name}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${schedule.schedule_status}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${schedule.schedule_startdate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${schedule.schedule_enddate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> ${schedule.schedule_detail}</td>
	                </tr>
			 	 </c:forEach>
              </tbody>
              
               </table>
            </div>
            
            
         </div>
      </div>
      
      <div id="content" class="card">
         <div class="card-header">
            <h3 class="card-title">예산 관리</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select id="searchPerPageNum" name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							
						</select>
                  <input type="text" name="keyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getEnd', $('.endThead'),$('#endProject-list-template'))">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
         <button type="button" class="btn btn-block btn-info btn-sm"
            style="width: 80px; " onclick="OpenWindow('registBudgetForm','등록',500,400);">등록</button>
            
            </div>
         <div id="table-content">
            <div  class="card-body table-responsive p-0">
               <table  class="table table-hover">
                  <thead class="endThead" class="text-left">
	                <tr>
	                  <th style="width:20%">사업 예산</th>
	                  <th style="width:30%">예산 이름</th>
	                  <th style="width:20%">예산 분류</th>
	                  <th style="width:15%">예산 금액</th>
	                  <th style="width:15%">예산 내용</th>
	                </tr>
              	</thead>
              
              <tbody class="endProjectLi" class="text-left">
              	<c:if test="${empty budgetList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${budgetList }" var="budget">
					 <tr>
			                  <td>사업예산</td>
			                  <td>${budget.budget_name}</td>
			                  <td>${budget.budget_type}</td>
			                  <td>${budget.budget_price}</td>
			                  <td> ${budget.budget_detail}</td>
	                </tr>
				</c:forEach>
              </tbody>
              
               </table>
            </div>
            
            
         </div>
      </div>
       



        <!--col-6종료-->
      </div>

     <div class="col-6">
      	<div id="content" class="card">
         <div class="card-header">
            <h3 class="card-title">인력 프로젝트</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							
						</select>
                  <input type="text" name="keyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getProceeding', $('.proceedingThead'),$('#proceedingProject-list-template'))">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
         <button type="button" class="btn btn-block btn-info btn-sm"
            style="width: 80px;" onclick="OpenWindow('registWorkforceForm','등록',500,400);">등록</button>
            </div>
         <div id="table-content">
            <div  class="card-body table-responsive p-0">
               <table  class="table table-hover">
                  <thead class="proceedingThead" class="text-left">
	                <tr>
	                  <th style="width:20%">인력 이름</th>
	                  <th style="width:30%">인력 상태</th>
	                  <th style="width:20%">인력 날짜</th>
	                  <th style="width:15%">요구사항</th>
	                  <th style="width:15%">설명</th>
	                </tr>
              	</thead>
              
              <tbody class="workforceProjectLi" class="text-left">
              	<c:if test="${empty workforceList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${workforceList }" var="workforce">
					 <tr>
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_name}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_status}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${workforce.workforce_regdate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">test</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> ${workforce.workforce_discription}</td>
	                </tr>
			 	 </c:forEach>
              </tbody>
              
               </table>
            </div>
            
            
         </div>
      </div>
      
      <div id="content" class="card">
         <div class="card-header">
            <h3 class="card-title">단위업무</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select id="searchPerPageNum" name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							
						</select>
                  <input type="text" name="keyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getEnd', $('.endThead'),$('#endProject-list-template'))">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
         <button type="button" class="btn btn-block btn-info btn-sm"
            style="width: 80px; " onclick="OpenWindow('registUnitworkForm','등록',500,400);">등록</button>
            </div>
            
         <div id="table-content">
            <div  class="card-body table-responsive p-0">
               <table  class="table table-hover">
                  <thead class="unitworkThead" class="text-left">
	                <tr>
	                  <th style="width:20%">업무명</th>
	                  <th style="width:30%">상태</th>
	                  <th style="width:20%">시작날짜</th>
	                  <th style="width:15%">종료날짜</th>
	                  <th style="width:15%">설명</th>
	                </tr>
              	</thead>
              
              <tbody class="unitwrokLi" class="text-left">
              	<c:if test="${empty unitworkList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${unitworkList }" var="unitwork">
					 <tr>
			                  <td>${unitwork.unitwork_name}</td>
			                  <td>${unitwork.unitwork_check}</td>
			                  <td><fmt:formatDate pattern="yyyy-MM-dd" value="${unitwork.unitwork_startdate}"/></td>
			                  <td><fmt:formatDate pattern="yyyy-MM-dd" value="${unitwork.unitwork_enddate}"/></td>
			                  <td>${unitwork.unitwork_detail}</td>
	                </tr>
				</c:forEach>
              </tbody>
              
               </table>
            </div>
            
            
         </div>
      </div>
       



        <!--col-6종료-->
      </div>
      
      <!--col-6종료-->

	<div>
	
	</div><br/>
	 <!-- <div id="curve_chart" style="width: 900px; height: 500px"></div>
	 <div id="Line_chart" style="width: 900px; height: 500px"></div>
     <a class="2015-btn" href="#">2015</a> -->
    </div>
		<%@ include file="./ajax_list_js.jsp" %>
		<%@ include file="/WEB-INF/module/pagination.jsp" %>
    </div>


    <!--row종료-->
    
    





  
  