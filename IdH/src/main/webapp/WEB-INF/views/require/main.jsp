<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="pageMaker" value="${dataMap.pageMaker }" />

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
	height: 600px;
}

.fc-header-toolbar {
	max-width: 1100px;
	font-size: 11px;
}
.page-link {
	width: 30px;
	height: 30px;
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
	<div class="row" >
		<div class="col-7" >
			<div id='calendar-wrap'>
				<div id='calendar1' ></div>
			</div>
		</div>


		<div class="col-5">
			<div  >
				<div id="content" class="card" style="height:500px !important;">
					<div class="card-header">
						<h3 class="card-title">요구사항</h3>
					</div>
					<div class="card-tools"
						style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
						<div class="input-group input-group-sm" style="width: 270px">
							<select class="form-control-sm" name="searchType" id="searchType"
								style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
								<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
								<option value="l" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
								<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>
							</select> <input type="text" name="keyword"
								class="form-control float-right" placeholder="Search"
								value="
								<c:if test="">
								${cri.keyword }
								</c:if>">
							<div class="input-group-append">


								<button type="button" class="btn btn-default" id="searchBtn"
									data-card-widget="search" onclick="level_go(1)">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
						<button type="button" class="btn btn-block btn-info btn-sm"
							style="width: 80px;"
							onclick="OpenWindow('registForm','등록',680,800);">등록</button>
					</div>
					<div id="table-content" >
						<div class="card-body table-responsive p-0">
							<table class="table table-hover">
								<thead class="text-left">
									<tr>
										<th style="width: 20%">요구사항번호</th>
										<th style="width: 20%">제목</th>
										<th style="width: 10%">중요도</th>
										<th style="width: 10%">출처</th>
										<th style="width: 20%">등록일자</th>
										<th style="width: 20%">등록자</th>
									</tr>
								</thead>
								<tbody class="text-left">
									<c:if test="${empty requireList}">
										<tr>
											<td colspan="5">데이터가 없습니다.</td>
										</tr>
									</c:if>
									<c:forEach items="${requireList }" var="require">
										<tr
											onclick="OpenWindow('detail?require_number=${require.require_number}','상세보기',680,800);">
											<td
												style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${require.require_number}</td>
											<td
												style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${require.require_title}</td>
											<td
												style="text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">

												${require.require_level eq 1 ? '하':'' }
												${require.require_level eq 2 ? '중':'' }
												${require.require_level eq 3 ? '상':'' }</td>
											<td
												style="text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
												<c:if test="${!empty require.attachList }">
													<i class="fa-sharp fa-solid fa-folder" style="color: gold;"></i>
												</c:if> <c:if test="${empty require.attachList }">
													<span>-</span>
												</c:if>
											</td>
											<td
												style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
													value="${require.require_regdate}" pattern="yyyy-MM-dd" /></td>
											<td
												style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
												${require.require_setter_id}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br />
							<div class="card-footer">
								<nav id="paginationNav" aria-label="Navigation">
									<ul class="pagination justify-content-center m-0">
										<li class="page-item"><a class="page-link"
											href="javascript:level_go(1);"> <i
												class="fas fa-angle-double-left"></i>
										</a></li>
										<li class="page-item"><a class="page-link"
											href="javascript:level_go(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
												<i class="fas fa-angle-left"></i>
										</a></li>
										<c:forEach var="pageNum" begin="${pageMaker.startPage }"
											end="${pageMaker.endPage }">

											<li
												class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
												<a class="page-link" href="javascript:level_go(${pageNum});">${pageNum }</a>
											</li>
										</c:forEach>

										<li class="page-item"><a class="page-link"
											href="javascript:level_go(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
												<i class="fas fa-angle-right"></i>
										</a></li>

										<li class="page-item"><a class="page-link"
											href="javascript:level_go('${pageMaker.realEndPage}');">
												<i class="fas fa-angle-double-right"></i>
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
		<!-- calendar 태그 -->

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
<c:if test="${from eq 'regist'}">
	<script>
		alert("등록 되었습니다.");
		window.close();
		window.opener.location.reload();
	</script>
</c:if>
<script>
	window.onload = function() {
		url = "getUnitworkCalender"
		$.ajax({
			type : 'get',
			cache : false,
			url : url,
			dataType : 'json',
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(param) {
				var events = [];
				$.each(param, function(index, date) {
					console.log(date);
					events.push({
						title : date.title,
						start : date.start,
						end : date.end,
						url : date.url
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
					
					
					
					///클릭이벤트 추가
					
					eventClick: function(info) {
				        var eventObj = info.event;

				        if (eventObj.url) {
				          
				          OpenWindow('<%=request.getContextPath()%>/projectManage/unitworkDetail?unitwork_number='+eventObj.url,'상세보기',680,800);

				          //window.open(eventObj.url);

				          info.jsEvent.preventDefault(); // prevents browser from following link in current tab.
				        } else {
				          alert('Clicked ' + eventObj.title);
				        }
				      },
					
					//
					
					
					
					
					
					
					
					
					
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
	function level_go(page, url) {
		var level;
		if ($('div.input-group>input[name="keyword"]').val() == '상')
			level = 3;
		if ($('div.input-group>input[name="keyword"]').val() == '중')
			level = 2;
		if ($('div.input-group>input[name="keyword"]').val() == '하')
			level = 1;
		if (!url)
			url = "main";
		var jobForm = $('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val(10);
		jobForm.find("[name='searchType']").val(
				$('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val(level);

		jobForm.attr({
			action : url,
			method : 'get'
		}).submit();
	}
</script>

