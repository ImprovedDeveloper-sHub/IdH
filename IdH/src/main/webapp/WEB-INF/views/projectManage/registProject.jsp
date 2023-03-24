<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
table input {
	width: 100%;
	font-size: 13px;
	color: #64697a;
	border: none;
}

.content-list #title {
	width: 100px;
}

.content-list table input {
	border: solid black 1px;
	padding: 1px 0;
}

#projectDetailtable>th, td {
	border: 1px solid #444444;
}

table td {
	padding: 0.5px !important;
}
</style>

<div class="content row">

	<div class="col-8 content-list card">
		<form role="form" method="post" action="registProject"
			name="registProjectForm">
			<input name="project_member_id" type="hidden" value="${loginUser.member_id}">
			<table style="width: 100%;">
				<tr id=business_tr>
					<td id="title">사업</td>
					<td id="content" colspan="3"><select class="form-control-sm"
						name="project_business_number" id="business_selector"
						style="hegith: 30px; width: 100% !important; border-color: #CED4DA !important;">
							<option>사업선택</option>
							<c:forEach items="${businessList }" var="business">
								<option value="${business.business_number} ">${business.business_name }
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr class="project_tr">
					<td id="title">프로젝트 명</td>
					<td id="content" colspan="3"><input name="project_name" type="text"
						placeholder="프로젝트 이름을 입력해주세요" /></td>
				</tr>
				<tr>
					<td class="name-td">시작날짜</td>
					<td class="table-td"><input class="datepicker"
						name="project_startdate"></td>
					<td class="name-td">종료날짜</td>
					<td class="table-td" ><input class="datepicker"
						name="project_enddate"></td>
				</tr>

				<tr id="reqiure">
					<td id="title">요구사항</td>
					<td id="content" colspan="3"><input type="text" placeholder="사업을 선택해주세요."
						disabled /></td>
				</tr>
				<tr id="schedulePlan">
					<td id="title">예상일정</td>
					<td id="content" colspan="3"><input type="text" placeholder="사업을 선택해주세요."
						disabled /></td>
				</tr>
				<tr id="budgetPlan">
					<td id="title">예산계획</td>
					<td id="content" colspan="3"><input type="text" placeholder="사업을 선택해주세요."
						disabled /></td>
				</tr>
				<tr id="workforcePlan">
					<td id="title">예상인력</td>
					<td id="content" colspan="3"><input type="text" placeholder="사업을 선택해주세요."
						disabled /></td>
				</tr>
				<tr id="unitworkPlan">
					<td id="title">예상단위업무</td>
					<td id="content" id="content" colspan="3"><input type="text" placeholder="사업을 선택해주세요."
						disabled /></td>
				</tr>
				<tr>
					<td id="title">내용</td>
					<td id="content" colspan="3" ><textarea style="height: 100px;"
							name="project_discription" id="summernote" name="summernote"
							rows="3" cols="40"></textarea></td>
				</tr>
			</table>

			<input type="hidden" id=budgetparam name="budgetArrayParam">
			<input type="hidden" id=unitworkparam name="unitworkArrayParam">
			<input type="hidden" id=workforceparam name="workforceArrayParam">
			<input type="hidden" id=scheduleparam name="scheduleArrayParam">


		</form>
		<div class="card-tool">
			<button type="button" id="regbtn" class="btn btn-info"
				onclick="regist_project_go();">등록</button>
			<button type="button" id="regbtn" class="btn btn-info"
				onclick="location.reload()">재작성</button>
		</div>
	</div>
	<div class="col-4 content-util card">
		<table id="businessDetailtable" style="width: 370px; height: 500px">
			<thead class="businessDetailthead">
				<tr>
					<td class="name-td" style="width: 15%;">분류</td>
					<td class="name-td" colspan="3" style="width: 35%;">세부사항</td>
					<td class="name-td" style="width: 15%;">분류</td>
					<td class="name-td" style="width: 35%;">세부사항</td>
				</tr>
			</thead>
			<tbody class="businessDetailtbody">
				<tr>
					<td class="name-td">사업이름</td>
					<td class="table-td" colspan="3"></td>
					<td class="name-td">수준</td>
					<td class="table-td"></td>
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
				<tr style="height: 50px;">
								<td class="name-td">사업 예산</td>
								<td class="table-td" colspan="3"></td>
								<td class="name-td">사용예산</td>
								<td class="table-td" colspan="3"></td>
							</tr>
							<tr style="height: 50px;">
								<td class="name-td">국가 지원 예산</td>
								<td class="table-td" colspan="3"></td>
								<td class="name-td">회사 자체 예산</td>
								<td class="table-td" colspan="3"></td>
				</tr>
							
							
				<tr style="height: 70px;">
					<td class="name-td">내용</td>
					<td class="table-td td-summernote" colspan="5"></td>
				</tr>
				
				<tr style="height: 2px; backgorund-color:#16A2B8;"><td colspan="6" ></td></tr>
				
				<tr style="height: 70px;">
					<td class="name-td">일정</td>
					<td class="table-td" colspan="5" id="scheduleBox"></td>
				</tr>
				<tr style="height: 70px;">
					<td class="name-td">예산</td>
					<td class="table-td" colspan="5" id="budgetBox"></td>
				</tr>
				<tr style="height: 70px;">
					<td class="name-td">인력</td>
					<td class="table-td" colspan="5" id="workforceBox"></td>
				</tr>
				<tr style="height: 70px;">
					<td class="name-td">단위업무</td>
					<td class="table-td" colspan="5" id="unitworkBox"></td>
				</tr>


				
			</tbody>
		</table>
	</div>

