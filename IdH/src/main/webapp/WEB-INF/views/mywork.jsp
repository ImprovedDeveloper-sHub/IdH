<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.timeline-card {
	overflow: scroll;
	overflow-x: hidden;
	margin: 0 10px 20px 10px;
}

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

.content-parts {
	margin-top: 25px;
}

#table-content tbody tr:hover {
	background: #fefaf2;
}

#table-content {
	height: 300px;
}
</style>


<div class="row" style="justify-content: center;">
	<div class="timeline-card card col-11">
		<div id="table-content" style="height: 250px;">
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-23</span>
						<h3 class="timeline-header">
							<a href="#">공지사항</a>
						</h3>
						<div class="timeline-body">새로운 글이 등록되었습니다.</div>
					</div>
				</div>
			</div>
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h3 class="timeline-header">
							<a href="#">이슈관리</a>
						</h3>
						<div class="timeline-body">새로운 이슈가 등록되었습니다.</div>
					</div>
				</div>
			</div>
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h3 class="timeline-header">
							<a href="#">2월 22일 업무보고입니다.</a>
						</h3>
						<div class="timeline-body">결제바랍니다.</div>
					</div>
				</div>
			</div>
			<div class="timeline">
				<div>
					<i class="fas fa-paper-plane bg-yellow"></i>
					<div class="timeline-item">
						<span class="time"><i class="fas fa-clock"></i>23-02-22</span>
						<h3 class="timeline-header">
							<a href="#">2월 22일 업무보고입니다.</a>
						</h3>
						<div class="timeline-body">결제바랍니다.</div>
					</div>
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