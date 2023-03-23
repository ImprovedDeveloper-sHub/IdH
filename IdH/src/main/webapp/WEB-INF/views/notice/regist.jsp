<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



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
	/* border-bottom: #eaecee solid 1px; */
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



<div class="header">
		<div class="card card-info" style="height: 80%;">
			<div class="card-header">
				<h3 class="card-title">정책등록</h3>
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
								<td class="name-td">글번호</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">작성자</td>
								<td class="table-td"><input name="notice_member_id" type="text" readonly value="${loginUser.member_id}" /></td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td"><input name="notice_title" type="text" value="제목을 입력하세요" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td colspan="5"><input name="notice_regdate" type="text" readonly value="${sysdate}" /></td>
							</tr>
						
							<tr>
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" style="height: 330px;" colspan="5"><textarea name="notice_content" class="summernote" rows="30" cols="40" style="display:none; width:500px;"></textarea></td>
							</tr>

						</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="card-tools" style="margin-left: 1050px">
    	<button type="button" id="regbtn" class="btn btn-info"
    		onclick="regist_go();">등록</button>
    	<button type="button" id="close" class="btn btn-info"
    		onclick="location.href='main';">취소</button>
    </div>
<script>
	window.onload = function() {
		summernote_go($('.summernote'),'<%=request.getContextPath()%>');
	};
</script>
<script>
function regist_go(){
	   
	 
	   
	   $("form[role='form']").submit();
	   
	
</script>

