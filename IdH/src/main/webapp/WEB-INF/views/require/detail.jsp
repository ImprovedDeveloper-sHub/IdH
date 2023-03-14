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

	<!-- 사업 일정 상세 정보 -->
	<div class="col-8" >
		<div class="card card-info" style="width: 680px; height: 800px;">
			<div class="card-header" >
				<h3 class="card-title">요구사항 상세보기</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm">
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
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">발의자</td>
								<td class="table-td"></td>
							</tr>
							<tr>
								<td class="name-td">제목</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">등록일</td>
								<td colspan="5"></td>
							</tr>
							<tr>
								<td class="name-td">중요도</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">관련사업</td>
								<td colspan="5"></td>
							</tr>
							<tr>
								<td class="name-td">프로젝트 팀</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="name-td">담당자</td>
								<td colspan="5"></td>
							</tr>
							<tr>
								<td class="name-td">첨부파일</td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td class="table-td"></td>
								<td colspan="5">
							</tr>
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td" colspan="5" style=" width: 500px; height: 500px;">
								<textarea rows="15" cols="40"
										style="display: none; width: 500px; height: 500px;"></textarea></td>
							</tr>


						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
