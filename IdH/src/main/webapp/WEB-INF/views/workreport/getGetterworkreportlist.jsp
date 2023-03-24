<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

				<div class="card-header bg-info">
					<h3 class="card-title">보낸 보고</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;margin:3px;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select id="getterPerPageNum" name="getterPerPageNum"
							style="display: none"><option value="5" selected></option></select>
						<select class="form-control-sm" name="getterSearchType"
							id="getterSearchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
						</select> <input id="getterKeyword" type="text" name="getterKeyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="print_getterworkreportlist(1)">
								<i class="fas fa-search"></i>

							</button>
						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
					style="width: 80px" id="registBtn"
					onclick="OpenWindow('registForm','글등록',680,555)">등록</button>
				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="text-left getterWorkreportThead">
								<tr>
									<th style="width: 20%">제목</th>
									<th style="width: 30%">첨부파일</th>
									<th style="width: 20%">작성일</th>
									<th style="width: 15%">작성자</th>
									<th style="width: 15%">결제여부</th>
								</tr>
							</thead>
							<tbody class="text-left getterWorkreportTbody">
								<c:if test="${empty getterWorkreportList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${getterWorkreportList }" var="workreport">
									<tr style="cursor:pointer;"onclick="javascript:OpenWindow('detail.do?from=main&workreport_number=${workreport.workreport_number}','상세보기',600,508);">
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workreport.workreport_title}</td>
										<c:if test="${empty workreport.attachList }">
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">-</td>										
										</c:if>
										<c:if test="${!empty workreport.attachList }">
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><i class="fa-sharp fa-solid fa-folder" style="color:gold;"></i></td>										
										</c:if>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${workreport.workreport_regdate}"
												pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workreport.workreport_getter}</td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${workreport.workreport_check}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div><nav id="paginationNav" aria-label="Navigation">
      <ul class="pagination justify-content-center m-0">
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterworkreportlist(1);">
               <i class="fas fa-angle-double-left"></i>
            </a>
         </li>
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterworkreportlist(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
               <i class="fas fa-angle-left"></i>
            </a>                  
         </li>
         <c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
   
         <li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
            <a class="page-link" href="javascript:print_getterworkreportlist('${pageNum}');" >${pageNum }</a>
         </li>
         </c:forEach>
         
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterworkreportlist(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
               <i class="fas fa-angle-right" ></i>
            </a>
         </li>
         
         <li class="page-item">
            <a class="page-link" href="javascript:print_getterworkreportlist('${pageMaker.realEndPage}');">
               <i class="fas fa-angle-double-right"></i>
            </a>
         </li>   
      </ul>
   </nav></div>
		
		