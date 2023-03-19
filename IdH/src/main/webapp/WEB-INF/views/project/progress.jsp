<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<div class="content">
	<div class="row">
		<div class="card">
			<div class="col-12">
				<div class="row">
					<div class="col-12">
						<div id="chart_div"
							style="width: 1200; height: 200; margin-bottom: 40px;"></div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">단위 업무 진행률</h3>
					</div>
					<div class="card-body p-0">
						<table class="table table-striped projects">
							<thead>
								<tr>
									<th style="width: 2%">#</th>
									<th style="width: 25%">단위업무</th>
									<th style="width: 10%">담당자</th>
									<th style="width: 15%">시작날짜</th>
									<th style="width: 15%">마감날짜</th>
									<th style="width: 25%" class="text-center">업무단계</th>
									<th style="width: 8%" class="text-center">업무상태</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${unitworkList }" var="unitwork">
									<tr>
										<td>${unitwork.unitwork_number }</td>
										<td><a> ${unitwork.unitwork_name } </a></td>
										<td>
											<ul class="list-inline">
												<li class="list-inline-item">${unitwork.unitwork_getter_id }</li>
											</ul>
										</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${unitwork.unitwork_regdate}" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${unitwork.unitwork_enddate}" /></td>
										<td class="project_progress">
											<div class="progress progress-sm">
												<div class="progress-bar bg-green" role="progressbar"
													aria-valuenow="${unitwork.unitwork_level * 25}"
													aria-valuemin="0" aria-valuemax="100"
													style="width: ${unitwork.unitwork_level * 25 -25}%"></div>
											</div>
										</td>
										<c:choose>
											<c:when test="${unitwork.unitwork_level eq 5 }">
												<td class="project-state"><span
													class="badge badge-success">success </span></td>
											</c:when>
											<c:when test="${unitwork.unitwork_level eq 3 }">
												<td class="project-state"><span
													class="badge badge-info">proceeding </span></td>
											</c:when>
											<c:when test="${unitwork.unitwork_level eq 1 }">
												<td class="project-state"><span
													class="badge badge-warning">plan </span></td>
											</c:when>
											<c:when
												test="${unitwork.unitwork_level eq 2 or unitwork.unitwork_level eq 4}">
												<td class="project-state"><span
													class="badge badge-danger">delay </span></td>
											</c:when>

										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!--row종료-->


</div>
<!--content종료-->
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
			height : 200,
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