</div>

<script>

function regist_project_go(){
	//var form = $('form[name="registSchdeulForm"]')[0];
	var budgetArray = new Array();
	$('input:checkbox[name=budget]:checked').each(function(){
		budgetArray.push(this.value);
	})
	$('#budgetparam').val(budgetArray);
	
	var scheduleArray = new Array();
	$('input:checkbox[name=schedule]:checked').each(function(){
		scheduleArray.push(this.value);
	})
	$('#scheduleparam').val(scheduleArray);
	
	var unitworkArray = new Array();
	$('input:checkbox[name=unitwork]:checked').each(function(){
		unitworkArray.push(this.value);
		//alert(this.value);
	})
	$('#unitworkparam').val(unitworkArray);
	

	var workforceArray = new Array();
	$('input:checkbox[name=workforce]:checked').each(function(){
		workforceArray.push(this.value);
		//alert(this.value);
	})
	$('#workforceparam').val(workforceArray);
	

	
	
	var form = document.registProjectForm;
		if(form.title.value==""){
			alert("제목은 필수입니다.");
			return;
		}
		
		form.submit();
	
	}


</script>



<script>
	window.onload = function() {
		summernote_go($('#summernote'),'<%=request.getContextPath()%>');
		$('.datepicker').datepicker();

		//사업선택 셀렉트
		$(function() {
			$("#business_selector").on("change", function() {
				var v = $('#business_selector').val();
				//alert("셀렉트값 : "+v);
				getPlan(v);
				getBusiness(v);
			});
		});
	};
</script>


<script>
	function getPlan(business_number) {
		//alert(business_number);
		$.ajax({
			url : "getPlan?business_number=" + business_number,
			type : "GET",
			success : function(data) {
				//console.log(JSON.stringify(data));
				//alert(business_number);
				//printPlan(data,$('.project_tr'),$('.budgetPlan)');
				//printPlan(data,$('#budgetPlan'),$('#schedluePlan'),$('#workforcePlan'),$('#unitworkPlan'));
				printPlan(data, $('#budgetPlan'),
						$('#budget-plan-list-template'));
				printPlan(data, $('#schedulePlan'),
						$('#schedule-plan-list-template'));
				printPlan(data, $('#workforcePlan'),
						$('#workforce-plan-list-template'));
				printPlan(data, $('#unitworkPlan'),
						$('#unitwork-plan-list-template'));
			}
		});
	}
</script>



<script>
	function getBusiness(business_number) {
		$.ajax({
			url : "getBusinessDetail?business_number=" + business_number,
			type : "GET",
			success : function(data) {
				printPlan(data, $('#businessDetailtable'),
						$('#business-detail-template'));
			}
		});
	}
