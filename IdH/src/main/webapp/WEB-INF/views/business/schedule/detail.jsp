<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>



<!-- My CSS start -->

<style>
#content {
	background: #eaedf2;
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
	font-size: 10px;
	font-weight: 600;
	background-color: #E7E7E7;
	text-align: center;
}

.table-td {
	font-size: 12px;
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

	<div class="col-6">
		<!-- 사업 일정 상세 정보 -->
		<div class="card card-info">
			<div class="card-header bg-info">
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
							<tr style="text-align: center;">
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 20%;">세부사항</td>
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 15%;">세부사항</td>
								<td class="name-td" style="width: 15%;">분류</td>
								<td class="name-td" style="width: 20%;">세부사항</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="name-td" style="height: 50px;">사업번호</td>
								<td class="table-td" colspan="3">${business.business_number}</td>
								<td class="name-td" style="height: 50px;">사업등록자</td>
								<td class="table-td">${business.business_member_id}</td>
							</tr>
							<tr>
								<td class="name-td" style="height: 50px;">사업명</td>
								<td class="table-td" colspan="3">${business.business_name}</td>
								<td class="name-td" style="height: 50px;">투입인원</td>
								<td class="table-td">${business.business_people} 명</td>
							</tr>
							<tr>
								<td class="name-td" style="height: 50px;">시작일자</td>
								<td class="table-td"><fmt:formatDate
										value="${business.business_begin}" pattern="yyyy-MM-dd" /></td>
								<td class="name-td" style="height: 50px;">종료일자</td>
								<td class="table-td"><fmt:formatDate
										value="${business.business_end}" pattern="yyyy-MM-dd" /></td>
								<td class="name-td">D-DAY</td>
							</tr>
							<tr style="height: 225px;">
								<td class="name-td">내용</td>
								<td class="table-td" colspan="5">${business.business_content}</td>
							</tr>

							<tr>
								<td class="name-td" style="height: 50px;">총예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_budget}" pattern="#,###" /> 원</td>
								<td class="name-td" style="height: 50px;">사용예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_usebudget}" pattern="#,###" /> 원</td>
							</tr>
							<tr>
								<td class="name-td" style="height: 50px;">국가지원예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_nationbudget}" pattern="#,###" />
									원</td>
								<td class="name-td" style="height: 50px;">회사자체예산</td>
								<td class="table-td" colspan="2"><fmt:formatNumber
										value="${business.business_companybudget}" pattern="#,###" />
									원</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 사업 일정 상세 정보 끝 -->
		
	</div>

	<!-- 사업 일정 세부 그래프 -->
	<div class="col-6">
		<div class="card card-info">
			<div class="card-header bg-info">
				<h3 class="card-title">사업 항목 별 진행도</h3>
				<div class="card-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<div class="input-group-append"></div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="table-content" style="height: 501px;">
					<!-- <button id="change-chart">Change to Classic</button> -->
    				<div id="chart_div" style="width: 500px; height: 500px;"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- 사업 일정 세부 그래프 끝 -->
	<div class="card-tools" style="margin-left: 1000px">
		<button type="button" id="modifyBtn" class="btn btn-info" onclick="location.href='modifyForm?business_number=${business.business_number}';">수정</button>
	   	<button type="button" id="removeBtn" class="btn btn-info" onclick="location.href='remove?business_number=${business.business_number}';">삭제</button>	
	   	<button type="button" id="listBtn" class="btn btn-info" onclick="location.href='main';">목록</button>
	</div>

</div>

<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {

        /* var button = document.getElementById('change-chart'); */
        var chartDiv = document.getElementById('chart_div');

        var data = google.visualization.arrayToDataTable([
          
           
          ['Galaxy', '일정진행도', 'none'],
          ['PMS 사업 관리', 50000, 0],
          ['PMS 인사 관리', 24000, 0],
          ['PMS 요구사항 분석', 30000, 0],
          ['PMS 프로젝트 구성', 50000, 0],
          ['PMS 공지사항', 45000, 0]
        ]);

        
        
         /* var materialOptions = {
          width: 600,
          chart: {
            title: 'Nearby galaxies',
            subtitle: 'distance on the left, brightness on the right'
          },
          series: {
            0: { axis: 'distance' }, // Bind series 0 to an axis named 'distance'.
            1: { axis: 'brightness' } // Bind series 1 to an axis named 'brightness'.
          },
          axes: {
            y: {
              distance: {label: 'parsecs'}, // Left y-axis.
              brightness: {side: 'right', label: 'apparent magnitude'} // Right y-axis.
            }
          }
        }; */

        var classicOptions = {
          width: 590,
          series: {
            0: {targetAxisIndex: 0},
            1: {targetAxisIndex: 1}
          },
          title: '',
          vAxes: {
            // Adds titles to each axis.
            0: {title: 'parsecs'},
            1: {title: 'apparent magnitude'}
          }
        };
      
        function drawClassicChart() {
          var classicChart = new google.visualization.ColumnChart(chartDiv);
          classicChart.draw(data, classicOptions);
          /* button.innerText = 'Change to Material';
          button.onclick = drawMaterialChart; */
        }

        /* function drawMaterialChart() {
          var materialChart = new google.charts.Bar(chartDiv);
          materialChart.draw(data, google.charts.Bar.convertOptions(materialOptions));
          button.innerText = 'Change to Classic';
          button.onclick = drawClassicChart;
        } */
      
        drawClassicChart();
    };
</script>

