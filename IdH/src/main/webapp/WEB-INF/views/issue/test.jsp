<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
table input {
	width: 100%;
	font-size: 13px;
	color: #64697a;
	border:none;
}
.content-list #title{
	width:100px;
}
.content-list table input{
	 border:solid black 1px;
	 padding:5px 0;
}
</style>

<div class="content row">
	<div class="col-8 content-list card">
		<table style="width:100%;">
			<tr>
				<td id="title">사업</td>
				<td id="content"><select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:100% !important; border-color:#CED4DA !important;">
							<option>사업선택</option>
							<c:forEach items="${issueList }" var="issue">
							<option >${bussnes.name }</option>
							</c:forEach>
						</select></td>
			</tr>
			<tr>
				<td id="title">요구사항</td>
				<td id="content"><input type="text" placeholder="요구사항을 입력하세요." /></td>
			</tr>
			<tr>
				<td id="title">예상일정</td>
				<td id="content"><input type="text" placeholder="예상일정을 입력하세요." /></td>
			</tr>
			<tr>
				<td id="title">예산계획</td>
				<td id="content"><input type="text" placeholder="예산계획을 입력하세요." /></td>
			</tr>
			<tr>
				<td id="title">예상인력</td>
				<td id="content"><input type="text" placeholder="예상인력을 입력하세요." /></td>
			</tr>
			<tr>
				<td id="title">내용</td>
				<td id="content"><textarea id="summernote" name="summernote" rows="5" cols="40"></textarea></td>
			</tr>
		</table>
	</div>
	<div class="col-4 content-util card">
		<select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:100% !important; border-color:#CED4DA !important;">
							<option>사업선택</option>
							<c:forEach items="${issueList }" var="issue">
							<option >${bussnes.name }</option>
							</c:forEach>
						</select>
	</div>
</div>

<script>
	window.onload = function() {
		summernote_go($('#summernote'),'<%=request.getContextPath()%>');
	};
</script>
