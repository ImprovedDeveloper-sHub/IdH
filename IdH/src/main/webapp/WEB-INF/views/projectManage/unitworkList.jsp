<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<div class="card-header bg-info">
					<h3 class="card-title">단위업무</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse; margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select id="searchPerPageNum" name="perPageNum"
							style="display: none"><option value="5" selected></option></select>
						<select class="form-control-sm" name="searchType" id="searchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="n" ${cri.searchType eq 'n' ? 'selected':'' }>제목</option>
							<option value="d" ${cri.searchType eq 'd' ? 'selected':'' }>내용</option>

						</select> <input type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="print_unitworkList(1,0)">
								<i class="fas fa-search"></i>
							</button>


						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;"
						onclick="OpenWindow('registUnitworkForm','등록',500,700);">등록</button>
				</div>

				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="unitworkThead" class="text-left">
								<tr>
									<th style="width: 15%">프로젝트 상태</th>
									<th style="width: 20%">업무명</th>
									<th style="width: 15%">업무세부</th>
									<th style="width: 10%">작성자</th>
									<th style="width: 15%">시작날짜</th>
									<th style="width: 15%">종료날짜</th>
								</tr>
							</thead>

							<tbody class="unitwrokLi" class="text-left">
								<c:if test="${empty unitworkList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${unitworkList }" var="unitwork">
									<tr
										onclick="OpenWindow('unitworkDetail?unitwork_number=${unitwork.unitwork_number}','단위업무',580,600);">
										<td>${unitwork.unitwork_status eq 1 ? '계획' : '진행'}</td>
										<td>${unitwork.unitwork_name}</td>
										<td>${unitwork.unitwork_level eq 1 ? '진행중' : ''}${unitwork.unitwork_level eq 2 ? '지연' : ''}${unitwork.unitwork_level eq 3 ? '예정' : ''}${unitwork.unitwork_level eq 4 ? '지연2' : ''}${unitwork.unitwork_level eq 5 ? '완료' : ''}</td>
										<td>${unitwork.unitwork_setter_id}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${unitwork.unitwork_startdate}" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${unitwork.unitwork_enddate}" /></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						<div>
								<nav id="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:print_unitworkList(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:print_unitworkList(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page},${project_num});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
	
			<li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
				<a class="page-link" href="javascript:print_unitworkList('${pageNum}',${project_num});" >${pageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item">
				<a class="page-link" href="javascript:print_unitworkList(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page},${project_num});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:print_unitworkList('${pageMaker.realEndPage}',${project_num});">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>
	
	

						</div>
					</div>


				</div>
				
				
				
		