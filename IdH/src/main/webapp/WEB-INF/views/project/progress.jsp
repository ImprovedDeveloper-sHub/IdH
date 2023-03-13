<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<div class="content">
	<div class="row">

		<div class="col-12">
			<div class="col-12">
				<div id="chart_div" style="width: 1000; height: 300"></div>
			</div>
			<div class="row">
			<div class="col-8">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">단위 진행률</h3>
						<div class="card-tools">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="table_search"
									class="form-control float-right" placeholder="Search">
								<div class="input-group-append">
									<button type="submit" class="btn btn-default">
										<i class="fas fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="card-body table-responsive p-0">
						<table class="table table-hover text-nowrap">
							<thead>
								<tr>
									<th>ID</th>
									<th>User</th>
									<th>Date</th>
									<th>Status</th>
									<th>Reason</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>183</td>
									<td>John Doe</td>
									<td>11-7-2014</td>
									<td><span class="tag tag-success">Approved</span></td>
									<td>Bacon ipsum dolor sit amet salami venison chicken
										flank fatback doner.</td>
								</tr>
								<tr>
									<td>183</td>
									<td>John Doe</td>
									<td>11-7-2014</td>
									<td><span class="tag tag-success">Approved</span></td>
									<td>Bacon ipsum dolor sit amet salami venison chicken
										flank fatback doner.</td>
								</tr>
								<tr>
									<td>183</td>
									<td>John Doe</td>
									<td>11-7-2014</td>
									<td><span class="tag tag-success">Approved</span></td>
									<td>Bacon ipsum dolor sit amet salami venison chicken
										flank fatback doner.</td>
								</tr>
								<tr>
									<td>183</td>
									<td>John Doe</td>
									<td>11-7-2014</td>
									<td><span class="tag tag-success">Approved</span></td>
									<td>Bacon ipsum dolor sit amet salami venison chicken
										flank fatback doner.</td>
								</tr>
								<tr>
									<td>219</td>
									<td>Alexander Pierce</td>
									<td>11-7-2014</td>
									<td><span class="tag tag-warning">Pending</span></td>
									<td>Bacon ipsum dolor sit amet salami venison chicken
										flank fatback doner.</td>
								</tr>
								<tr>
									<td>657</td>
									<td>Bob Doe</td>
									<td>11-7-2014</td>
									<td><span class="tag tag-primary">Approved</span></td>
									<td>Bacon ipsum dolor sit amet salami venison chicken
										flank fatback doner.</td>
								</tr>
								<tr>
									<td>175</td>
									<td>Mike Doe</td>
									<td>11-7-2014</td>
									<td><span class="tag tag-danger">Denied</span></td>
									<td>Bacon ipsum dolor sit amet salami venison chicken
										flank fatback doner.</td>
								</tr>
							</tbody>
						</table>
					</div>

				</div>

			</div>
			<div class="col-4">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">단위 진행률</h3>
						<div class="card-tools">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="width: 10px">#</th>
										<th>Task</th>
										<th>Progress</th>
										<th style="width: 40px">Label</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1.</td>
										<td>Update software</td>
										<td>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-danger"
													style="width: 55%"></div>
											</div>
										</td>
										<td><span class="badge bg-danger">55%</span></td>
									</tr>
									<tr>
										<td>2.</td>
										<td>Clean database</td>
										<td>
											<div class="progress progress-xs">
												<div class="progress-bar bg-warning" style="width: 70%"></div>
											</div>
										</td>
										<td><span class="badge bg-warning">70%</span></td>
									</tr>
									<tr>
										<td>3.</td>
										<td>Cron job running</td>
										<td>
											<div class="progress progress-xs progress-striped active">
												<div class="progress-bar bg-primary" style="width: 30%"></div>
											</div>
										</td>
										<td><span class="badge bg-primary">30%</span></td>
									</tr>
									<tr>
										<td>4.</td>
										<td>Fix and squish bugs</td>
										<td>
											<div class="progress progress-xs progress-striped active">
												<div class="progress-bar bg-success" style="width: 90%"></div>
											</div>
										</td>
										<td><span class="badge bg-success">90%</span></td>
									</tr>
									<tr>
										<td>5.</td>
										<td>Update software</td>
										<td>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-danger"
													style="width: 55%"></div>
											</div>
										</td>
										<td><span class="badge bg-danger">55%</span></td>
									</tr>
									<tr>
									<tr>
										<td>6.</td>
										<td>Update software</td>
										<td>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-danger"
													style="width: 55%"></div>
											</div>
										</td>
										<td><span class="badge bg-danger">55%</span></td>
									</tr>
									<tr>
									<tr>
										<td>7.</td>
										<td>Update software</td>
										<td>
											<div class="progress progress-xs">
												<div class="progress-bar progress-bar-danger"
													style="width: 55%"></div>
											</div>
										</td>
										<td><span class="badge bg-danger">55%</span></td>
									</tr>
									<tr>
								</tbody>
							</table>
						</div>
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

				[ '진행률', 2, 4, 2, 1, '' ] ]);

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