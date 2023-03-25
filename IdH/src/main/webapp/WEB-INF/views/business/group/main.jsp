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
	font-size: 15px;
	text-transform: uppercase;
	padding: 14px 10px;
}

#table-content tbody tr td {
	padding: 14px 10px;
	border-bottom: #eaecee solid 1px;
	font-size: 13px;
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

	<!-- 사업 인원 전체 정보 -->
	<div class="col-12">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 인원 현황</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<table style="text-align: center;">
						<thead>
							<tr>
								<td class="name-td" style="width: 25%;">전체</td>
								<td class="name-td" style="width: 25%;">임원</td>
								<td class="name-td" style="width: 25%;">팀장</td>
								<td class="name-td" style="width: 25%;">팀원</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-td">${total}</td>
								<td class="table-td">${excutieves} </td>
								<td class="table-td">${teamLeader}</td>
								<td class="table-td">${teamMember}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 인원 전체 정보 끝 -->

	<div class="card-tools"
		style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
		
		<div class="input-group input-group-sm"
			style="width: 350px; margin: 10px; margin-left: 750px;">
			<select class="form-control-sm" name="searchType" id="searchType"
				style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
				<option value="tcw" ${cri.searchType eq 'n' ? 'selected':'' }>전체</option>
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
		<!-- <button type="button" class="btn btn-block btn-info btn-sm"
			style="width: 80px; margin: 10px; text-align: center;" id="registBtn"
			onclick="OpenWindow('registForm','글등록',680,555)">등록</button> -->

	</div>

	<!-- 사업 별 인원 현황 -->
	<div class="col-12">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 별 인원 현황</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<table style="height: 348px;">
						<thead>
							<tr>
								<td style="width: 25%; text-align: center;">사업번호</td>
								<td style="width: 25%;">사업명</td>
								<td style="width: 25%; text-align: center;">등록자</td>
								<td style="width: 25%; text-align: center;">참여인원</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${businessList}" var="business">
							<tr onclick="location.href='detail?business_number=${business.business_number}';" style="cursor: pointer;">
								<td class="table-td" style="text-align: center;">${business.business_number}</td>
								<td class="table-td">${business.business_name}</td>
								<td class="table-td" style="text-align: center;">${business.business_member_id}</td>
								<td class="table-td" style="text-align: center;">${business.business_people}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 별 인원 현황 끝 -->

</div>


