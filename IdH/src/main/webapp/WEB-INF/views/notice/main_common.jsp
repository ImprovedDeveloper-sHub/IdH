<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- Notice CSS -->



<!-- Notice CSS End -->



<div class="row" style="width: 1200px; ">
	<div class="content-parts col-12" style="height: 630px;">
		<div id="content" class="card" style="height: 100%;">
			<div class="card-header">
				<h3 class="card-title">공지 사항 목록</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 400px">
					<select id="myNoticePerPageNum" name="perPageNum"
						style="display: none"><option value="5" selected></option></select>
					<select class="form-control-sm" name="searchType"
						id="myNoticeSearchType"
						style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
						<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전&nbsp;&nbsp;체</option>
						<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제&nbsp;&nbsp;목</option>
						<option value="w" ${cri.searchType eq 'l' ? 'selected':'' }>수&nbsp;&nbsp;준</option>
						<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내&nbsp;&nbsp;용</option>
					</select>
					e
					<input id="myNoticeKeyword" type="text" name="keyword" class="form-control float-right" placeholder="Search">
					
					<div class="input-group-append">
						<button type="submit" class="btn btn-default"
							onclick="search_go_ajax(0, $('#myNoticePerPageNum'), $('#myNoticeSearchType'), $('#myNoticeKeyword'),'<%=request.getContextPath()%>/notice/getMyNotice', $('.myNoticeThead'), $('.myNoticeTbody') ,$('#searchMyNotice'))">
							<i class="fas fa-search"></i>

						</button>
					</div>
				</div>
				<!-- <button type="button" class="btn btn-block btn-info btn-sm"
					style="width: 80px;" onclick="location.href='registForm';">등록</button> -->
			</div>
			<div id="table-content">
				<div class="card-body table-responsive p-0">
					<table class="table table-hover" style="table-layout: fixed; width: 100%;">
						<thead class="text-left myNoticeThead">

							<tr>
								<th style="width: 10%; font-size: 15px;">번호</th>
								<th style="width: 20%; font-size: 15px;">제목</th>
								<th style="width: 35%; font-size: 15px;">내용</th>
								<th style="width: 15%; font-size: 15px;">작성자</th>
								<th style="width: 10%; font-size: 15px;">등록일</th>
								<th style="width: 10%; font-size: 15px;">구분</th>
							</tr>
						</thead>
						<tbody class="text-left myNoticeTbody">
							<c:if test="${empty noticeList}">
								<tr>
									<td colspan="5">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${noticeList}" var="notice">
								<tr onclick="location.href='detail?notice_number=${notice.notice_number}';"style="cursor:pointer;">
									<td style="font-size: 15px; text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${notice.notice_number}</td>
									<td style="font-size: 15px; text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${notice.notice_title}</td>
									<td style="font-size: 15px; text-align: left; max-width: 35%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${notice.notice_content }</td>
									<td style="font-size: 15px; text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${notice.notice_member_id }</td>
									<td style="font-size: 15px; text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><fmt:formatDate value="${notice.notice_regdate}" pattern="yyyy-MM-dd" /></td>
									<td style="font-size: 15px; text-align: left; max-width: 10%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${notice.notice_level}</td>

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



</script>