</script>

<script>
	function getBudgetDetail(budget_number) {
		$.ajax({
			url : "getBudgetDetail?budget_number=" + budget_number,
			type : "GET",
			success : function(data) {
				printPlanDetail(data, $('#budgetBox'),
						$('#budget-detail-template'));
			}
		});
	}

	function getScheduleDetail(schedule_number) {
		$.ajax({
			url : "getScheduleDetail?schedule_number=" + schedule_number,
			type : "GET",
			success : function(data) {
				printPlanDetail(data, $('#scheduleBox'),
						$('#schedule-detail-template'));
			}
		});
	}

	function getWorkforceDetail(workforce_number) {
		$.ajax({
			url : "getWorkforceDetail?workforce_number=" + workforce_number,
			type : "GET",
			success : function(data) {
				printPlanDetail(data, $('#workforceBox'),
						$('#workforce-detail-template'));
			}
		});
	}

	function getUnitworkDetail(unitwork_number) {
		$.ajax({
			url : "getUnitworkDetail?unitwork_number=" + unitwork_number,
			type : "GET",
			success : function(data) {
				//alert(JSON.stringify(data));
				printPlanDetail(data, $('#unitworkBox'),
						$('#unitwork-detail-template'));
			},
			error : function(error) {
				alert('error');
			}
		});
	}
</script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>

<script type="text/x-handlebars-template" id="unitwork-detail-template">
			{{unitwork_name}} : {{unitwork_detail}} ,&nbsp;&nbsp;&nbsp;
</script>

<script type="text/x-handlebars-template" id="schedule-detail-template">
			{{schedule_name}} : {{schedule_detail}} ,&nbsp;&nbsp;&nbsp;    
</script>

<script type="text/x-handlebars-template" id="workforce-detail-template">
			{{workforce_name}} : {{workforce_member_id}} ,&nbsp;&nbsp;&nbsp;    
</script>

<script type="text/x-handlebars-template" id="budget-detail-template">
			{{budget_name}} : {{budget_detail}} ,&nbsp;&nbsp;&nbsp;    
</script>






