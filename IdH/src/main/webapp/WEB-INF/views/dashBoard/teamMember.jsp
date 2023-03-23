<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link
	href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css'
	rel='stylesheet' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>



<style>
#calendar1 {
	width: 100%;
	height: 88vh;
}

a {
	color: inherit;
	text-decoration: none;
}

#calendar button {
	width: 80px;
}
</style>

<div class="content">

	<div class="col-md-12">

		<div class="row" style="padding-top: 10px;">

			<!-- 캘린더 -->
			<div class="col-md-8">
				<div class="card" style="height: 95vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray;">
						<h3 class="card-title" style="color: black;">프로젝트 일정</h3>
					</div>

					<div id="calendar1">
						<!-- class="fc fc-media-screen fc-direction-ltr fc-theme-standard">
						<div class="fc-header-toolbar fc-toolbar fc-toolbar-ltr">
							<div class="fc-toolbar-chunk"></div>
							<div class="fc-toolbar-chunk">
								<div class="fc-button-group">
									<button class="fc-today-button fc-button fc-button-primary"
										type="button" disabled="">오늘</button>
									&nbsp;&nbsp;
									<button class="fc-prev-button fc-button fc-button-primary"
										type="button" aria-label="prev">
										<span class="fc-icon fc-icon-chevron-left"></span>
									</button>
									<button class="fc-next-button fc-button fc-button-primary"
										type="button" aria-label="next">
										<span class="fc-icon fc-icon-chevron-right"></span>
									</button>
								</div>
							</div>
						</div> -->
					</div>
				</div>
			</div>

			<div class="col-md-4">

				<div class="card card-row card-primar" style="height: 30vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray;">
						<h3 class="card-title" style="color: black;">납기일</h3>
					</div>


				</div>

				<div class="card card-row card-primar" style="height: 30vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray;">
						<h3 class="card-title" style="color: black;">내 이슈</h3>
					</div>

					<div id="table-content" style="overflow:auto; ">

						<table class="table table-hover table-head-fixed">
						
							<thead class="text-left myThead ">
								<tr>
									<th style="width: 20%">제목</th>
									<th style="width: 30%">내용</th>
									<th style="width: 20%">작성일</th>
									<th style="width: 15%">할당자</th>
									<th style="width: 15%">수준</th>
								</tr>
							</thead>
							
							<tbody class="text-left myli">
								<c:if test="${empty myIssueList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${myIssueList }" var="issue">
									<tr
										onclick="javascript:OpenWindow('<%=request.getContextPath()%>/issue/detail.do?from=main&issue_number=${issue.issue_number}','상세보기',600,508);">

										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_title}</td>
										<td
											style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_content}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${issue.issue_regdate}" pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_getter_id }</td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											${issue.issue_level}</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>

					</div>

				</div>

				<div class="card card-row card-primar" style="height: 30vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray;">
						<h3 class="card-title" style="color: black;">내 작업</h3>
					</div>


				</div>

			</div>

		</div>
		<!-- E:row -->

	</div>
	<!-- E:col-md-12 -->

</div>
<!-- E:content -->



<!-- <script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');

		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar : {
				left : 'title'
			},

			selectable : true,
			nowIndicator : true,
			dayMaxEvents : true,
			locale : 'ko',
			selectMirror : true

		});
		calendar.render();
	});
</script> -->

<script>
	window.onload = function() {
		url = "getProjectCalendar"
		$.ajax({
			type : 'get',
			cache : false,
			url : url,
			dataType : 'json',
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(param) {
				var events = [];
				$.each(param, function(index, date) {
					//console.log(date);
					events.push({
						title : date.title,
						start : date.start,
						end : date.end
					});
				})

				//alert(JSON.stringify(events));
				JsonData = events;
				//alert(JsonData);

				// calendar element 취득
				var calendarEl = $('#calendar1')[0];
				// full-calendar 생성하기
				var JsonData;

				var calendar = new FullCalendar.Calendar(calendarEl, {
					// 해더에 표시할 툴바
					/* initialDate : '2023-03-13', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.) */
					locale : 'ko', // 한국어 설정
					timeZone : 'Asia/Seoul',
					//editable : true, // 수정 가능
					/* droppable: true,  // 드래그 가능
					drop: function(arg) { // 드래그 엔 드롭 성공시
					  // 드래그 박스에서 아이템을 삭제한다.
					   manage_Schedule('regist');
					  arg.draggedEl.parentNode.removeChild(arg.draggedEl);
					}, */

					events : JsonData

				});
				// 캘린더 랜더링

				calendar.render();
			},

		});

	}
</script>