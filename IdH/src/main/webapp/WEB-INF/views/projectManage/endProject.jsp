<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  

<!-- CSS start -->

<style>
card{
	margin:0 !important;
	padding:0 !important;
}

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
				<h3 class="card-title">프로젝트 종료</h3>
				
			</div>
			<div class="card-tools">
					<div class="input-group" style="width: 300px;">
						<select class="form-control-sm" name="project_number" id="project_selector" style="hegith:30px; width:100% !important; border-color:#CED4DA !important;">
							<option value="">프로젝트를 선택해주세요.</option>
							<c:forEach items="${proceedingProjectList}" var="project">
								<option value="${project.project_number}">${project.project_name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			<div class="card-tools" style="margin-left:auto">
            <button type="button" id="regbtn" class="btn btn-info"
               onclick="deleteProject();">종료</button>
            <button type="button" id="close" class="btn btn-info"
               onclick="CloseWindow();">닫기</button>
				</div>
			</div>
		</div>
	</div>

<script>
	function deleteProject(){
		location.href='endProject?project_number='+$('#project_selector').val();
	}

</script>