<script type="text/x-handlebars-template" id="budget-plan-list-template">
		<td id="title">예산계획</td>
		<td id="budget_content" colspan="3">
		<label><input type="checkbox" id="budgetAll" onchange="checkAllBox('budget');">예산 전체선택</label>
		{{#each budgetList}}
		<label><input name="budget" type="checkbox" class="budget_checkbox" id="{{budget_number}}" value="{{budget_number}}" onclick="getBudgetDetail('{{budget_number}}')" >{{budget_name}}</label>
		{{/each}}
		</td>
</script>
<script type="text/x-handlebars-template"
	id="unitwork-plan-list-template">
		<td id="title">단위업무계획</td>
		<td id="unitwork_content" colspan="3">
		<label><input type="checkbox" id="unitworkAll" onchange="checkAllBox('unitwork');">업무 전체선택</label>
		{{#each unitworkList}}
		<label><input name="unitwork" type="checkbox" id="{{unitwork_number}}" value="{{unitwork_number}}" onclick="getUnitworkDetail('{{unitwork_number}}')">{{unitwork_name}}</label>
		{{/each}}
		</td>
</script>

<script type="text/x-handlebars-template"
	id="schedule-plan-list-template">
		<td id="title">일정계획</td>
		<td id="schedule_content" colspan="3">
		<label><input type="checkbox" id="scheduleAll" onchange="checkAllBox('schedule');">일정 전체선택</label>
		{{#each scheduleList}}
		<label><input name="schedule" type="checkbox" id="{{schedule_number}}" value="{{schedule_number}}" onclick="getScheduleDetail('{{schedule_number}}')">{{schedule_name}}</label>
		{{/each}}
		</td>
</script>

<script type="text/x-handlebars-template"
	id="workforce-plan-list-template">
		<td id="title">인력계획</td>
		<td id="workforce_content" colspan="3">
		<label><input type="checkbox" id="workforceAll" onchange="checkAllBox('workforce');" >인력 전체선택</label>
		{{#each workforceList}}
		<label><input name="workforce" type="checkbox" id="{{workforce_number}}" value="{{workforce_number}}" onclick="getWorkforceDetail('{{workforce_number}}')">{{workforce_name}}</label>
		{{/each}}
		</td>
</script>

<script type="text/x-handlebars-template" id="business-detail-template">
		
		<thead class="businessDetailthead">
							<tr>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" colspan="3" style="width:35%;">세부사항</td>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" style="width:35%;">세부사항</td>
							</tr>
						</thead>
						<tbody class="businessDetailtbody">
							<tr>
								<td class="name-td">사업 이름</td>
								<td class="table-td" colspan="3">{{business.business_name}}</td>
								<td class="name-td">수준</td>
								<td class="table-td">{{business.business_status}}</td>
							</tr>
							<tr>
								<td class="name-td">담당자</td>
								<td class="table-td" colspan="3">{{business.business_member_id}}</td>
								<td class="name-td">총원</td>
								<td class="table-td" colspan="3">{{business.business_people}}</td>
							</tr>
							
							<tr>
								<td class="name-td">시작날짜</td>
								<td class="table-td" colspan="3">{{prettifyDate business.business_begin}}</td>
								<td class="name-td">종료날짜</td>
								<td class="table-td" colspan="3">{{prettifyDate business.business_end}}</td>
							</tr>
							
							<tr style="height: 50px;">
								<td class="name-td">사업 예산</td>
								<td class="table-td" colspan="3">{{business.business_budget}}</td>
								<td class="name-td">사용예산</td>
								<td class="table-td" colspan="3">{{business.business_usebudget}}</td>
							</tr>
							<tr style="height: 50px;">
								<td class="name-td">국가 지원 예산</td>
								<td class="table-td" colspan="3">{{business.business_nationbudget}}</td>
								<td class="name-td">회사 자체 예산</td>
								<td class="table-td" colspan="3">{{business.business_companybudget}}</td>
							</tr>

							<tr style="height: 100px;">
								<td class="name-td">사업 내용</td>
								<td class="table-td td-summernote" colspan="5">{{business.business_content}}</td>
							</tr>


							<tr style="height: 2px; backgorund-color:#16A2B8;"><td colspan="6" ></td></tr>
				
							<tr style="height: 70px;">
								<td class="name-td">예산</td>
								<td class="table-td" colspan="5"  id="budgetBox"></td>
							</tr>
							<tr style="height: 70px;">
								<td class="name-td">일정</td>
								<td class="table-td" colspan="5"  id="scheduleBox"></td>
							</tr>
							<tr style="height: 70px;">
								<td class="name-td">인력</td>
								<td class="table-td" colspan="5"  id="workforceBox"></td>
							</tr>
							<tr style="height: 70px;">
								<td class="name-td">단위업무</td>
								<td class="table-td" colspan="5"  id="unitworkBox"></td>
							</tr>
							
							
							
						</tbody>
</script>

<script>
	Handlebars.registerHelper({
		"prettifyDate" : function(timeValue) { //Handlbars에 날짜출력함수 등록
			var dateObj = new Date(timeValue);
			var year = dateObj.getFullYear();
			var month = dateObj.getMonth() + 1;
			var date = dateObj.getDate();
			return year + "-" + month + "-" + date;
		}

	});
</script>
<script>
	function printPlan(data, target, templateObject) {
		var planTemplate = Handlebars.compile(templateObject.html());
		//alert(JSON.stringify(data));
		var plan_html = planTemplate(data);
		//delTarget.remove();
		//alert(html);
		target.html("").html(plan_html);
	}

	function printPlanDetail(data, target, templateObject) {
		var planTemplate = Handlebars.compile(templateObject.html());
		//alert(JSON.stringify(data));
		var plan_html = planTemplate(data);
		//delTarget.remove();
		//alert(html);
		target.prepend(plan_html);

	}
</script>

<script>
	function checkAllBox(box_name) {
		if ($('input:checkbox[id=' + box_name + 'All]').is(":checked"))
			$('input[name=' + box_name + ']').prop("checked", true);
		else
			$('input[name=' + box_name + ']').prop("checked", false);
	}
</script>



