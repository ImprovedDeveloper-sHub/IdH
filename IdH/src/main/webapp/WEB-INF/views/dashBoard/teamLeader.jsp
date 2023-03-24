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
						<h3 class="card-title" style="color: black;">프로젝트 진행현황</h3>
					</div>

					<div id="chart_div"></div>

				</div>

				<div class="card card-row card-primar" style="height: 30vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray;">
						<h3 class="card-title" style="color: black;">이슈</h3>
					</div>

					<div id="donutchart" style="width: 100%; height: 250px;"></div>

				</div>

				<div class="card card-row card-primar" style="height: 30vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray;">
						<h3 class="card-title" style="color: black;">세부계획</h3>
					</div>
					
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="proceedingThead" class="text-left">
								<tr>
									<th style="width: 15%">일정 상태</th>
									<th style="width: 35%">일정 이름</th>
									<th style="width: 25%">시작 날짜</th>
									<th style="width: 15%">종료 날짜</th>
								</tr>
							</thead>

							<tbody class="proceedingProjectLi" class="text-left">
								<c:if test="${empty scheduleList}">
									<tr>
										<td colspan="5">일정이 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${scheduleList }" var="schedule">
									<tr
										onclick="OpenWindow('scheduleDetail?schedule_number=${schedule.schedule_number}','스케줄',500,600);">
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											${schedule.schedule_status eq 1 ? '계획' : '진행'}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${schedule.schedule_name}</td>
										<td
											style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${schedule.schedule_type eq '1' ? '기획' : ''}${schedule.schedule_type eq '2' ? '설계' : ''}${schedule.schedule_type eq '3' ? '구현' : ''}${schedule.schedule_type eq '4' ? '테스트' : ''}</td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											${schedule.schedule_project_name}</td>
										
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${schedule.schedule_startdate}" pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${schedule.schedule_enddate}" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						
					

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

<script>
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['전체이슈', 'All Issue'],
          ['완료이슈', ${issuesuccess }],
          ['미완료이슈', ${issuenow }],
          ['할당된이슈', ${getter }],
          ['미할당이슈', ${total }]
        ]);

        var options = {
          title: 'Issue',
          pieHole: 0,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
</script>

<script>
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table, 
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {
		
		// Create the data table.
		var data = google.visualization.arrayToDataTable([
				[ '진행률', '진행중', '지연', '예정', '완료', {
					role : 'annotation'
				} ],

				[ '진행률', ${unitwork_plan}, ${unitwork_proceeding}, ${unitwork_delay1}+${unitwork_delay2}, ${unitwork_success}, '' ] ]);

		// Set chart options
		var options = {
			isStacked : 'absolute',
			height : 135,
			legend : {
				position : 'top',
				maxLines : 1
			},
			hAxis : {
				minValue : 0,
				ticks : [ '', '', '', '', '' ]
			}
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.BarChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>