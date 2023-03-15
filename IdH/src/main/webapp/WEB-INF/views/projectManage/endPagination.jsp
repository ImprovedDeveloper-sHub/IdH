<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!-- test- -->
	<nav aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(${endPageMaker.prev ? endPageMaker.startPage-1 : endPageMaker.cri.page});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="endPageNum" begin="${endPageMaker.startPage }" end="${endPageMaker.endPage }" >
	
			<li class="page-item ${endPageMaker.cri.page == endPageNum?'active':''}">
				<a class="page-link" href="javascript:list_go('${endPageNum}');" >${endPageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item" >
				<a class="page-link" href="javascript:list_go(${endPageMaker.next ? endPageMaker.endPage+1 :endPageMaker.cri.page});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:list_go('${endPageMaker.realEndPage}');">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>
	
	


  




	