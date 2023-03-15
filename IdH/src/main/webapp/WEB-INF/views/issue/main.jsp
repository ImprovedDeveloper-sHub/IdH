<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
.issue-th thead td {
	font-size: 14px;
}

.issue-th tbody td {
	font-size: 30px;
}
</style>




<div class="content-header card">
	<div class="row header-custum">
		<table class="issue-th text-center" style="width: 100%;">
			<thead>
				<tr class="bg-info" style="height: 40px;">
					<td>완료 이슈</td>
					<td>미완료 이슈</td>
					<td>할당된 이슈</td>
					<td>미할당 이슈</td>
					<td>전체 이슈</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${issuesuccess }</td>
					<td>${issuenow }</td>
					<td>${getter }</td>
					<td>${notgetter }</td>
					<td>${total }</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


<div class="content-body row">
	<div class="content-parts col-6">
		<div id="content" class="card">
			<div class="card-header">
				<h3 class="card-title">내 이슈</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 270px">
					<select id="myIssuePerPageNum" name="perPageNum"
						style="display: none"><option value="5" selected></option></select>
					<select class="form-control-sm" name="searchType"
						id="myIssueSearchType"
						style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
						<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전
							체</option>
						<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
						<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수준</option>
						<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
					</select> <input id="myIssueKeyword" type="text" name="keyword"
						class="form-control float-right" placeholder="Search">
					<div class="input-group-append">
						<button type="submit" class="btn btn-default"
							onclick="search_go_ajax(0, $('#myIssuePerPageNum'), $('#myIssueSearchType'), $('#myIssueKeyword'),'<%=request.getContextPath()%>/issue/getMyIssue', $('.myIssueThead'), $('.myIssueTbody') ,$('#searchMyIssue'))">
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
								<th style="width: 15%">할당자</th>
								<th style="width: 15%">수준</th>
							</tr>
						</thead>
						<tbody class="text-left myIssueTbody">
							<c:if test="${empty myIssueList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${myIssueList }" var="issue">
								<tr>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_title}</td>
									<td
										style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_content}</td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
											value="${issue.issue_regdate}" pattern="yyyy-MM-dd" /></td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_getter_id }</td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
										${issue.issue_level}</td>
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
				<h3 class="card-title">할당된 이슈</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 270px">
					<select id="getterIssuePerPageNum" name="perPageNum"
						style="display: none"><option value="5" selected></option></select>
					<select class="form-control-sm" name="searchType"
						id="getterIssueSearchType"
						style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
						<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>전
							체</option>
						<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제
							목</option>
						<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
						<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내
							용</option>
					</select> <input id="getterIssueKeyword" type="text" name="keyword"
						class="form-control float-right" placeholder="Search">
					<div class="input-group-append">
						<button type="submit" class="btn btn-default"
							onclick="search_go_ajax(0, $('#getterIssuePerPageNum'), $('#getterIssueSearchType'), $('#getterIssueKeyword'),'<%=request.getContextPath()%>/issue/getMyIssueList', $('.myIssueThead'), $('.myIssueTbody') ,$('#searchGetterIssue'))">
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
							<c:if test="${empty getterIssueList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${getterIssueList }" var="issue">
								<tr>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_title}</td>
									<td
										style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_content}</td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate
											value="${issue.issue_regdate}" pattern="yyyy-MM-dd" /></td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${issue.issue_setter_id }</td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
										${issue.issue_level}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
window.onload=function(){
	alert("${loginUser.member_id}");	
}
</script>