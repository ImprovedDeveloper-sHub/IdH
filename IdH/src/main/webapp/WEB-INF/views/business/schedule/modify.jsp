<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!-- My CSS start -->

<style>

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
	padding: 14px 10px;
}

#table-content tbody tr td {
	font-size: 15px;
	padding: 14px 10px;
	border-bottom: #eaecee solid 1px;
}

#table-content tbody tr:hover {
	background: #fefaf2;
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

.date-td {
	text-align: right;
	font-size: 9px;
}

.checked {
	background: #fefaf2;
}

#credit {
	color: #76838c;
	width: 300px;
	margin: 0 auto;
	font-size: 12px;
	text-align: center;
}

.btn-info {
	text-align: right;
}

</style>

<!-- My CSS end -->



<div class="row">

	<!-- 공지 사항 상세 정보 -->
	<div class="col-12">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">사업 정보 수정</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<form enctype="multipart/form-data" role="form" method="post" action="modify" name="modifyForm">
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
								<td class="table-td" colspan="3"><input name="business_number" type="hidden" value="${business.business_number}" />${business.business_number}</td>
								<td class="name-td" style="text-align: center;">사업등록자</td>
								<td class="table-td"><input name="business_member_id" type="hidden" value="${loginUser.member_id}" />${loginUser.member_id}</td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">사업명</td>
								<td class="table-td" colspan="3"><input name="business_name" type="hidden" value="${business.business_name}" />${business.business_name}</td>
								<td class="name-td" style="text-align: center;">투입인원</td>
								<td class="table-td"><input name="business_people" type="text" value="${business.business_people}" /></td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">시작일자</td>
								<td class="table-td" colspan="3"><input class="datepicker" name="business_begin" value="<fmt:formatDate value="${business.business_begin}" pattern="yyyy/MM/dd"></fmt:formatDate>" /></td>
								<td class="name-td" style="text-align: center;">종료일자</td>
								<td class="table-td"><input class="datepicker" name="business_end" value="<fmt:formatDate value="${business.business_begin}" pattern="yyyy/MM/dd"></fmt:formatDate>" /></td>
							</tr>
							<tr style="height: 200px;">
								<td class="name-td" style="text-align: center;">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea name="business_content" class="summernote" rows="15" cols="40" style="display:none; width:500px;">${business.business_content}</textarea></td>
							</tr>

							<tr>
								<td class="name-td" style="text-align: center;">총예산</td>
								<td class="table-td" colspan="3"><input name="business_budget" type="text" value="${business.business_budget}" /></td>
								<td class="name-td" style="text-align: center;">사용예산</td>
								<td class="table-td" colspan="2">${business.business_usebudget}</td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">국가지원예산</td>
								<td class="table-td" colspan="3"><input name="business_nationbudget" type="text" value="${business.business_nationbudget}" /></td>
								<td class="name-td" style="text-align: center;">회사자체예산</td>
								<td class="table-td" colspan="2"><input name="business_companybudget" type="text" value="${business.business_companybudget}" /></td>
							</tr>
						</tbody>
					</table>
					</form>
				</div>
			</div>
			<div class="card-tools" style="margin-left:auto">
				<button type="button" id="modifyBtn" class="btn btn-info" onclick="modify_go();">수정</button>
		    	<button type="button" id="listBtn" class="btn btn-info" onclick="location.href='detail?business_number=${business.business_number}';">취소</button>
			</div>
		</div>
	</div>
	<!-- 공지 사항 상세 정보 끝 -->

</div>

<script>
	window.onload = function() {
		summernote_go($('.summernote'),'<%=request.getContextPath()%>');
	};
	
</script>

<script>

	window.onload = function() {
		summernote_go($('.summernote'),'<%=request.getContextPath()%>');
		$('.datepicker').datepicker();
	};
	
</script>

<script>

function modify_go(){
	
	$("form[role='form']").submit();

}
	   
</script>


