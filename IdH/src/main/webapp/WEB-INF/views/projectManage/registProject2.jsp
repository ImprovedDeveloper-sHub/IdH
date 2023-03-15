<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
table input {
	width: 100%;
	font-size: 13px;
	color: #64697a;
	border:none;
}
.content-list #title{
	width:100px;
}
.content-list table input{
	 border:solid black 1px;
	 padding:5px 0;
}
</style>

<div class="content row">

	<div class="col-8 content-list card">
	<form enctype="multiaprt/form-data" role="form" method="post" action="registProject" name="registSchdeulForm">
		<table style="width:100%;">
			<tr id=business_tr>
				<td id="title">사업</td>
				<td id="content"><select class="form-control-sm" name="business_number" id="business_selector" style="hegith:30px; width:100% !important; border-color:#CED4DA !important;">
				
							<option>사업선택</option>
							<c:forEach items="${businessList }" var="business">
								<option value="${business.business_number} ">${business.business_name } </option>
							</c:forEach>
						</select></td>
			</tr>
			<tr class="project_tr">
				<td id="title">프로젝트 명</td>
				<td id="content"><input type="text" placeholder="프로젝트 이름을 입력해주세요" /></td>
			</tr>
			<tr id="reqiure">
				<td id="title">요구사항</td>
				<td id="content"><input type="text" placeholder="사업을 선택해주세요." disabled/></td>
			</tr>
			<tr id="schedulePlan">
				<td id="title">예상일정</td>
				<td id="content"><input type="text" placeholder="사업을 선택해주세요." disabled/></td>
			</tr>
			<tr id="budgetPlan">
				<td id="title">예산계획</td>
				<td id="content"><input type="text" placeholder="사업을 선택해주세요." disabled/></td>
			</tr>
			<tr id="workforcePlan">
				<td id="title">예상인력</td>
				<td id="content"><input type="text" placeholder="사업을 선택해주세요." disabled/></td>
			</tr>
			<tr id="unitworkPlan">
				<td id="title">예상단위업무</td>
				<td id="content"><input type="text" placeholder="사업을 선택해주세요." disabled/></td>
			</tr>
			<tr>
				<td id="title">내용</td>
				<td id="content"><textarea id="summernote" name="summernote" rows="5" cols="40"></textarea></td>
			</tr>
		</table>
		
			 
               </form>
               <div class="card-tool">
            <button type="button" id="regbtn" class="btn btn-info"
               onclick="regist_go();">등록</button>
                  <button type="button" id="regbtn" class="btn btn-info"
               onclick="location.reload()">재작성</button>
              </div>
				</div>
			<div class="col-4 content-util card">
		<ul>
			<li>
				선택한제목
			</li>
		</ul>
	</div>
		
	</div>
	


<script>
	window.onload = function() {
		summernote_go($('#summernote'),'<%=request.getContextPath()%>');
		
		//사업선택 셀렉트
		$(function() {
		    $("#business_selector").on("change", function() {
		        var v = $('#business_selector').val();
		       alert("셀렉트값 : "+v);
		       getPlan(v);
		    });
		});
	};
</script>
	

<script>
	function getPlan(business_number){
		$.ajax({
			url:"getPlan2?business_number="+business_number,
			type:"GET",
			success: function(data){
				console.log(JSON.stringify(data));
				printPlan(data,$('#budgetPlan'),$('#budget-plan-list-template'));
				//printPlan(data,$('#schedulePlan'),$('#schedule-plan-list-template'));
				//printPlan(data,$('#workforcePlan'),$('#workforce-plan-list-template'));
				//printPlan(data,$('#unitworkPlan'),$('#unitwork-plan-list-template'));
			}
		});	
	}
</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="budget-plan-list-template" >
		<td id="title">예산계획</td>
		<td id="content">
		{{#each budgetList}}
			{{#each budgetList}}
				<label><input type="checkbox" id="{{budget_number}}" value="{{budget_number}}" checked>{{budget_name}}</label>
			{{/each}}
		{{/each}}
		</td>
</script>
<script type="text/x-handlebars-template"  id="unitwork-plan-list-template" >
		<td id="title">단위업무계획</td>
		<td id="content">
		{{#each unitworkList}}
		<label><input type="checkbox" id="{{unitwork_number}}" value="{{unitwork_number}}" checked>{{unitwork_name}}</label>
		{{/each}}
		</td>
</script>

<script type="text/x-handlebars-template"  id="schedule-plan-list-template" >
		<td id="title">일정계획</td>
		<td id="content">
		{{#each scheduleList}}
		<label><input type="checkbox" id="{{schedule_number}}" value="{{schedule_number}}" checked>{{schedule_name}}</label>
		{{/each}}
		</td>
</script>

<script type="text/x-handlebars-template"  id="workforce-plan-list-template" >
		<td id="title">인력계획</td>
		<td id="content">
		{{#each workforceList}}
		<label><input type="checkbox" id="{{workforce_number}}" value="{{workforce_number}}" checked>{{workforce_name}}</label>
		{{/each}}
		</td>
</script>



<script>
function printPlan2(data,target_budget, target_schedule, target_workforce, target_unitwork){
	//var planTemplate=Handlebars.compile($('#budget-plan-list-template').html());
	//alert(JSON.stringify(data));
	//var plan_html = planTemplate(data);
	//delTarget.remove();
	//alert(html);
	//target_budget.html("").html(plan_html);
	
}

function printPlan(data,target, templateObject){
	var planTemplate=Handlebars.compile(templateObject.html());
	//alert(JSON.stringify(data));
	var plan_html = planTemplate(data);
	//delTarget.remove();
	//alert(html);
	target.html("").html(plan_html);
}

function printPlan1(data,target, templateObject){
	var planTemplate2=Handlebars.compile(templateObject.html());
	//alert(JSON.stringify(data));
	var plan_html2 = planTemplate2(data);
	//delTarget.remove();
	//alert(html);
	target.html("").html(plan_html2);
}

</script>



<script>




</script>
