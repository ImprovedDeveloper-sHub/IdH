<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



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
	padding: 14px 10px;
}

#table-content tbody tr td {
	padding: 14px 10px;
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

.date-td {
	text-align: right;
	font-size: 9px;
}

.checked {
	background: #fefaf2;
}

#credit {
	color: #76838c;
	width: 300px;
	margin: 0 auto;
	font-size: 12px;
	text-align: center;
}

.btn-info {
	text-align: right;
}

#calendar-wrap {
	width: 100%;
	height: 100%;
	background-color: white;
}
</style>

<!-- My CSS end -->



<div class="row">

	<!-- 사업 일정 전체 조회 -->
	<div class="col-6">
		<div class="card card-info"
			style="display: inline-block !important; width: 100%;">
			<div class="card-header">
				<h3 class="card-title">사업 일정 전체 조회</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
				
				
				
					<!-- calendar -->
					<div class="col-12">
						<div id="calendar-wrap">
							<div id="calendar1"
								class="fc fc-media-screen fc-direction-ltr fc-theme-standard">
								<div class="fc-header-toolbar fc-toolbar fc-toolbar-ltr">
									<div class="fc-toolbar-chunk">
										<div class="fc-button-group">
											<button class="fc-prev-button fc-button fc-button-primary"
												type="button" aria-label="prev">
												<span class="fc-icon fc-icon-chevron-left"></span>
											</button>
											<button class="fc-next-button fc-button fc-button-primary"
												type="button" aria-label="next">
												<span class="fc-icon fc-icon-chevron-right"></span>
											</button>
										</div>
										<button class="fc-today-button fc-button fc-button-primary"
											type="button">오늘</button>
									</div>
									<div class="fc-toolbar-chunk">
										<h2 class="fc-toolbar-title">2021년 7월</h2>
									</div>
									<div class="fc-toolbar-chunk">
										<div class="fc-button-group">
											<button
												class="fc-dayGridMonth-button fc-button fc-button-primary fc-button-active"
												type="button">월</button>
											<button
												class="fc-timeGridWeek-button fc-button fc-button-primary"
												type="button">주</button>
											<button
												class="fc-timeGridDay-button fc-button fc-button-primary"
												type="button">일</button>
											<button
												class="fc-listWeek-button fc-button fc-button-primary"
												type="button">일정목록</button>
										</div>
									</div>
								</div>
								<div class="fc-view-harness fc-view-harness-active"
									style="height: 250px;">
									<div class="fc-daygrid fc-dayGridMonth-view fc-view">
										<table class="fc-scrollgrid  fc-scrollgrid-liquid">
											<thead>
												<tr
													class="fc-scrollgrid-section fc-scrollgrid-section-header ">
													<td><div class="fc-scroller-harness">
															<div class="fc-scroller" style="overflow: hidden;">
																<table class="fc-col-header " style="width: 100%;">
																	<colgroup></colgroup>
																	<tbody>
																		<tr>
																			<th class="fc-col-header-cell fc-day fc-day-sun"><div
																					class="fc-scrollgrid-sync-inner">
																					<a class="fc-col-header-cell-cushion ">일</a>
																				</div></th>
																			<th class="fc-col-header-cell fc-day fc-day-mon"><div
																					class="fc-scrollgrid-sync-inner">
																					<a class="fc-col-header-cell-cushion ">월</a>
																				</div></th>
																			<th class="fc-col-header-cell fc-day fc-day-tue"><div
																					class="fc-scrollgrid-sync-inner">
																					<a class="fc-col-header-cell-cushion ">화</a>
																				</div></th>
																			<th class="fc-col-header-cell fc-day fc-day-wed"><div
																					class="fc-scrollgrid-sync-inner">
																					<a class="fc-col-header-cell-cushion ">수</a>
																				</div></th>
																			<th class="fc-col-header-cell fc-day fc-day-thu"><div
																					class="fc-scrollgrid-sync-inner">
																					<a class="fc-col-header-cell-cushion ">목</a>
																				</div></th>
																			<th class="fc-col-header-cell fc-day fc-day-fri"><div
																					class="fc-scrollgrid-sync-inner">
																					<a class="fc-col-header-cell-cushion ">금</a>
																				</div></th>
																			<th class="fc-col-header-cell fc-day fc-day-sat"><div
																					class="fc-scrollgrid-sync-inner">
																					<a class="fc-col-header-cell-cushion ">토</a>
																				</div></th>
																		</tr>
																	</tbody>
																</table>
															</div>
														</div></td>
												</tr>
											</thead>
											<tbody>
												<tr
													class="fc-scrollgrid-section fc-scrollgrid-section-body  fc-scrollgrid-section-liquid">
													<td><div
															class="fc-scroller-harness fc-scroller-harness-liquid">
															<div class="fc-scroller fc-scroller-liquid-absolute"
																style="overflow: hidden auto;">
																<div class="fc-daygrid-body fc-daygrid-body-unbalanced "
																	style="width: 100%;">
																	<table class="fc-scrollgrid-sync-table"
																		style="width: 100%; height: 266px;">
																		<colgroup></colgroup>
																		<tbody>
																			<tr>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sun fc-day-past fc-day-other"
																					data-date="2021-06-27"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">27일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-mon fc-day-past fc-day-other"
																					data-date="2021-06-28"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">28일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-tue fc-day-past fc-day-other"
																					data-date="2021-06-29"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">29일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-wed fc-day-past fc-day-other"
																					data-date="2021-06-30"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">30일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																					data-date="2021-07-01"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">1일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																					data-date="2021-07-02"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">2일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																					data-date="2021-07-03"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">3일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																			</tr>
																			<tr>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sun fc-day-past"
																					data-date="2021-07-04"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">4일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																					data-date="2021-07-05"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">5일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-tue fc-day-past"
																					data-date="2021-07-06"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">6일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-wed fc-day-past"
																					data-date="2021-07-07"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">7일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																					data-date="2021-07-08"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">8일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																					data-date="2021-07-09"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">9일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																					data-date="2021-07-10"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">10일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																			</tr>
																			<tr>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sun fc-day-past"
																					data-date="2021-07-11"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">11일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																					data-date="2021-07-12"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">12일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-tue fc-day-past"
																					data-date="2021-07-13"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">13일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-wed fc-day-past"
																					data-date="2021-07-14"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">14일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																					data-date="2021-07-15"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">15일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																					data-date="2021-07-16"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">16일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																					data-date="2021-07-17"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">17일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																			</tr>
																			<tr>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sun fc-day-past"
																					data-date="2021-07-18"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">18일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																					data-date="2021-07-19"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">19일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-tue fc-day-past"
																					data-date="2021-07-20"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">20일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-wed fc-day-past"
																					data-date="2021-07-21"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">21일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																					data-date="2021-07-22"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">22일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																					data-date="2021-07-23"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">23일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																					data-date="2021-07-24"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">24일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																			</tr>
																			<tr>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sun fc-day-past"
																					data-date="2021-07-25"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">25일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																					data-date="2021-07-26"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">26일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-tue fc-day-past"
																					data-date="2021-07-27"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">27일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-wed fc-day-past"
																					data-date="2021-07-28"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">28일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																					data-date="2021-07-29"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">29일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																					data-date="2021-07-30"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">30일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																					data-date="2021-07-31"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">31일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																			</tr>
																			<tr>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sun fc-day-past fc-day-other"
																					data-date="2021-08-01"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">1일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-mon fc-day-past fc-day-other"
																					data-date="2021-08-02"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">2일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-tue fc-day-past fc-day-other"
																					data-date="2021-08-03"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">3일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-wed fc-day-past fc-day-other"
																					data-date="2021-08-04"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">4일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-thu fc-day-past fc-day-other"
																					data-date="2021-08-05"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">5일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-fri fc-day-past fc-day-other"
																					data-date="2021-08-06"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">6일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																				<td
																					class="fc-daygrid-day fc-day fc-day-sat fc-day-past fc-day-other"
																					data-date="2021-08-07"><div
																						class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																						<div class="fc-daygrid-day-top">
																							<a class="fc-daygrid-day-number">7일</a>
																						</div>
																						<div class="fc-daygrid-day-events">
																							<div class="fc-daygrid-day-bottom"
																								style="margin-top: 0px;"></div>
																						</div>
																						<div class="fc-daygrid-day-bg"></div>
																					</div></td>
																			</tr>
																		</tbody>
																	</table>
																</div>
															</div>
														</div></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
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
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">사업 일정 진행도</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<div class="col-12">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">전체 사업 진행률</h3>
						<div class="card-tools">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="width: 10px">#</th>
										<th>Task</th>
										<th style="width: 350px">Progress</th>
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
	</div>
	<!-- 사업 일정 그래프 끝 -->

</div>


