<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--chart-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--   <script>alert('${test}');</script> -->

<div class="content">

	<div class="row">
		<div class="card-tools"
			style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
			<div class="input-group input-group-sm" style="width: 270px">
				<select class="form-control-sm" name="project_number" id="project_selector" style="hegith:30px; width:100% !important; border-color:#CED4DA !important;">
							<option value="">전체 프로젝트</option>
							<c:forEach items="${projectList}" var="project">
								<option value="${project.project_number} ">${project.project_name } </option>
							</c:forEach>
				</select>
				
			</div>
		</div>
	</div>

	<div class="row">


		<!--col-6시작-->
		<div class="col-6">
			<div id="content" class="card boarder-info-2">
				<div class="card-header bg-info">
					<h3 class="card-title">일정관리</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse; margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select name="perPageNum" style="display: none"><option
								value="5" selected></option></select> <select class="form-control-sm"
							name="searchType" id="searchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>

						</select> <input type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getProceeding', $('.proceedingThead'),$('#proceedingProject-list-template'))">
								<i class="fas fa-search"></i>
							</button>


						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;"
						onclick="OpenWindow('registScheduleForm','등록',550,700);">등록</button>

				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="proceedingThead" class="text-left">
								<tr>
									<th style="width: 15%">일정 상태</th>
									<th style="width: 35%">일정 이름</th>
									<th style="width: 15%">일정 구분</th>
									<th style="width: 15%">프로젝트 명</th>
									<th style="width: 25%">시작 날짜</th>
									<th style="width: 15%">종료 날짜</th>
								</tr>
							</thead>

							<tbody class="proceedingProjectLi" class="text-left">
								<c:if test="${empty scheduleList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${scheduleList }" var="schedule">
									<tr
										onclick="OpenWindow('scheduleDetail?schedule_number=${schedule.schedule_number}','스케줄',500,600);">
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											${schedule.schedule_status eq 1 ? '계획' : '진행'}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${schedule.schedule_name}</td>
										<td
											style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${schedule.schedule_type eq '1' ? '기획' : ''}${schedule.schedule_type eq '2' ? '설계' : ''}${schedule.schedule_type eq '3' ? '구현' : ''}${schedule.schedule_type eq '4' ? '테스트' : ''}</td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											${schedule.schedule_project_name}</td>
										
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${schedule.schedule_startdate}" pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${schedule.schedule_enddate}" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>


				</div>
			</div>

			<div id="content" class="card">
				<div class="card-header bg-info">
					<h3 class="card-title">예산 관리</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select id="searchPerPageNum" name="perPageNum"
							style="display: none"><option value="5" selected></option></select>
						<select class="form-control-sm" name="searchType" id="searchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>

						</select> <input type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getEnd', $('.endThead'),$('#endProject-list-template'))">
								<i class="fas fa-search"></i>
							</button>


						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;"
						onclick="OpenWindow('registBudgetForm','등록',500,700);">등록</button>

				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="endThead" class="text-left">
								<tr>
									<th style="width: 20%">예산 상태</th>
									<th style="width: 30%">예산 이름</th>
									<th style="width: 20%">예산 구분</th>
									<th style="width: 15%">프로젝트 명</th>
									<th style="width: 15%">예산 금액</th>
								</tr>
							</thead>

							<tbody class="endProjectLi" class="text-left">
								<c:if test="${empty budgetList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${budgetList }" var="budget">
									<tr
										onclick="OpenWindow('budgetDetail?budget_number=${budget.budget_number}','예산',500,500);">
										<td>${budget.budget_status eq 1 ? '계획' : '진행'}</td>
										<td>${budget.budget_name}</td>
										 <td>${budget.budget_type eq '1' ? '인건비' : ''}${budget.budget_type eq '2' ? '교통비' : ''}${budget.budget_type eq '3' ? '비품비' : ''}${budget.budget_type eq '4' ? '식대' : ''}</td> 
										<td>${budget.budget_project_name}</td>
										<td><fmt:formatNumber value="${budget.budget_price}"
												pattern="#,###" /></td>
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
				<div class="card-header bg-info">
					<h3 class="card-title">인력 프로젝트</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select name="perPageNum" style="display: none"><option
								value="5" selected></option></select> <select class="form-control-sm"
							name="searchType" id="searchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>

						</select> <input type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getProceeding', $('.proceedingThead'),$('#proceedingProject-list-template'))">
								<i class="fas fa-search"></i>
							</button>


						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;"
						onclick="OpenWindow('registWorkforceForm','등록',500,700);">등록</button>
				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="proceedingThead" class="text-left">
								<tr>
									<th style="width: 15%">인력 상태</th>
									<th style="width: 15%; text-align: center;" >이름</th>
									<th style="width: 30%">인력 이름</th>
									<th style="width: 10%">인력 구분</th>
									<th style="width: 20%">인력 날짜</th>
									<th style="width: 15%">요구사항</th>
								</tr>
							</thead>

							<tbody class="workforceProjectLi" class="text-left">
								<c:if test="${empty workforceList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${workforceList }" var="workforce">
									<tr
										onclick="OpenWindow('workforceDetail?workforce_number=${workforce.workforce_number}','인력',580,480);">
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											${schedule.schedule_status eq 1 ? '계획' : '진행'}</td>
										<td
											style="text-align: center; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_member_id}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_name}</td>
										<td
											style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_type eq '1' ? '보통':''}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${workforce.workforce_regdate}" pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">test</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>


				</div>
			</div>

			<div id="content" class="card">
				<div class="card-header bg-info">
					<h3 class="card-title">단위업무</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse; margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select id="searchPerPageNum" name="perPageNum"
							style="display: none"><option value="5" selected></option></select>
						<select class="form-control-sm" name="searchType" id="searchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>

						</select> <input type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getEnd', $('.endThead'),$('#endProject-list-template'))">
								<i class="fas fa-search"></i>
							</button>


						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;"
						onclick="OpenWindow('registUnitworkForm','등록',500,700);">등록</button>
				</div>

				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="unitworkThead" class="text-left">
								<tr>
									<th style="width: 10%">업무 상태</th>
									<th style="width: 20%">업무명</th>
									<th style="width: 15%">업무난이도</th>
									<th style="width: 10%">작성자</th>
									<th style="width: 20%">시작날짜</th>
									<th style="width: 15%">종료날짜</th>
								</tr>
							</thead>

							<tbody class="unitwrokLi" class="text-left">
								<c:if test="${empty unitworkList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${unitworkList }" var="unitwork">
									<tr
										onclick="OpenWindow('unitworkDetail?unitwork_number=${unitwork.unitwork_number}','단위업무',580,600);">
										<td>${unitwork.unitwork_status eq 1 ? '계획' : '진행'}</td>
										<td>${unitwork.unitwork_name}</td>
										<td>${unitwork.unitwork_level eq 1 ? '진행중' : ''}${unitwork.unitwork_level eq 2 ? '지연' : ''}${unitwork.unitwork_level eq 3 ? '예정' : ''}${unitwork.unitwork_level eq 4 ? '완료' : ''}</td>
										<td>${unitwork.unitwork_setter_id}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${unitwork.unitwork_startdate}" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${unitwork.unitwork_enddate}" /></td>
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

		<div></div>
		<br />
	</div>
	<%@ include file="./ajax_list_js.jsp"%>
	
