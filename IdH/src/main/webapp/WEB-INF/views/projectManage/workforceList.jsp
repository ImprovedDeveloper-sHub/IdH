<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    

<div class="card-header bg-info">
					<h3 class="card-title">인력 프로젝트</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;margin:3px;">
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
								onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getProceeding', $('.proceedingThead'),$('#proceedingProject-list-template'))">
								<i class="fas fa-search"></i>
							</button>


						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;"
						onclick="OpenWindow('registWorkforceForm','등록',500,700);">등록</button>
				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="proceedingThead" class="text-left">
								<tr>
									<th style="width: 15%">인력 상태</th>
									<th style="width: 15%; text-align: center;" >이름</th>
									<th style="width: 30%">인력 이름</th>
									<th style="width: 15%">인력 구분</th>
									<th style="width: 15%">시작 날짜</th>
									<th style="width: 15%">종료 날짜</th>
								</tr>
							</thead>

							<tbody class="workforceProjectLi" class="text-left">
								<c:if test="${empty workforceList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${workforceList }" var="workforce">
									<tr
										onclick="OpenWindow('workforceDetail?workforce_number=${workforce.workforce_number}','인력',580,480);">
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											${schedule.schedule_status eq 1 ? '계획' : '진행'}</td>
										<td
											style="text-align: center; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_member_id}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_name}</td>
										<td
											style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workforce.workforce_type eq '1' ? 'PM':''}${workforce.workforce_type eq '2' ? 'PL':''}${workforce.workforce_type eq '3' ? 'DA':''}${workforce.workforce_type eq '4' ? 'TA':''}${workforce.workforce_type eq '5' ? 'AA':''}${workforce.workforce_type eq '6' ? 'BA':''}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${workforce.workforce_startdate}" pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${workforce.workforce_enddate}" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
												<div><nav id="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:print_workforceList(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:print_workforceList(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
	
			<li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
				<a class="page-link" href="javascript:print_workforceList('${pageNum}');" >${pageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item">
				<a class="page-link" href="javascript:print_workforceList(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:print_workforceList('${pageMaker.realEndPage}');">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav></div>
						
					</div>


				</div>
				
				
			