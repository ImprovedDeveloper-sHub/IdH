<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
  

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
				<h3 class="card-title">인력등록</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<form enctype="multiaprt/form-data" role="form" method="post" action="registWorkforce" name="registWorkforceForm">
				<input type="hidden" name="workforce_status" value="2">
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
								<td class="name-td">인력 선택</td>
								<td class="table-td" colspan="3" ><input id="workforce_member_id" type="text" name="workforce_member_id" value="" ></td>
								<td class="name-td">분류</td>
								<td class="table-td"><select name ="workforce_type">
													<option value="2">PL</option>
													<option value="3">DA</option>
													<option value="4">TA</option>
													<option value="5">AA</option>
													<option value="6">BA</option>
									</select></td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td colspan="5"><input id="workforce_name" type="text" name="workforce_name" placeholder="제목을 입력하여 주세요." /></td>
							</tr>
							<tr>
								<td class="name-td">시작날짜</td>
								<td class="table-td" colspan="3"><input class="datepicker" name="workforce_startdate" ></td>
								<td class="name-td">종료날짜</td>
								<td class="table-td" colspan="3"><input class="datepicker" name="workforce_enddate"></td>
								
							</tr>
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea class="summernote" rows="15" cols="40" style="display:none;" name="workforce_detail"></textarea></td>
							</tr>

							<tr>
								<td class="name-td">프로젝트명</td>
								<td class="table-td"><select name="workforce_project_number">
											<c:forEach items="${projectList}" var="project">
												<option value="${project.project_number}">${project.project_name}</option>
											</c:forEach>
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
		var form = $('form[name="registWorkforceForm"]')[0];
			//var form = document.registBudegetForm;
			/* if(form.workforce_name.value==""){
				alert("제목은 필수입니다.");
				return;
			} */
			
			form.submit();
		}
	
	
</script>


