<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
  
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
			<div class="card-header">
				<h3 class="card-title">일정수정</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<form enctype="multiaprt/form-data" role="form" method="post" action="modifySchedule" name="modifyScheduleForm">
				<input type="hidden" name="schedule_status" value="2">
				<input type="hidden" name="schedule_number" value="${schedule.schedule_number }"/>
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
								<td class="table-td" colspan="3" ><input type="text" name="schedule_member_id" value="${loginUser.member_id} " /></td>
								<td class="name-td">분류</td>
								<td class="table-td"><select name ="schedule_level">
													<option value="1">기획</option>
													<option value="2">설계</option>
													<option value="3">구현</option>
													<option value="4">테스트</option>
									</select></td>
							</tr>
							<tr>
								<td class="name-td">시작날짜</td>
								<td class="table-td" colspan="3"><fmt:formatDate value="${schedule.schedule_startdate }" pattern ="yyyy-MM-dd"/></td>
								<td class="name-td">종료날짜</td>
								<td class="table-td" colspan="3"><input class="datepicker" name="schedule_enddate" value="<fmt:formatDate value="${schedule.schedule_enddate }" pattern ="yyyy/MM/dd"/>"></td>
								
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td colspan="5"><input type="text" name="schedule_name" value=${schedule.schedule_name }
									 /></td>
							</tr>
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea class="summernote" rows="15" cols="40" style="display:none;" name="schedule_detail">${schedule.schedule_detail }</textarea></td>
							</tr>

							<tr>
								<td class="name-td">프로젝트명</td>
								<td class="table-td">${schedule.schedule_project_number }<select>
													
									</select></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
							</tr>
						</tbody>
					</table>
				</div>
				</form>
			</div>
			<div class="card-tools" style="margin-left:auto">
            <button type="button" id="regbtn" class="btn btn-info"
               onclick="modify_go();">수정</button>
            <button type="button" id="close" class="btn btn-info"
               onclick="CloseWindow();">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	window.onload = function() {
		summernote_go($('.summernote'),'<%=request.getContextPath()%>');
		$('.datepicker').datepicker();
	};
	
	function modify_go(){
		//var form = $('form[name="registSchdeulForm"]')[0];
			var form = document.modifyScheduleForm;
			/* if(form.schedule_name.value==""){
				alert("제목은 필수입니다.");
				return;
			}
			 */
			form.submit();
		}
</script>

