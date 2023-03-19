<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>





<div class="row">
	<div class="content-parts col-8">
		<div id="content" class="card">
			<div class="card-header bg-info">
				<h3 class="card-title">산출물연계진행</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between;margin:3px; display: flex; flex-direction: row-reverse;">
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


						<button type="submit" class="btn btn-default" onclick="list_go(1)">
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
				<!-- <form method="get" action="form-action.html"> -->
					<table class="table table-hover">
						<thead class="text-left">
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
							<c:if test="${empty productProceedList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
							
							<c:forEach items="${productProceedList }" var="product">
							
								<tr
									onclick="OpenWindow('detail?product_number=${product.product_number }','상세보기',680,400);"
									style="cursor: pointer;">
									
										
					
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><!-- <label><input type="checkbox" name="product_number" value=""> -->${product.product_number}<!-- </label> --></td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_title}</td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_member_id}</td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
											value="${product.product_regdate}" pattern="yyyy-MM-dd" /></td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_content}</td>
									
									<td>
								<!-- 첨부파일 -->
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
					<!-- </form> -->
					<!-- <input type="submit" value="Submit"> <input type="reset" value="Reset"> -->
				</div>
			</div>
		</div>
	</div>

	<div class="col-4">
		<div class="card card-info">

			<div class="card-header bg-info">
				<h3 class="card-title">협업요청목록</h3>
				<div class="card-tools">
					<button type="button" class="btn btn-tool"
						data-card-widget="collapse" title="Collapse">
						<i class="fas fa-minus"></i>
					</button>
				</div>
			</div>
			<div class="card-body p-0" style="display: block;">
				<table class="table table-hover">
					<thead>
						<tr>
						    <th>번호</th>
							<th>협업 산출물</th>
							<th>요청자</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty coworkList}">
							<tr>
								<td colspan="5">데이터가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach items="${coworkList }" var="cowork">

                          <c:forEach items="${product_CoworkList}" var="product">     
							<tr>
								
								<td
									style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_number}</td>
								<td
									style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_title}</td>
								<td
									style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${cowork.cowork_member_id}</td>

								<td class="text-right py-0 align-middle">
									<div class="btn-group btn-group-sm">
										<div class="btn btn-info" onclick="OpenWindow('detail?product_number=${product.product_number}','상세보기',680,400);"
								style="cursor: pointer;"><i class="fas fa-eye"></i></div>
										<div class="btn btn-danger"  onclick="submit_go('remove','${product.product_number }');"><i class="fas fa-trash"></i></div>		
										
									</div>
								</td>
							</tr>
								</c:forEach>
						</c:forEach>

					</tbody>
				</table>
				<br>
				<div class="row">




					<div class="col">

						<div class="small-box bg-success">
							<div class="inner">
								<h3>
									${proceedtotal}
								</h3>
								<p>Progress</p>
							</div>
							<div class="icon">
								<i class="ion ion-stats-bars"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fas fa-arrow-circle-right"></i></a>
						</div>
					</div>

					<div class="col">

						<div class="small-box bg-warning">
							<div class="inner">
								<h3>${issuenow}/${total}</h3>
								<p>Delay</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fas fa-arrow-circle-right"></i></a>
						</div>
					</div>

					<div class="col">

						<div class="small-box bg-danger">
							<div class="inner">
								<h3>${endtotal}</h3>
								<p>Finished</p>
							</div>
							<div class="icon">
								<i class="ion ion-pie-graph"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fas fa-arrow-circle-right"></i></a>
						</div>
					</div>

				</div>




				<!--row종료-->
			</div>

		</div>

	</div>
	<!--content종료-->

	<!--main(container)종료 -->
	<div class="col-3" style="margin: 0 auto;">
		<nav aria-label="Navigation">
			<ul class="pagination justify-content-center m-0">
				<li class="page-item"><a class="page-link"
					href="javascript:list_go(1);"> <i
						class="fas fa-angle-double-left"></i>
				</a></li>
				<li class="page-item"><a class="page-link"
					href="javascript:list_go(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
						<i class="fas fa-angle-left"></i>
				</a></li>
				<c:forEach var="pageNum" begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }">

					<li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
						<a class="page-link" href="javascript:list_go('${pageNum}');">${pageNum }</a>
					</li>
				</c:forEach>

				<li class="page-item"><a class="page-link"
					href="javascript:list_go(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
						<i class="fas fa-angle-right"></i>
				</a></li>

				<li class="page-item"><a class="page-link"
					href="javascript:list_go('${pageMaker.realEndPage}');"> <i
						class="fas fa-angle-double-right"></i>
				</a></li>
			</ul>
		</nav>
	</div>
	<br />
</div>

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
<script>
function submit_go(url,product_number ){	
	location.href=url+"?product_number="+product_number;
}
</script>
