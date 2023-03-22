<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--chart-->
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <!--   <script>alert('${test}');</script> -->
 <style>
 #projectDetailtable td{
 	border: 1px solid #444444 !important;
 }
 </style>       
        
        
 <div class= "content">
    <div class="row">

      <!--col-6시작-->
      <div class="col-6">
      	<div id="content" class="card" style="height:295px;">
         <div class="card-header bg-info">
            <h3 class="card-title">진행 프로젝트</h3>
         </div>
         <div id="test">
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse; margin:3px;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select id="proceedingPerPageNum" name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="proceedingSearchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							
						</select>
                  <input type="text" name="keyword" id ="proceedingKeyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  																				<!--페이지번호, 몇개띄울지, 검색타입, 검색어, url, table tr. (after붙일 대상) , 실행할때마다 삭제할 대상, 리스트template, 댓글 templete , 삭제할 div, typeString값. -->
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, $('#proceedingPerPageNum'), $('#proceedingSearchType'), $('#proceedingKeyword'), '<%=request.getContextPath()%>/projectManage/getProceeding', $('.proceedingThead'),$('.proceedingProjectLi'),$('#proceedingProject-list-template'),$('#proceeding-pagination-template'),$('#proceedingPaginationBox'),'proceeding')">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
         
            </div>
         <div id="table-content">
            <div  class="card-body table-responsive p-0" style="height:250px">
               <table  class="table table-hover" >
                  <thead id="proceedingThead" class="proceedingThead" class="text-left">
	                <tr>
	                  <th style="width:15%">사업 이름</th>
	                  <th style="width:30%">프로젝트 이름</th>
	                  <th style="width:20%; text-align:center;">시작 날짜</th>
	                  <th style="width:20%; text-align:center;">예상 종료 날짜</th>
	                  <th style="width:15%; text-align:center;">관련요구사항</th>
	                </tr>
              	</thead>
              
              <tbody id="proceedingProjectLi" class="proceedingProjectLi" class="text-left">
              	<c:if test="${empty proceedingProjectList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${proceedingProjectList }" var="project">
					 <tr onclick="setProjectNum(${project.project_number},'getProjectDetail'); change_comparison(${project.project_number });">
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_business_name }</td>
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_name}</td>
			                  <td style="text-align:center;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${project.project_regdate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:center;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${project.project_enddate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:center;">요구사항</td>
			                  
	                </tr>
			 	 </c:forEach>
			 	 	
              </tbody>
              
               </table>
               
               <div id="proceedingPaginationBox" class="card-tool">
               <%@ include file="/WEB-INF/views/projectManage/proceedingPagination.jsp" %></div>
            </div>
            
         </div>
      </div>
      
      <div id="content" class="card" style="height:295px;">
         <div class="card-header bg-info">
            <h3 class="card-title">종료 프로젝트</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse; margin:3px;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select id="endPerPageNum" name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="endSearchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
						</select>
                  <input type="text" name="keyword" id="endKeyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, $('#endPerPageNum'), $('#endSearchType'), $('#endKeyword'), '<%=request.getContextPath()%>/projectManage/getEnd', $('.endThead'),$('.endProjectLi'),$('#endProject-list-template'),$('#proceeding-end-template'),$('#endPaginationBox'),'end')">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
            </div>
         <div id="table-content">
            <div  class="card-body table-responsive p-0" style="height:200px">
               <table  class="table table-hover">
                  <thead class="endThead" class="text-left">
	                <tr>
	                  <th style="width:20%">사업 이름</th>
	                  <th style="width:30%">프로젝트 이름</th>
	                  <th style="width:20%">종료 날짜</th>
	                  <th style="width:15%">예상 종료날짜</th>
	                  <th style="width:15%">요구사항</th>
	                </tr>
              	</thead>
              
              <tbody class="endProjectLi" class="text-left">
              	<c:if test="${empty endProjectList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${endProjectList }" var="project">
					 <tr onclick="setProjectNum(${project.project_number},'getProjectDetail');">
					 <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_business_name}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_name}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${project.project_regdate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${project.project_enddate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> 요구사항</td>
					 </tr>
				</c:forEach>
              </tbody>
              
               </table>
                <div id="endPaginationBox">
               <%@ include file="/WEB-INF/views/projectManage/endPagination.jsp" %></div>
              
            </div>
            
            
         </div>
      </div>
       
        <!--col-6종료-->
      </div>

      <!--col-6시작-->
      <div class="col-6">
      
       <div class="card ">
          <div class="card-small-body row">
            <div class="col" style="margin:3px;">
            <input type="button" class="btn  btn-info btn-sm" id="projectEndButton" onclick="OpenWindow('<%=request.getContextPath()%>/projectManage/endProjectForm','계획등록',350,150);"  value="프로젝트 종료">
            <input id="" type="button" class="btn btn-info btn-sm" onclick="OpenWindow('<%=request.getContextPath()%>/projectManage/registSchedulePlanForm','계획등록',500,700);" value="프로젝트 계획"></input>
               <input type="button" class="btn  btn-info btn-sm" id="" onclick="OpenWindow('<%=request.getContextPath()%>/calendar/main','일정',850,750);" value="전체일정"></input>

              <input id="changeButton" type="button" class="btn btn-info btn-sm" onclick="returnButton()" value="프로젝트 현황"></input>
              <input id="changeButton" type="button" class="btn btn-info btn-sm" onclick="changeButton()" value="프로젝트 비교"></input>
          </div>
          </div>
        </div>
      
        <div class="card">
          <div class="card-header bg-info">
            <h3 class="card-title">프로젝트 현황</h3>
          </div>
<div class="card-small-body row"  >
		<div class="col" style="margin:3px;">
          <input type="button" class="btn  btn-info btn-sm" id="scheduleButton" onclick="OpenWindow('<%=request.getContextPath()%>/calendar/calByProject?project_number='+project_num,'등록',850,750);" value="프로젝트 일정"></input>
          
            <input type="button" class="btn  btn-info btn-sm" id="budgetButton" onclick="ajax_print_chart('budget');" value="예산현황"></input>
              <input type="button" class="btn  btn-info btn-sm" id="workforceButton" onclick="ajax_print_chart('workforce');" value="인력현황"></input>
               <input type="button" class="btn  btn-info btn-sm" id="unitworkButton" onclick="ajax_print_chart('unitwork');" value="단위업무현황"></input>
              <input type="button" class="btn  btn-info btn-sm"  id="issueButton" onclick="ajax_print_chart('issue');" value="이슈현황"></input>
				<input type="button" class="btn  btn-info btn-sm"  id="productButton" onclick="ajax_print_chart('product');" value="산출물현황"></input>
        </div>
        </div>
          <div id="chartDiv" class="card-body">
            <div id="curve_chart"></div>
            <div id="budget_chart"></div>
            <div id="schedule"></div>
            <div id="issue_chart"></div>
            <div id="product_chart"></div>
            <div id="workforce_chart"></div>
            <div id="unitwork_chart"></div>
            <div id="budgetComparison_chart"></div>
           <!--  <div id="scheduleComparison_chart"></div> -->
            <div id="issueComparison_chart"></div>
            <div id="productComparison_chart"></div>
            <div id="workforceComparison_chart"></div>
            <div id="unitworkComparison_chart"></div>
          </div>
          
 
        


       


        
       
          <div class="col">
		<div class="card card-info">
				<div class="card-tools" >
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			<div id="content">
				<div id="table-content">
					<table id="projectDetailtable" style="width:570px; height:200px">
						<thead class="projectDetailthead">
							<tr>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" colspan="3" style="width:35%;">세부사항</td>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" style="width:35%;">세부사항</td>
							</tr>
						</thead>
						<tbody class="projectDetailtbody">
							<tr>
								<td class="name-td">일정 번호</td>
								<td class="table-td" colspan="3"></td>
								<td class="name-td">수준</td>
								<td class="table-td">보통</td>
							</tr>
							<tr>
								<td class="name-td">등록자</td>
								<td class="table-td" colspan="3"></td>
								<td class="name-td">상태</td>
								<td class="table-td" colspan="3"></td>
							</tr>
							
							<tr>
								<td class="name-td">시작날짜</td>
								<td class="table-td" colspan="3"></td>
								<td class="name-td">종료날짜</td>
								<td class="table-td" colspan="3"></td>
							</tr>
							
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"></td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
			</div>
			</div>
		</div>
          
           
           
           
           
           
       
      </div>


      <!--col-6종료-->

	<div>
	
	</div><br/>
	 <!-- <div id="curve_chart" style="width: 900px; height: 500px"></div>
	 <div id="Line_chart" style="width: 900px; height: 500px"></div>
     <a class="2015-btn" href="#">2015</a> -->
    </div>
		<%@ include file="./ajax_list_js.jsp" %>
    </div>


    <!--row종료-->
    
    

	<input id="project_comparison_num1" type="hidden" value="1">
	<input id="project_comparison_num2" type="hidden" value="2">
	


  
  <!--content종료-->
  
  
  
  
  
  <script>
  
  function changeButton(){
	  $('#budgetButton').val('예산비교');
	  $('#workforceButton').val('인력비교');
	  $('#issueButton').val('이슈비교');
	  $('#productButton').val('산출물비교');
	  $('#unitworkButton').val('단위업무비교');
	  $('#changeButton').val('프로젝트 현황');
	  
	  
	  	$('#budgetButton').attr('onclick',"ajax_print_comparison_chart('budgetComparison')");
		$('#workforceButton').attr('onclick',"ajax_print_comparison_chart('workforceComparison')");
		$('#issueButton').attr('onclick',"ajax_print_comparison_chart('issueComparison')");
		$('#productButton').attr('onclick',"ajax_print_comparison_chart('productComparison')");
		 $('#unitworkButton').attr('onclick',"ajax_print_comparison_chart('unitworkComparison')")
		$('#changeButton').attr('onclick',"returnButton()");
	}

	
	function returnButton(){
		$('#budgetButton').val('예산현황'); $('#budgetButton').attr('onclick',"ajax_print_chart('budget')");
		$('#workforceButton').val('인력현황'); $('#workforceButton').attr('onclick',"ajax_print_chart('workforce')");
		$('#issueButton').val('이슈현황'); $('#issueButton').attr('onclick',"ajax_print_chart('issue')");
		$('#productButton').val('산출물현황'); $('#productButton').attr('onclick',"ajax_print_chart('product')");
		$('#unitworkButton').val('단위업무현황'); $('#unitworkButton').attr('onclick',"ajax_print_chart('uniwork')");
		
		/* $('#changeButton').val('프로젝트 비교');$('#changeButton').attr('onclick',"changeButton()"); */
	}

	

  
  var project_num = 1;
  var last_chart="curve_chart";
  var chart_type="";
  var chart_data="test";
  var data_table_test;
  
  var project_comparison_num1 = 1;
  var project_comparison_num2 = 2;
  var project_comparison_check = 1;
  
  function change_comparison(project_number){
		if(project_comparison_check == 1 ){
			project_comparison_num1 = project_number;
			project_comparison_check = 2;
		}	
		else if(project_comparison_check == 2 ){
			project_comparison_num2 = project_number;
			project_comparison_check = 1;
		}
		
	}
  
  
  
  function ajax_print_chart(url){
	  formData = new FormData();
	  test = $.ajax({
			url:"${request.ContextPath()}/IdH/"+url,//서버url
			data: {
				project_number : project_num	
			},
			method:"post",	//get post 보내는 방식
			success:function(data){
				//alert(url);
				chart_data = JSON.stringify(data);
				chart_type= url+"_chart";
				table_print();
			},	//서버에서 보내는 데이터
			error:function(error){
				alert('error')
			},
			complete:function(){
				//alert('complete')
			},
		})
  }
  
  
  function ajax_print_comparison_chart(url){
	  //alert(project_comparison_num1);
	  //alert(project_comparison_num2);
	  formData = new FormData();
	  test = $.ajax({
			url:"${request.ContextPath()}/IdH/"+url,//서버url
			data: {
				project_comparison_num1 : project_comparison_num1,
				project_comparison_num2 : project_comparison_num2
			},
			method:"post",	//get post 보내는 방식
			success:function(data){
				//alert(url);
				chart_data = JSON.stringify(data);
				chart_type= url+"_chart";
				table_print();
			},	//서버에서 보내는 데이터
			error:function(error){
				alert('error')
			},
			complete:function(){
				//alert('complete')
			},
		})
  }
  
  
  		
 
  var options = {
          title: '프로젝트 계획 - 진행',
          curveType: 'function',
          legend: { position: 'bottom' }
        };
  
  function table_print(){
	  data_table_test = new google.visualization.DataTable(chart_data);
	  var chart2 = new google.visualization.BarChart(document.getElementById(chart_type));
	  google.charts.setOnLoadCallback(drawChart);
	  
	   function drawChart() {
		  document.getElementById(last_chart).style.display="none";
		  document.getElementById(chart_type).style.display="block";
		  last_chart=chart_type;
          var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
          };
          chart2.draw(data_table_test,options);
        }
  }
  
  window.onload = function(){
	  google.charts.load('current', {packages: ['corechart', 'line']});
	  google.charts.load('current', {'packages':['corechart']});
	  google.charts.setOnLoadCallback(drawBasic);
	  
	  
  }
  function go_ajax(url, target, delTarget, templateObject ) {
	  	var jobForm=$('#jobForm');
	  	//var jobForm = document.getElementById('#jobForm');
	  	$.ajax({
	  		url: url,
	      	type: "GET",
	      	success: function(data) {    		
	      		//alert(JSON.stringify(data));
	      		printData(data,target,delTarget,templateObject);
	      	},
	      	error:function(error){
	      		AjaxErrorSecurityRedirectHandler(error.status);	
	      	}
	  	});
	  }
  
  
	  function setProjectNum(setNum,url){
		  //alert(setNum);
			project_num = setNum;
			go_ajax(url+'?project_number='+project_num,$('.ProjectDetailthead'),$('.ProjectDetailtbody'),$('#projectDetail-template'));
			$('#chartDiv').hidden;
	  }


  function drawBasic() {
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
        	
        	 var data = google.visualization.arrayToDataTable([
       	      ['Year', '프로젝트계획', '프로젝트현황'],
       	      ['2000',  1000,      400],
       	      ['2005',  1170,      460],
       	      ['2006',  660,       1120],
       	      ['2007',  1030,      540]
       	    ]);
        	
          var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
          };
          chart.draw(data, options);
        }
    
    
    /* $(document).ready(function(){
      $(".2015-btn").click(function(){
    	  var data = google.visualization.arrayToDataTable([
              ['Year', '프로젝트1', '프로젝트2'],
              ['2004',  1000,      400],
              ['2005',  1170,      460],
            ]);
        var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
          };

          chart.draw(data, options);
      });
  }); */
    
}
 
  </script>
  
  <c:if test="${from eq 'regist' }">
  <script>
	  	//alert('test');
	  	window.close();
	  	window.opener.location.reload();
  </script>
  
</c:if>

<c:if test="${from eq 'remove' }">
<script>
	alert('삭제되었습니다.');
	window.close();
	window.opener.location.reload();
</script>

</c:if>

<c:if test="${from eq 'end' }">
<script>
	window.close();
	window.opener.location.reload();
</script>

</c:if>


<script></script>  
  