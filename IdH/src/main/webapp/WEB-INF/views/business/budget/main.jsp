<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- My CSS start -->

<style>
#content {
	background: #eaedf2;
	position: relative;
	z-index: 10;
}

#table-content {
	background: #fff;
	margin-top: 20px;
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

	<!-- 사업 예산 전체 정보 -->
	<div class="col-8">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">사업 예산 전체 정보</h3>
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
								<td class="name-td"></td>
								<td class="name-td">전체</td>
								<td class="name-td">종료</td>
								<td class="name-td">집행중</td>
								<td class="name-td">예정</td>
								<td class="name-td"></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-td"></td>
								<td class="table-td">03건</td>
								<td class="table-td">01건</td>
								<td class="table-td">01건</td>
								<td class="table-td">01건</td>
								<td class="table-td"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 예산 전체 정보 끝 -->

	<!-- 사업 예산 목록 -->
	<div class="col-8">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">사업 예산 목록</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content">
					<table cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<td>사업 번호</td>
								<td>사업명</td>
								<td></td>
								<td>총 예산</td>
								<td></td>
								<td>사용 예산</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-td">20230117</td>
								<td class="table-td">[예정] 그룹웨어 시스템 개발 사업</td>
								<td class="table-td"></td>
								<td class="table-td">600,000,000(원)</td>
								<td class="table-td"></td>
								<td class="table-td">0(원)</td>
							</tr>
							<tr>
								<td class="table-td">20221201</td>
								<td class="table-td">PMS 개발 사업</td>
								<td class="table-td"></td>
								<td class="table-td">1,500,000,000(원)</td>
								<td class="table-td"></td>
								<td class="table-td">650,000,000(원)</td>
							</tr>
							<tr>
								<td class="table-td">20221001</td>
								<td class="table-td">LMS 시스템 개발 사업</td>
								<td class="table-td"></td>
								<td class="table-td">30,000,000(원)</td>
								<td class="table-td"></td>
								<td class="table-td">25,000,000(원)</td>
							</tr>
							<tr>
								<td class="table-td">20220425</td>
								<td class="table-td">[종료] 화학 물질 관리 시스템</td>
								<td class="table-td"></td>
								<td class="table-td">150,000,000(원)</td>
								<td class="table-td"></td>
								<td class="table-td">150,000,000(원)</td>
							</tr>
							<tr>
								<td class="table-td">20220102</td>
								<td class="table-td">[종료] 영업 사원 관리 시스템</td>
								<td class="table-td"></td>
								<td class="table-td">20,000,000(원)</td>
								<td class="table-td"></td>
								<td class="table-td">20,000,000(원)</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 예산 목록 끝 -->

</div>


