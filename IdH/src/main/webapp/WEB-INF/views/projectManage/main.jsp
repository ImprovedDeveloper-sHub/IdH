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
            <h3 class="card-title">진행 프로젝트</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select id="proceedingPerPageNum" name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="proceedingSearchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							
						</select>
                  <input type="text" name="keyword" id ="proceedingKeyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, $('#proceedingPerPageNum'), $('#proceedingSearchType'), $('#proceedingKeyword'), '<%=request.getContextPath()%>/projectManage/getProceeding', $('.proceedingThead'),$('.proceedingProjectLi'),$('#proceedingProject-list-template'))">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
         
            </div>
         <div id="table-content">
            <div  class="card-body table-responsive p-0">
               <table  class="table table-hover">
                  <thead class="proceedingThead" class="text-left">
	                <tr>
	                  <th style="width:20%">프로젝트 이름</th>
	                  <th style="width:30%">프로젝트 상태</th>
	                  <th style="width:20%">등록 날짜</th>
	                  <th style="width:15%">요구사항</th>
	                  <th style="width:15%">설명</th>
	                </tr>
              	</thead>
              
              <tbody class="proceedingProjectLi" class="text-left">
              	<c:if test="${empty proceedingProjectList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${proceedingProjectList }" var="project">
					 <tr>
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_name}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_status}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${project.project_regdate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">test</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> ${project.project_discription}</td>
	                </tr>
			 	 </c:forEach>
			 	 <tr>
			 	 	<td colspan="5">
			 	 	<%@ include file="/WEB-INF/module/pagination.jsp" %>
			 	 	</td>
			 	 </tr>
              </tbody>
              
               </table>
            </div>
            
            
         </div>
      </div>
      
      <div id="content" class="card">
         <div class="card-header">
            <h3 class="card-title">종료 프로젝트</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
               <select id="endPerPageNum" name="perPageNum" style="display:none"><option value="5" selected></option></select>
                  <select class="form-control-sm" name="searchType" id="endSearchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
						</select>
                  <input type="text" name="keyword" id="endKeyword"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	<button type="submit" class="btn btn-default" onclick="search_go_ajax(0, $('#endPerPageNum'), $('#endSearchType'), $('#endKeyword'), '<%=request.getContextPath()%>/projectManage/getEnd', $('.endThead'),$('.endProjectLi'),$('#endProject-list-template'))">
                        <i class="fas fa-search"></i>
                     </button>
                  	
                   
                  </div>
               </div>
         
            </div>
         <div id="table-content">
            <div  class="card-body table-responsive p-0">
               <table  class="table table-hover">
                  <thead class="endThead" class="text-left">
	                <tr>
	                  <th style="width:20%">프로젝트 이름</th>
	                  <th style="width:30%">프로젝트 상태</th>
	                  <th style="width:20%">등록 날짜</th>
	                  <th style="width:15%">요구사항</th>
	                  <th style="width:15%">설명</th>
	                </tr>
              	</thead>
              
              <tbody class="endProjectLi" class="text-left">
              	<c:if test="${empty endProjectList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${endProjectList }" var="project">
					 <tr>
					 <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_name}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${project.project_status}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${project.project_regdate}" pattern="yyyy-MM-dd"/></td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">요구사항</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> ${project.project_discription}</td>
					 </tr>
				</c:forEach>
				<tr>
			 	 	<td colspan="5">
			 	 	<%@ include file="/WEB-INF/module/pagination.jsp" %>
			 	 	</td>
			 	 </tr>
              </tbody>
              
               </table>
            </div>
            
            
         </div>
      </div>
       

   


        <!--col-6종료-->
      </div>


      <!--col-6시작-->
      <div class="col-6">
      
       <div class="card ">
          <div class="card-body row">
            <div class="col-6"><button type="button" class="btn btn-block btn-info btn-sm">프로젝트 계획</button>
              </div>
             <div class="col-6"> <input id="changeButton" type="button" class="btn btn-block btn-info btn-sm" onclick="changeButton()" value="프로젝트 비교"></input>
