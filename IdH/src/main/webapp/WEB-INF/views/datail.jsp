<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!-- CSS start -->

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
}
#table-content tbody tr td {
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
</style>

<!-- CSS end -->



<div class="row">
play
	<!-- 사업 일정 상세 정보 -->
	<div class="col-8">
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">이슈등록</h3>
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
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" colspan="3" style="width:35%;">세부사항</td>
								<td class="name-td" style="width:15%;">분류</td>
								<td class="name-td" style="width:35%;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td">글번호</td>
								<td class="table-td">1</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">수준</td>
								<td class="table-td">보통</td>
							</tr>
							<tr>
								<td class="name-td">등록자</td>
								<td class="table-td">허민호</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">할당자</td>
								<td class="table-td">서승훈</td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td">이슈발생~~~</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td" colspan="5" style="height:250px;">lorem itsum</td>
							</tr>

							<tr>
								<td class="name-td">프로젝트명</td>
								<td class="table-td">스타벅스</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td class="table-td">2023.03.07.</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
