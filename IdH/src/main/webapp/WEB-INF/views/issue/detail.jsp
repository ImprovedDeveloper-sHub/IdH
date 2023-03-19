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
</style>

<!-- CSS end -->
<div class="row">

	<!-- 사업 일정 상세 정보 -->
	<div class="col-12" style="height: 100%;">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">이슈등록</h3>
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
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" colspan="3" style="width: 35%;">세부사항</td>
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 35%;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td">글번호</td>
								<td class="table-td">${issue.issue_number }</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">수준</td>
								<td class="table-td">${issue.issue_level }</td>
							</tr>
							<tr>
								<td class="name-td">등록자</td>
								<td class="table-td">${loginUser.member_id }</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">할당자</td>
								<c:if test="${!empty issue.issue_getter_id }">
									<td class="table-td">${issue.issue_getter_id }</td>
								</c:if>
								<c:if test="${empty issue.issue_getter_id }">
									<td class="table-td">할당자가 없습니다.</td>
								</c:if>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td">${issue.issue_title }</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr style="height: 130px;">
								<td class="name-td">내용</td>
								<td class="table-td" colspan="5" style="height: 250px;">${issue.issue_title }</td>
							</tr>

							<tr>
								<td class="name-td">프로젝트명</td>
								<td class="table-td">${issue.issue_project_number }</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td class="table-td"><fmt:formatDate
										value="${issue.issue_regdate}" pattern="yyyy-MM-dd" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="card-tools" style="margin-left: auto">
				<button type="button" id="modifyBtn" class="btn btn-info"
					onclick="submit_go('modifyForm','${issue.issue_number }');">수정</button>
				<button type="button" id="removeBtn" class="btn btn-info"
					onclick="submit_go('remove','${issue.issue_number }');">삭제</button>
				<button type="button" id="listBtn" class="btn btn-info"
					onclick="CloseWindow();">닫기</button>
			</div>
		</div>
	</div>
</div>
<script>
	function submit_go(url, issue_number) {
		location.href = url + "?issue_number=" + issue_number;
	}
</script>

<c:if test="${from eq 'modify'}">
	<script>
		alert("정상적으로 수정되었습니다.");
		window.opener.location.reload();
	</script>
</c:if>



