<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!-- My CSS start -->

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

#table-content tbody tr:hover {
	background: #fefaf2;
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
</style>

<!-- My CSS end -->



<div class="row">

	<!-- 공지 사항 상세 정보 -->
	<div class="col-12">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">공지 사항 상세 정보</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<table>
						<thead>
							<tr>
								<td class="name-td">분류</td>
								<td class="name-td" style="width: 40%;">세부사항</td>
								<td class="name-td">분류</td>
								<td class="name-td" style="width: 40%;">세부사항</td>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td class="name-td">번호</td>
								<td class="table-td">${notice.notice_number}</td>
								<td class="name-td">구분</td>
								<td class="table-td">${notice.notice_level}</td>
							</tr>
							<tr>
								<td class="name-td">작성자</td>
								<td class="table-td">${notice.notice_member_id }</td>
								<td class="name-td">등록일</td>
								<td class="table-td"><fmt:formatDate
										value="${notice.notice_regdate}" pattern="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td">${notice.notice_title}</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
							</tr>
							<tr>
								<td class="name-td">내용</td>
								<td class="table-td" style="height: 250px;">${notice.notice_content}</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
							</tr>
							<c:forEach items="${notice.notice_attachList }" var="attach">
								<tr>
									<td class="name-td">첨부파일</td>
									<td class="table-td">${attach.filename }</td>
									<td class="table-td"><fmt:formatDate
											value="${attach.regdate }" pattern="yyyy-MM-dd" /></td>
									<td class="table-td" class="attach-box"
										style="cursor: pointer;"
										onclick="location.href='<%=request.getContextPath()%>/notice/getFile?ano=${attach.ano}';">
										<i class="fa-solid fa-download"></i>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="card-tools" style="margin-left: auto">
		<button type="button" id="removeBtn" class="btn btn-info"
			onclick="submit_go('remove','${notice.notice_number }');">삭제</button>
		<button type="button" id="listBtn" class="btn btn-info"
			onclick="location.href='main';">목록</button>&nbsp;&nbsp;
	</div>
	<!-- 공지 사항 상세 정보 끝 -->

</div>


<script>
	function submit_go(url, notice_number) {
		location.href = url + "?notice_number=" + notice_number;
	}
</script>
<c:if test="${from eq 'modify'}">
	<script>
		alert("정상적으로 수정되었습니다.");
		window.opener.location.reload();
	</script>
</c:if>
<c:if test="${from eq 'remove'}">
	<script>
		alert("삭제되었습니다.");
		window.location.reload();
	</script>
</c:if>

