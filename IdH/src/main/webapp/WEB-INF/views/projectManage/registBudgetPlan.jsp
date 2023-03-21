<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
  

<!-- CSS start -->

<style>
body{
	width:100%;
	height:100%;
}

#content {
	background: #eaedf2;
	position: relative;
	z-index: 10;
}

#table-content {
	background: #fff;
	margin-top: 20px;
	box-shadow: #dcdee3 0px 0px 10px;
}

#table-content table {
	width: 100%;
}

#table-content thead {
	background: #f2f3f5;
}

#table-content thead tr td {
	color: #757e92;
	font-size: 10px;
	text-transform: uppercase;
}

#table-content tbody tr td {
	border-bottom: #eaecee solid 1px;
}

.name-td {
	font-size: 13px;
	font-weight: 600;
	background-color: #E7E7E7;
}

.table-td {
	font-size: 13px;
	color: #64697a;
}

input {
	width: 100%;
	font-size: 13px;
	color: #64697a;
	border:none;
}

</style>

<!-- CSS end -->



<div class="row">

	<!-- 사업 일정 상세 정보 -->
	<div class="col">
		<div class="card card-info">
			<div class="card-header bg-info">
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 400px;">
						<div class="input-group-append">
						<input id="" type="button" class="btn btn-info btn-sm" onclick="location.href='<%=request.getContextPath()%>/projectManage/registSchedulePlanForm';" value="일정 계획"></input>
						<input id="" type="button" class="btn  " onclick="location.href='<%=request.getContextPath()%>/projectManage/registBudgetPlanForm';" value="예산 계획"></input>
						<input id="" type="button" class="btn btn-info btn-sm" onclick="location.href='<%=request.getContextPath()%>/projectManage/registWorkforcePlanForm';" value="인력 계획"></input>
						<input id="" type="button" class="btn btn-info btn-sm" onclick="location.href='<%=request.getContextPath()%>/projectManage/registUnitworkPlanForm';" value="단위업무 계획"></input>
						</div>
						
					</div>
				</div>
			</div>
			<div id="content">
				<form enctype="multiaprt/form-data" role="form" method="post" action="registBudget" name="registBudgetForm">
				<input type="hidden" name="budget_status" value="1">
				
				<div id="table-content">
					<table>
						<thead>
							<tr>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" colspan="3" style="width:35%;">세부사항</td>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" style="width:35%;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td">등록자</td>
								<td class="table-td" colspan="3" ><input id="budget_member_id" type="text" name="budget_member_id" value="${loginUser.member_id}" readonly></td>
								<td class="name-td">분류</td>
								<td class="table-td"><select name ="budget_type">
													<option value="1">인건비</option>
													<option value="2">교통비</option>
													<option value="3">비품비</option>
													<option value="4">식대</option>
									</select></td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td colspan="5"><input id="budget_name" type="text" name="budget_name" placeholder="제목을 입력하여 주세요." /></td>
							</tr>
							<tr>
								<td class="name-td">예산 금액</td>
								<td colspan="5"><input type="text" name="budget_price" placeholder="금액을 입력하여 주세요." /></td>
								<!-- <td class="table-td" colspan="3"><input class="datepicker" name="budget_startdate" ></td>
								<td class="name-td">종료날짜</td>
								<td class="table-td" colspan="3"><input class="datepicker" name="budget_enddate"></td> -->
								
							</tr>
							
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea class="summernote" rows="15" cols="40" style="display:none;" name="budget_detail"></textarea></td>
							</tr>

							<tr>
								<td class="name-td">프로젝트명</td>
								<td class="table-td"><select name="budget_project_number" >
									<option value="1">미정</option>
									</select></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td"></td>
								<td class="table-td"></td>
							</tr>
						</tbody>
					</table>
				</div>
				</form>
			</div>
			<div class="card-tools" style="margin-left:auto">
            <button type="button" id="regbtn" class="btn btn-info"
               onclick="regist_go();">등록</button>
            <button type="button" id="close" class="btn btn-info"
               onclick="CloseWindow();">닫기</button>
				</div>
			</div>
		</div>
	</div>

<script>
	window.onload = function() {
		summernote_go($('.summernote'),'<%=request.getContextPath()%>');
		$('.datepicker').datepicker();
	};
	
	function regist_go(){
		var form = $('form[name="registBudgetForm"]')[0];
			//var form = document.registBudegetForm;
			/* if(form.budget_name.value==""){
				alert("제목은 필수입니다.");
				return;
			} */
			
			form.submit();
		}
	
	
</script>


