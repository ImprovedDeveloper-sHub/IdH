<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="reply-list-template" >
{{#each .}}
<div class="replyLi" >
	<div class="timeline-item" >
  		<span class="time">
    		<i class="fa fa-clock"></i>{{prettifyDate regdate}}
	 		<a class="btn btn-info btn-xs {{rno}}-a" id="modifyReplyBtn" 
				data-rno={{rno}} data-replyer={{replyer}}
				onclick="replyModifyModal_go('{{rno}}');"
				style="display:{{visibleByLoginCheck replyer}};"
	    		data-toggle="modal" data-target="#modifyModal">Modify</a>
  		</span>
	
  		<h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
  		<div class="timeline-body" id="{{rno}}-replytext">{{replytext}}</div>
	</div>
</div>

{{/each}}	
</script>





<script>
var replyPage=1;
window.onload=function(){
	getPage("<%=request.getContextPath()%>/reply/list?issue_number=${issue.issue_number}&page="+replyPage);
}

function getPage(pageInfo,page){
	if(page) replyPage = page;
	$.getJSON(pageInfo,function(data){	
		printData(data.replyList,$('#repliesDiv'),$('#reply-list-template'));	
		printPagination(data.pageMaker,$('ul#pagination'),$('#reply-pagination-template'));
	});
}

function printData(replyArr,target,templateObject){
	var template=Handlebars.compile(templateObject.html());
	var html = template(replyArr);	
	$('.replyLi').remove();
	target.after(html);
}

/* pagination */
function printPagination(pageMaker,target,templateObject){
	var pageNumArray = new Array(pageMaker.endPage-pageMaker.startPage+1);
	for(var i=pageMaker.startPage;i<pageMaker.endPage+1;i++){
		pageNumArray[i-pageMaker.startPage]=i;
	}	
	
	pageMaker.pageNum=pageNumArray;  
	pageMaker.prevPageNum=pageMaker.startPage-1;
	pageMaker.nextPageNum=pageMaker.endPage+1;
	
	var template=Handlebars.compile(templateObject.html());	
	var html = template(pageMaker);	
	target.html("").html(html);
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
		if(replyer == "${loginUser.member_id}") result="visible";		
		return result;						  
	},
	"signActive":function(pageNum){
		if(pageNum == replyPage) return 'active';
	},
	"goPage":function(pageNum){
		return 'javascript:getPage("<%=request.getContextPath()%>/reply/list?issue_number=${issue.issue_number}&page='+pageNum+'",'+pageNum+');';
	}
});
</script>

<script>
function replyRegist_go(){
	//alert("add reply click");
	var replytext=$('#newReplyText').val();	
	
	var data={
			"issue_number":"${issue.issue_number}",
			"replyer":"${loginUser.member_id}",
			"replytext":replytext	
	}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/reply/regist",
		type:"post",
		data:JSON.stringify(data),		
		contentType:'application/json',
		success:function(data){
			alert('댓글이 등록되었습니다.');
			replyPage=data; //페이지이동
			getPage("<%=request.getContextPath()%>/reply/list?issue_number="+${issue.issue_number}+"&page="+data);
			$('#newReplyText').val("");	
		},
		error:function(error){
			AjaxErrorSecurityRedirectHandler(error.status);	
		}
	});
}


//댓글 수정 modal
function replyModifyModal_go(rno){
	//alert(rno);
	//alert($('div#'+rno+'-replytext').text());
	
	$('div#modifyModal div.modal-body input#replytext').val($('div#'+rno+'-replytext').text());
	$('div#modifyModal div.modal-header h4.modal-title').text(rno);
}

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
		url:"<%=request.getContextPath()%>/reply/modify",
		type:"post",
		data:JSON.stringify(sendData),
		contentType:"application/json",
		success:function(result){
			alert("수정되었습니다.");			
			getPage("<%=request.getContextPath()%>/reply/list?issue_number=${issue.issue_number}&page="
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
		url:"<%=request.getContextPath()%>/reply/remove?rno="+rno+"&page="
				+replyPage+"&issue_number=${issue.issue_number}",
		type:"get",
		success:function(page){
			alert("삭제되었습니다.");
			getPage("<%=request.getContextPath()%>/reply/list?issue_number=${issue.issue_number}&page="+page);
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
</script>










