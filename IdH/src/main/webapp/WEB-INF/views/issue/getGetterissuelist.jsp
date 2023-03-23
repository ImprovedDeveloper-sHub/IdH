<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<div class="card-header bg-info">
				<h3 class="card-title">할당된 이슈</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse; margin: 3px;">
				<div class="input-group input-group-sm" style="width: 270px">
					<select id="getterPerPageNum" name="getterPerPageNum"
						style="display: none"><option value="10" selected></option></select>
					<select class="form-control-sm" name="getterSearchType"
						id="getterSearchType"
						style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
						<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
						<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
						<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
						<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
					</select> <input id="getterKeyword" type="text" name="getterKeyword"
						class="form-control float-right" placeholder="Search" value="">
					<div class="input-group-append">
						<button type="submit" class="btn btn-default" onclick="print_getterissuelist(1)">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>


			</div>
			<div id="table-content">
				<div class="card-body table-responsive p-0" style="height:320px;">
					<table class="table table-hover">
						<thead class="text-left getterThead">
							<tr>
								<th style="width: 10%">수준</th>
								<th style="width: 30%">제목</th>
								<th style="width: 25%">작성일</th>
								<th style="width: 25%">작성자</th>
								<th style="width: 10%">첨부파일</th>
							</tr>
						</thead>
						<tbody class="text-left getterli">
							<c:if test="${empty getterIssueList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${getterIssueList }" var="issue">
								<tr
									onclick="javascript:OpenWindow('detail.do?from=main&issue_number=${issue.issue_number}','상세보기',600,550);" style="cursor:pointer;">

									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
										${issue.issue_level}</td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_title}</td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
											value="${issue.issue_regdate}" pattern="yyyy-MM-dd" /></td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_setter_id }</td>
										<c:if test="${empty issue.attachList }">
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">-</td>										
										</c:if>
										<c:if test="${!empty issue.attachList }">
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><i class="fa-sharp fa-solid fa-folder" style="color:gold;"></i></td>										
										</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</div>
					<div><nav id="paginationNav" aria-label="Navigation">
      <ul class="pagination justify-content-center m-0">
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterissuelist(1);">
               <i class="fas fa-angle-double-left"></i>
            </a>
         </li>
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterissuelist(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
               <i class="fas fa-angle-left"></i>
            </a>                  
         </li>
         <c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
   
         <li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
            <a class="page-link" href="javascript:print_getterissuelist('${pageNum}');" >${pageNum }</a>
         </li>
         </c:forEach>
         
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterissuelist(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
               <i class="fas fa-angle-right" ></i>
            </a>
         </li>
         
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterissuelist('${pageMaker.realEndPage}');">
               <i class="fas fa-angle-double-right"></i>
            </a>
         </li>   
      </ul>
   </nav></div>
		
		