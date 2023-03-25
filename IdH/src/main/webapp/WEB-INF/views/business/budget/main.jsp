<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>



<!-- My CSS start -->

<style>
#content {
	/* background: #eaedf2; */
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
	font-size: 12px;
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
	<div class="col-7">
		<div class="card card-info">
			<div class="card-header bg-info">
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
		<!-- 사업 예산 전체 정보 끝 -->

		<!-- 사업 예산 목록 -->
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 예산 목록</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content" style="height: 401px;">
					<table>
						<thead>
							<tr style="text-align: center;">
								<td style="width: 20%;">사업 번호</td>
								<td style="width: 30%;">사업명</td>
								<td style="width: 25%;">총 예산</td>
								<td style="width: 25%;">사용 예산</td>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty businessList}">
								<tr style="text-align: center;">
									<td colspan="4">데이터가 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach items="${businessList}" var="business">
							<tr onclick="location.href='detail?business_number=${business.business_number}'; "
								style="cursor: pointer;">
								<td class="table-td" style="border: 1px solid; border-color: silver; text-align: center;">${business.business_number}</td>
								<td class="table-td" style="border: 1px solid; border-color: silver;">${business.business_name}</td>
								<td class="table-td" style="border: 1px solid; border-color: silver; text-align: right;"><fmt:formatNumber
										value="${business.business_budget}" pattern="#,###" /> 원</td>
								
								<td class="table-td" style="border: 1px solid; border-color: silver; text-align: right;"><fmt:formatNumber
										value="${business.business_usebudget}" pattern="#,###" /> 원</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<br/>
					<nav id="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="javascript:pageList_go(1);">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:pageList_go(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.cri.page});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
	
			<li class="page-item ${pageMaker.cri.page == pageNum?'active':''}">
				<a class="page-link" href="javascript:pageList_go('${pageNum}');" >${pageNum }</a>
			</li>
			</c:forEach>
			
			<li class="page-item">
				<a class="page-link" href="javascript:pageList_go(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.cri.page});">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="javascript:pageList_go('${pageMaker.realEndPage}');">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>
				</div>
			</div>
		</div>
		<!-- 사업 예산 목록 끝 -->

	</div>

	<!-- 사업 예산 그래프 -->
	<div class="col-5">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 예산 소모 내역</h3>
				<div class="card-tools"></div>
			</div>
			<div id="content">
				<div id="table-content" style="height: 516px;">
				
					<div class="card-tools"
						style="justify-content: space-between; display: flex; flex-direction: row-reverse;">
						<div class="input-group input-group-sm" style="width: 350px; margin: 10px;">
							<select class="form-control-sm" name="searchType" id="searchType"
								style="hegith: 30px; width: 90px !important; border-color: #CED4DA !important;">
								<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
								<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제목</option>
								<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>등록자</option>
								<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내용</option>
							</select>
							<input type="text" name="keyword" class="form-control float-right" value="<c:if test="">${cri.keyword}</c:if>">
							<div class="input-group-append">


								<button type="submit" class="btn btn-default"
									onclick="pageList_go(1)">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
						
					</div>
							<!-- <div style="margin-left: 70px;"><div id="columnchart_material" style="width: 400px; height: 450px;"></div></div> -->
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 예산 그래프 끝 -->

</div>

<!-- 
<script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['', 'Sales'],
          ['2014', 1000],
          ['2015', 1170],
          ['2016', 660],
          ['2017', 1030]
        ]);

        var options = {
          chart: {
            title: '',
            subtitle: '',
          }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
</script>
 -->
 
 <script>

function pageList_go(page,url){
	if(!url) url="main";
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='perPageNum']").val(10);
	jobForm.find("[name='searchType']")
		.val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']")
		.val($('div.input-group>input[name="keyword"]').val());
	

	jobForm.attr({action:url,method:'get'}).submit();
}

</script>


