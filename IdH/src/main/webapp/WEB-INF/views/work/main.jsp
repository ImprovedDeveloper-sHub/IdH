<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
.work-th thead td {
	font-size: 14px;
}

.work-th tbody td {
	font-size: 30px;
}
</style>


<div class="content-body" style="height: 550px;">


	<div class="content-parts row" style="height: 98%;">
		<div class="col-2 text-center">
			<div class="card" style="height: 98%;">
				<div style="height: 33.3%; border: solid green 3px;">
					<div class="badge-success">SUCCESS</div>
					<h2>3</h2>
				</div>
				<div style="height: 33.3%; border: solid gold 3px;">
					<div class="badge-warning">보류</div>
					<h2>3</h2>
				</div>
				<div style="height: 33.3%; border: solid red 3px;">
					<div class="badge-danger">미승인</div>
					<h2>3</h2>
				</div>
			</div>
		</div>
		<div class="col-10">
			<div id="content" class="card" style="height: 98%;overflow:scroll;overflow-x:hidden;">
				<div class="card-header">
					<h3 class="card-title">받은 보고</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select id="myIssuePerPageNum" name="perPageNum"
							style="display: none"><option value="5" selected></option></select>
						<select class="form-control-sm" name="searchType"
							id="myIssueSearchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
							<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
						</select> <input id="myIssueKeyword" type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="search_go_ajax(0, $('#myIssuePerPageNum'), $('#myIssueSearchType'), $('#myIssueKeyword'),'<%=request.getContextPath()%>/work/getMyIssue', $('.myIssueThead'), $('.myIssueTbody') ,$('#searchMyIssue'))">
								<i class="fas fa-search"></i>

							</button>
						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;">등록</button>
				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="text-left myIssueThead">
								<tr>
									<th style="width: 20%">제목</th>
									<th style="width: 30%">내용</th>
									<th style="width: 20%">작성일</th>
									<th style="width: 15%">상태</th>
									<th style="width: 15%">종료일</th>
								</tr>
							</thead>
							<tbody class="text-left myIssueTbody">
								<c:if test="${empty workListByApprover}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${workListByApprover }" var="work">
									<tr>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${work.work_title}</td>
										<td
											style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${work.work_content}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${work.work_regdate}" pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${work.work_check}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${work.work_enddate}" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>



		<div class="col-2 text-center">
			<div class="card" style="height: 98%;">
				<div style="height: 33.3%; border: solid green 3px;">
					<div class="badge-success">SUCCESS</div>
					<h2>3</h2>
				</div>
				<div style="height: 33.3%; border: solid gold 3px;">
					<div class="badge-warning">보류</div>
					<h2>3</h2>
				</div>
				<div style="height: 33.3%; border: solid red 3px;">
					<div class="badge-danger">미승인</div>
					<h2>3</h2>
				</div>
			</div>
		</div>
		<div class="col-10">
			<div id="content" class="card" style="height: 98%;overflow:scroll;overflow-x:hidden;">
				<div class="card-header">
					<h3 class="card-title">보낸 보고</h3>
				</div>
				<div class="card-tools"
					style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
					<div class="input-group input-group-sm" style="width: 270px">
						<select id="getterIssuePerPageNum" name="perPageNum"
							style="display: none"><option value="5" selected></option></select>
						<select class="form-control-sm" name="searchType"
							id="getterIssueSearchType"
							style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
						</select> <input id="getterIssueKeyword" type="text" name="keyword"
							class="form-control float-right" placeholder="Search">
						<div class="input-group-append">
							<button type="submit" class="btn btn-default"
								onclick="search_go_ajax(0, $('#getterIssuePerPageNum'), $('#getterIssueSearchType'), $('#getterIssueKeyword'),'<%=request.getContextPath()%>/work/getMyIssueList', $('.myIssueThead'), $('.myIssueTbody') ,$('#searchGetterIssue'))">
								<i class="fas fa-search"></i>

							</button>
						</div>
					</div>
					<button type="button" class="btn btn-block btn-info btn-sm"
						style="width: 80px;">등록</button>
				</div>
				<div id="table-content">
					<div class="card-body table-responsive p-0">
						<table class="table table-hover">
							<thead class="text-left getterIssueThead">
								<tr>
									<th style="width: 20%">제목</th>
									<th style="width: 30%">내용</th>
									<th style="width: 20%">작성일</th>
									<th style="width: 15%">작성자</th>
									<th style="width: 15%">수준</th>
								</tr>
							</thead>
							<tbody class="text-left getterIssueTbody">
								<c:if test="${empty workListByWriter}">
									<tr>
										<td colspan="5">데이터가 없습니다.</td>
									</tr>
								</c:if>
								<c:forEach items="${workListByWriter }" var="work">
									<tr>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${work.work_title}</td>
										<td
											style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${work.work_content}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${work.work_regdate}" pattern="yyyy-MM-dd" /></td>
										<td
											style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${work.work_check}</td>
										<td
											style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
												value="${work.work_enddate}" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
