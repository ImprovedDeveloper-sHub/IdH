<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="proceedingProject-list-template" >
<tbody class="proceedingProjectLi" class="text-left">
{{#each proceedingProjectList}}
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
<tr>
			 	 	<td colspan="5">
			 	 	<%@ include file="/WEB-INF/module/pagination.jsp" %>
			 	 	</td>
</tr>
</tbody>

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