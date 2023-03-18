<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="proceedingProject-list-template" >
<tbody class="proceedingProjectLi" class="text-left">
{{#each proceedingProjectList}}
					 <tr onclick="setProjectNum({{project_number}},'getProjectDetail');">
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_business_name}}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_name}}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{prettifyDate project_regdate}}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{prettifyDate project_enddate}}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> 요구사항</td>
	                </tr> 
{{/each}}
</tbody>
</script>


<script type="text/x-handlebars-template"  id="proceeding-pagination-template" >

<nav class="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="{{goPageProceeding 1}};">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="{{#if prev}}{{goPageProceeding prevPageNum}}{{else}}{{goPageProceeding cri.page}}{{/if}}">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>

			{{#each pageNum}}
<li class="paginate_button page-item {{signActiveProceeding this}} ">
	<a href="{{goPageProceeding this}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">{{this}}</a>
</li>
{{/each}}
			
			<li class="page-item">
				<a class="page-link" href="{{#if next}}{{goPageProceeding nextPageNum}}{{else}}{{goPageProceeding cri.page}}{{/if}}">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="{{goPageProceeding realEndPage}}">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>



</script>

<script type="text/x-handlebars-template"  id="end-pagination-template" >

<nav class="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="{{goPageEnd 1}};">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="{{#if prev}}{{goPageEnd prevPageNum}}{{else}}{{goPageEnd cri.page}}{{/if}}">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>

			{{#each pageNum}}
<li class="paginate_button page-item {{signActiveEnd this}} ">
	<a href="{{goPageEnd this}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">{{this}}</a>
</li>
{{/each}}
			
			<li class="page-item">
				<a class="page-link" href="{{#if next}}{{goPageEnd nextPageNum}}{{else}}{{goPageEnd cri.page}}{{/if}}">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="{{goPageEnd realEndPage}}">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>



</script>


<script type="text/x-handlebars-template"  id="endProject-list-template" >
<tbody class="endProjectLi" class="text-left">
{{#each endProjectList}}
					 <tr onclick="setProjectNum({{project_number}},'getProjectDetail');">
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_business_name}}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_name}}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{prettifyDate project_regdate}}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{prettifyDate project_enddate}}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> 요구사항</td>
	                </tr> 
{{/each}}
</tbody>
</script>

<script type="text/x-handlebars-template"  id="projectDetail-template" >
{{#each .}}
<tbody class="projectDetailtbody" class="text-left">
						 <tr>
								<td class="name-td">프로젝트 명</td>
								<td class="table-td" colspan="3">{{project_name}}</td>
								<td class="name-td">사업 번호</td>
								<td class="table-td">{{project_business_number}}</td>
							</tr>
							<tr>
								<td class="name-td">등록자</td>
								<td class="table-td" colspan="3">{{project_member_id}}</td>
								<td class="name-td">상태</td>
								<td class="table-td" colspan="3">{{project_name}}</td>
							</tr>
							
							<tr>
								<td class="name-td">시작날짜</td>
								<td class="table-td" colspan="3"></td>
								<td class="name-td">종료날짜</td>
								<td class="table-td" colspan="3"></td>
							</tr>
							
							<tr style="height: 100px;">
								<td class="name-td">내용</td>
								<td class="table-td td-summernote" colspan="5"></td>
							</tr>

							<tr>
								<td class="name-td">프로젝트번호</td>
								<td class="table-td">1</td>
								<td class="table-td">2</td>
								<td class="table-td">3</td>
								<td class="name-td">등록일</td>
								<td class="table-td">4</td>
</tbody>
{{/each}}
</script>


<script>
var proceedingPage=1;
var endPage=1;



function printData(data,target,delTarget, templateObject){
	var template=Handlebars.compile(templateObject.html());
	var html = template(data);
	delTarget.remove();
	target.after(html);
}


function printProceedingPagination(data,target, templateObject){
	var pageNumArray = new Array(data.proceedingPageMaker.endPage-data.proceedingPageMaker.startPage+1);
	for(var i=data.proceedingPageMaker.startPage;i<data.proceedingPageMaker.endPage+1;i++){
		pageNumArray[i-data.proceedingPageMaker.startPage]=i;
	}	
	data.proceedingPageMaker.pageNum=pageNumArray;  
	data.proceedingPageMaker.prevPageNum=data.proceedingPageMaker.startPage-1;
	data.proceedingPageMaker.nextPageNum=data.proceedingPageMaker.endPage+1;
	var template=Handlebars.compile(templateObject.html());	
	var html = template(data.proceedingPageMaker);
	//alert(html);
	//alert(html);
	target.html("").html(html);
	//target.remove();
	//target.after(html);
	/* $(target).appendTo(html);
	$(target).after("test"); */
}


function printEndPagination(data,target, templateObject){
	var pageNumArray = new Array(data.endPageMaker.endPage-data.endPageMaker.startPage+1);
	for(var i=data.endPageMaker.startPage;i<data.endPageMaker.endPage+1;i++){
		pageNumArray[i-data.endPageMaker.startPage]=i;
	}	
	data.endPageMaker.pageNum=pageNumArray;  
	data.endPageMaker.prevPageNum=data.endPageMaker.startPage-1;
	data.endPageMaker.nextPageNum=data.endPageMaker.endPage+1;
	var template=Handlebars.compile(templateObject.html());	
	var html = template(data.endPageMaker);
	//alert(html);
	target.html("").html(html);
}




Handlebars.registerHelper({
	"prettifyDate":function(timeValue){ //Handlbars에 날짜출력함수 등록
						var dateObj=new Date(timeValue);
						var year=dateObj.getFullYear();
						var month=dateObj.getMonth()+1;
						var date=dateObj.getDate();
						return year+"-"+month+"-"+date;
					},
	"goPageProceeding":function(pageNum){
		return "javascript:search_go_ajax("+pageNum+", $('#proceedingPerPageNum'), $('#proceedingSearchType'), $('#proceedingKeyword'), '" + '<%=request.getContextPath()%>/projectManage/getProceeding' + "', $('.proceedingThead'),$('.proceedingProjectLi'),$('#proceedingProject-list-template'),$('#proceeding-pagination-template'),$('#proceedingPaginationBox'),'proceeding');"
	},
	"goPageEnd":function(pageNum){
		return "javascript:search_go_ajax("+pageNum+", $('#endPerPageNum'), $('#endSearchType'), $('#endKeyword'), '" + '<%=request.getContextPath()%>/projectManage/getEnd' + "', $('.endThead'),$('.endProjectLi'),$('#endProject-list-template'),$('#end-pagination-template'),$('#endPaginationBox'),'end');"
	},
	"signActiveProceeding":function(pageNum){
		if(pageNum == proceedingPage) return 'active';
	},
	"signActiveEnd":function(pageNum){
		if(pageNum == endPage) return 'active';
	},
	
});
</script>