<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"
	id="my-list-template">
<tbody class="text-left myli">
{{#each myIssueList}}
							
							
								<tr
									onclick="javascript:OpenWindow('detail.do?from=main&issue_number={{issue_number}}','상세보기',600,508);">

									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">{{issue_title}}</td>
									<td
										style="text-align: left; max-width: 30%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">{{issue_content}}</td>
									<td
										style="text-align: left; max-width: 20%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											{{prettifyDate issue_regdate}}</td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">{{issue_getter_id }}</td>
									<td
										style="text-align: left; max-width: 15%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
										{{issue_level}}</td>
								</tr>
							
{{/each}}
						</tbody>
</script>


<script type="text/x-handlebars-template"
	id="my-pagination-template">

<nav class="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="{{goPageMy 1}};">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="{{#if prev}}{{goPageMy prevPageNum}}{{else}}{{goPageMy cri.page}}{{/if}}">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>

			{{#each pageNum}}
<li class="paginate_button page-item {{signActiveMy this}} ">
	<a href="{{goPageMy this}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">{{this}}</a>
</li>
{{/each}}
			
			<li class="page-item">
				<a class="page-link" href="{{#if next}}{{goPageMy nextPageNum}}{{else}}{{goPageMy cri.page}}{{/if}}">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="{{goPageMy realEndPage}}">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>



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

function printMyPagination(data,target, templateObject){
	alert(data);
	alert(JSON.stringify(data));
	alert(JSON.stringify(data.PageMaker));
	
	
	var pageNumArray = new Array(data.PageMaker.endPage-data.PageMaker.startPage+1);
	for(var i=data.PageMaker.startPage;i<data.PageMaker.endPage+1;i++){
		pageNumArray[i-data.PageMaker.startPage]=i;
	}	
	data.PageMaker.pageNum=pageNumArray;  
	data.PageMaker.prevPageNum=data.PageMaker.startPage-1;
	data.PageMaker.nextPageNum=data.PageMaker.endPage+1;
	var template=Handlebars.compile(templateObject.html());	
	var html = template(data.PageMaker);
	
	
	//alert(html);
	//alert(html);
	//target.html("").html(html);
	//target.remove();
	target.after(html);
	//$(target).appendTo(html);
	//$(target).after("test");
}

function printGetterPagination(data,target, templateObject){
	var pageNumArray = new Array(data.PageMaker.endPage-data.PageMaker.startPage+1);
	for(var i=data.PageMaker.startPage;i<data.PageMaker.endPage+1;i++){
		pageNumArray[i-data.PageMaker.startPage]=i;
	}	
	data.PageMaker.pageNum=pageNumArray;  
	data.PageMaker.prevPageNum=data.PageMaker.startPage-1;
	data.PageMaker.nextPageNum=data.PageMaker.endPage+1;
	var template=Handlebars.compile(templateObject.html());	
	var html = template(data.PageMaker);
	//alert(html);
	//alert(html);
	target.html("").html(html);
	//target.remove();
	//target.after(html);
	/* $(target).appendTo(html);
	$(target).after("test"); */
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
	"goPageMy":function(pageNum){
		return "javascript:search_go_ajax("+pageNum+", $('#myPerPageNum'), $('#mySearchType'), $('#myKeyword'), '" + '<%=request.getContextPath()%>/issue/my' + "', $('.myThead'),$('.myli'),$('#my-list-template'),$('#my-pagination-template'),$('#myPaginationBox'),'my');"
	},
	"goPageGetter":function(pageNum){
		return "javascript:search_go_ajax("+pageNum+", $('#getterPerPageNum'), $('#getterSearchType'), $('#getterKeyword'), '" + '<%=request.getContextPath()%>/issue/getter' + "', $('.getterThead'),$('.getterli'),$('#getter-list-template'),$('#getter-pagination-template'),$('#getterPaginationBox'),'getter');"
	},
	"goPageEnd":function(pageNum){
		return "javascript:search_go_ajax("+pageNum+", $('#endPerPageNum'), $('#endSearchType'), $('#endKeyword'), '" + '<%=request.getContextPath()%>/projectManage/getEnd'
							+ "', $('.endThead'),$('.endProjectLi'),$('#endProject-list-template'),$('#end-pagination-template'),$('#endPaginationBox'),'end');"
				},
				"signActiveProceeding" : function(pageNum) {
					if (pageNum == proceedingPage)
						return 'active';
				},
				"signActiveEnd" : function(pageNum) {
					if (pageNum == endPage)
						return 'active';
				},
				"signActiveMy" : function(pageNum) {
					if (pageNum == mygPage)
						return 'active';
				},
				"signActiveGetter" : function(pageNum) {
					if (pageNum == getterPage)
						return 'active';
				},

			});
</script>