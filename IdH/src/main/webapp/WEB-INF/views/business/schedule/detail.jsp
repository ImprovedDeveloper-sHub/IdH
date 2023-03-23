<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



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
	font-size: 10px;
	font-weight: 600;
	background-color: #E7E7E7;
	text-align: center;
}

.table-td {
	font-size: 12px;
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

	<div class="col-7">
		<!-- 사업 일정 상세 정보 -->
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 일정 상세 정보</h3>
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
							<tr style="text-align: center;">
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 20%;">세부사항</td>
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 15%;">세부사항</td>
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 20%;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td">사업번호</td>
								<td class="table-td" colspan="3">${business.business_number}</td>
								<td class="name-td">사업등록자</td>
								<td class="table-td">${business.business_member_id}</td>
							</tr>
							<tr>
								<td class="name-td">사업명</td>
								<td class="table-td" colspan="3">${business.business_name}</td>
								<td class="name-td">투입인원</td>
								<td class="table-td">${business.business_people} 명</td>
							</tr>
							<tr>
								<td class="name-td">시작일자</td>
								<td class="table-td"><fmt:formatDate
										value="${business.business_begin}" pattern="yyyy-MM-dd" /></td>
								<td class="name-td">종료일자</td>
								<td class="table-td"><fmt:formatDate
										value="${business.business_end}" pattern="yyyy-MM-dd" /></td>
								<td class="name-td">D-DAY</td>
							</tr>
							<tr style="height: 115px;">
								<td class="name-td">내용</td>
								<td class="table-td" colspan="5">${business.business_content}</td>
							</tr>

							<tr>
								<td class="name-td">총예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_budget}" pattern="#,###" /> 원</td>
								<td class="name-td">사용예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_usebudget}" pattern="#,###" /> 원</td>
							</tr>
							<tr>
								<td class="name-td">국가지원예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_nationbudget}" pattern="#,###" />
									원</td>
								<td class="name-td">회사자체예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_companybudget}" pattern="#,###" />
									원</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 사업 일정 상세 정보 끝 -->

		<!-- 사업 일정 경고 -->
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">일정 경고 항목</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content" style="height: 160px;">
					<table>
						<thead>
							<tr style="text-align: center;">
								<td>사업번호</td>
								<td>사업명</td>
								<td>항목</td>
								<td>예상 진행도</td>
								<td>현재 진행도</td>
								<td>상태</td>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty businesslist}">
								<tr>
									<td colspan="6" style="text-align: center;">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${businessList}" var="business">
								<tr>
									<td class="table-td"></td>
									<td class="table-td"></td>
									<td class="table-td"></td>
									<td class="table-td"></td>
									<td class="table-td"></td>
									<td class="table-td"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 사업 일정 경고 끝 -->
	</div>

	<!-- 사업 일정 세부 그래프 -->
	<div class="col-5">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 항목 별 진행도</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content" style="height: 501px;"></div>
			</div>
		</div>
	</div>
	<!-- 사업 일정 세부 그래프 끝 -->
	<div class="card-tools" style="margin-left: 1025px">
		<button type="button" id="modifyBtn" class="btn btn-info" onclick="location.href='modifyForm?business_number=${business.business_number}';">수정</button>
	   	<button type="button" id="removeBtn" class="btn btn-info" onclick="location.href='remove?business_number=${business.business_number}';">삭제</button>	
	   	<button type="button" id="listBtn" class="btn btn-info" onclick="location.href='main';">목록</button>
	</div>

</div>


