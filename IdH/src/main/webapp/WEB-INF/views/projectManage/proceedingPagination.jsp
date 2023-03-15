<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<nav aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(${proceedingPageMaker.prev ? proceedingPageMaker.startPage-1 : proceedingPageMaker.cri.page});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="proceedingPageNum" begin="${proceedingPageMaker.startPage }" end="${proceedingPageMaker.endPage }" >
	
			<li class="page-item ${proceedingPageMaker.cri.page == proceedingPageNum?'active':''}">
				<a class="page-link" href="javascript:list_go('${proceedingPageNum}');" >${proceedingPageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item" >
				<a class="page-link" href="javascript:list_go(${proceedingPageMaker.next ? proceedingPageMaker.endPage+1 :proceedingPageMaker.cri.page});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:list_go('${proceedingPageMaker.realEndPage}');">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>
	
	


  




	