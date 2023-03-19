<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!-- CSS start -->

<style>
#content {
	background: #eaedf2;
	position: relative;
	z-index: 10;
}

#table-content {
	background: #fff;
	/* margin-top: 20px; */
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
	<div class="col-12">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 등록</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<form enctype="multipart/form-data" role="form" method="post" action="regist" name="registForm">
					<table>
						<thead style="text-align: center;">
							<tr>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" colspan="3" style="width:35%;">세부사항</td>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" style="width:35%;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td" style="text-align: center;">사업번호</td>
								<td class="table-td" colspan="3"><input name="business_number" type="text" readonly value="자동 생성" /></td>
								<td class="name-td" style="text-align: center;">사업등록자</td>
								<td class="table-td"><input name="business_member_id" type="text" readonly value="${loginUser.member_id}" /></td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">사업명</td>
								<td class="table-td" colspan="3"><input name="business_name" type="text" value="사업 이름을 입력하세요." /></td>
								<td class="name-td" style="text-align: center;">투입인원</td>
								<td class="table-td"><input name="business_people" type="text" value="투입 인원 수를 입력하세요." /></td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">시작일자</td>
								<td class="table-td" colspan="3"><input name="business_begin" type="text" placeholder="시작 일자를 '000000' 형식으로 입력하세요." /></td>
								<td class="name-td" style="text-align: center;">종료일자</td>
								<td class="table-td"><input name="business_end" type="text" placeholder="종료 일자를  '000000' 형식으로 입력하세요." /></td>
							</tr>
							<tr style="height: 200px;">
								<td class="name-td" style="text-align: center;">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea name="business_content" class="summernote" rows="15" cols="40" style="display:none; width:500px;"></textarea></td>
							</tr>

							<tr>
								<td class="name-td" style="text-align: center;">총예산</td>
								<td class="table-td" colspan="3"><input name="business_budget" type="text" value="총 예산을 숫자만 입력하세요." /></td>
								<td class="name-td" style="text-align: center;">사용예산</td>
								<td class="table-td" colspan="2"><input name="business_usebudget" type="text" value="현재까지 사용한 예산을 숫자만 입력하세요." /></td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">국가지원예산</td>
								<td class="table-td" colspan="3"><input name="business_nationbudget" type="text" value="국가 지원 예산을 숫자만 입력하세요." /></td>
								<td class="name-td" style="text-align: center;">회사자체예산</td>
								<td class="table-td" colspan="2"><input name="business_companybudget" type="text" value="회사 자체 예산을 숫자만 입력하세요." /></td>
							</tr>
						</tbody>
					</table>
					</form>
				</div>
			</div>
			<div class="card-tools" style="margin-left:auto">
            <button type="button" id="regbtn" class="btn btn-info"
               onclick="regist_go();">등록</button>
            <button type="button" id="close" class="btn btn-info"
               onclick="location.href='main';">취소</button>
         	</div>
		</div>
	</div>
</div>

<script>
	window.onload = function() {
		summernote_go($('.summernote'),'<%=request.getContextPath()%>');
	};
	
</script>

<script>

function regist_go(){ 
	   alert('test');
	   $("form[role='form']").submit();
}
</script>
