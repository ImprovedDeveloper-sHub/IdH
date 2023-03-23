<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />


<style>
p, span {
	margin: 0 !important;
	padding: 0 !important;
}
</style>

<!--header row종료 -->


<div class="row">
	<div class=" col-6" style="height: 630px;">

		<div id="companyrule-content" class="card" style="height: 98%;">
			<div class="card-header bg-info">
				<h3 class="card-title">정책관리</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; margin: 3px; display: flex; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 270px">
					<select id="companyrulePerPageNum" name="companyrulePerPageNum"
						style="display: none"><option value="15" selected></option></select>
					<select class="form-control-sm" name="companyruleSearchType"
						id="companyruleSearchType"
						style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
						<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
						<option value="l" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
						<option value="d" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
					</select> <input type="text" name="companyruleKeyword"
						id="companyruleKeyword" class="form-control float-right"
						placeholder="Search" value="">
					<div class="input-group-append">


						<button type="button" class="btn btn-default" id="searchBtn"
							data-card-widget="search" onclick="print_companyrulelistpg(1)">
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
						style="table-layout: fixed; width: 100%;">
						<thead class="text-left">
							<tr>
								<th style="width: 10%">번호</th>
								<th style="width: 15%">제목</th>
								<th style="width: 10%">담당자</th>
								<th style="width: 20%">등록일</th>
								<th style="width: 25%">내용</th>
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
										style="text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_number}</td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_title}</td>
									<td
										style="text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_member_id}</td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
											value="${companyrule.companyrule_regdate}"
											pattern="yyyy-MM-dd" /></td>
									<td
										style="text-align: left; max-width: 25%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${companyrule.companyrule_content}</td>

									<td>
										<!-- 첨부파일 --> <c:if test="${!empty companyrule.attachList }">
											<i class="fa-sharp fa-solid fa-folder" style="color: gold;"></i>
										</c:if> <c:if test="${empty companyrule.attachList }">
											<span>-</span>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="card-footer">
					<div>
						<nav id="paginationNav" aria-label="Navigation">
							<ul class="pagination justify-content-center m-0">
								<li class="page-item"><a class="page-link"
									href="javascript:print_companyrulelistpg(1);"> <i
										class="fas fa-angle-double-left"></i>
								</a></li>
								<li class="page-item"><a class="page-link"
									href="javascript:print_companyrulelistpg(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
										<i class="fas fa-angle-left"></i>
								</a></li>
								<c:forEach var="pageNum" begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }">

									<li
										class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
										<a class="page-link"
										href="javascript:print_companyrulelistpg('${pageNum}');">${pageNum }</a>
									</li>
								</c:forEach>

								<li class="page-item"><a class="page-link"
									href="javascript:print_companyrulelistpg(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
										<i class="fas fa-angle-right"></i>
								</a></li>

								<li class="page-item"><a class="page-link"
									href="javascript:print_companyrulelistpg('${pageMaker.realEndPage}');">
										<i class="fas fa-angle-double-right"></i>
								</a></li>
							</ul>
						</nav>
					</div>

				</div>
			</div>
		</div>

	</div>


	<div class="col-6" style="height: 630px;">
		<div id="product_detail-content" class="card" style="height: 98%;">
			<div class="card-header bg-info">
				<h3 class="card-title">산출물관리</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; margin: 3px; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 270px">
					<select id="product_detailPerPageNum"
						name="product_detailPerPageNum" style="display: none"><option
							value="15" selected></option></select> <select class="form-control-sm"
						name="product_detailSearchType" id="product_detailSearchType"
						style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">

						<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
						<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
						<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
					</select> <input type="text" name="product_detailKeyword"
						id="product_detailKeyword" class="form-control float-right"
						placeholder="Search" value="">

					<div class="input-group-append">

						<button type="button" class="btn btn-default" id="searchBtn"
							data-card-widget="search" onclick="print_product_detaillistpg(1)">
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
									<td><c:if test="${!empty product.attachList }">
											<i class="fa-sharp fa-solid fa-folder" style="color: gold;"></i>
										</c:if> <c:if test="${empty product.attachList }">
											<span>-</span>
										</c:if></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>

				</div>
				<div class="card-footer">
					<div>
						<nav id="paginationNav" aria-label="Navigation">
							<ul class="pagination justify-content-center m-0">
								<li class="page-item"><a class="page-link"
									href="javascript:print_product_detaillistpg(1);"> <i
										class="fas fa-angle-double-left"></i>
								</a></li>
								<li class="page-item"><a class="page-link"
									href="javascript:print_product_detaillistpg(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
										<i class="fas fa-angle-left"></i>
								</a></li>
								<c:forEach var="pageNum" begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }">

									<li
										class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
										<a class="page-link"
										href="javascript:print_product_detaillistpg('${pageNum}');">${pageNum }</a>
									</li>
								</c:forEach>

								<li class="page-item"><a class="page-link"
									href="javascript:print_product_detaillistpg(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
										<i class="fas fa-angle-right"></i>
								</a></li>

								<li class="page-item"><a class="page-link"
									href="javascript:print_product_detaillistpg('${pageMaker.realEndPage}');">
										<i class="fas fa-angle-double-right"></i>
								</a></li>
							</ul>
						</nav>
					</div>

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
<script>
	function print_companyrulelistpg(page) {
		var jobForm = $('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val(
				$('select[name="companyrulePerPageNum"]').val());
		jobForm.find("[name='searchType']").val(
				$('select[name="companyruleSearchType"]').val());
		jobForm.find("[name='keyword']").val(
				$('div.input-group>input[name="companyruleKeyword"]').val());
		alert(jobForm.serialize());
		$.ajax({
			url : 'getCompanyrulelistpg',
			type : "POST",
			data : jobForm.serialize(),
			success : function(data) {
				$('#companyrule-content').html("").html(data);
			},
			error : function(error) {
				alert('error');
			}
		});
	}
</script>
<script>
	function print_product_detaillistpg(page) {
		var jobForm = $('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val(
				$('select[name="product_detailPerPageNum"]').val());
		jobForm.find("[name='searchType']").val(
				$('select[name="product_detailSearchType"]').val());
		jobForm.find("[name='keyword']").val(
				$('div.input-group>input[name="product_detailKeyword"]').val());
		alert(jobForm.serialize());
		$.ajax({
			url : 'getProduct_detaillistpg',
			type : "POST",
			data : jobForm.serialize(),
			success : function(data) {
				$('#product_detail-content').html("").html(data);
			},
			error : function(error) {
				alert('error');
			}
		});
	}
</script>
