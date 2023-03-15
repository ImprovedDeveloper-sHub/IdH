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
	border: none;
}
</style>

<!-- CSS end -->



<div class="header" style="width: 680px; height: 555px;">
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">요구사항수정</h3>
			<div class="card-tools">
				<div class="input-group input-group-sm" style="width: 150px;">
					<div class="input-group-append"></div>
				</div>
			</div>
		</div>
		<div id="content">
			<div id="table-content">
				<form enctype="multiaprt/form-data" role="form" method="post"
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
								<td class="table-td">${require.require_title }<input type="text"
									placeholder="제목을 입력하세요" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								
							</tr>
							<tr>
								<td class="name-td">발의자</td>
								<td class="table-td">${require.require_writer_id }</td>
									<td class="table-td"></td>
									<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td colspan="5"><fmt:formatDate value="${require.require_regdate }" pattern="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<td class="name-td">중요도</td>
								<td class="table-td"><input type="text" placeholder="${require.require_level }" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">관련사업</td>
								<td colspan="5"><input type="text" placeholder="${require.require_business }" /></td>
							</tr>
							<tr>
								<td class="name-td">프로젝트 팀</td>
								<td class="table-td"><input type="text"
									placeholder="${require.require_project }" /></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">담당자</td>
								<td colspan="5"><input type="text" placeholder="${require.require_member_id }" /></td>
							</tr>
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"><textarea
										class="summernote" rows="15" cols="40"
										style="display: none; width: 500px;"></textarea></td>
							</tr>


						</tbody>
					</table>
				</form>
			</div>
		</div>
		<div class="card-tools" style="margin-left: auto">
			<button type="button" id="regbtn" class="btn btn-info"
				onclick="submit_go('modifyForm','${require.require_number }');">수정</button>
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
function modify_submit(){
	//alert("modify btn click");
	var form = $('form [name="modifyForm"]');
	
	//유효성 체크
	if($("input[name='title']").val()==""){
		alert(input.name+"은 필수입니다.");
		$("input[name='title']").focus();
		return;
	}
	
	//파일 첨부확인
	var files = $('input[name="uploadFile"]');
	for(var file of files){
		console.log(file.name+" : "+file.value);
		if(file.value==""){
			alert("파일을 선택하세요.");
			file.focus();
			return false;
		}
	}	
	
	form.submit();
}

window.onload=function(){
	summernote_go($('#content'),'<%=request.getContextPath()%>');
}

</script>

<script>
function removeFile_go(className){
	var li = $('li.'+className);
	
	if(!confirm(li.attr("file-name")+"을 정말 삭제하시겠습니까?")){
		return;
	}    
	
	li.remove();
	
	var input=$('<input>').attr({"type":"hidden",
		 "name":"deleteFile",
		 "value":li.attr("target-ano")
		}); 
	$('form[role="form"]').prepend(input);
}

var dataNum=0;

function addFile_go(){
	//alert("add file btn");
	
	var attachedFile=$('a[name="attachedFile"]').length; //기존파일
	var inputFile=$('input[name="uploadFile"]').length;	 //추가된 파일
	var attachCount=attachedFile+inputFile; //기존파일 + 추가된파일 개수
	
	if(attachCount >=5){
		alert("파일추가는 5개까지만 가능합니다.");
		return;
	}
	
	var div=$('<div>').addClass("inputRow").attr("data-no",dataNum);
	var input=$('<input>').attr({"type":"file","name":"uploadFile"}).css("display","inline");
	div.append(input).append("<button onclick='remove_go("+dataNum+");' style='border:0;outline:0;' class='badge bg-red' type='button'>X</button>");	
	$('.fileInput').append(div);	
	dataNum++;
}
</script>