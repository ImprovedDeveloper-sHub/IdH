<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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



<div class="header"style="width:680px;height:555px;">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">산출물등록</h3>
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
								
								<td class="name-td">작성자</td>
								<td class="name-td">글번호</td>
								<td class="table-td"><input type="text"
									name="product_member_id" readonly value="${loginUser.member_id }" /></td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td"><input type="text"
									name="product_title" placeholder="제목을 입력하세요" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td colspan="5"><input type="text" readonly
									value='<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>' /></td>
							</tr>
						
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote"  colspan="5"><textarea class="summernote" rows="15" cols="40"name="product_content" style="display:none; width:500px;"></textarea></td>
							</tr>
							<tr style="display:none;">
							<td><input name="product_project_number" value="1"></td>
							</tr>
							<tr style="display:none;">
							<td><input name="product_status" value="1"></td>
							</tr>
							<tr style="display:none;">
							<td><input name="product_stage" value="1"></td>
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
               onclick="CloseWindow();">닫기</button>
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
	   
	 
	   
	   $("form[role='form']").submit();
	   
}
</script>

