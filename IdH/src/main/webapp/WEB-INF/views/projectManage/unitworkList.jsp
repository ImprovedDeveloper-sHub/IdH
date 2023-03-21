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
								onclick="search_go_ajax(0, '<%=request.getContextPath()%>/projectManage/getEnd', $('.endThead'),$('#endProject-list-template'))">
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
						<div><%@ include file="/WEB-INF/module/pagination.jsp" %></div>
					</div>


				</div>