</div>


<!--row종료-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="budget-plan-list-template" >
</script>

<script>
	window.onload = function() {
		//프로젝트 셀렉트
		$(function() {
		    $("#project_selector").on("change", function() {
		        var project_number = $('#project_selector').val();
		       //alert("셀렉트값 : "+project_number);
		       $.ajax({
		    	    url:"getManage?project_number="+ project_number,
		    	    type:"GET",
		    	    success:function(data){
		    	    	/* alert(JSON.stringify(data));
		    	    	console.log(data); */
		    	    	console.log(JSON.stringify(data));
		    	    },
		       		error:function(error){
		       			alert('error');
		       		}
		       })
		    });
		});
	};
</script>


<script>

function printPlan(data,target, templateObject){
	var planTemplate=Handlebars.compile(templateObject.html());
	//alert(JSON.stringify(data));
	var plan_html = planTemplate(data);
	//delTarget.remove();
	//alert(html);
	target.html("").html(plan_html);
}
</script>




 
  </script>
  
  <c:if test="${from eq 'regist' }">
  <script>
	  	//alert('test');
	  	window.close();
	  	window.opener.location.reload();
  </script>
  
</c:if>

<c:if test="${from eq 'delete' }">
<script>
	alert('삭제되었습니다.');
	window.close();
	window.opener.location.reload();
</script>

</c:if>



