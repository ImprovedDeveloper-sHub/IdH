<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
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
	border: none;
}
</style>

<!-- CSS end -->



<div class="header" style="width: 680px; height: 555px;">
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">요구사항등록</h3>
			<div class="card-tools">
				<div class="input-group input-group-sm" style="width: 150px;">
					<div class="input-group-append"></div>
				</div>
			</div>
		</div>
		<div id="content">
			<div id="table-content">
				<form enctype="multipart/form-data" role="form" method="post"
					action="regist" name="registForm">
					<table>
						<thead>
							<tr>

								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" colspan="3" style="width: 35%;">세부사항</td>
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 35%;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td"><input type="text" name="require_title"
									placeholder="제목을 입력하세요" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								
							</tr>
							<tr>
								<td class="name-td">발의자</td>
								<td class="table-td"><input type="text" readonly
									placeholder="${loginUser.member_id } " /></td>
									<td class="table-td"></td>
									<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td colspan="5"><input type="text" readonly
									placeholder="<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>" /></td>
							</tr>
							<tr>
								<td class="name-td">중요도</td>
								<td class="table-td">
								<select class="form-control col-md-3" name="require_level">
							<option value="1" ${require.require_number eq 1 ? 'selected':'하' }>하</option>
							<option value="2" ${require.require_number eq 2 ? 'selected':'중' }>중</option>
							<option value="3" ${require.require_number eq 3 ? 'selected':'상' }>상</option>																			
						</select></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">관련사업</td>
								<td colspan="5"><input type="text" name="require_business" readonly
									placeholder="관련사업" />${business.business_name }</td>
							</tr>
							<tr>
								<td class="name-td">프로젝트 팀</td>
								<td class="table-td"><input type="text" name="require_project"
									placeholder="미정" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">담당자</td>
								<td colspan="5"><input type="text" name="require_getter_id"
									placeholder="담당자 미정" /></td>
							</tr>
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea
										class="summernote" rows="15" cols="40" name="require_detail"
										style="display: none; width: 500px;"></textarea></td>
							</tr>


						</tbody>
					</table>
					<div class="fileUpload">
						<span><i class="fa fa-plus-circle"></i> Add File</span> <input
							type="file" class="upload" id="files" name="files" multiple />
					</div>

					<ul id="selectedFiles"></ul>
				</form>
			</div>
		</div>
		<div class="card-tools" style="margin-left: auto">
			<!-- <button type="button" id="tempbtn" class="btn btn-info"
				onclick="regist_go();">임시저장</button> -->
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

<script>
$('input:file[multiple]').change(
	      function(e){
	        // console.log(e.currentTarget.files);
	        var numFiles = e.currentTarget.files.length;
	        for (i=0;i<numFiles;i++){
	        $('<li>').text(e.currentTarget.files[i].name).appendTo($('#selectedFiles'));
	        $('<span>').addClass('filesize').text('(' + filesize + 'kb)').appendTo($('#selectedFiles li:last'));
	      }
	    });
</script>