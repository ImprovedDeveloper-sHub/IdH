<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--chart-->
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        
        
        <!--   <script>alert('${test}');</script> -->
          
 <div class= "content">
    <div class="row">

      <!--col-6시작-->
      <div class="col-6">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">종료 프로젝트</h3>
            <div class="card-tools">
              
              <div class="input-group input-group-sm" style="width: 300px;">
                <div class="btn-group">
<button type="button" class="btn btn-info">Action</button>
<button type="button" class="btn btn-info dropdown-toggle dropdown-icon" data-toggle="dropdown">
<span class="sr-only">Toggle Dropdown</span>
</button>
<div class="dropdown-menu" role="menu">
<a class="dropdown-item" href="#">Action</a>
<a class="dropdown-item" href="#">Another action</a>
<a class="dropdown-item" href="#">Something else here</a>
<div class="dropdown-divider"></div>
<a class="dropdown-item" href="#">Separated link</a>
</div>
</div>
                <input type="text" name="table_search" class="form-control float-right" placeholder="Search">
                <div class="input-group-append">
                  <button type="submit" class="btn btn-default">
                    <i class="fas fa-search"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div class="card-body table-responsive p-0">
            <table class="table table-hover ">
              <thead>
                <tr>
                  <th>프로젝트 이름</th>
                  <th>프로젝트 상태</th>
                  <th>등록 날짜</th>
                  <th>요구사항</th>
                  <th>설명</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>183</td>
                  <td>John Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-success">Approved</span></td>
                  <td> fatback doner.</td>
                </tr>
                <tr>
                  <td>219</td>
                  <td>Alexander Pierce</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-warning">Pending</span></td>
                  <td>flank fatback doner.</td>
                </tr>
                <tr>
                  <td>657</td>
                  <td>Bob Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-primary">Approved</span></td>
                  <td> flank fatback doner.</td>
                </tr>
                <tr>
                  <td>175</td>
                  <td>Mike Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-danger">Denied</span></td>
                  <td> flank fatback doner.</td>
                </tr>
                <tr>
                  <td>175</td>
                  <td>Mike Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-danger">Denied</span></td>
                  <td> flank fatback doner.</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

        <div class="card">
          <div class="card-header">
            <h3 class="card-title">종료 프로젝트</h3>
            <div class="card-tools">
              <div class="input-group input-group-sm" style="width: 150px;">
                <input type="text" name="table_search" class="form-control float-right" placeholder="Search">
                <div class="input-group-append">
                  <button type="submit" class="btn btn-default">
                    <i class="fas fa-search"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div class="card-body table-responsive p-0">
            <table class="table table-hover ">
              <thead>
                <tr>
                  <th>프로젝트 이름</th>
                  <th>프로젝트 상태</th>
                  <th>등록 날짜</th>
                  <th>요구사항</th>
                  <th>설명</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>183</td>
                  <td>John Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-success">Approved</span></td>
                  <td> fatback doner.</td>
                </tr>
                <tr>
                  <td>219</td>
                  <td>Alexander Pierce</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-warning">Pending</span></td>
                  <td>flank fatback doner.</td>
                </tr>
                <tr>
                  <td>657</td>
                  <td>Bob Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-primary">Approved</span></td>
                  <td> flank fatback doner.</td>
                </tr>
                <tr>
                  <td>175</td>
                  <td>Mike Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-danger">Denied</span></td>
                  <td> flank fatback doner.</td>
                </tr>
                <tr>
                  <td>175</td>
                  <td>Mike Doe</td>
                  <td>11-7-2014</td>
                  <td><span class="tag tag-danger">Denied</span></td>
                  <td> flank fatback doner.</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

    <div class="card ">
          <div class="card-body row">
            <div class="col-6"><button type="button" class="btn btn-block btn-info btn-sm">프로젝트 계획</button>
              </div>
             <div class="col-6"> <button type="button" class="btn btn-block btn-info btn-sm">프로젝트 비교</button>
