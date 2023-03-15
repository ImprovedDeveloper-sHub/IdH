<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.timeline-card {
	overflow: scroll;
	overflow-x: hidden;
	margin: 0 10px 20px 10px;
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

.content-parts {
	margin-top: 25px;
}

#table-content tbody tr:hover {
	background: #fefaf2;
}

#table-content {
	height: 300px;
}
.card{
	overflow-y:scroll;
}
</style>


<div class="row" style="justify-content: center;">
	<div class="timeline-card card col-11">
		<div id="table-content" style="height: 250px;">
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-23</span>
						<h3 class="timeline-header">
							<a href="#">공지사항</a>
						</h3>
						<div class="timeline-body">새로운 글이 등록되었습니다.</div>
					</div>
				</div>
			</div>
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h3 class="timeline-header">
							<a href="#">이슈관리</a>
						</h3>
						<div class="timeline-body">새로운 이슈가 등록되었습니다.</div>
					</div>
				</div>
			</div>
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h3 class="timeline-header">
							<a href="#">2월 22일 업무보고입니다.</a>
						</h3>
						<div class="timeline-body">결제바랍니다.</div>
					</div>
				</div>
			</div>
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h3 class="timeline-header">
							<a href="#">2월 22일 업무보고입니다.</a>
						</h3>
						<div class="timeline-body">결제바랍니다.</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="content-parts col-6">
		<div id="content" class="card">
			<div class="card-header">
				<h3 class="card-title">산출물연계진행</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
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
			</div>
		</div>
	</div>



	<div class="content-parts col-6">
		<div id="content" class="card">
			<div class="card-header">
				<h3 class="card-title">산출물연계진행</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
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
			</div>
		</div>
	</div>
</div>