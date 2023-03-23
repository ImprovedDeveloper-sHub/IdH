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

	<!-- 사업 일정 전체 조회 -->
	<div class="col-6">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">사업 일정 전체 조회</h3>
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
								<td class="name-td">캘린더를 넣자</td>
								<td class="name-td"></td>
								<td class="name-td"></td>
								<td class="name-td"></td>
								<td class="name-td"></td>
								<td class="name-td"></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 일정 전체 조회 끝 -->

	<!-- 사업 일정 그래프 -->
	<div class="col-6">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">사업 일정 진행도</h3>
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
								<td>막대 그래프를 넣자</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 일정 그래프 끝 -->

</div>