</div>
          </div>
        </div>


        <!--col-6종료-->
      </div>


      <!--col-6시작-->
      <div class="col-6">


        <div class="card">
          <div class="card-header">
            <h3 class="card-title">Progress bars</h3>
          </div>

          <div class="card-body">
            <div class="progress mb-3">
              <div class="progress-bar bg-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                <span class="sr-only">40% Complete (success)</span>
              </div>
            </div>
            <div class="progress mb-3">
              <div class="progress-bar bg-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                <span class="sr-only">20% Complete</span>
              </div>
            </div>
            <div class="progress mb-3">
              <div class="progress-bar bg-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                <span class="sr-only">60% Complete (warning)</span>
              </div>
            </div>
            <div class="progress mb-3">
              <div class="progress-bar bg-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                <span class="sr-only">80% Complete</span>
              </div>
            </div>
          </div>
          
 
        </div>


        <div class="card ">
          <div class="card-body row">
            <div class="col-4"><button type="button" class="btn btn-block btn-info btn-sm">예산현황</button>
              <button type="button" class="btn btn-block btn-info btn-sm">인력현황</button></div>
             <div class="col-4"> <button type="button" class="btn btn-block btn-info btn-sm">일정현황</button>
              <button type="button" class="btn btn-block btn-info btn-sm">이슈현황</button>   
</div><div class="col-4"> <button type="button" class="btn btn-block btn-info btn-sm">산출물현황</button></div>
          </div>
        </div>


        
        <div class="row">
          <div class="card col-6 card-info">
            <div class="card-header ">
            <h3 class="card-title ">종료 프로젝트</h3>
           
               <div class="card-body table-responsive p-0">
            <table class="table table-hover ">
              <thead>
                <tr>
                  <th>1</th>
                  <th>2</th>
                  <th>3</th>
                  <th>4</th>
                  <th>5</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>2</td>
                  <td>3</td>
                  <td><span class="tag tag-success">4</span></td>
                  <td> 5</td>
                </tr></tbody>
              </table>
              
              
              </div>
            </div>
          </div>
          
           <div class="card col-6 card-info">
            <div class="card-header ">
            <h3 class="card-title ">종료 프로젝트</h3>
           
              <div class="card-body table-responsive p-0">
            <table class="table table-hover ">
              <thead>
                <tr>
                  <th>1</th>
                  <th>2</th>
                  <th>3</th>
                  <th>4</th>
                  <th>5</th>
                </tr>
              </thead>
              </table></div>
              
              
              
            </div>
          </div>
        </div>
      </div>


      <!--col-6종료-->

	
	<button onclick="ajax_test()">ajax</button>
	<button onclick="table_print()">table</button>
	
	 <div id="curve_chart" style="width: 900px; height: 500px"></div>
	 <div id="Line_chart" style="width: 900px; height: 500px"></div>
      <a class="2015-btn" href="#">2015</a>
    </div>

    </div>


    <!--row종료-->
  </div>
  <!--content종료-->
  
  
  
  
  
  <script>
  var test="test";
  var data_table_test;
  function ajax_test(){
	  test = $.ajax({
			url:"${request.ContextPath()}/IdH/test5",		//서버url
			method:"post",	//get post 보내는 방식
			success:function(data){
				console.log(data);
				test = JSON.stringify(data);
				
			},	//서버에서 보내는 데이터
			error:function(error){
				alert('error')
			},
			complete:function(){
				alert('complete')
			},
		})
  }
  
  		
 
  var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };
  
  function table_print(){
	  alert(test);
	  data_table_test = new google.visualization.DataTable(test);
	  var chart2 = new google.visualization.LineChart(document.getElementById('Line_chart'));
	  google.charts.setOnLoadCallback(drawChart);
	  
	   function drawChart() {

          var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
          };
          chart2.draw(data_table_test,options);
        }
	  
	  
  }
  
  window.onload = function(){
	  google.charts.load('current', {packages: ['corechart', 'line']});
	  google.charts.load('current', {'packages':['corechart']});
	  google.charts.setOnLoadCallback(drawBasic);
  }
  
  


  function drawBasic() {
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
        	
        	 var data = google.visualization.arrayToDataTable([
       	      ['Year', '프로젝트계획', '프로젝트현황'],
       	      ['2000',  1000,      400],
       	      ['2005',  1170,      460],
       	      ['2006',  660,       1120],
       	      ['2007',  1030,      540]
       	    ]);
        	
          var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
          };
          chart.draw(data, options);
        }
    
    
    $(document).ready(function(){
      $(".2015-btn").click(function(){
    	  var data = google.visualization.arrayToDataTable([
              ['Year', '프로젝트1', '프로젝트2'],
              ['2004',  1000,      400],
              ['2005',  1170,      460],
            ]);
        var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
          };

          chart.draw(data, options);
      });
  });
    
}
  
  
  </script>
  
  
  
  
  