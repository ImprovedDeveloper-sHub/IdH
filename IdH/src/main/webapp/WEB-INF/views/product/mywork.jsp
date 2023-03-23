<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />

<style>
.timeline-card {
	overflow: scroll;
	overflow-x: hidden;
	margin:5px 0;
}

thead {
	background: #f2f3f5;
}

thead tr td {
	color: #757e92;
	text-transform: uppercase;
	padding: 14px 5px;
	font-weight: bold;
	color: black;
}

tbody tr td {
	padding: 14px 5px;
	border-bottom: #eaecee solid 1px;
}

#table-content tbody tr:hover {
	background: #fefaf2;
}

#table-content {
	height: 300px;
}
.timeline-card{
	overflow-y:scroll;
}
.timeline-card::-webkit-scrollbar {
    width: 10px;
  }
.timeline-card::-webkit-scrollbar-thumb {
    background-color: #2f3542;
    border-radius: 10px;
    background-clip: padding-box;
    border: 2px solid transparent;
  }
.timeline-card::-webkit-scrollbar-track {
    background-color: white;
    border-radius: 10px;
    box-shadow: inset 0px 0px 5px white;
  }
</style>


<div class="row" style="justify-content: center;height:630px;">
	<div class="timeline-card card"style="width:1195px;height:30%;">
		<div id="content" style="height: 200px;font-size:10px;">
			<div class="timeline"style="margin:7px 0 !important;">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-23</span>
						<div class="timeline-header" style="padding:5px;font-size:12px;">
							<a href="#">공지사항</a>
						</div>
						<div class="timeline-body">새로운 글이 등록되었습니다.</div>
					</div>
				</div>
			</div>
			<div class="timeline"style="margin:5px 0 !important;">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h6 class="timeline-header" style="padding:5px;font-size:12px;">
							<a href="#">이슈관리</a>
						</h6>
						<div class="timeline-body">새로운 이슈가 등록되었습니다.</div>
					</div>
				</div>
			</div>
			
			
			<div class="timeline"style="margin:5px 0 !important;">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h6 class="timeline-header" style="padding:5px;font-size:12px;">
							<a href="#">이슈관리</a>
						</h6>
						<div class="timeline-body">새로운 이슈가 등록되었습니다.</div>
					</div>
				</div>
			</div><div class="timeline"style="margin:5px 0 !important;">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h6 class="timeline-header" style="padding:5px;font-size:12px;">
							<a href="#">이슈관리</a>
						</h6>
						<div class="timeline-body">새로운 이슈가 등록되었습니다.</div>
					</div>
				</div>
			</div><div class="timeline"style="margin:5px 0 !important;">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h6 class="timeline-header" style="padding:5px;font-size:12px;">
							<a href="#">이슈관리</a>
						</h6>
						<div class="timeline-body">새로운 이슈가 등록되었습니다.</div>
					</div>
				</div>
			</div>
			
			
		</div>
	</div>


	<div class="content-parts col-6" style="height:67%;">
		<div id="myproceed-content" class="card" style="height:98%;">
			<div class="card-header bg-info">
				<h3 class="card-title">진행중인 산출물</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; margin: 3px; display: flex; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 270px">
				<select id="myproceedPerPageNum"
						name="myproceedPerPageNum" style="display: none"><option
							value="7" selected></option></select>
					<select class="form-control-sm" name="myproceedSearchType" id="myproceedSearchType"
						style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
						
						<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
						<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
						<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
					</select> 
					<input type="text" name="myproceedKeyword"
						id="myproceedKeyword" class="form-control float-right"
						placeholder="Search" value="">
					<div class="input-group-append">


						<button type="submit" class="btn btn-default" onclick="print_myproceed(1)">
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
							<c:if test="${empty productMyProceedList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${productMyProceedList }" var="product">
								<tr
									onclick="OpenWindow('detail?product_number=${product.product_number }','상세보기',680,400);"
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
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_content}</td>

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
									href="javascript:print_myproceed(1);"> <i
										class="fas fa-angle-double-left"></i>
								</a></li>
								<li class="page-item"><a class="page-link"
									href="javascript:print_myproceed(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
										<i class="fas fa-angle-left"></i>
								</a></li>
								<c:forEach var="pageNum" begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }">

									<li
										class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
										<a class="page-link"
										href="javascript:print_myproceed('${pageNum}');">${pageNum }</a>
									</li>
								</c:forEach>

								<li class="page-item"><a class="page-link"
									href="javascript:print_myproceed(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
										<i class="fas fa-angle-right"></i>
								</a></li>

								<li class="page-item"><a class="page-link"
									href="javascript:print_myproceed('${pageMaker.realEndPage}');">
										<i class="fas fa-angle-double-right"></i>
								</a></li>
							</ul>
						</nav>
					</div>

				</div>
			</div>
		</div>
	</div>



	<div class="content-parts col-6" style="height:67%;">
		<div id="content" class="card" style="height:98%;">
			<div class="card-header bg-info">
				<h3 class="card-title">종료된 산출물</h3>
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
							data-card-widget="search" onclick="print_myproceed(1)">
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
								<th style="width: 10%">번호</th>
								<th style="width: 15%">제목</th>
								<th style="width: 10%">담당자</th>
								<th style="width: 10%">등록일</th>
								<th style="width: 35%">내용</th>
								<th style="width: 20%">첨부파일</th>

							</tr>
						</thead>
						<tbody class="text-left">
							<c:if test="${empty productMyEndList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${productMyEndList }" var="product">
								<tr
									onclick="OpenWindow('detail?product_number=${product.product_number }&from=list','상세보기',680,400);"
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
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product.product_content}</td>

									<c:forEach items="${product.attachList }" var="product_attach">
										<td
											style="text-align: left; max-width: 35%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${product_attach.ano}</td>
									</c:forEach>
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
									href="javascript:print_myproceed(1);"> <i
										class="fas fa-angle-double-left"></i>
								</a></li>
								<li class="page-item"><a class="page-link"
									href="javascript:print_myproceed(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
										<i class="fas fa-angle-left"></i>
								</a></li>
								<c:forEach var="pageNum" begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }">

									<li
										class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
										<a class="page-link"
										href="javascript:print_myproceed('${pageNum}');">${pageNum }</a>
									</li>
								</c:forEach>

								<li class="page-item"><a class="page-link"
									href="javascript:print_myproceed(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
										<i class="fas fa-angle-right"></i>
								</a></li>

								<li class="page-item"><a class="page-link"
									href="javascript:print_myproceed('${pageMaker.realEndPage}');">
										<i class="fas fa-angle-double-right"></i>
								</a></li>
							</ul>
						</nav>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<script>
	function print_myproceed(page) {
		var jobForm = $('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val(
				$('select[name="myproceedPerPageNum"]').val());
		jobForm.find("[name='searchType']").val(
				$('select[name="myproceedSearchType"]').val());
		jobForm.find("[name='keyword']").val(
				$('div.input-group>input[name="myproceedKeyword"]').val());
		alert(jobForm.serialize());
		$.ajax({
			url : 'getMyproceed',
			type : "POST",
			data : jobForm.serialize(),
			success : function(data) {
				$('#myproceed-content').html("").html(data);
			},
			error : function(error) {
				alert('error');
			}
		});
	}
</script>