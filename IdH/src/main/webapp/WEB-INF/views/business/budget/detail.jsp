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

	<!-- 사업 예산 상세 정보 -->
	<div class="col-8">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">사업 예산 상세 정보</h3>
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
								<td class="name-td">분류</td>
								<td class="name-td">세부사항</td>
								<td class="name-td"></td>
								<td class="name-td"></td>
								<td class="name-td">분류</td>
								<td class="name-td">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td">사업번호</td>
								<td class="table-td">20221201</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">사업명</td>
								<td class="table-td">PMS 개발 사업</td>
							</tr>
							<tr>
								<td class="name-td">총예산</td>
								<td class="table-td">1,500,000,000(원)</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">사용예산</td>
								<td class="table-td">650,000,000(원)</td>
							</tr>
							<tr>
								<td class="name-td">국가지원예산</td>
								<td class="table-td">500,000,000(원)</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">회사자체예산</td>
								<td class="table-td">1,000,000,000(원)</td>
							</tr>
							<tr>
								<td class="name-td">사용내역</td>
								<td class="table-td">인건비</td>
								<td class="table-td">300,000,000(원)</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="name-td"></td>
								<td class="table-td">비품비</td>
								<td class="table-td">100,000,000(원)</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="name-td"></td>
								<td class="table-td">교통비</td>
								<td class="table-td">100,000,000(원)</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="name-td"></td>
								<td class="table-td">식대</td>
								<td class="table-td">150,000,000(원)</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td class="name-td"></td>
								<td class="table-td">잔여예산</td>
								<td class="table-td">850,000,000(원)</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 예산 상세 정보 끝 -->

	<!-- 사업 예산 경고 -->
	<div class="col-8">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">예산 경고 항목</h3>
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
								<td>사업번호</td>
								<td>사업명</td>
								<td>항목</td>
								<td>배정 예산</td>
								<td>사용 예산</td>
								<td>상태</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-td">20221201</td>
								<td class="table-td">PMS 개발 사업</td>
								<td class="table-td">식대</td>
								<td class="table-td">25%</td>
								<td class="table-td">05%</td>
								<td class="table-td">저조</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 예산 경고 끝 -->

</div>


