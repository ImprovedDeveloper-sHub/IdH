<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />


<style>
p,span{
margin:0 !important;
padding:0 !important;
}
</style>

<!--header row종료 -->


<div class="row" >
	<div class=" col-6" style="height: 630px;">
		
			<div id="content" class="card" style="height:100%;">
				<div class="card-header bg-info">
					<h3 class="card-title">정책관리</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; margin:3px; display: flex; flex-direction: row-reverse;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select class="form-control-sm" name="searchType" id="searchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전
								체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
							<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
						</select> <input type="text" name="table_search"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">


							<button type="submit" class="btn btn-default"
								onclick="list_go(1)">
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
						<table class="table table-hover"
							style="table-layout: fixed; width: 100%;" >
							<thead class="text-left" >
								<tr>
								<th style="width: 10%">번호</th>
								<th style="width: 15%">제목</th>
								<th style="width: 10%">담당자</th>
								<th style="width: 10%">등록일</th>
								<th style="width: 35%">내용</th>
								<th style="width: 20%">첨부파일</th>

							</tr>
							</thead>
							<tbody class="text-left">
								<c:if test="${empty companyruleList}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${companyruleList }" var="companyrule">
									<tr 
										onclick="OpenWindow('detail?companyrule_number=${companyrule.companyrule_number }&from=list','상세보기',680,400);"
										style="cursor: pointer;">
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_number}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_title}</td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_member_id}</td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${companyrule.companyrule_regdate}"
												pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 35%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_content}</td>

                                    <td>
										<!-- 첨부파일 --> <c:if test="${!empty product.attachList }">
											<i class="nav-icon fas fa-file"></i>
										</c:if> <c:if test="${empty product.attachList }">
											<span>-</span>
										</c:if>
									</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					 <div class="card-footer">
				<nav id="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
	
			<li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
				<a class="page-link" href="javascript:list_go('${pageNum}');" >${pageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:list_go('${pageMaker.realEndPage}');">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>
	
		</div> 
				</div>
			</div>

		</div>
		
		
			<div class="col-6" style="height: 630px;">
				<div id="content" class="card" style="height: 100%;">
					<div class="card-header bg-info">
						<h3 class="card-title">산출물관리</h3>
					</div>
					<div class="card-tools"
						style="justify-content: space-between; display: flex; margin:3px; flex-direction: row-reverse;">
						<div class="input-group input-group-sm" style="width: 270px">
							<select class="form-control-sm" name="searchType" id="searchType"
								style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
								<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전
									체</option>
								<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
								<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
								<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
							</select> <input type="text" name="table_search"
								class="form-control float-right" placeholder="Search">
							<div class="input-group-append">


								<button type="submit" class="btn btn-default"
									onclick="list_go(1)">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
						
					</div>
					<div id="table-content">
						<div class="card-body table-responsive p-0">
							<table class="table table-hover">
								<thead class="text-left">
									<tr>
										<th style="width: 15%">번호</th>
										<th style="width: 20%">제목</th>
										<th style="width: 15%">담당자</th>
										<th style="width: 15%">등록일</th>
										<th style="width: 15%">내용</th>
										<th style="width: 20%">첨부파일</th>

									</tr>
								</thead>
								<tbody class="text-left">
									<c:if test="${empty productEndList}">
										<tr>
											<td colspan="5">데이터가 없습니다.</td>
										</tr>
									</c:if>
									<c:forEach items="${productEndList }" var="product">
										<tr
											onclick="OpenWindow('product_detail?product_number=${product.product_number }&from=list','상세보기',680,400);"
											style="cursor: pointer;">
											<td
												style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_number}</td>
											<td
												style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_title}</td>
											<td
												style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_member_id}</td>
											<td
												style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
													value="${product.product_regdate}" pattern="yyyy-MM-dd" /></td>
											<td
												style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_content}</td>
                                           <td>
											<c:if test="${!empty product.attachList }">
									<i class="nav-icon fas fa-file"></i>
								</c:if>
								<c:if test="${empty product.attachList }">
									<span>-</span>
								</c:if>
								</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
	
					</div>
					 <div class="card-footer">
				<nav id="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
	
			<li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
				<a class="page-link" href="javascript:list_go('${pageNum}');" >${pageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item">
				<a class="page-link" href="javascript:list_go(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:list_go('${pageMaker.realEndPage}');">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>
	
		</div> 
				</div>
			</div>


			<!--row종료-->
		</div>

		<!--row종료-->
	</div>





	<!--content종료-->

	<!--main(container)종료 -->
	

<c:if test="${from eq 'regist' }">
<script>
	alert("정상 등록이 되었습니다.");
	window.close();
	window.opener.location.reload();
</script>
</c:if>
<c:if test="${from eq 'remove' }">
<script>
	alert("정상적으로 삭제 되었습니다.");
	window.close();
	window.opener.location.reload();
</script>
</c:if>

<!--content종료-->
<!-- <script>
function OpenWindow(){
	window.open('registForm','글등록',800,700);
}

</script> -->

