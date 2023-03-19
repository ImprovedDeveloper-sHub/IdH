
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

<style>
body {
	margin-top: 40px;
	font-size: 14px;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
}
/* 드래그 박스의 스타일 */
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

#calendar-wrap {
}

#calendar1 {
	max-width: 800px;
	margin: 0 auto;
	background-color: white;
}
</style>



<!-- <div id='wrap'>
    드래그 박스
    <div id='external-events'>
      <h4>Draggable Events</h4>
      <div id='external-events-list'></div>
    </div> -->
<!-- calendar 태그 -->
<div id='calendar-wrap'>
	<div id='calendar1'></div>
</div>


<script>
	function manage_Schedule(url) {
		alert('등록');
		var jobForm = $('#ScheduleForm');
		$
				.ajax({
					type : "POST",
					data : jobForm.serialize(),
					url : url,
					success : function(data) {
						alert('success');
					},
					error : function(error) {
						alert('error');
						AjaxErrorSecurityRedirectHandler(error.status);
						var $div = $("<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'></div>");
						$event = $("<div class='fc-event-main'></div>").text(
								"Event ");
						$('#external-events-list').append($div.append($event));
					}

				});

	}
</script>






<script>

var url = "getCalendarByProject?project_number="+${param.project_number};

window.onload = function(){
	url = url,
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
									
					var calendar = new FullCalendar.Calendar(calendarEl,
							{
								// 해더에 표시할 툴바
								/* initialDate : '2023-03-13', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.) */
								locale : 'ko', // 한국어 설정
								timeZone : 'Asia/Seoul',
								editable : true, // 수정 가능
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
		}
	
});
	
}
</script>

<script>
	
</script>
