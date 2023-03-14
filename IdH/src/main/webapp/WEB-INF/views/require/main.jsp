<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
#external-events {
	position: fixed;
	left: 20px;
	top: 20px;
	width: 100px;
	padding: 0 10px;
	border: 1px solid #ccc;
	background: #eee;
	text-align: left;
}

#external-events h4 {
	font-size: 16px;
	margin-top: 0;
	padding-top: 1em;
}

#external-events .fc-event {
	margin: 3px 0;
	cursor: move;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 11px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

#calendar1 {
	max-width: 1100px;
	margin: 0 auto;
	background: white;
}

.fc-header-toolbar {
	max-width: 1100px;
	font-size: 11px;
}
</style>
<!-- jquery CDN -->
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

<div class="content">
	<div class="row">
		<div class="col-8">
			<div>
				<div id="content" class="card">
					<div class="card-header">
						<h3 class="card-title">요구사항</h3>
					</div>
					<div class="card-tools"
						style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
						<div class="input-group input-group-sm" style="width: 270px">
							<select class="form-control-sm" name="searchType" id="searchType"
								style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
								<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전체</option>
								<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
								<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
								<option value="c" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							</select> <input type="text" name="table_search"
								class="form-control float-right" placeholder="Search">
							<div class="input-group-append">


								<button type="submit" class="btn btn-default"
									onclick="list_go(1)">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
						<button type="button" class="btn btn-block btn-info btn-sm"
							style="width: 80px;"
							onclick="OpenWindow('registForm','등록',680,800);">등록</button>
					</div>
					<div id="table-content">
						<div class="card-body table-responsive p-0">
							<table class="table table-hover">
								<thead class="text-left">
									<tr>
										<th style="width: 15%">요구사항번호</th>
										<th style="width: 30%">제목</th>
										<th style="width: 20%">중요도</th>
										<th style="width: 10%">출처</th>
										<th style="width: 10%">등록일자</th>
										<th style="width: 15%">등록자</th>
									</tr>
								</thead>
								<tbody class="text-left">
									<c:if test="${empty requireList}">
										<tr>
											<td colspan="8">데이터가 없습니다.</td>
										</tr>
									</c:if>
									<c:forEach items="${requireList }" var="require">
										<tr onclick="OpenWindow('detail?require_number=${require.require_number}','상세보기',680,800);">
											<td
												style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${require.require_number}</td>
											<td
												style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${require.require_title}</td>
											<td
												style="text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${require.require_level }</td>
											<c:forEach items="${require.attachList }" var="attach">
												<td
													style="text-align: left; max-width: 35%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${attach.ano}</td>
											</c:forEach>
											<td
												style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
													value="${require.require_regdate}" pattern="yyyy-MM-dd" /></td>
											<td
												style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
												${require.require_writer_id}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br />
							<div class="col-3" style="margin: 0 auto;">
								<nav aria-label="Navigation">
									<ul class="pagination justify-content-center m-0">
										<li class="page-item"><a class="page-link"
											href="javascript:list_go(1);"> <i
												class="fas fa-angle-double-left"></i>
										</a></li>
										<li class="page-item"><a class="page-link"
											href="javascript:list_go(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
												<i class="fas fa-angle-left"></i>
										</a></li>
										<c:forEach var="pageNum" begin="${pageMaker.startPage }"
											end="${pageMaker.endPage }">

											<li
												class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
												<a class="page-link"
												href="javascript:list_go('${pageNum}');">${pageNum }</a>
											</li>
										</c:forEach>

										<li class="page-item"><a class="page-link"
											href="javascript:list_go(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
												<i class="fas fa-angle-right"></i>
										</a></li>

										<li class="page-item"><a class="page-link"
											href="javascript:list_go('${pageMaker.realEndPage}');"> <i
												class="fas fa-angle-double-right"></i>
										</a></li>
									</ul>
								</nav>
							</div>
							<br />
						</div>


					</div>

				</div>




			</div>
		</div>
		<!-- 드래그 박스 -->
		<div id='external-events'>
			<h4>Draggable Events</h4>
			<div id='external-events-list'></div>
		</div>
		<!-- calendar 태그 -->
		<div class="col-4">
			<div id='calendar-wrap'>
				<div id='calendar1'></div>
			</div>
		</div>
	</div>
</div>
<!--row종료-->
</div>
<!--content종료-->

<script>
	function submit_go(url, pno) {
		location.href = url + "?pno=" + pno;
	}
</script>

<script>
	(function() {
		$(function() {
			// 드래그 박스 취득
			var containerEl = $('#external-events-list')[0];
			// 설정하기
			new FullCalendar.Draggable(containerEl, {
				itemSelector : '.fc-event',
				eventData : function(eventEl) {
					return {
						title : eventEl.innerText.trim()
					}
				}
			});
			// 드래그 아이템 추가하기
			for (var i = 1; i <= 5; i++) {
				var $div = $("<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'></div>");
				$event = $("<div class='fc-event-main'></div>").text(
						"Event " + i);
				$('#external-events-list').append($div.append($event));
			}
			// calendar element 취득
			var calendarEl = $('#calendar1')[0];
			// full-calendar 생성하기
			var calendar = new FullCalendar.Calendar(calendarEl, {
				// 해더에 표시할 툴바
				headerToolbar : {
					left : 'prev,next today',
					center : 'title',
					right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
				},
				initialDate : '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
				locale : 'ko', // 한국어 설정
				editable : true, // 수정 가능
				droppable : true, // 드래그 가능
				drop : function(arg) { // 드래그 엔 드롭 성공시
					// 드래그 박스에서 아이템을 삭제한다.
					arg.draggedEl.parentNode.removeChild(arg.draggedEl);
				}
			});
			// 캘린더 랜더링
			calendar.render();
		});
	})();
</script>


