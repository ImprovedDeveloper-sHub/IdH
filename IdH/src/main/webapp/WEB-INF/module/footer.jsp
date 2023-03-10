<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="subMenu-list-template" >
<nav id="subMenuList" class="subMenu left">
{{#each .}}
    	<a id="{{mcode}}" href="javascript:goPage('<%=request.getContextPath()%>/{{murl}}','{{mcode}}')">{{mname}}</a>
{{/each}}
</nav>
</script>

<script>

	function subMenu_go(mCode){
		if(mCode!="M000000"){			
			$.ajax({
				url:"<%=request.getContextPath()%>/subMenu?mCode="+mCode,
				type:"get",				
				success:function(data){
					printSubMenu(data, $('.subeMenuLi'),$('#subMenu-list-template'));
					//acitve css주는 함수.
					$(mCode).attr('style','active');
				},
				error:function(error){
					AjaxErrorSecurityRedirectHandler(error.status);	
				}				
			});
			
		}else{
			$('.subMenuList').html("");		
		}
	}
	
	//handelbars printElement (args : data Array, appent target, handlebar template, remove class)
	function printSubMenu(data,target,templateObject,removeSelector){
		var template=Handlebars.compile(templateObject.html());
		var html = template(data);
		$('#subMenuList').remove();
		
		$('#subMenuLi').append(html);
		//$('#subMenuList').append(html);
	} 
	
	
	function goPage(url,mCode){
		$('iframe[name="ifr"]').attr("src",url);
		  // HTML5 지원브라우저에서 사용 가능
		if (typeof(history.pushState) == 'function') {
		    //현재 주소를 가져온다.
		    
		    var renewURL = location.href;
		    //현재 주소 중 .do 뒤 부분이 있다면 날려버린다.
		    
		    renewURL = renewURL.substring(0, renewURL.indexOf("mCode")-1);
		    
		    if (mCode != 'M000000') {
		        renewURL += "?mCode="+mCode;
		    }
		    
		    
		    //페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
		    history.pushState(mCode, null, renewURL);
		} else {
		    location.hash = "#"+mCode;
		}
	}
	
	
	

</script>


<script>
window.onload = function(){
	goPage('<%=request.getContextPath()%>${menu.murl}','${menu.mcode}');
	subMenu_go('${menu.mcode}'.substring(0,3)+"0000");
}
	
</script>



<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.js">
 
<!-- jQuery -->
<script
	src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script
	src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script
	src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<script
	src="<%=request.getContextPath() %>/resources/js/common.js"></script>

</body>
</html>

