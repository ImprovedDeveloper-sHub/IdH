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
	border: none;
}

.fileUpload {
	position: relative;
	overflow: hidden;
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	border: 1px solid #357ebd;
	border-radius: 4px;
	color: #fff;
	background: #428bca;
}

.fileUpload input.upload {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 20px;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity = 0);
}
</style>

<!-- CSS end -->




<div class="header" style="width: 680px; height: 555px;">
	<div class="card card-info">
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
								<td class="table-td"><input type="text"
									name="companyrule_title" placeholder="제목을 입력하세요" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								
								
							</tr>
							
							<tr>
								<td class="name-td">등록자</td>
								<td class="table-td"><input type="text" name="companyrule_member_id" readonly
									value="${loginUser.member_id }" /></td>
									<td class="table-td"></td>
									<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td colspan="5"><input type="text" readonly
									value='<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>' /></td>
									
							</tr>
						
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea
										class="summernote" rows="15" cols="40" name="companyrule_content"
										style="display: none; width: 500px;"></textarea></td>
						
						</tbody>

					</table>
					<div class="fileUpload">
						<span><i class="fa fa-plus-circle"></i> Add File</span> <input
							type="file" class="" id="files" name="files" multiple />
					</div>

					<ul id="selectedFiles"></ul>

				</form>
			</div>
		</div>

		<div class="card-tools" style="margin-left: auto">
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
