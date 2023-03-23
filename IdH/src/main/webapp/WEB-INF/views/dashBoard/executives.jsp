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

#calendar1 button {
	width: 80px;
}

.tbtb {
	width: 100%;
	height: 22.5vh;
}

.name-td {
	width: 25%;
	background-color: #E7E7E7;
	font-width: bold;
	font-size: 12px;
	border: 1px solid gray;
}

.table-td {
	width: 25%;
	font-width: bold;
	font-size: 10px;
	border: 1px solid gray;
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
						<h3 class="card-title" style="color: black;">사업 일정</h3>
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
						style="background: none; border: 1px solid gray; padding: 5px;">

						<h3 class="card-title"
							style="color: black; margin: 5px; padding: 2px;">사업예산 및 인원</h3>

						<select class="form-control-sm" name="searchType"
							id="business_selector"
							style="hegith: 30px; width: 200px !important; border-color: #CED4DA !important; margin: 0px; padding: 0px; float: right;">

							<c:if test="${empty businessList }">
								<option>진행중인 사업이 없습니다.</option>
							</c:if>
							<c:forEach items="${businessList }" var="businessLi">
								<option value="${businessLi.business_number}">${businessLi.business_name}</option>
							</c:forEach>

						</select>
					</div>

					<div id="business_budget_table">
						<table class="tbtb" onclick="location.href='<%=request.getContextPath()%>/business/budget/detail?business_number=${business.business_number}'; " style="cursor: pointer;">
							<tr class="trtr">
								<td class="name-td" style="text-align: center;">사업번호</td>
								<td class="table-td">${business.business_number}</td>
								<td class="name-td" style="text-align: center;">투입인원</td>
								<td class="table-td">${business.business_people}</td>
							</tr>
							<tr class="trtr">
								<td class="name-td" style="text-align: center;">총예산</td>
								<td class="table-td"><fmt:formatNumber
										value="${business.business_budget}" pattern="#,###" /> 원</td>
								<td class="name-td" style="text-align: center;">사용예산</td>
								<td class="table-td"><fmt:formatNumber
										value="${business.business_usebudget}" pattern="#,###" /> 원</td>
							</tr>
							<tr class="trtr">
								<td class="name-td" style="text-align: center;">국가지원예산</td>
								<td class="table-td"><fmt:formatNumber
										value="${business.business_nationbudget}" pattern="#,###" />
									원</td>
								<td class="name-td" style="text-align: center;">회사자체예산</td>
								<td class="table-td"><fmt:formatNumber
										value="${business.business_companybudget}" pattern="#,###" />
									원</td>
							</tr>
						</table>
					</div>

				</div>

				<div class="card card-row card-primar" style="height: 30vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray;">
						<h3 class="card-title" style="color: black;">업무보고</h3>
					</div>


				</div>

				<div class="card card-row card-primar" style="height: 30vh;">

					<div class="card-header"
						style="background: none; border: 1px solid gray; padding: 5px;">
						<h3 class="card-title"
							style="color: black; margin: 5px; padding: 2px;">프로젝트 진행도</h3>

						<select class="form-control-sm" name="searchType"
							id="project_selector"
							style="hegith: 30px; width: 200px !important; border-color: #CED4DA !important; margin: 0px; padding: 0px; float: right;">
							<c:if test="${empty projectList }">
								<option>진행중인 프로젝트가 없습니다.</option>
							</c:if>
							<c:forEach items="${projectList }" var="projectLi">
								<option value="${projectLi.project_number}">${projectLi.project_name}</option>
							</c:forEach>
						</select>
					</div>

					<div id="project_curve_chart" style="width: 100%; height: 220px;"></div>

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
		url = "getBusinessCalendar"
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

		//사업선택 셀렉트
		$(function() {
			$("#business_selector").on("change", function() {
				var business_number = $('#business_selector').val();
				//alert("셀렉트값 : "+v);
				$.ajax({
					url : 'getBusiness?business_number=' + business_number,
					success : function(data) {
						$('#business_budget_table').html("").html(data);
					},
					error : function(error) {
						alert('error');
					}
				})

			});
		});
		
		$(function() {
			$("#project_selector").on("change", function() {
				var project_number = $('#project_selector').val();
				//alert("셀렉트값 : "+v);
				$.ajax({
					url : 'getProject?project_number=' + project_number,
					success : function(data) {
						$('#project_curve_chart').html("").html(data);
					},
					error : function(error) {
						alert('error');
					}
				})

			});
		});

	}
</script>

<!-- <script>
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['총예산', 'All Budget'],
          ['사용예산', ${business.business_usebudget}],
          ['국가지원예산', ${business.business_nationbudget}],
          ['회사자체예산', ${business.business_companybudget}]
        ]);

        var options = {
          title: '단위 : 원',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
</script> -->

<script>
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var data = google.visualization.arrayToDataTable([
				[ 'price', '할거1', '할거2', '할거3' ], [ '1주차', 10, 5, 17 ],
				[ '2주차', 40, 29, 20 ], [ '3주차', 55, 63, 50 ],
				[ '4주차', 78, 88, 70 ], [ '5주차', 100, 100, 97 ] ]);

		var options = {
			title : '제목',
			curveType : 'function',
			legend : {
				position : 'bottom'
			}
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('project_curve_chart'));

		chart.draw(data, options);
	}
</script>