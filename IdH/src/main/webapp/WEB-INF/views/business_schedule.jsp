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

	<!-- 사업 일정 상세 정보 -->
	<div class="col-8">
		<div class="card card-info">
			<div class="card-header">
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
							<tr>
								<td class="name-td">분류</td>
								<td class="name-td">세부사항</td>
								<td class="name-td">분류</td>
								<td class="name-td">세부사항</td>
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
								<td class="name-td">사업등록자</td>
								<td class="table-td">권이혁</td>
							</tr>
							<tr>
								<td class="name-td">사업명</td>
								<td class="table-td">PMS 개발 사업</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">투입인원</td>
								<td class="table-td">13명</td>
							</tr>
							<tr>
								<td class="name-td">시작일자</td>
								<td class="table-td">22.12.01.</td>
								<td class="name-td">종료일자</td>
								<td class="table-td">23.06.30.(*예정)</td>
								<td class="name-td">D-DAY</td>
								<td class="table-td">127일</td>
							</tr>
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td">차세대 PMS 개발</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 일정 상세 정보 끝 -->

	<!-- 사업 일정 저조 경고 -->
	<div class="col-8">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">일정 저조 항목</h3>
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
								<td>예상 진행도</td>
								<td>현재 진행도</td>
								<td>상태</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-td">20221201</td>
								<td class="table-td">PMS 개발 사업</td>
								<td class="table-td">범위 2</td>
								<td class="table-td">35%</td>
								<td class="table-td">18%</td>
								<td class="table-td">저조</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 일정 저조 경고 끝 -->

</div>


