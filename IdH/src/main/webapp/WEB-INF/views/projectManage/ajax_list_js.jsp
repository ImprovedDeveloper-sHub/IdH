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


<script type="text/x-handlebars-template"  id="pagination-template" >
<tr>
<td colspan="5">
<nav aria-label="Navigation">
		<ul class="pagination justify-content-center m-0">
			<li class="page-item">
				<a class="page-link" href="{{goPage 1}}">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="{{#if prev}}{{goPage prevPageNum}}{{else}}{{goPage cri.page}}{{/if}});">
					<i class="fas fa-angle-left"></i>
				</a>						
			</li>
			
			{{#each pageNum}}
			<li class="page-item ">
				<a class="page-link" href="{{goPage this}}" >{{this}}</a>
			</li>
			{{#each pageNum}}

			<li class="page-item" >
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


</td>
</tr>

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


function printPagination(pageMaker,target,templateObject){
	alert(JSON.stringify(pageMaker))
	var pageNumArray = new Array(pageMaker.endPage-pageMaker.startPage+1);
	for(var i=pageMaker.startPage;i<pageMaker.endPage+1;i++){
		pageNumArray[i-pageMaker.startPage]=i;
	}	
	alert('test');
	pageMaker.pageNum=pageNumArray;  
	pageMaker.prevPageNum=pageMaker.startPage-1;
	pageMaker.nextPageNum=pageMaker.endPage+1;
	
	var template=Handlebars.compile(templateObject.html());	
	var html = template(pageMaker);	
	alert(html);
	target.after(html);
	target.appendTo(html);
}

Handlebars.registerHelper({
	"prettifyDate":function(timeValue){ //Handlbars에 날짜출력함수 등록
						var dateObj=new Date(timeValue);
						var year=dateObj.getFullYear();
						var month=dateObj.getMonth()+1;
						var date=dateObj.getDate();
						return year+"/"+month+"-"+date;
					}
});
</script>