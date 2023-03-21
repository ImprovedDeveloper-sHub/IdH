<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<div class="card-header bg-info">
					<h3 class="card-title">예산 관리</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;margin:3px;">
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
						onclick="OpenWindow('registBudgetForm','등록',500,700);">등록</button>

				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="endThead" class="text-left">
								<tr>
									<th style="width: 20%">예산 상태</th>
									<th style="width: 30%">예산 이름</th>
									<th style="width: 20%">예산 구분</th>
									<th style="width: 15%">프로젝트 명</th>
									<th style="width: 15%">예산 금액</th>
								</tr>
							</thead>

							<tbody class="endProjectLi" class="text-left">
								<c:if test="${empty budgetList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${budgetList }" var="budget">
									<tr
										onclick="OpenWindow('budgetDetail?budget_number=${budget.budget_number}','예산',500,500);">
										<td>${budget.budget_status eq 1 ? '계획' : '진행'}</td>
										<td>${budget.budget_name}</td>
										 <td>${budget.budget_type eq '1' ? '인건비' : ''}${budget.budget_type eq '2' ? '교통비' : ''}${budget.budget_type eq '3' ? '비품비' : ''}${budget.budget_type eq '4' ? '식대' : ''}</td> 
										<td>${budget.budget_project_name}</td>
										<td><fmt:formatNumber value="${budget.budget_price}"
												pattern="#,###" /></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						 <div><%@ include file="/WEB-INF/module/pagination.jsp" %></div>
					</div>


				</div>