<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
thead {
  background: #f2f3f5;
}
thead tr td {
  color: #757e92;
  text-transform: uppercase;
  padding: 14px 5px;
  font-weight:bold;
  color:black;
}
tbody tr td {
  padding: 14px 5px;
  border-bottom: #eaecee solid 1px;
}

.issue-content{
  height:600px;
}


.issue-content{
  text-align:center;
}
.content-header{
  text-align:center;
  overflow-y:hidden;
  height:150px;
  margin-top:25px;
}
.issue-th>tbody td{
  font-size:2.5rem;
}
.content-parts{
  margin-top:25px;
}
#table-content tbody tr:hover {
  background: #fefaf2;
}
</style>

<div class="row content-main">
	<div class="content-body col-6 card"></div>


	<div class="content-body col-6 card">

		<div class="form-group" data-select2-id="29">
			<label>D-day</label> <select
				class="form-control select2 select2-hidden-accessible"
				style="width: 100%;" data-select2-id="1" tabindex="-1"
				aria-hidden="true">
				<option selected="selected" data-select2-id="3">Project</option>
				<option data-select2-id="34">Project1</option>
				<option data-select2-id="35">Project2</option>
				<option data-select2-id="36">Project3</option>
				<option data-select2-id="37">Project4</option>
				<option data-select2-id="38">Project5</option>
				<option data-select2-id="39">Project6</option>
			</select><span
				class="select2 select2-container select2-container--default select2-container--below select2-container--focus"
				dir="ltr" data-select2-id="2" style="width: 100%;"><span
				class="selection"></span><span class="dropdown-wrapper"
				aria-hidden="true"></span></span>
		</div>



		<div class="col-md-12 col-12">
			<div class="info-box bg-gradient-warning">
				<span class="info-box-icon"><i class="far fa-calendar-alt"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">Events</span> <span
						class="info-box-number">41,410</span>
					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
			</div>
		</div>
	</div>


	<div class="content-parts col-6">
		<div id="content" class="card">
			<div class="card-header">
				<h3 class="card-title">등록한 이슈</h3>
			</div>
				<div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
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
				<div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
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