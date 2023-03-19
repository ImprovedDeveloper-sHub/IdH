<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<nav aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="search_go_ajax(1, $('#myPerPageNum'), $('#mySearchType'), $('#myKeyword'), '<%=request.getContextPath()%>/issue/getMy', $('.myThead'),$('.myli'),$('#my-list-template'),$('#my-pagination-template'),$('#myPaginationBox'),'my');">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<%-- <a class="page-link" href="javascript:list_go('${myPageMaker.prev ? myPageMaker.startPage-1 : myPageMaker.cri.page}');">
					<i class="fas fa-angle-left"></i>
				</a> --%>
				<a class="page-link" href="javascript:search_go_ajax(${PageMaker.prev ? PageMaker.startPage-1 : PageMaker.cri.page}');, $('#myPerPageNum'), $('#mySearchType'), $('#myKeyword'), '<%=request.getContextPath()%>/issue/getMy', $('.myThead'),$('.myli'),$('#my-list-template'),$('#my-pagination-template'),$('#myPaginationBox'),'my');">
					<i class="fas fa-angle-left"></i>
				</a>
								
										
			</li>
			<c:forEach var="myPageNum" begin="${PageMaker.startPage }" end="${PageMaker.endPage }" >
	
			<li class="page-item ${PageMaker.cri.page == PageNum?'active':''}">
				<a class="page-link" href="javascript:search_go_ajax('${myPageNum}', $('#myPerPageNum'), $('#mySearchType'), $('#myKeyword'), '<%=request.getContextPath()%>/projectManage/getMy', $('.myThead'),$('.myProjectLi'),$('#myProject-list-template'),$('#my-pagination-template'),$('#myPaginationBox'),'my');" >${myPageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item" >
				<%-- <a class="page-link" href="javascript:list_go('${myPageMaker.next ? myPageMaker.endPage+1 :myPageMaker.cri.page}');">
					<i class="fas fa-angle-right" ></i>
				</a> --%>
				 <a class="page-link" href="javascript:search_go_ajax('${PageMaker.next ? PageMaker.endPage+1 :PageMaker.cri.page}', $('#getterPerPageNum'), $('#getterSearchType'), $('#getterKeyword'), '<%=request.getContextPath()%>/issue/getGetter', $('.getterThead'),$('.getterLi'),$('#getter-list-template'),$('#getter-pagination-template'),$('#getterPaginationBox'),'my');" >${getterPageNum }
					<i class="fas fa-angle-right" ></i>
				</a>
				
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:search_go_ajax('${PageMaker.realEndPage}', $('#getterPerPageNum'), $('#getterSearchType'), $('#getterKeyword'), '<%=request.getContextPath()%>/issue/getGetter', $('.getterThead'),$('.getterLi'),$('#getter-list-template'),$('getter-pagination-template'),$('#getterPaginationBox'),'getter');">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>
	
	


  




	