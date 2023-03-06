<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
ul,li{
   list-sytle:none;
}

a{
   text-decoration:none;
}

body{
  margin:0;
  padding:0;
}
.main{
  margin:0 auto;
  width:1224px;
  background-color:#eaedf2;
}

.header{
  width:1212px;
}

.logo{
  width:100px;
  height:100px;
}
.main-menu{
  display:flex;
  align-items:center;
  justify-content:space-between;
  background-color:#B7C4CF;
  
}
.menu{
  display:inline-block;
  font-size:18px;
  color:#black;
}
.menu:hover{
  color:white;
}

.row{
  margin:0 !important;
  padding:0!important;
}

.active{
 color:white;
  font-weight:bold;
}

.top-menu {
  background: #fff;
  width: 1200px;
  max-height: 56px;
  float: left;
  margin-bottom :15px;
}

nav {
   position: relative;
   z-index: 1;
   white-space: nowrap;
  float: left;
  position: relative;
}

nav a {
   position: relative;
   display: inline-block;
   padding: 1.9em 3em 1.2em 1em;
   color: #757c8f;
   text-decoration: none;
   margin: 0 -2px;
  position: relative;
  top: 0px;
  font-size: 15px;
  font-weight: 600;
} 

nav a:hover::before {
   content: ''; /* To generate the box */
   position: absolute;
   top: 0; right: 0; bottom: .5em; left: 0;
   z-index: -1;
   border-bottom: none;
   border-radius: 5px 2px 0 0;
   background: #eaedf2;
   box-shadow: 0 2px hsla(0,0%,100%,.5) inset;
   transform: perspective(6px) rotateX(1.9deg);
   transform-origin: bottom left;
   height: 80px;
  margin-top: -24px;
}

.active-tab::before {
   content: ''; /* To generate the box */
   position: absolute;
  
   top: 0; right: 0; bottom: .5em; left: 0;
   z-index: -10;
   border-bottom: none;
   border-radius: 5px 2px 0 0;
   background: #eaedf2;
   box-shadow: 0 2px hsla(0,0%,100%,.5) inset;
   transform: perspective(6px) rotateX(1.9deg);
   transform-origin: bottom left;
  box-shadow: inset 0px 0px 10px #dadce0;
  height: 80px;
  margin-top: -24px;
}

.active-tab {
  color: #5e9cf7;
  padding: 1.9em 4em 1.2em 1em;
  margin-left: 1px
}
table th{
   font-size:12px;
}
table td{
   font-size:10px;
}

</style>
<script>
google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['Work',     11],
    ['Eat',      2],
    ['Commute',  2],
    ['Watch TV', 2],
    ['Sleep',    7]
  ]);

  var options = {
    title: 'My Daily Activities',
    pieHole: 0.4,
  };

  var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
  chart.draw(data, options);
}
</script>



<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    

<!-- 부트스트랩 불러오기 -->
<script src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 폰트어썸 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

<div class="main">
  <div class="header row">
    <div class="header-logo col-1">
      <div class="logo">IDH</div>
    </div>
    <!-- header종료 -->
    <div class="main-menu col-11">
      <div class="menu"><i class="fa-solid fa-border-all"></i>&nbsp대시보드</div>
      <div class="menu"><i class="fa-solid fa-globe"></i>&nbsp사업관리</div>
      <div class="menu"><i class="fa-solid fa-keyboard"></i>&nbsp요구사항관리</div>
      <div class="menu"><i class="fa-solid fa-screwdriver-wrench"></i>&nbsp프로젝트구성</div>
      <div class="menu active"><i class="fa-brands fa-r-project"></i>&nbsp프로젝트</div>
      <div class="menu"><i class="fa-solid fa-users-line"></i>&nbsp커뮤니케이션</div>
      <div class="menu"><i class="fa-solid fa-bell"></i>&nbsp공지사항</div>
      <div class="menu "><i class="fa-sharp fa-solid fa-book"></i>&nbsp표준관리</div>
    </div>
        <!--main-menu종료 -->
     <div class="col-12 sub-menu">
      <div class="top-menu">
        <nav class="left">


          <a " href="#">활동수행결과</a>
                    <a class="active-tab" a href="#">산출물연계진행</a>
            <a href="#">진행현황</a>
            <a href="#">진행률관리</a>
            <a href="#">이슈관리</a>

        </nav>
      </div>
    </div>
  </div>
  <!--header row종료 -->    
    
     <div class= "content">
    <div class="row">
  <div class="col-12">
	    <div class="col-8">
<table class="table table-bordered">
   
<thead>
<tr>
<th style="width: 10px">#</th>
<th>A프로젝트</th>
<th>진행도</th>
<th style="width: 60px">진행률</th>
  <th>담당자</th>
</tr>
</thead>
<tbody>
<tr>
<td>1.</td>
<td>Update software</td>
<td>
<div class="progress progress-xs">
<div class="progress-bar progress-bar-danger" style="width: 55%"></div>
 
</div>

</td>
<td><span class="badge bg-danger">55%</span></td>
  <td>송창현</td>
</tr>
<tr>
<td>2.</td>
<td>Clean database</td>
<td>
<div class="progress progress-xs">
<div class="progress-bar bg-warning" style="width: 70%"></div>
</div>
</td>
<td><span class="badge bg-warning">70%</span></td>
  <td>송창현</td>
</tr>
<tr>
<td>3.</td>
<td>Cron job running</td>
<td>
<div class="progress progress-xs progress-striped active">
<div class="progress-bar bg-primary" style="width: 30%"></div>
</div>
</td>
<td><span class="badge bg-primary">30%</span></td>
  <td>송창현</td>
</tr>
<tr>
<td>4.</td>
<td>Fix and squish bugs</td>
<td>
<div class="progress progress-xs progress-striped active">
<div class="progress-bar bg-success" style="width: 90%"></div>
</div>
</td>
<td><span class="badge bg-success">90%</span></td>
  <td>송창현</td>
</tr> 
  
</tbody>
  
</table>
   <div class="col-4">
                                   <div id="donutchart" style="width-max: 900px; "></div>

                                                                                            </div>
                                                                                  </div>
                                  </div>
          
      <!--row종료-->
    </div>
   
  </div>
  
  </div>
  <!--content종료-->

<!--main(container)종료 -->


</div>
