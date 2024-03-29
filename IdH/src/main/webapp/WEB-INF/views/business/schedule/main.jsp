<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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



<!-- My CSS start -->

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

<!-- My CSS end -->



<div class="row">

	<!-- 사업 일정 전체 조회 -->
	<div class="col-6">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 일정 전체 조회</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content" style="height: 515px;">



					<!-- calendar -->
					<!-- 드래그 박스 -->

					<!-- calendar 태그 -->
					<div class="col-12">
						<div id='calendar-wrap'>
							<div id='calendar1'></div>
						</div>
					</div>
					<!-- calendar end -->



				</div>
			</div>
		</div>
	</div>
	<!-- 사업 일정 전체 조회 끝 -->

	<!-- 사업 일정 그래프 -->
	<div class="col-6">
		<div class="card card-info" style="height: 557px;">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 일정 진행도</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content" style="margin: 10px; padding: 10px;">
				
					<div class="card-tools"
						style="justify-content: space-between; margin: 3px; display: flex; flex-direction: row-reverse;">
						<div class="input-group input-group-sm" style="width: 350px">
							<select class="form-control-sm" name="searchType" id="searchType"
								style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
								<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전체</option>
								<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
								<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
								<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
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
							style="width: 80px" id="registBtn"
							onclick="location.href='registForm';">등록</button>
					</div>

						<table class="table table-bordered" style="margin-top: 21px;">
							<thead>
								<tr style="text-align: center;">
									<th style="width: 15%; font-size: 13px !important;">사업번호</th>
									<th style="width: 45%; font-size: 13px !important;">사업명</th>
									<th style="width: 25%; font-size: 13px !important;">진행도</th>
									<th style="width: 15%; font-size: 13px !important;">진행률</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty businessList}">
									<tr style="text-align: center; font-size: 13px !important;">
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${businessList}" var="business">
									<tr
										onclick="location.href='detail?business_number=${business.business_number}'; "
										style="cursor: pointer;">
										<td style="text-align: center; font-size: 13px !important;">${business.business_number}</td>
										<td style="font-size: 13px !important;">${business.business_name}</td>
										<td>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-danger"
													style="width: ${business.business_progress}%;"></div>
											</div>
										</td>
										<td style="text-align: right; font-size: 13px !important;"><span
											class="badge bg-teal">${business.business_progress}%</span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				</div>
			</div>
		</div>
	</div>

</div>

<!-- 사업 일정 그래프 끝 -->



<script>
	(function() {
		$(function() {

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

<c:if test="${from eq 'regist' }">

<script>
   alert("정상 등록이 되었습니다.");
   window.close();
   window.opener.location.reload();
</script>

</c:if>

<c:if test="${from eq 'remove' }">

<script>
   alert("정상적으로 삭제 되었습니다.");
   window.close();
   window.opener.location.reload();
</script>

</c:if>


