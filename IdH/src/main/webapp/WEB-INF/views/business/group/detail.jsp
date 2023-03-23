<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!-- My CSS start -->

<style>
#content {
	background: #eaedf2;
	position: relative;
	z-index: 10;
}

#table-content {
	background: #fff;
	/* margin-top: 20px; */
	box-shadow: #dcdee3 0px 0px 10px;
}

#table-content table {
	width: 100%;
}

#table-content thead {
	background: #f2f3f5;
}

#table-content thead tr td {
	color: #757e92;
	font-size: 10px;
	text-transform: uppercase;
	padding: 14px 10px;
}

#table-content tbody tr td {
	padding: 14px 10px;
	border-bottom: #eaecee solid 1px;
}

#table-content tbody tr:hover {
	background: #fefaf2;
}

.name-td {
	font-size: 13px;
	font-weight: 600;
	background-color: #E7E7E7;
}

.table-td {
	font-size: 13px;
	color: #64697a;
}

.date-td {
	text-align: right;
	font-size: 9px;
}

.checked {
	background: #fefaf2;
}

#credit {
	color: #76838c;
	width: 300px;
	margin: 0 auto;
	font-size: 12px;
	text-align: center;
}

.btn-info {
	text-align: right;
}
</style>

<!-- My CSS end -->



<div class="row">

	<div class="col-12">
	
		<!-- 사업 인원 상세 정보 -->
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 인원 상세 정보</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<table>
						<thead>
							<tr>
								<td class="name-td" style="width: 15%; text-align: center;">분류</td>
								<td class="name-td" style="width: 35%; text-align: center;">세부사항</td>
								<td class="name-td" style="width: 15%; text-align: center;">분류</td>
								<td class="name-td" style="width: 35%; text-align: center;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td" style="text-align: center;">사업번호</td>
								<td class="table-td">${business.business_number}</td>
								<td class="name-td" style="text-align: center;">팀장</td>
								<td class="table-td"><c:forEach items="${business.business_workforce_member_id}" var="workforce">${workforce}&nbsp;&nbsp;&nbsp;</c:forEach></td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">사업명</td>
								<td class="table-td">${business.business_name}</td>
								<td class="name-td" style="text-align: center;">투입인원</td>
								<td class="table-td">${business.business_people} 명</td>
							</tr>
							<tr>
								<td class="name-td" style="text-align: center;">시작일자</td>
								<td class="table-td"><fmt:formatDate
										value="${business.business_begin}" pattern="yyyy-MM-dd" /></td>
								<td class="name-td" style="text-align: center;">종료일자</td>
								<td class="table-td"><fmt:formatDate
										value="${business.business_end}" pattern="yyyy-MM-dd" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 사업 인원 상세 정보 끝 -->
		
		<!-- 인원 별 상세 현황 -->
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">인원 별 상세 현황</h3>
			</div>
			<div id="content">
				<div id="table-content">
					<table style="height: 330px;">
						<thead>
							<tr>
								<td style="width: 20%; text-align: center;">ID</td>
								<td style="width: 15%; text-align: center;">담당 업무</td>
								<td style="width: 50%; text-align: center;">구현 기능</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${workforceList}" var="workforce">
							<tr>
								<td class="table-td">${workforce.workforce_member_id}</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 인원 별 상세 현황 끝 -->
		
	</div>
	
	<div class="card-tool"" style="margin-left: 1140px">
		<%-- <button type="button" id="modifyBtn" class="btn btn-info" onclick="location.href='modifyForm?business_number=${business.business_number}';">수정</button> --%>
	   	<button type="button" id="listBtn" class="btn btn-info" onclick="location.href='main';">목록</button>
	</div>

</div>


