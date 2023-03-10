<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="proceedingProject-list-template" >
<tbody class="proceedingProjectLi" class="text-left">
{{#each proceedingProjectList}}
					 <tr onclick="setProjectNum({{project_number}})">
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_name}}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_status}}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{prettifyDate project_regdate}}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">test</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> {{project_discription}}</td>
	                </tr> 
{{/each}}
</tbody>
</script>


<script type="text/x-handlebars-template"  id="proceeding-pagination-template" >

<nav class="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="{{goPage 1}};">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="{{#if prev}}{{goPage prevPageNum}}{{else}}{{goPage cri.page}}{{/if}}">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>

			{{#each pageNum}}
<li class="paginate_button page-item  ">
	<a href="{{goPage this}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">{{this}}</a>
</li>
{{/each}}
			
			<li class="page-item">
				<a class="page-link" href="{{#if next}}{{goPage nextPageNum}}{{else}}{{goPage cri.page}}{{/if}}">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="{{goPage realEndPage}}">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>



</script>

<script type="text/x-handlebars-template"  id="end-pagination-template" >
nav class="paginationNav" aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="{{goPage 1}};">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="{{#if prev}}{{goPage prevPageNum}}{{else}}{{goPage cri.page}}{{/if}}">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>

			{{#each proceeding.pageNum}}
<li class="paginate_button page-item  ">
	<a href="{{goPage this}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">{{this}}</a>
</li>
{{/each}}
			
			<li class="page-item">
				<a class="page-link" href="{{#if next}}{{goPage nextPageNum}}{{else}}{{goPage cri.page}}{{/if}}">
					<i class="fas fa-angle-right" ></i>
				</a>
			</li>
			
			<li class="page-item">
				<a class="page-link" href="{{goPage realEndPage}}">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>	
		</ul>
	</nav>


</script>


<script type="text/x-handlebars-template"  id="endProject-list-template" >
<tbody class="endProjectLi" class="text-left">
{{#each endProjectList}}
					 <tr>
			                  <td style="text-align:left;max-width:20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_name}}</td>
			                  <td style="text-align:left;max-width: 30%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{project_status}}</td>
			                  <td style="text-align:left;max-width: 20%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">{{prettifyDate project_regdate}}</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;">test</td>
			                  <td style="text-align:left;max-width: 15%; overflow: hidden; 
                                    white-space: nowrap; text-overflow: ellipsis;"> {{project_discription}}</td>
	                </tr> 
{{/each}}
</tbody>
</script>

<script>
function printData(data,target,delTarget, templateObject){
	var template=Handlebars.compile(templateObject.html());
	//alert(JSON.stringify(data));
	var html = template(data);
	delTarget.remove();
	//alert(html);
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
	alert(html);
	//alert(html);
	target.html("").html(html);
	//target.remove();
	//target.after(html);
	/* $(target).appendTo(html);
	$(target).after('test'); */
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
	alert(html);
	target.html("").html(html);
}

Handlebars.registerHelper({
	"prettifyDate":function(timeValue){ //Handlbars??? ?????????????????? ??????
						var dateObj=new Date(timeValue);
						var year=dateObj.getFullYear();
						var month=dateObj.getMonth()+1;
						var date=dateObj.getDate();
						return year+"/"+month+"-"+date;
					},

"goPage":function(pageNum){
	return 'javascript:alert("test");';
}
});
</script>