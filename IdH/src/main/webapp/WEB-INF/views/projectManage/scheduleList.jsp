<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<div class="card-header bg-info">
					<h3 class="card-title">일정관리</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse; margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select name="perPageNum" style="display: none"><option
								value="5" selected></option></select> <select class="form-control-sm"
							name="searchType" id="searchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>

						</select> <input type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="print_scheduleList(1,0)">
								<i class="fas fa-search"></i>
							</button>


						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;"
						onclick="OpenWindow('registScheduleForm','등록',550,700);">등록</button>

				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="proceedingThead" class="text-left">
								<tr>
									<th style="width: 15%">일정 상태</th>
									<th style="width: 35%">일정 이름</th>
									<th style="width: 15%">일정 구분</th>
									<th style="width: 15%">프로젝트 명</th>
									<th style="width: 25%">시작 날짜</th>
									<th style="width: 15%">종료 날짜</th>
								</tr>
							</thead>

							<tbody class="proceedingProjectLi" class="text-left">
								<c:if test="${empty scheduleList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
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
						
						 <div><nav id="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:print_scheduleList(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:print_scheduleList(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page},${project_num});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
	
			<li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
				<a class="page-link" href="javascript:print_scheduleList('${pageNum}',${project_num} );" >${pageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item">
				<a class="page-link" href="javascript:print_scheduleList(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page}, ${project_num});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:print_scheduleList('${pageMaker.realEndPage}',${project_num});">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav></div>
						
					</div>
					
					
					
					