</div>
          </div>
        </div>
      
		<div class="card ">
          <div class="card-body row">
            <div class="col-4"><input type="button" class="btn btn-block btn-info btn-sm" id="budgetButton"
            onclick="ajax_print_chart('budget');" value="예산현황"></input>
              <input type="button" class="btn btn-block btn-info btn-sm" id="workforceButton" onclick="ajax_print_chart('workforce');" value="인력현황"></input></div>
             <div class="col-4"> <input type="button" class="btn btn-block btn-info btn-sm"  id="scheduleButton" onclick="ajax_print_chart('schedule');" value="일정현황"></input>
              <input type="button" class="btn btn-block btn-info btn-sm" onclick="ajax_print_chart('issue');" id="issueButton" value="이슈현황"></input>   
</div><div class="col-4"> <input type="button" class="btn btn-block btn-info btn-sm"  id="productButton" onclick="ajax_print_chart('product');" value="산출물현황"></input>
 <input type="button" class="btn btn-block btn-info btn-sm" id="unitworkButton" onclick="ajax_print_chart('product');" value="단위업무현황"></input>

</div>
          </div>
        </div>
        

        <div class="card">
          <div class="card-header">
            <h3 class="card-title">chart</h3>
          </div>

          <div class="card-body">
            <div id="curve_chart"></div>
            <div id="budget_chart"></div>
            <div id="schedule_chart"></div>
            <div id="issue_chart"></div>
            <div id="product_chart"></div>
            <div id="workforce_chart"></div>
            <div id="budgetComparison_chart"></div>
          </div>
          
 
        </div>


       


        
        <div class="row">
          <div class="card col-6 card-info">
            <div class="card-header ">
            <h3 class="card-title ">종료 프로젝트</h3>
           
               <div class="card-body table-responsive p-0">
            <table class="table table-hover ">
              <thead>
                <tr>
                  <th>1</th>
                  <th>2</th>
                  <th>3</th>
                  <th>4</th>
                  <th>5</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>2</td>
                  <td>3</td>
                  <td><span class="tag tag-success">4</span></td>
                  <td> 5</td>
                </tr></tbody>
              </table>
              
              
              </div>
            </div>
          </div>
          
           <div class="card col-6 card-info">
            <div class="card-header ">
            <h3 class="card-title ">종료 프로젝트</h3>
           
              <div class="card-body table-responsive p-0">
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
    
    




  
  <!--content종료-->
  
  
  
  
  
  <script>
  var last_chart="curve_chart";
  var chart_type="";
  var chart_data="test";
  var data_table_test;
  
  
  function ajax_print_chart(url){
	  test = $.ajax({
			url:"${request.ContextPath()}/IdH/"+url,		//서버url
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
          title: 'Company Performance',
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
  
  
  <script>
  	function changeButton(){
  		$('#budgetButton').val('예산비교'); $('#budgetButton').attr('onclick',"ajax_print_chart('budgetComparison')")
  		$('#workforceButton').val('인력비교');
  		$('#scheduleButton').val('일정비교');
  		$('#issueButton').val('이슈비교');
  		$('#productButton').val('산출물비교');
  		$('#unitworkButton').val('인력비교');
  		$('#changeButton').val('프로젝트 현황');$('#changeButton').attr('onclick',"returnButton()")
  	}
  
  	
  	function returnButton(){
  		$('#budgetButton').val('예산현황'); $('#budgetButton').attr('onclick',"ajax_print_chart('budget')")
  		$('#workforceButton').val('인력현황');
  		$('#scheduleButton').val('일정현황');
  		$('#issueButton').val('이슈현황');
  		$('#productButton').val('산출물현황');
  		$('#unitworkButton').val('인력현황');
  		$('#changeButton').val('프로젝트 비교');$('#changeButton').attr('onclick',"changeButton()")
  	}
  
  </script>
  

  
  