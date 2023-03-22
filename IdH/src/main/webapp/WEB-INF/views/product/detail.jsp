<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- CSS start -->

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



<div class="header"style="width:680px;height:400px;">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">상세화면</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
				<form enctype="multiaprt/form-data" role="form" method="post" action="regist" name="registForm">
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
								<td class="name-td">글번호</td>
								<td class="table-td">${product.product_number }</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">작성자</td>
								<td class="table-td">${product.product_member_id }</td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td">${product.product_title }</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td colspan="5"><fmt:formatDate
												value="${product.product_regdate}"
												pattern="yyyy-MM-dd"/></td>
							</tr>
						
							<tr style="height: 100px;">
							<td class="name-td">내용</td>
								<td class="table-td">${product.product_content }</td>
							</tr>

						</tbody>
					</table>
					</form>
										
							
						
				</div>
			</div>
			
			<div class="card-tools" style="margin-left:auto">
			
			<button type="button" id="modifyBtn" class="btn btn-info" onclick="submit_go('modifyForm','${product.product_number }');">수정</button>						
		    <button type="button" id="removeBtn" class="btn btn-info" onclick="submit_go('remove','${product.product_number }');">삭제</button>					   
		    <button type="button" id="listBtn" class="btn btn-info" onclick="CloseWindow();">닫기</button>
		</div>
		</div>
	</div>

<script>
function submit_go(url,product_number ){	
	location.href=url+"?product_number="+product_number;
}
</script>

<c:if test="${from eq 'modify'}" >
	<script>
		alert("정상적으로 수정되었습니다.");
		window.opener.location.reload();
	</script>
</c:if>    


