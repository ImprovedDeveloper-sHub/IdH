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

ul, li {
	list-style: none;
}

.faq-box {
	border: 2px solid black;
	background-color: #343434;;
	color: white;
	padding: 5px 0;
	font-size:14px;
}

.faq-box__question {
	cursor: pointer;
}

.faq-box__question::after {
	content: "[+]";
	float: right;
}


.faq-box>ul>li.hover>.faq-box__question::after {
	content: "[-]";
}

.faq-box__answer {
	display: none;
	background-color: #565656;
	border-radius: 10px;
}

.faq-box>ul>li.hover>.faq-box__answer {
	display: block;
}
</style>

<!-- CSS end -->
<div class="row">

	<!-- 사업 일정 상세 정보 -->
	<div class="col-12" style="height: 100%;">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">이슈등록</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content" style="margin: 0 !important;">
				<div id="table-content" style="margin: 0 !important;">
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
								<c:if test="${issue.issue_level eq 1 }">
									<td class="table-td">하</td>
								</c:if>
								<c:if test="${issue.issue_level eq 2 }">
									<td class="table-td">중</td>
								</c:if>
								<c:if test="${issue.issue_level eq 3 }">
									<td class="table-td">상</td>
								</c:if>
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
								<td class="table-td" colspan="5" style="height: 250px;">${issue.issue_content }</td>
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
							<c:forEach items="${issue.attachList }" var="attach">
								<tr>
									<td class="name-td">첨부파일</td>
									<td class="table-td">${attach.fileName }</td>
									<td class="table-td"></td>
									<td class="table-td"></td>
									<td class="table-td"><fmt:formatDate
											value="${attach.regDate }" pattern="yyyy-MM-dd" /></td>
									<td class="table-td" class="attach-box"
										style="cursor: pointer;"
										onclick="location.href='<%=request.getContextPath()%>/issue/getFile?ano=${attach.ano }';">
										<i class="fa-solid fa-download"></i>
									</td>
								</tr>
							</c:forEach>
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


<section class="section section-faq">
		<div class="faq-box">
			<ul>
				<li>
					<div id="faq-box__question" class="faq-box__question">
						<span>댓글</span>
					</div>
					<div class="faq-box__answer">
						<section class="content container-fluid">
							<!-- reply component start -->

							<div class="card-body">
								<!-- The time line -->
								<div class="timeline">
									<!-- timeline time label -->
									<div class="time-label" id="repliesDiv"></div>


								</div>
								<div class='text-center'>
									<ul id="pagination"
										class="pagination justify-content-center m-0">

									</ul>
								</div>
							</div>
							<div class="card-footer">
								<input class="form-control" type="text" placeholder="REPLY TEXT"
									id="newReplyText" /> <br />
								<button type="button" class="btn btn-info" id="replyAddBtn"
									onclick="replyRegist_go();">댓글등록</button>
							</div>

						</section>
					</div>

				</li>
			</ul>
		</div>

</section>


<div id="modifyModal" class="modal modal-default fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" style="display: none;"></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body" data-rno>
				<p>
					<input type="text" id="replytext" class="form-control">
				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" id="replyModBtn"
					onclick="replyModify_go();">수정</button>
				<button type="button" class="btn btn-info" id="replyDelBtn"
					onclick="replyRemove_go();">삭제</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>



<form role="form">
	<input type="hidden" name="issue_number" value="${issue.issue_number }" />
</form>

<script>
	function modify_go() {
		var formObj = $("form[role='form']");
		formObj.attr({
			'action' : 'modifyForm.do',
			'method' : 'get'
		});
		formObj.submit();
	}
	function remove_go() {
		var formObj = $("form[role='form']");
		var answer = confirm("정말 삭제하시겠습니까?");
		if (answer) {
			formObj.attr("action", "remove");
			formObj.attr("method", "post");
			formObj.submit();
		}
	}
</script>



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


<script>
	function FaqBox__init() {
		$('.faq-box > ul > li')
				.click(
						function() {
							let $this = $(this);

							$this.siblings('.hover')
									.find(' > .faq-box__answer').stop()
									.slideUp(300); // 추가
							$this.siblings('.hover').removeClass('hover');

							if ($this.hasClass('hover')) {
								$this.find(' > .faq-box__answer').stop()
										.slideUp(300); // 추가
								$this.removeClass('hover');
							} else {
								$this.find(' > .faq-box__answer').stop()
										.slideDown(300); // 추가
								$this.addClass('hover');
							}
						});

		$('.faq-box__answer').click(function() {
			return false;
		});
	}

	FaqBox__init();
</script>



<!-- <script>
	function change(li){
		li.siblings('.hover').removeClass('hover');

		if (li.hasClass('hover')) {
			li.removeClass('hover');
		} else {
			li.addClass('hover');
		}
		
	}
</script> -->


<%@ include file="./reply_js.jsp"%>


