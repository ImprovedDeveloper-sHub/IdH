<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="reply-list-template" >
{{#each .}}
<div class="chart_area" >
	
</div>

{{/each}}	
</script>



<script>
var replyPage=1;
window.onload=function(){
	getPage("<%=request.getContextPath()%>/reply/list.do?bno=${board.bno}&page="+replyPage);
}

function getPage(pageInfo,page){
	if(page) replyPage = page;
	$.getJSON(pageInfo,function(data){	
		printData(data.replyList,$('#repliesDiv'),$('#reply-list-template'));	
	});
}

function printData(replyArr,target,templateObject){
	var template=Handlebars.compile(templateObject.html());
	var html = template(replyArr);	
	$('.replyLi').remove();
	target.after(html);
}

Handlebars.registerHelper({
	"prettifyDate":function(timeValue){ //Handlbars에 날짜출력함수 등록
						var dateObj=new Date(timeValue);
						var year=dateObj.getFullYear();
						var month=dateObj.getMonth()+1;
						var date=dateObj.getDate();
						return year+"/"+month+"/"+date;
					},
	"visibleByLoginCheck":function(replyer){
		var result="none";		
		if(replyer == "${loginUser.id}") result="visible";		
		return result;						  
	},
	"signActive":function(pageNum){
		if(pageNum == replyPage) return 'active';
	},
	"goPage":function(pageNum){
		return 'javascript:getPage("<%=request.getContextPath()%>/reply/list.do?bno=${board.bno}&page='+pageNum+'",'+pageNum+');';
	}
});
</script>



















<%--

<script>
function replyRegist_go(){
	//alert("add reply click");
	var replytext=$('#newReplyText').val();	
	
	var data={
			"bno":"${board.bno}",
			"replyer":"${loginUser.id}",
			"replytext":replytext	
	}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/reply/regist.do",
		type:"post",
		data:JSON.stringify(data),		
		contentType:'application/json',
		success:function(data){
			alert('댓글이 등록되었습니다.\n마지막페이지로 이동합니다.');
			replyPage=data; //페이지이동
			getPage("<%=request.getContextPath()%>/reply/list.do?bno="+${board.bno}+"&page="+data); //리스트 출력
			$('#newReplyText').val("");	
		},
		error:function(error){
			AjaxErrorSecurityRedirectHandler(error.status);	
		}
	});
}



</script>







 //댓글 수정.
function replyModify_go(){
	//alert("modify btn");
	
	var rno=$('div#modifyModal h4.modal-title').text();
	var replytext=$('div#modifyModal #replytext').val();
	
	var sendData={
			"rno":rno,
			"replytext":replytext
	}
	
	//console.log(sendData);
	
	$.ajax({
		url:"<%=request.getContextPath()%>/reply/modify.do",
		type:"post",
		data:JSON.stringify(sendData),
		contentType:"application/json",
		success:function(result){
			alert("수정되었습니다.");			
			getPage("<%=request.getContextPath()%>/reply/list.do?bno=${board.bno}&page="
					+replyPage);
		},
		error:function(error){
			AjaxErrorSecurityRedirectHandler(error.status);	
		},
		complete:function(){
			$('#modifyModal').modal('hide');
		}
	});
}

function replyRemove_go(){
	//alert("delete btn");
	var rno=$('h4.modal-title').text();
	
	//alert(rno);
	$.ajax({
		url:"<%=request.getContextPath()%>/reply/remove.do?rno="+rno+"&page="
				+replyPage+"&bno=${board.bno}",
		type:"get",
		success:function(page){
			alert("삭제되었습니다.");
			getPage("<%=request.getContextPath()%>/reply/list.do?bno=${board.bno}&page="+page);
			replyPage=page;
		},
		error:function(error){
			AjaxErrorSecurityRedirectHandler(error.status);	
		},
		complete:function(){
			$('#modifyModal').modal('hide');
		}
	});
}
</script> --%>










