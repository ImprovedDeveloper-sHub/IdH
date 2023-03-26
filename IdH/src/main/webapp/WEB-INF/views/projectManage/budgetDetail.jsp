<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<div class="card-header  bg-info">
				<h3 class="card-title">${budget.budget_name}</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
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
								<td class="name-td">예산 상태</td>
								<td class="table-td" colspan="3">${budget.budget_status}</td>
								<td class="name-td">수준</td>
								<td class="table-td">${budget.budget_type eq '1' ? '인건비' : ''}${budget.budget_type eq '2' ? '교통비' : ''}${budget.budget_type eq '3' ? '비품비' : ''}${budget.budget_type eq '4' ? '식대' : ''}</td>
							</tr>
							<tr>
								<td class="name-td">등록자</td>
								<td class="table-td" colspan="3">${budget.budget_member_id}</td>
								<td class="name-td">분류</td>
								<td class="table-td" colspan="3">${budget.budget_status eq '1' ? '계획' : '진행중'}</td>
							</tr>
							<tr>
								<td class="name-td">예산 금액</td>
								<td class="table-td " colspan="5">${budget.budget_price}</td>
							</tr>
							
							<tr style="height: 200px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5">${budget.budget_detail}</td>
							</tr>

							<tr>
								<td class="name-td">프로젝트이름</td>
								<td class="table-td">${budget.budget_project_name}</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td class="table-td"><fmt:formatDate pattern="yyyy-MM-dd" value="${budget.budget_regdate}"/></td>
							</tr>
							
						
						</tbody>
					</table>
					
				</div>
			</div>
			<div class="card-tools" style="margin-left:auto">
            <button type="button" id="regbtn" class="btn btn-info"
               onclick="location.href='modifyBudgetForm?budget_number=${budget.budget_number}'">수정</button>
            <button type="button" id="close" class="btn btn-info"
               onclick="CloseWindow();">취소</button>
               <button type="button" id="regbtn" class="btn btn-info"
               onclick="location.href='deleteBudget?budget_number=${budget.budget_number}'">삭제</button>
				</div>
			</div>
		</div>
	</div>

<c:if test="${from eq 'modify' }">
	<script>
		alert("수정되었습니다.");
		window.opener.location.reload();
		
	</script>
</c:if>




