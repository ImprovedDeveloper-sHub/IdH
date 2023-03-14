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
            <h3 class="card-title">진행 프로젝트</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
                  <select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="tcw"  ${cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
						</select>
                  <input type="text" name="table_search"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	
                  	
                     <button type="submit" class="btn btn-default" onclick="list_go(1)">
                        <i class="fas fa-search"></i>
                     </button>
                  </div>
               </div>
         <button type="button" class="btn btn-block btn-info btn-sm"
            style="width: 80px;">등록</button>
            </div>
         <div id="table-content">
            <div class="card-body table-responsive p-0">
               <table class="table table-hover">
                  <thead class="text-left">
                <tr>
                  <th style="width:20%">프로젝트 이름</th>
                  <th style="width:30%">프로젝트 상태</th>
                  <th style="width:20%">등록 날짜</th>
                  <th style="width:15%">요구사항</th>
                  <th style="width:15%">설명</th>
                </tr>
              </thead>
              <tbody class="text-left">
              	<c:if test="${empty issueList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${issueList }" var="project">
					 <tr>
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${issue_name}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${issue_status}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${issue_regdate}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">test</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> ${issue_discription}</td>
	                </tr>
			 	 </c:forEach>
                
                
              </tbody>
               </table>
            </div>
         </div>
      </div>
	</div>



	<div class="content-parts col-6">
		<div id="content" class="card">
         <div class="card-header">
            <h3 class="card-title">진행 프로젝트</h3>
         </div>
            <div class="card-tools"style="justify-content:space-between;display:flex;flex-direction:row-reverse;">
               <div class="input-group input-group-sm" style="width: 270px">
                  <select class="form-control-sm" name="searchType" id="searchType" style="hegith:30px; width:90px !important; border-color:#CED4DA !important;">
							<option value="tcw"  ${cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
						</select>
                  <input type="text" name="table_search"
                     class="form-control float-right" placeholder="Search">
                  <div class="input-group-append">
                  	
                  	
                     <button type="submit" class="btn btn-default" onclick="list_go(1)">
                        <i class="fas fa-search"></i>
                     </button>
                  </div>
               </div>
         <button type="button" class="btn btn-block btn-info btn-sm"
            style="width: 80px;">등록</button>
            </div>
         <div id="table-content">
            <div class="card-body table-responsive p-0">
               <table class="table table-hover">
                  <thead class="text-left">
                <tr>
                  <th style="width:20%">프로젝트 이름</th>
                  <th style="width:30%">프로젝트 상태</th>
                  <th style="width:20%">등록 날짜</th>
                  <th style="width:15%">요구사항</th>
                  <th style="width:15%">설명</th>
                </tr>
              </thead>
              <tbody class="text-left">
              	<c:if test="${empty issueList}">
				  <tr><td colspan="5">데이터가 없습니다.</td></tr>
			 	 </c:if>
			 	 <c:forEach items="${issueList }" var="project">
					 <tr>
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${issue_name}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${issue_status}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">${issue_regdate}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">test</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> ${issue_discription}</td>
	                </tr>
			 	 </c:forEach>
                
                
              </tbody>
               </table>
            </div>
         </div>
      </div>
	</div>
</div>