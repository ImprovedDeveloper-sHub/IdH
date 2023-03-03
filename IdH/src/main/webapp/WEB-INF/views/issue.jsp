<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
thead {
	background: #f2f3f5;
}

thead tr td {
	color: #757e92;
	text-transform: uppercase;
	padding: 14px 5px;
	font-weight: bold;
	color: black;
}

tbody tr td {
	padding: 14px 5px;
	border-bottom: #eaecee solid 1px;
}

.issue-content {
	height: 600px;
}

.issue-content {
	text-align: center;
}

.card {
	margin: 0 10px 20px 10px;
}

.content-header {
	text-align: center;
	overflow-y: hidden;
	height: 150px;
	margin-top: 25px;
}

.issue-th>tbody td {
	font-size: 2.5rem;
}

.content-parts {
	margin-top: 25px;
}

#table-content tbody tr:hover {
	background: #fefaf2;
}
</style>




<div class="content-header card">
	<div class="row header-custum">
		<table class="issue-th" style="width: 100%;">
			<thead>
				<tr class="bg-info">
					<td>잔여 이슈</td>
					<td>지연된 이슈</td>
					<td>할당된 이슈</td>
					<td>등록한 이슈</td>
					<td>미할당 이슈</td>
					<td>프로젝트</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>값</td>
					<td>값</td>
					<td>값</td>
					<td>값</td>
					<td>값</td>
					<td>값</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>


<div class="content-body row">
	<div class="content-parts col-6">
		<div id="content" class="card">
			<div class="card-header">
				<h3 class="card-title">등록한 이슈</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 150px;">
					<input type="text" name="table_search"
						class="form-control float-right" placeholder="Search">
					<div class="input-group-append">
						<button type="submit" class="btn btn-default">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
				<button type="button" class="btn btn-block btn-info btn-sm"
					style="width: 80px;">등록</button>
			</div>
			<div id="table-content">
				<div class="card-body table-responsive p-0">
					<table class="table table-hover text-center">
						<thead>
							<tr>
								<th>프로젝트번호</th>
								<th>산출물이름</th>
								<th>작성자</th>
								<th>등록일</th>
								<th>산출물내용</th>
								<th>프로젝트 담장자</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>

							</tr>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>

							</tr>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>

							</tr>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<div class="content-parts col-6">
		<div id="content" class="card">
			<div class="card-header">
				<h3 class="card-title">등록한 이슈</h3>
			</div>
			<div class="card-tools"
				style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
				<div class="input-group input-group-sm" style="width: 150px;">
					<input type="text" name="table_search"
						class="form-control float-right" placeholder="Search">
					<div class="input-group-append">
						<button type="submit" class="btn btn-default">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
				<button type="button" class="btn btn-block btn-info btn-sm"
					style="width: 80px;">등록</button>
			</div>
			<div id="table-content">
				<div class="card-body table-responsive p-0">
					<table class="table table-hover text-center">
						<thead>
							<tr>
								<th>프로젝트번호</th>
								<th>산출물이름</th>
								<th>작성자</th>
								<th>등록일</th>
								<th>산출물내용</th>
								<th>프로젝트 담장자</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>

							</tr>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>

							</tr>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>

							</tr>
							<tr>
								<td>P12313121</td>
								<td>1월12일산출물 자료</td>
								<td>송창현</td>
								<td>2022-03-12</td>
								<td>산출물 내용이 들어갑니다.</td>
								<td>서승훈</td>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>